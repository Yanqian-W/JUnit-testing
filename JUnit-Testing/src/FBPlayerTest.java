

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



class FBPlayerTest {
/*	@Test
	void setPersonID() {
		FBPlayer player1 = new FBPlayer();
		int personID = "123 456";
		player1.setPersonID(personID);
		int getid = player1.getPersonID();
		assertEquals(getid, personID);
	}*/
	@Test
	void setPersonGender() {
		FBPlayer player1 = new FBPlayer();
		String personGender = "abcd";
		player1.setPersonGender(personGender);
		String getgender = player1.getPersonGender();
		assertEquals(getgender, personGender);
	}
	
	@Test
	void setPersonName() {
		FBPlayer player1 = new FBPlayer();
		String personName = "abcd";
		player1.setPersonName(personName);
		String getname = player1.getPersonName();
		assertEquals(getname, personName);
	}
	

	@Test
	void getPersonID() {
		FBPlayer player1 = new FBPlayer();
		int myID = player1.getPersonID();
		assertEquals(myID, 0);
	}
	@Test
	void getPersonName() {
		FBPlayer player1 = new FBPlayer();
		String myName = player1.getPersonName();
		assertEquals(null, myName);
	}
	@Test
	void getPersonGender() {
		FBPlayer player1 = new FBPlayer();
		String myGender = player1.getPersonGender();
		assertEquals(null, myGender);
	}
	@Test
	void isIDValid() {
		FBPlayer player1 = new FBPlayer();
		boolean ID_isvalid = player1.isIDValid();
		assertFalse(ID_isvalid);
	}
	@Test
	void isNameValid() {
		FBPlayer player1 = new FBPlayer();
		boolean Name_isvalid = player1.isNameValid();
		assertTrue(Name_isvalid);
	}
	@Test
	void isGenderValid() {
		FBPlayer player1 = new FBPlayer();
		boolean Gender_isvalid = player1.isGenderValid();
		assertTrue(Gender_isvalid);
	}
	@Test
	void test1() {
		FBPlayer player1 = new FBPlayer();
		String information = player1.toString();
		String info = "Player Information:\n";
        info = info + "Name: "+null + "\n";
        info = info + "Gender: "+null + "\n";
        info = info + "ID: "+0+ "\n"; 
		assertEquals(information, info);
	}
	void test() {
		fail("Not yet implemented");
	}

}
