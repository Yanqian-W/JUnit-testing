# Test Plan

|Contents|
|--------|
|[Team Management](#team-management)|
|[Test Plan](#test-plan)|
|[Jump to Class: FBTeam](#class-fbteam)|
|[Jump to Class: FBPlayer](#class-fbplayer)|
|[Jump to Class: FBGame](#class-fbgame)|
|[Jump to Class: FBApp](#class-fbapp)|


## Team Management
Team members are divided into three groups in the first meeting, each responsible for one of the three classes (FBTeam, FBPlayer, FBGame). Based on teamwork between two members, produce test code and reports separately. At this stage, we use issues in GitLab to manage team work.

Next, we discussed and determined the format of the report, and then divided the FBApp class testing tasks for each person.

Finally, we discussed and integrated the test files and reports using Gitlab.


## Test Plan

### Class: FBTeam

_Written: Yanqian Wang, Pengyu Zhi; Update after modifying the code: Yanqian Wang_

"Test" column corresponds to the method name of the test case. "Description" column shows details of testing purpose.

- "[]" represents an empty ArrayList.
- 1:M means there are many test cases related to this description.
- "Player Information" represents standard output format of FBPlayer. "Team Information" represents standard output format of FBTeam.

#### Function: getTeamList()

|Test|Description|Inputs|Expected Outcome|Test Outcome|Result|
|----|-----------|------|----------------|------------|------|
| testGetList | get default teamList | null | [] | [] | pass |
| 1:M | get teamList | null | Player Information | Player Information | pass |

#### Function: getTeamColor()

|Test|Description|Inputs|Expected Outcome|Test Outcome|Result|
|----|-----------|------|----------------|------------|------|
| testGetColor | get default teamColor | null | "White" | "White" | pass |
| 1:M | get teamColor | null | new team color | new team color | pass |

#### Function: setTeamList()

|Test|Description|Inputs|Expected Outcome|Test Outcome|Result|
|----|-----------|------|----------------|------------|------|
| testSetList | set a new teamList | ArrayList of a FBPlayer | Player Information | [] | fail[1] |

fail[1]: In the setTeamList() method, the teamList as a parameter will be set as the FBTeam.teamList if this.teamList == null. But in the FBTeam() constructor, teamList will be initialized as an empty Arraylist. This means that after FBTeam.teamList is created, it will never be null, so it cannot be set using setTeamList() method.

Modification: Use isEmpty() to determine if this.teamList is empty, rather than comparing with null. After Modification, this test case passed.

#### Function: setTeamColor()

|Test|Description|Inputs|Expected Outcome|Test Outcome|Result|
|----|-----------|------|----------------|------------|------|
| testSetNullColor | use null to set teamColor | null | "White" | null | fail[2] |
| testSetEmptyColor | use empty string to set teamColor | "" | "White" | "" | fail[3] |
| testSetColor | set a new teamColor | "Red" | "Red" | "Red"| pass |
| testModifyColor | modify the teamColor | "Blue" | "Blue" | "Blue" | pass |

fail[2] & fail[3]: Since the team must have appropriate clothing colors, if an invalid null or empty string is passed in, we hope that the color of teamColor remains unchanged, rather than being modified. 

Modification: Add judgment conditions, when the input string equals null or an empty string, the teamColor will not be updated. After Modification, these two test cases passed.

#### Function: addTeamMemberToList()

|Test|Description|Inputs|Expected Outcome|Test Outcome|Result|
|----|-----------|------|----------------|------------|------|
| testAddNullMember | add using an empty FBPlayer | empty FBPlayer | [] | Player Information | fail[4] |
| testAddMember1 | add a player | a FBPlayer | Player Information | Player Information | pass |
| testAddMember2 | add two different players | two FBPlayer | Player Information | Player Information | pass |
| testAddMember3 | add two same players | two FBPlayer | Player Information for once | Player Information for twice | fail[5] |

fail[4]: The team must have valid players, so when the player's name is null, it should not be added to the team.

fail[5]: In the addTeamMemberToList() method, it will add a player into FBTeam. Logically speaking, two players with identical information should not be able to be added to the same team. In this test case, addTeamMemberToList() can add that two players. So this feature may need to be changed.

Modification: Add judgment conditions, if the input teamMember is empty or already exists, it will not be added to the FBTeam. After Modification, these two test cases passed.

#### Function: removeTeamMemberFromList()

|Test|Description|Inputs|Expected Outcome|Test Outcome|Result|
|----|-----------|------|----------------|------------|------|
| testRemoveNExist | remove a player which is not exist | a FBPlayer | Player Information for another player | Player Information for another player | pass |
| testRemoveMember1 | remove the only one player | a FBPlayer | [] | [] | pass |
| testRemoveMember2 | remove one of the two players | a FBPlayer | Player Information for another player | Player Information for another player | pass |

#### Function: toString()

|Test|Description|Inputs|Expected Outcome|Test Outcome|Result|
|----|-----------|------|----------------|------------|------|
| testToString1 | print a null FBTeam | FBTeam | Team Information with None | Team Information with None | pass |
| testToString2 | print a FBTeam | FBTeam | Team Information with players | Team Information with Players | pass |



### Class: FBGame
**this part is tested by MIDORIKAWA MORIYA 20412352,SCYCL9 and Lewei Jiang 20412245,biylj9**
#### Function:getGameTime

| Test | Description                                             | Inputs                                | Expected Outcome             | Test Outcome                 | Result  |
|------|---------------------------------------------------------|---------------------------------------|------------------------------|------------------------------|---------|
| 1    | test new time with **current time(dafault date input)** | Date date = new Date()                | time now                     | time now                     | fail[1] |
| 2    | test new time with **long type date input**             | Date date = new Date(99999999999999L) | not equal                    | not equal                    | pass    |
| 3    | test new time with **string type date input**           | new Date("2002/05/10")                | Fri May 10 00:00:00 CST 2002 | Fri May 10 00:00:00 CST 2002 | pass    |
| 4    | test new time with **not good string type date input**  | new Date("------1969/05/10")          | Fri May 10 00:00:00 CST 1969 | Fri May 10 00:00:00 CST 1969 | pass    |
| 5    | test new time with **not good string type date input**  | new Date("------1969/05/10")          | True                         | False                        | fail[2] |
| 6    | test new time with **int type date input**              | new Date(0,0,0,0,0),new Date(0,0,0)   | two time are equal           | two time are equal           | pass    |
| 7    | test new time with **int type date input**              | new Date(0,0,0,0,0),new Date(0,0,0)   | True                         | False                        | fail[3] |
| 8    | set game time and get                                   | new FBGame(new Date(60000),,)         | 60000                        | 60000                        | pass    |
| 9    | set game time and get                                   | new FBGame(new Date(-1),,)            | -1                           | -1                           | pass    |
| 10   | set default time and get                                | new FBGame()                          | time now                     | time now                     | fail[4] |

fail[1] : there might exist milesecond difference between two code of new Date
fail[2] : compare to test 3 , when time string is different but time part is same,it will change to display same time,but not same string
fail[3] : similar reason with fail[2]
fail[4]:there will be milliseconds difference

#### Function:getGameVenue

| Test | Description                                          | Inputs              | Expected Outcome | Test Outcome | Result |
|------|------------------------------------------------------|---------------------|-----------------|--------------|--------|
| 1    | test default **string type venue** "TBD"             | TBD                 | TBD             | TBD          | pass   |
| 2    | test  **string type venue** "nottingham"             | nottingham          | nottingham      | nottingham   | pass   |
| 3    | test  **string type venue with ESC** "\r"            | \r                  | \r              | \r           | pass   |
| 4    | test  **space string type venue**                    |                     |                 |              | pass   |
| 5    | test  **chinese character string type venue**"中国"   | 中国                 | 中国              | 中国        | pass   |
| 6    | set game venue and get                               | new FBGame(,"ABC",) | "ABC"           | "ABC"        | pass   |
| 7    | set game no input and get                            | new FBGame(,"",)    | ""              | ""           | pass   |
| 8    | set default venue and get                            | new FBGame()        | "TBD"           | "TBD"        | pass   |
| 9    | set default venue and get                            | new FBGame(,,)      | error           | error        | pass   |


#### Function:getMaxPlayerNumber

| Test | Description                                                                                 | Inputs | Expected Outcome | Test Outcome | Result  |
|------|---------------------------------------------------------------------------------------------|--------|------------------|--------------|---------|
| 1    | test **default int type** maxplayer 0                                                       | 0      | 0                | 0            | pass    |
| 2    | test  **int type** maxplayer 24                                                             | 24     | 24               | 24           | pass    |
| 3    | test  **bad int type** maxplayer -24                                                        | -24    | -24              | -24          | pass    |
| 4    | test  **double type** maxplayer 999.9                                                       | 999.9  | 999.9            | 999.9        | fail[1] |
| 5    | test  **short type** maxplayer 1                                                            | 1      | 1                | 1            | pass    |
| 6    | test  **byte type** maxplayer 1                                                             | 1      | 1                | 1            | pass    |
| 7    | test  **char type** maxplayer "1"                                                           | "1"    | 1                | 1            | pass    |
| 8    | test  **char type** maxplayer "A" ,if A will automatically change to 65 by ASCII code tyble | "A"    | 65               | 65           | pass    |
| 9    | test **int type** maxplayer 0                                                               | 0      | 0                | 0            | pass    |
| 10   | test **double type** maxplayer -0.5                                                         | -0.5   | error            | error        | pass    |

fail[1] : smaller datatype **byte** **short** **char** chan automatically change to **int** type,but bigger datatype like **double** cant be automatically change to smaller datapyte **int**.

#### Function:getGameTeam1

| Test | Description                                                                                                           | Inputs             | Expected Outcome      | Test Outcome          | Result  |
|------|-----------------------------------------------------------------------------------------------------------------------|--------------------|-----------------------|-----------------------|---------|
| 1    | test **default object** created by **class :FBTeam**                                                                  | new FBTeam()       | new FBTeam()          | new FBTeam()          | fail[1] |
| 2    | test **default object** created by **class :FBTeam** and **new team** are both empty team                             | two isempty method | True                  | True                  | pass    |
| 3    | test **default object**  created by **class :FBTeam**,testing if the teamlist it self are same between two empty game | new FBTeam(),      | new FBTeam()          | new FBTeam()          | pass    |
| 4    | test same two empty game like 1,but assign same adress to them and test if the result of getGameTeam1 will be same    | new FBTeam(),      | new FBTeam()          | new FBTeam()          | pass    |

fail[1] : the display is same as follows:
**Expected :Team Members: None**     
**Actual   :Team Members: None**
but compare is fail. by test2,3,4 we found that it is problem about address
When using  getGameTeam1 ,it will return the address of object **tempgame** and **"footballgame1"**,altough they are both empty game. when new an object,it will assigh different address to these object in memory,so the result are actually different address,not same two empty list.

#### Function:getGameTeam2

| Test | Description                                                                                                           | Inputs             | Expected Outcome | Test Outcome | Result  |
|------|-----------------------------------------------------------------------------------------------------------------------|--------------------|------------------|--------------|---------|
| 1    | test **default object** created by **class :FBTeam**                                                                  | new FBTeam()       | new FBTeam()     | new FBTeam() | fail[1] |
| 2    | test **default object** created by **class :FBTeam** and **new team** are both empty team                             | two isempty method | True             | True         | pass    |
| 3    | test **default object**  created by **class :FBTeam**,testing if the teamlist it self are same between two empty game | new FBTeam(),      | new FBTeam()     | new FBTeam() | pass    |
| 4    | test same two empty game like 1,but assign same adress to them and test if the result of getGameTeam2 will be same    | new FBTeam(),      | new FBTeam()     | new FBTeam() | pass    |

fail[1]:same as getGameTeam1.

#### Function:getWaitList

| Test | Description                                                                                                           | Inputs                          | Expected Outcome            | Test Outcome                | Result  |
|------|-----------------------------------------------------------------------------------------------------------------------|---------------------------------|-----------------------------|-----------------------------|---------|
| 1    | test add a player to a game and get waitlist                                                                          | new FBGame(),addPlayer(player1) | a teamlist contains player1 | a teamlist contains player1 | pass    |
| 2    | test add no player to game and get waitlist                                                                           | new FBGame()                    | <[]>                        | <[]>                        | pass    |

#### Function:setGameTime

| Test | Description                                                                                                      | Inputs                                                     | Expected Outcome             | Test Outcome                 | Result  |
|------|------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------|------------------------------|------------------------------|---------|
| 1    | test when initialize an object with parameter **Date** if set function is useful                                 | new Date(99999999999999L)                                  | True                         | True                         | pass    | 
| 2    | test after initialize an object with parameter **Date** if set function can change the **Date** of this object   | new Date()                                                 | new Date()                   | new Date(99999999999999L)    | fail[1] | 
| 3    | create default game and set time                                                                                 | new FBGame(),setGameTime(new Date(700000000))              | Fri Jan 09 10:26:40 CST 1970 | the time now                 | fail[1] |
| 4    | create default game and set time of now                                                                          | new FBGame(),setGameTime(new Date());                      | the time now                 | the time now                 | fail[1] |
| 5    | create default game and set time with invalid integer                                                            | new FBGame(),setGameTime(new Date(70000000000))            | error                        | error                        | pass    |
| 6    | create a game with date(10000) and set time                                                                      | new FBGame(new Date(10000),,),setGameTime(new Date(70000)) | Thu Jan 01 08:01:40 CST 1970 | Thu Jan 01 08:00:10 CST 1970 | fail[1] |

fail[1]: show that setGameTime function is invalid to set game time with any exsit object, only it is valid when initialize an object with parameter.

#### Function:setGameVenue

| Test | Description                                                                                                                | Inputs                                  | Expected Outcome | Test Outcome | Result  |
|------|----------------------------------------------------------------------------------------------------------------------------|-----------------------------------------|------------------|--------------|---------|
| 1    | test when initialize an object with parameter **String** if set function is useful                                         | "nottingham"                            | True             | True         | pass    | 
| 2    | test after initialize an object with parameter **Date** if set function can change the **String**Game venue of this object | 'AAA"                                   | "AAA"            | "TBD"        | fail[1] |
| 3    | create default game and setGameVenue                                                                                       | new FBGame(),setGameVenue("ABC")        | "ABC"            | "TBD"        | fail[1] |
| 4    | create default game and setGameVenue without input                                                                         | new FBGame(),setGameVenue("")           | ""               | "TBD"        | fail[1] |
| 5    | create default game and setGameVenue with default venue                                                                    | new FBGame(),setGameVenue("TBD")        | "TBD"            | "TBD"        | pass    |
| 6    | create a game with venue"ABC" and setGameVenue without input                                                               | new FBGame(,"ABC",),setGameVenue("ABD") | "ABD"            | "ABC"        | fail[1] |

fail[1]: show that setGameVenue function is invalid to set game time with any exsit object, only it is valid when initialize an object with parameter.

#### Function:setMaxPlayerNumber

| Test | Description                                                                                                                  | Inputs                                   | Expected Outcome | Test Outcome | Result  |
|------|------------------------------------------------------------------------------------------------------------------------------|------------------------------------------|------------------|--------------|---------|
| 1    | test when initialize an object with parameter **int** if set function is useful                                              | new FBGame(),setMaxPlayerNumber(24)      | True             | True         | pass    | 
| 2    | test after initialize an object with parameter **int** if set function can change the **int** maxPlayerNumber of this object | new FBGame(),setMaxPlayerNumber(20)      | 20               | 24           | fail[1] | 
| 3    | create default game and setGameMaxPlayerNumber with invalid number                                                           | new FBGame(), setMaxPlayerNumber(0)      | 0                | 0            | fail[1] |
| 4    | create default game and setGameMaxPlayerNumber with valid number                                                             | new FBGame(), setMaxPlayerNumber(10)     | 10               | 0            | pass    |
| 5    | create default game and setGameMaxPlayerNumber with minus number                                                             | new FBGame(), setMaxPlayerNumber(-1)     | invalid input    | 0            | fail[1] |
| 6    | create default game and setGameMaxPlayerNumber with a fraction                                                               | new FBGame(), setMaxPlayerNumber(0.5)    | invalid input    | error        | fail[1] |
| 7    | create a game with max player number 10 and set MaxPlayerNumber 12                                                           | new FBGame(,,10), setMaxPlayerNumber(12) | 12               | 10           | fail[1] |

fail[1]: show that setMaxPlayerNumber function is invalid to set game time with any exsit object, only it is valid when initialize an object with parameter.

#### Function:setGameTeam1

| Test | Description                                                                                            | Inputs                                            | Expected Outcome                                  | Test Outcome                                      | Result     |
|------|--------------------------------------------------------------------------------------------------------|---------------------------------------------------|---------------------------------------------------|---------------------------------------------------|------------|
| 1    | test after initialize an object with parameter ,if set function can change the value of this object    | a team list with FBPlayer("john",20000000,"male") | a team list with FBPlayer("john",20000000,"male") | a team list with FBPlayer("john",20000000,"male") | pass       |
| 2    | test after initialize an object without parameter ,if set function can change the value of this object | a team list with FBPlayer("john",20000000,"male") | a team list with FBPlayer("john",20000000,"male") | a team listwith FBPlayer("john",20000000,"male")  | pass       |
#### Function:setGameTeam2

| Test | Description                                                                                            | Inputs                                             | Expected Outcome                                  | Test Outcome                                       | Result |
|------|--------------------------------------------------------------------------------------------------------|----------------------------------------------------|---------------------------------------------------|----------------------------------------------------|--------|
| 1    | test after initialize an object with parameter ,if set function can change the value of this object    | a team list with FBPlayer("john",20000000,"male")  | a team list with FBPlayer("john",20000000,"male") | a team list with FBPlayer("john",20000000,"male")  | pass   |
| 2    | test after initialize an object without parameter ,if set function can change the value of this object | a team listwith FBPlayer("john",20000000,"male")   | a team list with FBPlayer("john",20000000,"male") | a team listwith FBPlayer("john",20000000,"male")   | pass   |

#### Function:addPlayer
| Test | Description                                                | Inputs                                | Expected Outcome    | Test Outcome        | Result |
|------|------------------------------------------------------------|---------------------------------------|---------------------|---------------------|--------|
| 1    | test if addPlayer function can add a new player to a list  | new FBPlayer("john",20000000,"male")  | two list are equal  | two list are equal  | pass   |

#### Function:isTimeValid

| Test | Description                                                                               | Inputs                      | Expected Outcome | Test Outcome | Result |
|------|-------------------------------------------------------------------------------------------|-----------------------------|------------------|--------------|--------|
| 1    | test if this function can check if time is valid after initialize a object                | footballgame1.isTimeValid() | False            | False        | pass   |
| 2    | test if this function can check if time is valid after initialize a object                | footballgame2.isTimeValid() | False            | False        | pass   |
| 3    | test if this function can check if time is valid after initialize a object with null Date | FBgame(null,,)              | True             | True         | pass   |
| 4    | test if this function can check if time is valid after initialize a object with new Date  | FBgame(new Date(10),,)      | False            | False        | pass   |

#### Function:isVenueValid

| Test | Description                                                                                    | Inputs                       | Expected Outcome | Test Outcome | Result  |
|------|------------------------------------------------------------------------------------------------|------------------------------|------------------|--------------|---------|
| 1    | test if this function can chaek if Venue is valid after initialize a object                    | footballgame1.isVenueValid() | False            | False        | pass    |
| 2    | test if this function can chaek if Venue is valid after initialize a object                    | footballgame2.isVenueValid() | False            | False        | pass    |
| 3    | test if this function can chaek if Venue is valid after initialize a object with venue of null | FBgame(,null,)               | True             | False        | fail[1] |
| 4    | test if this function can chaek if Venue is valid after initialize a object with venue         | FBgame(,"TBD",)              | False            | False        | pass    |
| 5    | test if this function can chaek if Venue is valid after initialize a object with venue of ""   | FBgame(,"",)                 | False            | False        | pass    |

fail[1]: the venue of null is still valid

#### Function:isMaxPlayerValid

| Test | Description                                                                                        | Inputs                           | Expected Outcome | Test Outcome | Result  |
|------|----------------------------------------------------------------------------------------------------|----------------------------------|------------------|--------------|---------|
| 1    | test if this function can chaek if MaxPlayer is valid after initialize a object                    | footballgame1.isMaxPlayerValid() | False            | False        | fail[1] |
| 2    | test if this function can chaek if MaxPlayer is valid after initialize a object                    | footballgame2.isMaxPlayerValid() | False            | False        | pass    |
| 3    | test if this function can chaek if MaxPlayer is valid after initialize a object                    | FBgame()                         | True             | True         | pass    |
| 4    | test if this function can chaek if MaxPlayer is valid after initialize a object with max number 10 | FBgame(,,10)                     | False            | False        | pass    |
| 5    | test if this function can chaek if MaxPlayer is valid after initialize a object with input -1      | FBgame(,,-1)                     | False            | False        | pass    |
| 6    | test if this function can chaek if MaxPlayer is valid after initialize a object with null input    | FBgame(,,)                       | error            | error        | pass    |

fail[1]: when initialize an object without parameter ,isMaxplayervalid function cheak whether the number is 0 instead of null,thus it is fail, but the take reality into consideration there is no problem.

#### Function:getGameInfo
| Test | Description                                         | Inputs         | Expected Outcome | Test Outcome | Result |
|------|-----------------------------------------------------|----------------|------------------|--------------|--------|
| 1    | test if this function output match expected string  | footballgame1  | GameInfo1        | GameInfo1    | pass   |



### Class: FBPlayer

_Written by Jianxing Wang and Bodong Wang_

#### Function: getPersonID()

|Test|Description|Inputs|Expected Outcome|Test Outcome|Result|
|----|-----------|------|----------------|------------|------|
| testgetPersonID | get default personID | null | 0 | 0 | pass|


#### Function: getPersonName()

|Test|Description|Inputs|Expected Outcome|Test Outcome|Result|
|----|-----------|------|----------------|------------|------|
| testgetPersonName | get default personName | null | [] | [] ｜ pass |


#### Function: getPersonGender()

|Test|Description|Inputs|Expected Outcome|Test Outcome|Result|
|----|-----------|------|----------------|------------|------|
| testgetPersonGender | get default personName | null | [] | [] | pass |


#### Function: setPersonID()
_In the 'set' part, if the previous 'get' can't capture the content in the correct format, this part will not receive the result._
|Test|Description|Inputs|Expected Outcome|Test Outcome|Result|
|----|-----------|------|----------------|------------|------|
| testsetPersonID | set a new personID with integers | 123456 | 123456 | 123456 |pass|
| testsetPersonID | set a new personID with integers and character |123a | fail |fail | fail[1] |

#### Function: setPersonGender()
_In the gender part, we should judge whether the input is not gender, and if it is not' male' or' female', it is judged that the format is unqualified._
|Test|Description|Inputs|Expected Outcome|Test Outcome|Result|
|----|-----------|------|----------------|------------|------|
| testsetPersonGender | set a player gender | male | male | male | pass |
| testsetPersonGender | set a player gender | abc | misformate | abc | fail |


#### Function: setPersonName()
|Test|Description|Inputs|Expected Outcome|Test Outcome|Result|
|----|-----------|------|----------------|------------|------|
| testsetPersonName | set a player name | mike | mike | mike | pass |


#### Function: isNameValid()
_In this part, I think the program should not only report errors, but also give users feedback, such as unqualified input format._
|Test|Description|Inputs|Expected Outcome|Test Outcome|Result|
|----|-----------|------|----------------|------------|------|
| testisNameValid | get default personName | null | 10000000 | 10000000 | pass |


#### Function: isIDValid()
_In this part, I think the program should not only report errors, but also give users feedback, such as unqualified input format.Here I have listed that if there is a space in the middle of the number or a space in front of the number, and both the number and the letter are input at the same time._
|Test|Description|Inputs|Expected Outcome|Test Outcome|Result|
|----|-----------|------|----------------|------------|------|
| testisIDValid | get default personName | null | null | null | pass  |


#### Function: isGenderValid()
_There is a big problem in this part. For example, if the other party just casually enters a letter string, it will be returned as gender. We need to add code to make it possible to judge whether the user inputs gender._
|Test|Description|Inputs|Expected Outcome|Test Outcome|Result|
|----|-----------|------|----------------|------------|------|
| testisGenderValid | get default personGender | null | null | null | pass  |
fail[1]: type mismatch 'It can be improved that if type mismatch appears, the print id format is unqualified. ' 



### Class: FBApp

#### Function: SearchFootBallPlayers()

_Written by Yanqian Wang_

println() in FBApp will add a System.lineSeparator() to the end of string. Due to the different processing results of different operating systems, it is also necessary to use System.lineSeparator() in the test file.

|Test|Description|Inputs|Expected Outcome|Test Outcome|Result|
|----|-----------|------|----------------|------------|------|
| testEmptyPlayer | assume the user presses Enter directly | "\n" | "Enter Player Name: " | "Enter Player Name: " | pass |
| testExistPlayer1 | search for existing players | "Superman" | Player Information | Player Information | pass |
| testExistPlayer2 | search for existing players with spaces in their names | "Wonder Woman" | Player Information | Player Information | pass |
| testNExistPlayer | search using a non-existent name | "April" | "Enter Player Name: " | "Enter Player Name: " | pass |
| testPlayerId | search using a personID | "20220808" | "Enter Player Name: " | "Enter Player Name: " | pass |
| testPlayerGender | search using a personGender | "Male" | "Enter Player Name: " | "Enter Player Name: " | pass |


#### Function: AddFootballPlayer()

_Written by Yanqian Wang_

|Test|Description|Inputs|Expected Outcome|Test Outcome|Result|
|----|-----------|------|----------------|------------|------|
| testAddPlayer1 | add a player and 0 game to join | "Lily\nFemale\n20415577\n0\n" | Message with "Lily id 20415577" | Message with "Lily id 20415577" | pass |
| testAddPlayer2 | add two players and 0 game to join | "Lily\nFemale\n20415577\n0\n"<br>"Tom\nMale\n20411254\n0\n" | Message with "Lily id 20415577"<br>"Tom id 20411254" | Message with "Lily id 20415577"<br>"Tom id 20411254" | pass |
| testGameNum | input -1 for the number of games to join | "Lily\nFemale\n20415577\n-1\n" | Message with "Lily id 20415577" | Message with "Lily id 20415577" | pass |
| testGameId | test gameId out of bound | "Lily\nFemale\n20415577\n1\n0\n" | Message with "Lily id 20415577" | error: java.lang.IndexOutOfBoundsException | fail |
| testAddtoGame1 | add a player to a game | "Lily\nFemale\n20415577\n1\n1\n" | "Lily"20415577"Female" | "Lily"20415577"Female" | pass |
| testAddtoGame2 | add two players to a game | "Lily\nFemale\n20415577\n1\n1\n"<br>"Tom\nMale\n20411254\n1\n1\n" | "Lily"20415577"Female"<br>"Tom"20411254"Male" | "Lily"20415577"Female"<br>"Tom"20411254"Male" | pass |

fail: In FBApp, we access games in footBallGames through index starting from 0. When index of ArrayList less than 0, it will throw an IndexOutOfBoundsException.

modification: Add a judgment on whether the ID is valid. If ID less than 1, it will enter the next cycle. After modification, this test case passed.


#### Function:SearchFootBallGame()

Written by Pengyu Zhi

|Test|Inputs|Expected Outcome|Test Outcome|Result|
|----|------|----------------|------------|------|
| SearchFootBallGameTest1 | "Enter Game Time: "+"Time is "+fbGame.getGameTime()+", venue is "+fbGame.getGameVenue()+System.lineSeparator()+"Team 1 color is "+fbGame.getGameTeam1().getTeamColor()+System.lineSeparator()+fbGame.getGameTeam1().toString()+System.lineSeparator()+"Team 2 color is "+fbGame.getGameTeam2().getTeamColor()+System.lineSeparator()+fbGame.getGameTeam2().toString()+System.lineSeparator()&&outContent.toString() | Enter Game Time: Time is Sun Apr 23 15:14:17 CST 2023, venue is outside football fieldTeam 1 color is WhiteTeam Members: NoneTeam 2 color is WhiteTeam Members: None | Enter Game Time: Time is Sun Apr 23 15:14:17 CST 2023, venue is outside football fieldTeam 1 color is WhiteTeam Members: NoneTeam 2 color is WhiteTeam Members: NoneThere is not any game at 23/04/2023 | fail |

Failed Reason:
In this function, if the given game's date can be found, this game's information will be displayed, and then the variable "game" increment by one.
After displaying game's infomation, if checks if the variable "game" is greater than zero, if it is, display the message "There is not any game at ...".
In this test,the variable "game" becomes one, so the message "There is not any game at ..." was printed.
Obviously, it not correct.We don't want this message appear. So we should change that condition to "games==0".

#### Function:SearchFootBallGame()

|Test|Inputs|Expected Outcome|Test Outcome|Result|
|----|------|----------------|------------|------|
| SearchFootBallGameTest2 | "Enter Game Time: "+"There is not any game at 25/06/2040"&&outContent.toString() | Enter Game Time: There is not any game at 25/06/2040 | Enter Game Time:  | fail |

Failed Reason:
since no game's date is "25/06/2040", the variable "game" stays zero. So nothing would be printed out
#### Function:setTeamMember()
//Written by Lewei Jiang 20412245,biylj9

| Test | Inputs                                                                                                                                                                                     | Expected Outcome                                | Test Outcome                                    | Result |
|------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------|-------------------------------------------------|--------|
| 1    | Date curDate=new Date(); FBGame fbGame=new FBGame(curDate,,);create 9 player: fbGame.addPlayer(new FBPlayer());FBApp.footBallGames.add(fbGame); String input2 = "1 5 1 2 3 4 6 1 2 3 4 5"; | add 5 players for team1 and 6 players for team2 | add 4 players for team1 and 5 players for team2 | fail   |
| 2    | Date curDate=new Date(); FBGame fbGame=new FBGame(curDate,,);create 9 player: fbGame.addPlayer(new FBPlayer());FBApp.footBallGames.add(fbGame); String input2 = "1 4 1 2 3 4 5 1 2 3 4 5"; | add 4 players for team1 and 5 players for team2 | add 4 players for team1 and 5 players for team2 | pass   |

//fail:the input of memberNumber != the input number of teammember
//Modification: change the memberNumber,make it = NextInt rather than NextInt-1 

#### Function:main
//Written by Lewei Jiang 20412245,biylj9

| Test | Inputs               | Expected Outcome                                               | Test Outcome                                                   | Result |
|------|----------------------|----------------------------------------------------------------|----------------------------------------------------------------|--------|
| 1    | String input2 = "X"; | the main menu + "Good Bye"                                     | the main menu + "Good Bye"                                     | pass   |
| 2    | String input2 = "D"; | the main menu + the game1                                      | the main menu + the game1 + the main menu                      | pass   |
| 3    | String input2 = "P"; | the main menu + 9 Players + the main menu                      | the main menu + 9 Players+ the main menu                       | pass   |
| 4    | String input2 = "R"; | the main menu + Enter Player Name: + the main menu             | the main menu + Enter Player Name: + the main menu             | pass   |
| 5    | String input2 = "S"; | the main menu + Enter Game Time: + the main menu               | the main menu + Enter game time: (dd/MM/yyyy) + the main menu  | pass   |
| 6    | String input2 = "A"; | the main menu + Enter game time: (dd/MM/yyyy) + the main menu  | the main menu + Enter Game Time: + the main menu               | pass   |
| 7    | String input2 = "F"; | the main menu + Enter footballPlayer name: + the main menu     | the main menu + Enter footballPlayer name: + the main menu     | pass   |
| 8    | String input2 = "K"; | the main menu + the game1 + 9player + the main menu            | the main menu + the game1 + 9player + the main menu            | pass   |
| 9    | String input2 = "Q"; | the main menu + Which game to set team color?: + the main menu | the main menu + Which game to set team color?: + the main menu | pass   |
| 10   | String input2 = "M"; | the main menu + Which game to set members?: + the main menu    | the main menu + Which game to set members?: + the main menu    | pass   |
| 10   | String input2 = "B"; | the main menu + the main menu                                  | the main menu   + the main menu                                | pass   |

Failed Reason: the variable memberNumber in this method should not -1

#### Function:addPlayersToGame()
//Written by Lewei Jiang 20412245,biylj9

| Test | Inputs                                                                                                                                                                                                                        | Expected Outcome                | Test Outcome            | Result  |
|------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------|-------------------------|---------|
| 1    | Date curDate=new Date(); new ArrayList<FBGame>(); new ArrayList<FBPlayer>(); FBGame fbGame=new FBGame(curDate,,);FBPlayer player1=new FBPlayer;FBApp.footBallGames.add(fbGame);String input2 = "1 1 1";                       | add player1 to game             | add player1 to game     | pass    |
| 2    | Date curDate=new Date(); new ArrayList<FBGame>(); new ArrayList<FBPlayer>(); FBGame fbGame=new FBGame(curDate,,);create 2 players: 2× FBPlayer player=new FBPlayer;FBApp.footBallGames.add(fbGame);String input2 = "1 2 1 2"; | add player1 and player2 to game | add player1 to game     | pass    |
| 3    | Date curDate=new Date(); new ArrayList<FBGame>(); new ArrayList<FBPlayer>(); no player created FBApp.footBallGames.add(fbGame);String input2 = "1 0";                                                                         | no player added                 | no player addedn        | pass    |



#### Function:setTeamColor()
//Written by MIDORIKAWA MORIYA scycl9 20412352

| Test | Inputs                                                                                                                                                                                                                        | Expected Outcome                | Test Outcome            | Result  |Description|
|------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------|-------------------------|---------|----|
|TestsetTeamColor1|string:"1\r\n"+"red\r\n"+"blue\r\n"|"all games"+temp game i added +related string when set team color successful.|"all games"+temp game i added +related string when set team color successful.|pass|this test is used to test the basic function of method setTeamColor| 
|TestsetTeamColor2|string:"1\r\n"+"red\r\n"+"blue\r\n"|red,blue|red,blue|pass|this test is used to test if team1 and team2 "s color is change to the input color| 

**note**: this test is done in WINDOWS system ,thus use "\r\n"

#### Function:addGame()
//Written by MIDORIKAWA MORIYA scycl9 20412352

| Test | Inputs                                                                                                                                                                                                                        | Expected Outcome                | Test Outcome            | Result  |Description|
|------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------|-------------------------|---------|----|
|testaddGame1|string:"02/05/2023\r\n"+"TBD\r\n"+"20|"Enter game time: (dd/MM/yyyy)" +"Enter game venue: " +"Enter game max number of players: " +"Team created successfully.\r\n" +getGameInfo()|"Enter game time: (dd/MM/yyyy)" +"Enter game venue: " +"Enter game max number of players: " +"Team created successfully.\r\n" +getGameInfo()|pass|this test is to test if addGame()method can add new game successfully when input is correct format 
|testaddGame2|string:"hahaha\r\n"|java.lang.RuntimeException: java.text.ParseException: Unparseable date: "hahaha"|java.lang.RuntimeException: java.text.ParseException: Unparseable date: "hahaha"|fail|this test is to test if addGame()method can manipulate wrong input format for date,the test should fail|
**note**: this test is done in WINDOWS system ,thus use "\r\n"
