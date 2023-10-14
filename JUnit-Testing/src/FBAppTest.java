

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class FBAppTest {
	// create a place for System.out to go
	private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@BeforeAll
	public static void setUpStreams() {
		// tells System.out to send its output to the outContent
		System.setOut(new PrintStream(outContent));
	}
	
	@BeforeAll
	// call the main method to initialize footBallPlayers
	public static void main() {
		outContent.reset();
        String input = "X";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        FBApp.main(new String[2]);
        
        assertEquals("\n" +
                "What do you want to do?" + System.lineSeparator() + 
                "[D]: Display games" + System.lineSeparator() +
                "[P]: Display players" + System.lineSeparator() +
                "[S]: Search for a game." + System.lineSeparator() +
                "[R]: Search for a player." + System.lineSeparator() +
                "[A]: Create a new game with settings." + System.lineSeparator() +
                "[F]: Enter a new player." + System.lineSeparator() +
                "[K]: Add players to game." + System.lineSeparator() +
                "[Q]: Change team color." + System.lineSeparator() +
                "[M]: Set team member." + System.lineSeparator() +
                "[X]: Exit." + System.lineSeparator() +
                "Enter choice: " +
                "\nGoodbye!" + System.lineSeparator(),outContent.toString());
    }


	@Test
	void main1() {
		outContent.reset();
		String input2 = "X";
		InputStream in2 = new ByteArrayInputStream(input2.getBytes());
		System.setIn(in2);
		FBApp.main(new String[2]);
		assertEquals("\n" +
				"What do you want to do?\n" +
				"[D]: Display games\n" +
				"[P]: Display players\n" +
				"[S]: Search for a game.\n" +
				"[R]: Search for a player.\n" +
				"[A]: Create a new game with settings.\n" +
				"[F]: Enter a new player.\n" +
				"[K]: Add players to game.\n" +
				"[Q]: Change team color.\n" +
				"[M]: Set team member.\n" +
				"[X]: Exit.\n" +
				"Enter choice: \n" +
				"Goodbye!\n",outContent.toString());
	}

	@Test
	void main2() {
		outContent.reset();
		String input2 = "D";
		InputStream in2 = new ByteArrayInputStream(input2.getBytes());
		System.setIn(in2);
		FBApp.main(new String[2]);
		Date curdate= new Date();
		assertEquals("\r\n" +
				"What do you want to do?\r\n" +
				"[D]: Display games\r\n" +
				"[P]: Display players\r\n" +
				"[S]: Search for a game.\r\n" +
				"[R]: Search for a player.\r\n" +
				"[A]: Create a new game with settings.\r\n" +
				"[F]: Enter a new player.\r\n" +
				"[K]: Add players to game.\r\n" +
				"[Q]: Change team color.\r\n" +
				"[M]: Set team member.\r\n" +
				"[X]: Exit.\r\n" +
				"Enter choice: \r\n" +
				"Game 1\r\n" +
				"------\r\n" +
				"Time is " + curdate+ ", venue is outside football field\r\n" +
				"Team 1 color is White\r\n" +
				"Team Members: None\r\n" +
				"Team 2 color is White\r\n" +
				"Team Members: None\r\n" +
				"\n" +
				"What do you want to do?\r\n" +
				"[D]: Display games\r\n" +
				"[P]: Display players\r\n" +
				"[S]: Search for a game.\r\n" +
				"[R]: Search for a player.\r\n" +
				"[A]: Create a new game with settings.\r\n" +
				"[F]: Enter a new player.\r\n" +
				"[K]: Add players to game.\r\n" +
				"[Q]: Change team color.\r\n" +
				"[M]: Set team member.\r\n" +
				"[X]: Exit.\r\n" +
				"Enter choice: ",outContent.toString());
	}

	@Test
	void main3() {
		outContent.reset();
		String input2 = "P";
		InputStream in2 = new ByteArrayInputStream(input2.getBytes());
		System.setIn(in2);
		FBApp.main(new String[2]);
		Date curdate= new Date();
		assertEquals("\r\n" +
				"What do you want to do?\r\n" +
				"[D]: Display games\r\n" +
				"[P]: Display players\r\n" +
				"[S]: Search for a game.\r\n" +
				"[R]: Search for a player.\r\n" +
				"[A]: Create a new game with settings.\r\n" +
				"[F]: Enter a new player.\r\n" +
				"[K]: Add players to game.\r\n" +
				"[Q]: Change team color.\r\n" +
				"[M]: Set team member.\r\n" +
				"[X]: Exit.\r\n" +
				"Enter choice: \r\n" +
				"Player 1\r\n" +
				"Player Information:\r\n" +
				"Name: Hawkeye\r\n" +
				"Gender: Male\r\n" +
				"ID: 20220101\r\n" +
				"\r\n" +
				"\r\n" +
				"Player 2\r\n" +
				"Player Information:\r\n" +
				"Name: Black Widow\r\n" +
				"Gender: Male\r\n" +
				"ID: 20220801\r\n" +
				"\r\n" +
				"\r\n" +
				"Player 3\r\n" +
				"Player Information:\r\n" +
				"Name: Iron Man\r\n" +
				"Gender: Male\r\n" +
				"ID: 20229756\r\n" +
				"\r\n" +
				"\r\n" +
				"Player 4\r\n" +
				"Player Information:\r\n" +
				"Name: Thor\r\n" +
				"Gender: Male\r\n" +
				"ID: 20228842\r\n" +
				"\r\n" +
				"\r\n" +
				"Player 5\r\n" +
				"Player Information:\r\n" +
				"Name: Captain America\r\n" +
				"Gender: Male\r\n" +
				"ID: 20220808\r\n" +
				"\r\n" +
				"\r\n" +
				"Player 6\r\n" +
				"Player Information:\r\n" +
				"Name: Batman\r\n" +
				"Gender: Male\r\n" +
				"ID: 20234477\r\n" +
				"\r\n" +
				"\r\n" +
				"Player 7\r\n" +
				"Player Information:\r\n" +
				"Name: Superman\r\n" +
				"Gender: Male\r\n" +
				"ID: 20239988\r\n" +
				"\r\n" +
				"\r\n" +
				"Player 8\r\n" +
				"Player Information:\r\n" +
				"Name: Wonder Woman\r\n" +
				"Gender: Male\r\n" +
				"ID: 20233378\r\n" +
				"\r\n" +
				"\r\n" +
				"Player 9\r\n" +
				"Player Information:\r\n" +
				"Name: Flash\r\n" +
				"Gender: Male\r\n" +
				"ID: 20231335\r\n" +
				"\r\n" +
				"\r\n" +
				"What do you want to do?\r\n" +
				"[D]: Display games\r\n" +
				"[P]: Display players\r\n" +
				"[S]: Search for a game.\r\n" +
				"[R]: Search for a player.\r\n" +
				"[A]: Create a new game with settings.\r\n" +
				"[F]: Enter a new player.\r\n" +
				"[K]: Add players to game.\r\n" +
				"[Q]: Change team color.\r\n" +
				"[M]: Set team member.\r\n" +
				"[X]: Exit.\r\n" +
				"Enter choice: ",outContent.toString());
	}
	@Test
	void main4() {
		outContent.reset();
		String input2 = "S";
		InputStream in2 = new ByteArrayInputStream(input2.getBytes());
		System.setIn(in2);
		FBApp.main(new String[2]);
		assertEquals("\r\n" +
						"What do you want to do?\r\n" +
						"[D]: Display games\r\n" +
						"[P]: Display players\r\n" +
						"[S]: Search for a game.\r\n" +
						"[R]: Search for a player.\r\n" +
						"[A]: Create a new game with settings.\r\n" +
						"[F]: Enter a new player.\r\n" +
						"[K]: Add players to game.\r\n" +
						"[Q]: Change team color.\r\n" +
						"[M]: Set team member.\r\n" +
						"[X]: Exit.\r\n" +
						"Enter choice: Enter Game Time: Something went wrong: java.util.NoSuchElementException: No line found\r\n" +
						"\r\n" +
						"\r\n" +
						"What do you want to do?\r\n" +
						"[D]: Display games\r\n" +
						"[P]: Display players\r\n" +
						"[S]: Search for a game.\r\n" +
						"[R]: Search for a player.\r\n" +
						"[A]: Create a new game with settings.\r\n" +
						"[F]: Enter a new player.\r\n" +
						"[K]: Add players to game.\r\n" +
						"[Q]: Change team color.\r\n" +
						"[M]: Set team member.\r\n" +
						"[X]: Exit.\r\n" +
						"Enter choice: "
				,outContent.toString());
	}

	@Test
	void main5() {
		outContent.reset();
		String input2 = "R";
		InputStream in2 = new ByteArrayInputStream(input2.getBytes());
		System.setIn(in2);
		FBApp.main(new String[2]);
		assertEquals("\r\n" +
				"What do you want to do?\r\n" +
				"[D]: Display games\r\n" +
				"[P]: Display players\r\n" +
				"[S]: Search for a game.\r\n" +
				"[R]: Search for a player.\r\n" +
				"[A]: Create a new game with settings.\r\n" +
				"[F]: Enter a new player.\r\n" +
				"[K]: Add players to game.\r\n" +
				"[Q]: Change team color.\r\n" +
				"[M]: Set team member.\r\n" +
				"[X]: Exit.\r\n" +
				"Enter choice: Enter Player Name: Something went wrong: java.util.NoSuchElementException: No line found\r\n" +
				"\r\n" +
				"\r\n" +
				"What do you want to do?\r\n" +
				"[D]: Display games\r\n" +
				"[P]: Display players\r\n" +
				"[S]: Search for a game.\r\n" +
				"[R]: Search for a player.\r\n" +
				"[A]: Create a new game with settings.\r\n" +
				"[F]: Enter a new player.\r\n" +
				"[K]: Add players to game.\r\n" +
				"[Q]: Change team color.\r\n" +
				"[M]: Set team member.\r\n" +
				"[X]: Exit.\r\n" +
				"Enter choice: ",outContent.toString());
	}

	@Test
	void main6() {
		outContent.reset();
		String input2 = "F";
		InputStream in2 = new ByteArrayInputStream(input2.getBytes());
		System.setIn(in2);
		FBApp.main(new String[2]);
		assertEquals("\r\n" +
				"What do you want to do?\r\n" +
				"[D]: Display games\r\n" +
				"[P]: Display players\r\n" +
				"[S]: Search for a game.\r\n" +
				"[R]: Search for a player.\r\n" +
				"[A]: Create a new game with settings.\r\n" +
				"[F]: Enter a new player.\r\n" +
				"[K]: Add players to game.\r\n" +
				"[Q]: Change team color.\r\n" +
				"[M]: Set team member.\r\n" +
				"[X]: Exit.\r\n" +
				"Enter choice: \r\n"+"Enter footballPlayer name: Something went wrong: java.util.NoSuchElementException: No line found\r\n" +
				"\r\n" +
				"\r\n" +
				"What do you want to do?\r\n" +
				"[D]: Display games\r\n" +
				"[P]: Display players\r\n" +
				"[S]: Search for a game.\r\n" +
				"[R]: Search for a player.\r\n" +
				"[A]: Create a new game with settings.\r\n" +
				"[F]: Enter a new player.\r\n" +
				"[K]: Add players to game.\r\n" +
				"[Q]: Change team color.\r\n" +
				"[M]: Set team member.\r\n" +
				"[X]: Exit.\r\n" +
				"Enter choice: ",outContent.toString());
	}
	@Test
	void main7() {
		outContent.reset();
		String input2 = "A";
		InputStream in2 = new ByteArrayInputStream(input2.getBytes());
		System.setIn(in2);
		FBApp.main(new String[2]);
		assertEquals("\r\n" +
				"What do you want to do?\r\n" +
				"[D]: Display games\r\n" +
				"[P]: Display players\r\n" +
				"[S]: Search for a game.\r\n" +
				"[R]: Search for a player.\r\n" +
				"[A]: Create a new game with settings.\r\n" +
				"[F]: Enter a new player.\r\n" +
				"[K]: Add players to game.\r\n" +
				"[Q]: Change team color.\r\n" +
				"[M]: Set team member.\r\n" +
				"[X]: Exit.\r\n" +
				"Enter choice: \r\n"+"Enter game time: (dd/MM/yyyy)Something went wrong: java.util.NoSuchElementException: No line found\r\n" +
				"\r\n" +
				"\r\n" +
				"What do you want to do?\r\n" +
				"[D]: Display games\r\n" +
				"[P]: Display players\r\n" +
				"[S]: Search for a game.\r\n" +
				"[R]: Search for a player.\r\n" +
				"[A]: Create a new game with settings.\r\n" +
				"[F]: Enter a new player.\r\n" +
				"[K]: Add players to game.\r\n" +
				"[Q]: Change team color.\r\n" +
				"[M]: Set team member.\r\n" +
				"[X]: Exit.\r\n" +
				"Enter choice: ",outContent.toString());
	}


	@Test
	void main8() {
		outContent.reset();
		String input2 = "K";
		InputStream in2 = new ByteArrayInputStream(input2.getBytes());
		System.setIn(in2);
		Date curDate = new Date();
		FBApp.main(new String[2]);
		assertEquals("\r\n" +
				"What do you want to do?\r\n" +
				"[D]: Display games\r\n" +
				"[P]: Display players\r\n" +
				"[S]: Search for a game.\r\n" +
				"[R]: Search for a player.\r\n" +
				"[A]: Create a new game with settings.\r\n" +
				"[F]: Enter a new player.\r\n" +
				"[K]: Add players to game.\r\n" +
				"[Q]: Change team color.\r\n" +
				"[M]: Set team member.\r\n" +
				"[X]: Exit.\r\n" +
				"Enter choice: "+"All games: \r\n" +
				"Game 1 ["+curDate+ "outside football field]\r\n" +
				"All players\r\n" +
				"\r\n" +
				"Player 1\r\n" +
				"Player Information:\r\n" +
				"Name: Hawkeye\r\n" +
				"Gender: Male\r\n" +
				"ID: 20220101\r\n" +
				"\r\n" +
				"\r\n" +
				"Player 2\r\n" +
				"Player Information:\r\n" +
				"Name: Black Widow\r\n" +
				"Gender: Male\r\n" +
				"ID: 20220801\r\n" +
				"\r\n" +
				"\r\n" +
				"Player 3\r\n" +
				"Player Information:\r\n" +
				"Name: Iron Man\r\n" +
				"Gender: Male\r\n" +
				"ID: 20229756\r\n" +
				"\r\n" +
				"\r\n" +
				"Player 4\r\n" +
				"Player Information:\r\n" +
				"Name: Thor\r\n" +
				"Gender: Male\r\n" +
				"ID: 20228842\r\n" +
				"\r\n" +
				"\r\n" +
				"Player 5\r\n" +
				"Player Information:\r\n" +
				"Name: Captain America\r\n" +
				"Gender: Male\r\n" +
				"ID: 20220808\r\n" +
				"\r\n" +
				"\r\n" +
				"Player 6\r\n" +
				"Player Information:\r\n" +
				"Name: Batman\r\n" +
				"Gender: Male\r\n" +
				"ID: 20234477\r\n" +
				"\r\n" +
				"\r\n" +
				"Player 7\r\n" +
				"Player Information:\r\n" +
				"Name: Superman\r\n" +
				"Gender: Male\r\n" +
				"ID: 20239988\r\n" +
				"\r\n" +
				"\r\n" +
				"Player 8\r\n" +
				"Player Information:\r\n" +
				"Name: Wonder Woman\r\n" +
				"Gender: Male\r\n" +
				"ID: 20233378\r\n" +
				"\r\n" +
				"\r\n" +
				"Player 9\r\n" +
				"Player Information:\r\n" +
				"Name: Flash\r\n" +
				"Gender: Male\r\n" +
				"ID: 20231335\r\n" +
				"\r\n" +
				"----------\r\n" +
				"Which game to add players?: Something went wrong: java.util.NoSuchElementException\r\n" +
				"\r\n" +
				"\r\n" +
				"What do you want to do?\r\n" +
				"[D]: Display games\r\n" +
				"[P]: Display players\r\n" +
				"[S]: Search for a game.\r\n" +
				"[R]: Search for a player.\r\n" +
				"[A]: Create a new game with settings.\r\n" +
				"[F]: Enter a new player.\r\n" +
				"[K]: Add players to game.\r\n" +
				"[Q]: Change team color.\r\n" +
				"[M]: Set team member.\r\n" +
				"[X]: Exit.\r\n" +
				"Enter choice: ",outContent.toString());
	}
	@Test
	void main9() {
		outContent.reset();
		String input2 = "Q";
		InputStream in2 = new ByteArrayInputStream(input2.getBytes());
		System.setIn(in2);
		Date curDate = new Date();
		FBApp.main(new String[2]);
		assertEquals("\r\n" +
				"What do you want to do?\r\n" +
				"[D]: Display games\r\n" +
				"[P]: Display players\r\n" +
				"[S]: Search for a game.\r\n" +
				"[R]: Search for a player.\r\n" +
				"[A]: Create a new game with settings.\r\n" +
				"[F]: Enter a new player.\r\n" +
				"[K]: Add players to game.\r\n" +
				"[Q]: Change team color.\r\n" +
				"[M]: Set team member.\r\n" +
				"[X]: Exit.\r\n" +
				"Enter choice: \r\n"+"----------\r\n" +
				"All games: \r\n" +
				"Game 1 ["+curDate +" outside football field]\r\n" +
				"----------\r\n" +
				"Which game to set team color?: Something went wrong: java.util.NoSuchElementException\r\n" +
				"\r\n" +
				"\r\n" +
				"What do you want to do?\r\n" +
				"[D]: Display games\r\n" +
				"[P]: Display players\r\n" +
				"[S]: Search for a game.\r\n" +
				"[R]: Search for a player.\r\n" +
				"[A]: Create a new game with settings.\r\n" +
				"[F]: Enter a new player.\r\n" +
				"[K]: Add players to game.\r\n" +
				"[Q]: Change team color.\r\n" +
				"[M]: Set team member.\r\n" +
				"[X]: Exit.\r\n" +
				"Enter choice: ",outContent.toString());
	}
	@Test
	void main10() {
		outContent.reset();
		String input2 = "M";
		InputStream in2 = new ByteArrayInputStream(input2.getBytes());
		System.setIn(in2);
		Date curDate = new Date();
		FBApp.main(new String[2]);
		assertEquals("\r\n" +
				"What do you want to do?\r\n" +
				"[D]: Display games\r\n" +
				"[P]: Display players\r\n" +
				"[S]: Search for a game.\r\n" +
				"[R]: Search for a player.\r\n" +
				"[A]: Create a new game with settings.\r\n" +
				"[F]: Enter a new player.\r\n" +
				"[K]: Add players to game.\r\n" +
				"[Q]: Change team color.\r\n" +
				"[M]: Set team member.\r\n" +
				"[X]: Exit.\r\n" +
				"Enter choice: "+
				"All games: \r\n" +
				"Game 1 ["+curDate +"outside football field]\r\n" +
				"----------\r\n" +
				"Which game to set members?: Something went wrong: java.util.NoSuchElementException\r\n" +
				"\r\n" +
				"\r\n" +
				"What do you want to do?\r\n" +
				"[D]: Display games\r\n" +
				"[P]: Display players\r\n" +
				"[S]: Search for a game.\r\n" +
				"[R]: Search for a player.\r\n" +
				"[A]: Create a new game with settings.\r\n" +
				"[F]: Enter a new player.\r\n" +
				"[K]: Add players to game.\r\n" +
				"[Q]: Change team color.\r\n" +
				"[M]: Set team member.\r\n" +
				"[X]: Exit.\r\n" +
				"Enter choice: ",outContent.toString());
	}
	@Test
	void main11() {
		outContent.reset();
		String input2 = "B";
		InputStream in2 = new ByteArrayInputStream(input2.getBytes());
		System.setIn(in2);
		Date curDate = new Date();
		FBApp.main(new String[2]);
		assertEquals("\n" +
				"What do you want to do?\n" +
				"[D]: Display games\n" +
				"[P]: Display players\n" +
				"[S]: Search for a game.\n" +
				"[R]: Search for a player.\n" +
				"[A]: Create a new game with settings.\n" +
				"[F]: Enter a new player.\n" +
				"[K]: Add players to game.\n" +
				"[Q]: Change team color.\n" +
				"[M]: Set team member.\n" +
				"[X]: Exit.\n" +
				"Enter choice: \n" +
				"What do you want to do?\n" +
				"[D]: Display games\n" +
				"[P]: Display players\n" +
				"[S]: Search for a game.\n" +
				"[R]: Search for a player.\n" +
				"[A]: Create a new game with settings.\n" +
				"[F]: Enter a new player.\n" +
				"[K]: Add players to game.\n" +
				"[Q]: Change team color.\n" +
				"[M]: Set team member.\n" +
				"[X]: Exit.\n" +
				"Enter choice: ",outContent.toString());
	}

	
	
	// SearchFootBallPlayers() test
    	// written by Yanqian Wang
	@Test
	// search using an '\n', assuming the user presses Enter directly
	void testEmptyPlayer() {
		outContent.reset();
		
		// create user input strings
		String input = "\n";
		// create an InputStream
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		// set System.setIn to be this stream
		System.setIn(in);
		// call the method which will be tested
		FBApp.SearchFootBallPlayers();

		assertEquals("Enter Player Name: ", outContent.toString());
	}
	
	@Test
	// search for an existing player
	void testExistPlayer1() {
		outContent.reset();
		// create user input strings
		String input = "Superman";
		// create an InputStream
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		FBApp.SearchFootBallPlayers();
		
		assertEquals("Enter Player Name: Player Information:\n" +
				"Name: Superman\n" + "Gender: Male\n" +
				"ID: 20239988\n" + System.lineSeparator(), outContent.toString());
	}
	
	@Test
	// search for an existing player
	void testExistPlayer2() {
		outContent.reset();
		// create user input strings
		String input = "Wonder Woman";
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		FBApp.SearchFootBallPlayers();
		
		assertEquals("Enter Player Name: Player Information:\n" + 
					 "Name: Wonder Woman\n" + "Gender: Male\n" + 
					 "ID: 20233378\n" + System.lineSeparator(), outContent.toString());
	}
	
	@Test
	// search for a non-existent player
	void testNExistPlayer() {
		outContent.reset();
		// create user input strings
		String input = "April";
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		FBApp.SearchFootBallPlayers();
		
		assertEquals("Enter Player Name: ", outContent.toString());
	}
	
	@Test
	// search using a personID
	void testPlayerId() {
		outContent.reset();
		// create user input strings
		String input = "20220808";
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		FBApp.SearchFootBallPlayers();
		
		assertEquals("Enter Player Name: ", outContent.toString());
	}
	
	@Test
	// search using a personGender
	void testPlayerGender() {
		outContent.reset();
		// create user input strings
		String input = "Male";
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		FBApp.SearchFootBallPlayers();
		
		assertEquals("Enter Player Name: ", outContent.toString());
	}
	


	// AddFootballPlayer() test
    	// written by Yanqian Wang
    	@Test
	// add a player and does not let him join any games
	void testAddPlayer1() {
		outContent.reset();
		// create the input string for name, gender and id
		String input = "Sam\nFemale\n20415577\n0\n";
		
		// create an InputStream
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		// set System.setIn to be this stream
		System.setIn(in);
		// call the method which will be tested
		FBApp.AddFootballPlayer();

		assertEquals("\nEnter footballPlayer name: "
				+ "\nEnter footballPlayer Gender: "
				+ "\nEnter footballPlayer ID: ----------" + System.lineSeparator()
				+ "Football player created successfully: Sam id 20415577." + System.lineSeparator()
				+ " How many games to join?: " + System.lineSeparator()
				+ "Player create successfully." + System.lineSeparator(), outContent.toString());
	}
	
	@Test
	// add two players and does not let them join any games
	void testAddPlayer2() {
		outContent.reset();
		// create the input string for name, gender and id
		String input1 = "Lily\nFemale\n20415577\n0\n";
		String input2 = "Tom\nMale\n20411254\n0\n";
		
		// Call twice
		ByteArrayInputStream in1 = new ByteArrayInputStream(input1.getBytes());
		System.setIn(in1);
		FBApp.AddFootballPlayer();
		ByteArrayInputStream in2 = new ByteArrayInputStream(input2.getBytes());
		System.setIn(in2);
		FBApp.AddFootballPlayer();

		assertEquals("\nEnter footballPlayer name: "
				+ "\nEnter footballPlayer Gender: "
				+ "\nEnter footballPlayer ID: ----------" + System.lineSeparator()
				+ "Football player created successfully: Lily id 20415577." + System.lineSeparator()
				+ " How many games to join?: " + System.lineSeparator()
				+ "Player create successfully." + System.lineSeparator()
				+ "\nEnter footballPlayer name: "
				+ "\nEnter footballPlayer Gender: "
				+ "\nEnter footballPlayer ID: ----------" + System.lineSeparator()
				+ "Football player created successfully: Tom id 20411254." + System.lineSeparator()
				+ " How many games to join?: " + System.lineSeparator()
				+ "Player create successfully."+ System.lineSeparator(), outContent.toString());
	}
	
	@Test
	// add a player and input -1 for the number of games to join
	void testGameNum() {
		outContent.reset();
		// create the input string for name, gender and id
		String input = "Lily\nFemale\n20415577\n-1\n";
		
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		FBApp.AddFootballPlayer();

		assertEquals("\nEnter footballPlayer name: "
				+ "\nEnter footballPlayer Gender: "
				+ "\nEnter footballPlayer ID: ----------" + System.lineSeparator()
				+ "Football player created successfully: Lily id 20415577." + System.lineSeparator()
				+ " How many games to join?: " + System.lineSeparator()
				+ "Player create successfully." + System.lineSeparator(), outContent.toString());
	}
	
	@Test
	// add a player and input 0 for the id of games to join
	void testGameId() {
		outContent.reset();
		// create the input string for name, gender and id
		String input = "Lily\nFemale\n20415577\n1\n0\n";
		
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		FBApp.AddFootballPlayer();

		assertEquals("\nEnter footballPlayer name: "
				+ "\nEnter footballPlayer Gender: "
				+ "\nEnter footballPlayer ID: ----------" + System.lineSeparator()
				+ "Football player created successfully: Lily id 20415577." + System.lineSeparator()
				+ " How many games to join?: " + System.lineSeparator()
				+ "Player create successfully." + System.lineSeparator(), outContent.toString());
	}
	
	@Test
	// add a player to a game
	void testAddtoGame1() {
		main();  // reset footBallGames
		// create the input string for name, gender and id
		String input1 = "Lily\nFemale\n20415577\n1\n1\n";
		ByteArrayInputStream in1 = new ByteArrayInputStream(input1.getBytes());
		System.setIn(in1);
		FBApp.AddFootballPlayer();

		// check if this player has already joined the waiting list for the first game
		FBTeam newFBTeam = FBApp.footBallGames.get(0).getWaitList();
		ArrayList<FBPlayer> teamList = newFBTeam.getTeamList();
		assertEquals("Lily", teamList.get(0).getPersonName());
		assertEquals(20415577, teamList.get(0).getPersonID());
		assertEquals("Female", teamList.get(0).getPersonGender());
	}
	
	@Test
	// add two players to the same game
	void testAddtoGame2() {
		main();  // reset footBallGames
		// create the input string for name, gender and id
		String input1 = "Lily\nFemale\n20415577\n1\n1\n";
		String input2 = "Tom\nMale\n20411254\n1\n1\n";
		// call twice
		ByteArrayInputStream in1 = new ByteArrayInputStream(input1.getBytes());
		System.setIn(in1);
		FBApp.AddFootballPlayer();
		ByteArrayInputStream in2 = new ByteArrayInputStream(input2.getBytes());
		System.setIn(in2);
		FBApp.AddFootballPlayer();

		// check if two players has already joined the waiting list for the first game
		FBTeam newFBTeam = FBApp.footBallGames.get(0).getWaitList();
		ArrayList<FBPlayer> teamList = newFBTeam.getTeamList();
		assertEquals("Lily", teamList.get(0).getPersonName());
		assertEquals(20415577, teamList.get(0).getPersonID());
		assertEquals("Female", teamList.get(0).getPersonGender());
		assertEquals("Tom", teamList.get(1).getPersonName());
		assertEquals(20411254, teamList.get(1).getPersonID());
		assertEquals("Male", teamList.get(1).getPersonGender());
	}



	// SearchFootBallGame test
	// written by Pengyu Zhi
	@Test
	public void SearchFootBallGameTest1() {
		outContent.reset();
		FBApp.footBallGames=new ArrayList<FBGame>();
		Date curDate = new Date();
        FBGame fbGame = new FBGame(curDate,"outside football field",20);
		FBApp.footBallGames.add(fbGame);
		
		String input="23/04/2023";
		InputStream in= new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		FBApp.SearchFootBallGame();
		
		assertEquals("Enter Game Time: "+"Time is "+fbGame.getGameTime()+", venue is "+
		fbGame.getGameVenue()+System.lineSeparator()+
		"Team 1 color is "+fbGame.getGameTeam1().getTeamColor()+System.lineSeparator()+
		fbGame.getGameTeam1().toString()+System.lineSeparator()+
		"Team 2 color is "+fbGame.getGameTeam2().getTeamColor()+System.lineSeparator()+
		fbGame.getGameTeam2().toString()+System.lineSeparator()
				,outContent.toString());
	}
	@Test
	public void SearchFootBallGameTest2() {
		outContent.reset();
		
		FBApp.footBallGames=new ArrayList<FBGame>();
		Date curDate = new Date();
        FBGame fbGame = new FBGame(curDate,"outside football field",20);
		FBApp.footBallGames.add(fbGame);
		
		String input="25/06/2040";
		InputStream in= new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		FBApp.SearchFootBallGame();
		
		assertEquals("Enter Game Time: "+"There is not any game at 25/06/2040",outContent.toString());
	}
	@Test
	void setTeamMember() {//before modified test
		outContent.reset();
		FBApp.footBallGames = new ArrayList<FBGame>();
		Date curDate = new Date();
		FBGame fbGame = new FBGame(curDate,"outside football field",20);
		fbGame.addPlayer(new FBPlayer("Hawkeye", 20220101,"Male"));
		fbGame.addPlayer(new FBPlayer("Black Widow", 20220801,"Male"));
		fbGame.addPlayer(new FBPlayer("Iron Man", 20229756,"Male"));
		fbGame.addPlayer(new FBPlayer("Thor", 20228842,"Male"));
		fbGame.addPlayer(new FBPlayer("Captain America", 20220808,"Male"));
		fbGame.addPlayer(new FBPlayer("Batman", 20234477,"Male"));
		fbGame.addPlayer(new FBPlayer("Superman", 20239988,"Male"));
		fbGame.addPlayer(new FBPlayer("Wonder Woman", 20233378,"Male"));
		fbGame.addPlayer(new FBPlayer("Flash", 20231335,"Male"));
		FBApp.footBallGames.add(fbGame);

		String input2 = "1 5 1 2 3 4 6 1 2 3 4 5";//before modified test
		//String input2 = "1 4 1 2 3 4 5 1 2 3 4 5";//after modified test
		InputStream in2 = new ByteArrayInputStream(input2.getBytes());
		System.setIn(in2);
		FBApp.SetTeamMember();
		assertEquals("All games: \r\n" +
				"Game 1 ["+curDate.toString()+"outside football field]\r\n" +
				"----------\r\n" +
				"Which game to set members?: \r\n" +
				"----------\r\n" +
				"Team Members: None\r\n" +
				"Team Members: None\r\n" +
				"Waiting----------\r\n" +
				"Team Members: [0]: Hawkeye\r\n" +
				"[1]: Black Widow\r\n" +
				"[2]: Iron Man\r\n" +
				"[3]: Thor\r\n" +
				"[4]: Captain America\r\n" +
				"[5]: Batman\r\n" +
				"[6]: Superman\r\n" +
				"[7]: Wonder Woman\r\n" +
				"[8]: Flash\r\n" +
				"\r\n" +
				"----------\r\n" +
				"How many players in team1?: Which member to team1?: Remaining Waiting Team Members: [0]: Captain America\r\n" +
				"[1]: Batman\r\n" +
				"[2]: Superman\r\n" +
				"[3]: Wonder Woman\r\n" +
				"[4]: Flash\r\n" +
				"\r\n" +
				"How many members to team2?: Which member to team2?: Team member has changed successfully.\r\n",outContent.toString());
	}
	@Test
	void setTeamMember2() {//after modified test
		outContent.reset();
		FBApp.footBallGames = new ArrayList<FBGame>();
		Date curDate = new Date();
		FBGame fbGame = new FBGame(curDate,"outside football field",20);
		fbGame.addPlayer(new FBPlayer("Hawkeye", 20220101,"Male"));
		fbGame.addPlayer(new FBPlayer("Black Widow", 20220801,"Male"));
		fbGame.addPlayer(new FBPlayer("Iron Man", 20229756,"Male"));
		fbGame.addPlayer(new FBPlayer("Thor", 20228842,"Male"));
		fbGame.addPlayer(new FBPlayer("Captain America", 20220808,"Male"));
		fbGame.addPlayer(new FBPlayer("Batman", 20234477,"Male"));
		fbGame.addPlayer(new FBPlayer("Superman", 20239988,"Male"));
		fbGame.addPlayer(new FBPlayer("Wonder Woman", 20233378,"Male"));
		fbGame.addPlayer(new FBPlayer("Flash", 20231335,"Male"));
		FBApp.footBallGames.add(fbGame);

		String input2 = "1 4 1 2 3 4 5 1 2 3 4 5";//after modified test
		InputStream in2 = new ByteArrayInputStream(input2.getBytes());
		System.setIn(in2);
		FBApp.SetTeamMember();
		assertEquals("All games: \r\n" +
				"Game 1 ["+curDate.toString()+"outside football field]\r\n" +
				"----------\r\n" +
				"Which game to set members?: \r\n" +
				"----------\r\n" +
				"Team Members: None\r\n" +
				"Team Members: None\r\n" +
				"Waiting----------\r\n" +
				"Team Members: [0]: Hawkeye\r\n" +
				"[1]: Black Widow\r\n" +
				"[2]: Iron Man\r\n" +
				"[3]: Thor\r\n" +
				"[4]: Captain America\r\n" +
				"[5]: Batman\r\n" +
				"[6]: Superman\r\n" +
				"[7]: Wonder Woman\r\n" +
				"[8]: Flash\r\n" +
				"\r\n" +
				"----------\r\n" +
				"How many players in team1?: Which member to team1?: Remaining Waiting Team Members: [0]: Captain America\r\n" +
				"[1]: Batman\r\n" +
				"[2]: Superman\r\n" +
				"[3]: Wonder Woman\r\n" +
				"[4]: Flash\r\n" +
				"\r\n" +
				"How many members to team2?: Which member to team2?: Team member has changed successfully.\r\n",outContent.toString());
	}
	@Test
	void addPlayersToGame() {
		outContent.reset();
		FBApp.footBallGames = new ArrayList<FBGame>();
		FBApp.footBallPlayers = new ArrayList<FBPlayer>();
		Date curDate = new Date();
		FBGame fbGame = new FBGame(curDate,"outside football field",20);
		FBApp.footBallGames.add(fbGame);
		FBPlayer player1 = new FBPlayer("Hawkeye", 20220101,"Male");
		FBApp.footBallPlayers.add(player1);
		String input2 = "1 1 1";
		InputStream in2 = new ByteArrayInputStream(input2.getBytes());
		System.setIn(in2);
		FBApp.AddPlayersToGame();
		assertEquals("All games: \r\n" +
				"Game 1 ["+curDate+"outside football field]\r\n" +
				"All players\r\n" +
				"\r\n" +
				"Player 1\r\n" +
				"Player Information:\r\n" +
				"Name: Hawkeye\r\n" +
				"Gender: Male\r\n" +
				"ID: 20220101\r\n" +
				"\r\n" +
				"----------\r\n" +
				"Which game to add players?: \r\n" +
				"----------\r\n" +
				"How many players to add?: Game players has added successfully.\r\n" ,outContent.toString());
	}

	@Test
	void addPlayersToGame2() {
		outContent.reset();
		FBApp.footBallGames = new ArrayList<FBGame>();
		FBApp.footBallPlayers = new ArrayList<FBPlayer>();
		Date curDate = new Date();
		FBGame fbGame = new FBGame(curDate,"outside football field",20);
		FBApp.footBallGames.add(fbGame);
		FBPlayer player1 = new FBPlayer("Hawkeye", 20220101,"Male");
		FBPlayer player2 = new FBPlayer("IronMan", 20220102,"Male");
		FBApp.footBallPlayers.add(player1);
		FBApp.footBallPlayers.add(player2);
		String input2 = "1 2 1 2";
		InputStream in2 = new ByteArrayInputStream(input2.getBytes());
		System.setIn(in2);
		FBApp.AddPlayersToGame();
		assertEquals("All games: \r\n" +
				"Game 1 ["+curDate+"outside football field]\r\n" +
				"All players\r\n" +
				"\r\n" +
				"Player 1\r\n" +
				"Player Information:\r\n" +
				"Name: Hawkeye\r\n" +
				"Gender: Male\r\n" +
				"ID: 20220101\r\n" +
				"\r\n" +
				"\n" +
				"Player 2\r\n" +
				"Player Information:\r\n" +
				"Name: IronMan\r\n" +
				"Gender: Male\r\n" +
				"ID: 20220102\r\n"+
				"\n"+
				"----------\r\n" +
				"Which game to add players?: \r\n" +
				"----------\r\n" +
				"How many players to add?: Game players has added successfully.\r\n" ,outContent.toString());
	}

	@Test
	void addPlayersToGame3() {
		outContent.reset();
		FBApp.footBallGames = new ArrayList<FBGame>();
		FBApp.footBallPlayers = new ArrayList<FBPlayer>();
		Date curDate = new Date();
		FBGame fbGame = new FBGame(curDate,"outside football field",20);
		FBApp.footBallGames.add(fbGame);
		//FBPlayer player1 = new FBPlayer("Hawkeye", 20220101,"Male");
		//FBPlayer player2 = new FBPlayer("IronMan", 20220102,"Male");
		//FBApp.footBallPlayers.add(player1);
		//FBApp.footBallPlayers.add(player2);
		String input2 = "1 0";
		InputStream in2 = new ByteArrayInputStream(input2.getBytes());
		System.setIn(in2);
		FBApp.AddPlayersToGame();
		assertEquals("All games: \r\n" +
				"Game 1 ["+curDate+"outside football field]\r\n" +
				"All players\r\n" +
				"----------\r\n" +
				"Which game to add players?: \r\n" +
				"----------\r\n" +
				"How many players to add?: Game players has added successfully.\r\n" ,outContent.toString());
	}
	@Test
    void TestsetTeamColor1() {
		outContent.reset();
        FBApp.footBallGames = new ArrayList<FBGame>();
        Date tempDate = new Date(0L);
        FBGame fbGame = new FBGame(tempDate,"outside football field",20);
        FBApp.footBallGames.add(fbGame);

        String input2 = "1\r\n" +
                     "red\r\n" +
                     "blue\r\n";
        InputStream in2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(in2);
        FBApp.SetTeamColor();
        assertEquals("\n----------\r\n" +
                "All games: \r\n" +
                "Game 1 [Thu Jan 01 08:00:00 CST 1970 outside football field]\r\n" +
                "----------\r\n" +
                "Which game to set team color?: \n" +
                "----------\r\n" +
                "Team1 current color:White\r\n" +
                "Which color to use for Team1?\r\n" +
                "\n"+
                " Team2 current color:White\r\n" +
                "Which color to use?\r\n" +
                "Team color has changed successfully.\r\n",outContent.toString());

    } // pass test 1

    @Test
    void TestsetTeamColor2() {
		outContent.reset();
        FBApp.footBallGames = new ArrayList<FBGame>();
        Date tempDate = new Date(0L);
        FBGame fbGame = new FBGame(tempDate,"outside football field",20);
//
        FBApp.footBallGames.add(fbGame);
        String input2 = "1\r\n" +
                "red\r\n" +
                "blue\r\n";
        InputStream in2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(in2);
        FBApp.SetTeamColor();
        assertEquals("red",FBApp.footBallGames.get(0).getGameTeam1().getTeamColor());
        assertEquals("blue",FBApp.footBallGames.get(0).getGameTeam2().getTeamColor());

    } // pass test 2

	@Test
    void testaddGame1() {
		outContent.reset();
        FBApp.footBallGames = new ArrayList<FBGame>();
        String input2 =
                "02/05/2023\r\n" +
                "TBD\r\n"+
                "20";
        InputStream in2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(in2);
        FBApp.AddGame();
        assertEquals("\n" +
                "Enter game time: (dd/MM/yyyy)" +
                "Enter game venue: " +
                "Enter game max number of players: " +
                "Team created successfully.\r\n" +
                "Time is Tue May 02 00:00:00 CST 2023, venue is TBD\r\n" +
                "Team 1 color is White\r\n" +
                "Team Members: None\r\n" +
                "Team 2 color is White\r\n" +
                "Team Members: None\r\n",outContent.toString());
    }

    @Test
    void testaddGame2() {
		outContent.reset();
        FBApp.footBallGames = new ArrayList<FBGame>();
        String input2 =
                "hahaha\r\n";
        InputStream in2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(in2);
        FBApp.AddGame();
    } // java.lang.RuntimeException: java.text.ParseException: Unparseable date: "hahaha"




	// unset it for the future
	@AfterAll
	public static void cleanUpStreams() {
		System.setOut(null);
	}
}






