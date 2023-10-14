
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

// Test cases for FBTeam class
// Written by Yanqian Wang and Pengyu Zhi

class FBTeamTest {
	// build a new FBTeam, the following test cases are all based on this newFBTeam.
	FBTeam newFBTeam = new FBTeam();

	@Test
	// get default teamColor from FBTeam
	void testGetColor() {
		String color = newFBTeam.getTeamColor();
		assertEquals("White", color);
	}
	
	@Test
	// get default teamList from FBTeam
	void testGetList() {
		ArrayList<FBPlayer> list = newFBTeam.getTeamList();
		assertEquals(new ArrayList<>(), list);
	}
	
	
	@Test
	// use null to set teamColor
	void testSetNullColor() {
		newFBTeam.setTeamColor(null);
		String color = newFBTeam.getTeamColor();
		assertEquals("White", color);
	}
	
	@Test
	// use empty string to set teamColor
	void testSetEmptyColor() {
		newFBTeam.setTeamColor("");
		String color = newFBTeam.getTeamColor();
		assertEquals("White", color);
	}
	
	@Test
	// set teamColor in FBTeam
	void testSetColor() {
		newFBTeam.setTeamColor("Red");
		String color = newFBTeam.getTeamColor();
		assertEquals("Red", color);
	}
	
	@Test
	// modify teamColor in FBTeam
	void testModifyColor() {
		newFBTeam.setTeamColor("Red");
		newFBTeam.setTeamColor("Blue");
		String color = newFBTeam.getTeamColor();
		assertEquals("Blue", color);
	}
	
	
	@Test
	// set teamList in FBTeam
	void testSetList() {
		// create a new player
		FBPlayer player = new FBPlayer("Tom", 20410000, "Male");
		// add this player to an ArrayList
		ArrayList<FBPlayer> list = new ArrayList<>();
		list.add(player);
		
		// use newList to set teamList in FBTeam
		newFBTeam.setTeamList(list);
		ArrayList<FBPlayer> newList = newFBTeam.getTeamList();
		
		assertEquals(list, newList);
	}
	
	
	@Test
	// add a team member to FBTeam
	void testAddNullMember() {
		// create an empty player
		FBPlayer player = new FBPlayer();
		
		// add this player to FBTeam
		newFBTeam.addTeamMemberToList(player);
		ArrayList<FBPlayer> newList = newFBTeam.getTeamList();
		
		assertEquals(new ArrayList<>(), newList);
	}
	
	@Test
	// add a team member to FBTeam
	void testAddMember1() {
		// create a new player
		FBPlayer player = new FBPlayer("Sam", 20410001, "Male");
		
		// add this player to an ArrayList
		ArrayList<FBPlayer> list = new ArrayList<>();
		list.add(player);
		
		// add this player to FBTeam
		newFBTeam.addTeamMemberToList(player);
		ArrayList<FBPlayer> newList = newFBTeam.getTeamList();
		
		assertEquals(list, newList);
	}
	
	@Test
	// add two team members to FBTeam
	void testAddMember2() {
		// create new players and add them to an ArrayList
		FBPlayer player1 = new FBPlayer("Sam", 20410001, "Male");
		FBPlayer player2 = new FBPlayer("Anna", 20410002, "Female");
		ArrayList<FBPlayer> list = new ArrayList<>();
		list.add(player1);
		list.add(player2);
		
		// add players to FBTeam
		newFBTeam.addTeamMemberToList(player1);
		newFBTeam.addTeamMemberToList(player2);
		ArrayList<FBPlayer> newList = newFBTeam.getTeamList();
		
		assertEquals(list, newList);
	}
	
	@Test
	// add two same team members to FBTeam
	void testAddMember3() {
		// create a new player
		FBPlayer player = new FBPlayer("Sam", 20410001, "Male");
		
		// add only once to an ArrayList
		ArrayList<FBPlayer> list = new ArrayList<>();
		list.add(player);
		
		// add the same player twice to FBTeam
		newFBTeam.addTeamMemberToList(player);
		newFBTeam.addTeamMemberToList(player);
		ArrayList<FBPlayer> newList = newFBTeam.getTeamList();
		
		assertEquals(list, newList);
	}
	
	
	@Test
	// remove a team member which is not exist
	void testRemoveNExist() {
		FBPlayer player1 = new FBPlayer("Sam", 20410001, "Male");
		FBPlayer player2 = new FBPlayer("Tom", 20410002, "Male");
		ArrayList<FBPlayer> list = new ArrayList<>();
		list.add(player1);
		
		// add players to FBTeam
		newFBTeam.addTeamMemberToList(player1);
				
		// remove a player
		newFBTeam.removeTeamMemberFromList(player2);
		ArrayList<FBPlayer> newList = newFBTeam.getTeamList();
		
		assertEquals(list, newList);
	}
	
	@Test
	// remove the only one team member from FBTeam
	void testRemoveMember1() {
		// create a new player
		FBPlayer player = new FBPlayer("Sam", 20410001, "Male");
		
		// add this player to FBTeam
		newFBTeam.addTeamMemberToList(player);
		
		// remove that player
		newFBTeam.removeTeamMemberFromList(player);
		ArrayList<FBPlayer> newList = newFBTeam.getTeamList();
		
		assertEquals(new ArrayList<>(), newList);
	}
	
	@Test
	// remove one of the team members from FBTeam
	void testRemoveMember2() {
		// create new players
		FBPlayer player1 = new FBPlayer("Sam", 20410001, "Male");
		FBPlayer player2 = new FBPlayer("Anna", 20410002, "Female");
		ArrayList<FBPlayer> list = new ArrayList<>();
		list.add(player1);

		// add players to FBTeam
		newFBTeam.addTeamMemberToList(player1);
		newFBTeam.addTeamMemberToList(player2);
		
		// remove that player
		newFBTeam.removeTeamMemberFromList(player2);
		ArrayList<FBPlayer> newList = newFBTeam.getTeamList();
		
		assertEquals(list, newList);
	}
	
	
	@Test
	// use toString() to print a null FBTeam
	void testToString1() {
		// test a null FBTeam
		assertEquals("Team Members: None", newFBTeam.toString());
	}
	
	@Test
	// use toString() to print a valid FBTeam
	void testToString2() {
		// create new players
		FBPlayer player = new FBPlayer("Sam", 20410001, "Male");

		// add players to FBTeam
		newFBTeam.addTeamMemberToList(player);
		
		assertEquals("Team Members: [0]: Sam\n", newFBTeam.toString());
	}

}








