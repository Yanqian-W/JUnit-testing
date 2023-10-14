


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FBGameTest {
    FBGame footballgame1;
    FBGame footballgame2;
    @BeforeEach
    void init() {
        this.footballgame1 = new FBGame(); // initalise a object
        this.footballgame2 = new FBGame(new Date(99999999999999L),"nottingham",24);
    }

    @Test
    void TestgetGameTime1() {
        Date date = new Date();
        assertEquals(date,footballgame1.getGameTime()); // fail test1
    }
    @Test
    void TestgetGameTime2() {
        Date date = new Date();
        assertFalse(date==footballgame2.getGameTime());// pass test2
    }
    @Test
    void TestgetGameTime3() {
        Date date = new Date("2002/05/10");
        FBGame tempgame1 = new FBGame(new Date("2002/05/10"),"nottingham",24);
        assertEquals(date,tempgame1.getGameTime());
    } //pass test3
    @Test
    void TestgetGameTime4() {
        Date date = new Date("------1969/05/10");
        FBGame tempgame1 = new FBGame(new Date("1969/05/10"),"nottingham",24);
        assertEquals(date , tempgame1.getGameTime());
    } //pass test4
    @Test
    void TestgetGameTime5() {
        Date date = new Date("------1969/05/10");
        FBGame tempgame1 = new FBGame(new Date("1969/05/10"),"nottingham",24);
        assertTrue(date == tempgame1.getGameTime());
    } //fail test 5
    @Test
    void TestgetGameTime6() {
        Date date = new Date(0,0,0,0,0);
        FBGame tempgame1 = new FBGame(new Date(0,0,0),"nottingham",24);
        assertEquals(date,tempgame1.getGameTime());
    } //pass test6
    @Test
    void TestgetGameTime7() {
        Date date = new Date(0,0,0,0,0);
        FBGame tempgame1 = new FBGame(new Date(0,0,0),"nottingham",24);
        assertTrue(date == tempgame1.getGameTime());
    } //fail test7
    @Test
    void TestgetGameTime78() {
        FBGame game2 = new FBGame(new Date(60000),"TBD",12);
        Date gameTime = game2.getGameTime();
        assertEquals(gameTime, new Date(60000));
    }

    @Test
    void TestgetGameTime9() {
        FBGame game2 = new FBGame(new Date(-1),"TBD",12);
        Date gameTime = game2.getGameTime();
        assertEquals(gameTime, new Date(-1));
    }

    @Test
    void TestgetGameTime10() {
        FBGame game2 = new FBGame();
        Date gameTime = game2.getGameTime();
        assertEquals(gameTime, new Date());
    }//fail

    //TestgetGameVenue text
    @Test
    void TestgetGameVenue1() {
        assertEquals("TBD",footballgame1.getGameVenue());
    } // pass test1
    @Test
    void TestgetGameVenue2() {
        assertEquals("nottingham",footballgame2.getGameVenue());
    }
    // pass test2
    @Test
    void TestgetGameVenue3() {
        FBGame tempgame1 = new FBGame(new Date(),"\r",0);
        assertEquals("\r",tempgame1.getGameVenue());
    } // pass test3
    @Test
    void TestgetGameVenue4() {
        FBGame tempgame1 = new FBGame(new Date(),"",0);
        assertEquals("",tempgame1.getGameVenue());
    } // pass test4
    @Test
    void TestgetGameVenue5() {
        FBGame tempgame1 = new FBGame(new Date(),"中国",0);
        assertEquals("中国",tempgame1.getGameVenue());
    } // pass test5


    @Test
    void TestgetGameVenue6() {
        FBGame game2 = new FBGame(new Date(60000),"ABC",12);
        String gameVenue = game2.getGameVenue();
        assertEquals(gameVenue, "ABC");
    }

    @Test
    void TestgetGameVenue7() {
        FBGame game2 = new FBGame(new Date(60000),"",12);
        String gameVenue = game2.getGameVenue();
        assertEquals(gameVenue, "");
    }

    @Test
    void TestgetGameVenue8() {
        FBGame game2 = new FBGame();
        String gameVenue = game2.getGameVenue();
        assertEquals(gameVenue, "TBD");
    }

    /*@Test
   void TestgetGameVenue9() {
        FBGame game2 = new FBGame(new Date(),,12);
        String gameVenue = game2.getGameVenue();
        assertEquals(gameVenue, "TBD");
    }//it will cause error*/

//TestgetMaxPlayerNumber text
    @Test
    void TestgetMaxPlayerNumber1() {
        assertEquals(0,footballgame1.getMaxPlayerNumber()); // pass test1
    }
    @Test
    void TestgetMaxPlayerNumber2() {
        assertEquals(24,footballgame2.getMaxPlayerNumber()); //pass test2
    }
    @Test
    void TestgetMaxPlayerNumber3() {
        FBGame tempgame1 = new FBGame(new Date(0L),"nottingham",-24);
        assertEquals(-24,tempgame1.getMaxPlayerNumber()); //pass test3
    }
    //    @Test
//    void TestgetMaxPlayerNumber4() {
//        double maxplayer = 999.9 ;
//        FBGame tempgame1 = new FBGame(new Date(0L),"nottingham",maxplayer);
//        assertEquals(999.9,tempgame1.getMaxPlayerNumber()); //fail test4
//    }
    @Test
    void TestgetMaxPlayerNumber5() {
        short maxplayer = 1 ;
        FBGame tempgame1 = new FBGame(new Date(0L),"nottingham",maxplayer);
        assertEquals(1,tempgame1.getMaxPlayerNumber()); //pass test5
    }
    @Test
    void TestgetMaxPlayerNumber6() {
        byte maxplayer = 1 ;
        FBGame tempgame1 = new FBGame(new Date(0L),"nottingham",maxplayer);
        assertEquals(1,tempgame1.getMaxPlayerNumber()); //pass test6
    }
    @Test
    void TestgetMaxPlayerNumber7() {
        char maxplayer = '1' ;
        FBGame tempgame1 = new FBGame(new Date(0L),"nottingham",maxplayer);
        assertEquals(1,tempgame1.getMaxPlayerNumber()); //pass test7
    }
    @Test
    void TestgetMaxPlayerNumber8() {
        char maxplayer = 'A' ;
        FBGame tempgame1 = new FBGame(new Date(0L),"nottingham",maxplayer);
        assertEquals(65,tempgame1.getMaxPlayerNumber()); //pass test8
    }

    @Test
    void TestgetMaxPlayerNumber9() {
        FBGame game2 = new FBGame(new Date(),"TBD",0);
        int maxPlayerNumber = game2.getMaxPlayerNumber();
        assertEquals(maxPlayerNumber,0);
    }
 /*   @Test
    void TestgetMaxPlayerNumber10() {
        FBGame game2 = new FBGame(new Date(),"TBD",-0.5f);
        int maxPlayerNumber = game2.getMaxPlayerNumber();
        assertEquals(maxPlayerNumber,-0.5);
    }*/
 // getGameTeam1 test
    @Test
    void TestgetGameTeam1_1() {
        assertEquals(new FBTeam(),footballgame1.getGameTeam1());
    } //fail test1

    @Test
    void TestgetGameTeam1_2() {
        FBTeam tempteam = new FBTeam();
        assertTrue(tempteam.getTeamList().isEmpty()== footballgame1.getGameTeam1().getTeamList().isEmpty()); // pass ,show that they are actually empty teamlist
    } //pass test2
    @Test
    void TestgetGameTeam1_3(){
        FBGame tempgame = new FBGame();
        FBTeam tempteam = new FBTeam();
        assertEquals(tempteam.getTeamList(),tempgame.getGameTeam1().getTeamList());
    } //pass test3
    @Test
    void TestgetGameTeam1_4(){
        FBGame tempgame = footballgame1;
        assertEquals(tempgame.getGameTeam1(),footballgame1.getGameTeam1());
    } //pass test4

    // getGameTeam2 test
    @Test
    void TestgetGameTeam2_1() {
        assertEquals(new FBTeam(),footballgame1.getGameTeam2());
    } //fail test1

    @Test
    void TestgetGameTeam2_2() {
        FBTeam tempteam = new FBTeam();
        assertTrue(tempteam.getTeamList().isEmpty()== footballgame1.getGameTeam2().getTeamList().isEmpty()); // pass ,show that they are actually empty teamlist
    } //pass test2
    @Test
    void TestgetGameTeam2_3(){
        FBGame tempgame = new FBGame();
        FBTeam tempteam = new FBTeam();
        assertEquals(tempteam.getTeamList(),tempgame.getGameTeam2().getTeamList());
    } //pass test3
    @Test
    void TestgetGameTeam2_4(){
        FBGame tempgame = footballgame1;
        assertEquals(tempgame.getGameTeam2(),footballgame1.getGameTeam2());
    } //pass test4

    // getWaitList test
    @Test
    void getWaitList1() {
        FBGame game2 = new FBGame();
        FBPlayer player1 = new FBPlayer("Echo",20610004,"F");
        game2.addPlayer(player1);
        FBTeam teamlist = game2.getWaitList();
        FBTeam team = new FBTeam();
        team.addTeamMemberToList(player1);
        assertEquals(teamlist.getTeamList(),team.getTeamList());
    }
    @Test
    void getWaitList2() {
        FBGame game2 = new FBGame();
        FBPlayer player1 = new FBPlayer("Echo",20610004,"F");
        //game2.addPlayer(player1);
        FBTeam teamlist = game2.getWaitList();
        FBTeam team = new FBTeam();
        //team.addTeamMemberToList(player1);
        assertEquals(teamlist.getTeamList(),team.getTeamList());
    }
    // setGameTime tests
    @Test
    void TestsetGameTime1() {
        Date testdate = new Date(99999999999999L);
        assertTrue(testdate.getTime() == footballgame2.getGameTime().getTime()); //pass test1
    } // set is valid when initialize a object
    @Test
    void TestsetGameTime2() {
        Date testdate = new Date(99999999999999L);
        footballgame2.setGameTime(new Date());
        assertEquals(footballgame1.getGameTime(),testdate); // fail test2
    } // this set cant change gametime after new object was initialized
    @Test
    void TestsetGameTime3() {
        FBGame game2 = new FBGame();
        game2.setGameTime(new Date(700000000));
        assertEquals(game2.getGameTime(),new Date(700000000));//something wrong happens
    }
    @Test
    void TestsetGameTime4() {
        FBGame game2 = new FBGame();
        game2.setGameTime(new Date(70000000));
        assertEquals(game2.getGameTime(),new Date());//something wrong happens
    }
    @Test
    void TestsetGameTime5() {
        FBGame game2 = new FBGame();
        game2.setGameTime(new Date(70000000));
        assertEquals(game2.getGameTime(),new Date());//something wrong happens
    }
    @Test
    void TestsetGameTime6() {
        FBGame game2 = new FBGame(new Date(10000),"TBD",12);
        game2.setGameTime(new Date(70000000));
        assertEquals(game2.getGameTime(),new Date(100000));//something wrong happens
    }

    //setGameVenue tests
    @Test
    void TestsetGameVenue1() {
        String Nott = "nottingham";
        assertTrue(Nott == footballgame2.getGameVenue()); //pass test1
    } // set is valid when initialize a object
    @Test
    void TestsetGameVenue2() {
        String place = "AAA";
        footballgame1.setGameVenue(place);
        assertEquals("AAA",footballgame1.getGameVenue()); /// fail test2
    }
    @Test
    void TestsetGameVenue3() {
        FBGame game2 = new FBGame();
        game2.setGameVenue("ABC");
        assertEquals(game2.getGameVenue(),"ABC");
    }
    @Test
    void TestsetGameVenue4() {
        FBGame game2 = new FBGame();
        game2.setGameVenue("");
        assertEquals(game2.getGameVenue(),"");//
    }
    @Test
    void TestsetGameVenue5() {
        FBGame game2 = new FBGame();
        game2.setGameVenue("TBD");
        assertEquals(game2.getGameVenue(),"TBD");//something wrong happens
    }
    @Test
    void TestsetGameVenue6() {
        FBGame game2 = new FBGame(new Date(),"ABC",10);
        game2.setGameVenue("ABD");
        assertEquals(game2.getGameVenue(),"ABD");//something wrong happens
    }

    //setMaxPlayerNumber tests
    @Test
    void TestsetMaxPlayerNumber1() {
        int num = 24 ;
        assertEquals(num,footballgame2.getMaxPlayerNumber()); //pass test1
    }
    @Test
    void TestsetMaxPlayerNumber2() {
        int num = 20 ;
        footballgame2.setMaxPlayerNumber(num);
        assertEquals(20,footballgame2.getMaxPlayerNumber()); //fail test2
    }
    @Test
    void TestsetMaxPlayerNumber3() {
        FBGame game2 = new FBGame(new Date(),"TBD",12);
        game2.setMaxPlayerNumber(5);
        assertEquals(game2.getMaxPlayerNumber(),5);
    }
    @Test
    void TestsetMaxPlayerNumber4() {
        FBGame game2 = new FBGame();
        game2.setMaxPlayerNumber(0);
        assertEquals(game2.getMaxPlayerNumber(),0);
    }
    @Test
    void TestsetMaxPlayerNumber5() {
        FBGame game2 = new FBGame();
        game2.setMaxPlayerNumber(5);
        assertEquals(game2.getMaxPlayerNumber(),-1);
    }

    // setGameteam1 tests
    @Test
    void TestsetGameTeam1_1() {
        FBTeam testteam = new FBTeam();
        testteam.addTeamMemberToList(new FBPlayer("john",20000000,"male"));
        System.out.println(testteam);//Team Members: [0]: john,show that successfully add a member
        footballgame2.setGameTeam1(testteam);
        assertEquals(footballgame2.getGameTeam1(),testteam);//pass test1
    }
    @Test
    void TestsetGameTeam1_2() {
        FBTeam testteam = new FBTeam();
        testteam.addTeamMemberToList(new FBPlayer("john",20000000,"male"));
        System.out.println(testteam);//Team Members: [0]: john,show that successfully add a member
        footballgame1.setGameTeam1(testteam);
        assertEquals(footballgame1.getGameTeam1(),testteam);//pass test2
    }
    // setGameteam2tests
    @Test
    void TestsetGameTeam2_1() {
        FBTeam testteam = new FBTeam();
        testteam.addTeamMemberToList(new FBPlayer("john",20000000,"male"));
        System.out.println(testteam);//Team Members: [0]: john,show that successfully add a member
        footballgame2.setGameTeam2(testteam);
        assertEquals(footballgame2.getGameTeam2(),testteam);//pass test1
    }
    @Test
    void TestsetGameTeam2_2() {
        FBTeam testteam = new FBTeam();
        testteam.addTeamMemberToList(new FBPlayer("john",20000000,"male"));
        System.out.println(testteam);//Team Members: [0]: john,show that successfully add a member
        footballgame1.setGameTeam2(testteam);
        assertEquals(footballgame1.getGameTeam2(),testteam);//pass test2
    }


    // addPlayer tests
    @Test
    void TestaddPlayer1() {
        FBPlayer player1 = new FBPlayer("john",20000000,"male");
        footballgame1.addPlayer(player1);
        footballgame2.addPlayer(player1);
        assertEquals(footballgame2.getWaitList().getTeamList(),footballgame1.getWaitList().getTeamList()); // pass test1
    } // pass test1

    // isTimeValid tests
    @Test
    void TestisTimeValid1() {
        assertFalse (footballgame1.isTimeValid()); //pass 空参
    }// pass test1
    @Test
    void TestisTimeValid2() {
        assertFalse (footballgame2.isTimeValid());
    }//pass test2

    @Test
    void TestisTimeValid3() {
        FBGame game = new FBGame(null,"abc",10);
        assertSame(game.isTimeValid(),true);
    }
    @Test
    void TestisTimeValid4() {
        FBGame game = new FBGame(new Date(10000),"abc",10);
        assertSame(game.isTimeValid(),true);
    }

    // isVenueValid tests
    @Test
    void TestisVenueValid1() {
        assertFalse (footballgame1.isVenueValid()); //pass
    } //pass test1
    @Test
    void TestisVenueValid2() {
        assertFalse (footballgame2.isVenueValid());
    }  //pass test2

    @Test
    void TestisVenueValid3() {
        FBGame game = new FBGame(new Date(),"",10);
        assertSame(game.isVenueValid(),false);
    }
    @Test
    void TestisVenueValid4() {
        FBGame game = new FBGame(new Date(),"TBD",10);
        assertSame(game.isTimeValid(),false);
    }
    @Test
    void TestisVenueValid5() {
        FBGame game = new FBGame(new Date(),null,10);
        assertSame(game.isTimeValid(),true);
    }

    // isPlayerNumValid tests
    @Test
    void TestisPlayerNumValid1() {
        assertFalse (footballgame1.isPlayerNumValid());//fail
    } //fail test1
    @Test
    void TestisPlayerNumValid2() {
        assertFalse(footballgame2.isPlayerNumValid());
    } //pass test2

    @Test
    void TestisPlayerNumValid3() {
        FBGame game = new FBGame(new Date(),"BCD",-1);
        assertSame(game.isPlayerNumValid(),false);
    }
    @Test
    void TestisPlayerNumValid4() {
        FBGame game = new FBGame(new Date(),"BCD",10);
        assertSame(game.isPlayerNumValid(),false);
    }
    @Test
    void TestisPlayerNumValid5() {
        FBGame game = new FBGame();
        assertSame(game.isPlayerNumValid(),true);
    }
 /*   @Test
    void TestisPlayerNumValid6() {
        FBGame game = new FBGame(new Date(),"BCD",null);
        assertSame(game.isPlayerNumValid(),false);
    }*/

    @Test
    void TestgetGameInfo1() {
        // Create a stream to hold the output
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        // Save the old System.out to prevent error occure when reusing it
        PrintStream old = System.out;
        // Tell Java to use your special stream
        System.setOut(ps);
        // Print some output: goes to your special stream
        footballgame2.getGameInfo();
        // Put things back
        System.out.flush();
        System.setOut(old);
        // test
//      System.out.println("Here: " + baos.toString());
        assertEquals("Time is Wed Nov 16 17:46:39 CST 5138, venue is nottingham\r\n" +
                "Team 1 color is White\r\n" +
                "Team Members: None\r\n" +
                "Team 2 color is White\r\n" +
                "Team Members: None\r\n",baos.toString());
    }  //pass test1

}