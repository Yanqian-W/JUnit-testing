
import java.util.ArrayList;

public class FBTeam {
    private ArrayList<FBPlayer> teamList;
    private String teamColor;

    public FBTeam() {
        teamList = new ArrayList<FBPlayer>();
        teamColor = "White";
    }

    // Modified by Yanqian Wang
    // Use isEmpty() to determine if this.teamList is empty, rather than comparing with null
    // Because this.teamList will be initialized as ArrayList<FBPlayer>()
    public void setTeamList(ArrayList<FBPlayer> teamList) {
        if (this.teamList.isEmpty()) {
        	this.teamList = teamList;
        }
    }

    // Modified by Yanqian Wang
    // Add judgment conditions, check if teamColor is null or ""
    // Because we don't want the teamColor to update when the input string is null or ""
    public void setTeamColor(String teamColor){
    	if ((teamColor != null) & (teamColor != "" ))
        this.teamColor = teamColor;
    }

    
    public String getTeamColor(){
    	return this.teamColor;
    }
    
    public ArrayList<FBPlayer> getTeamList() {
        return teamList;
    }
    
    // Modified by Yanqian Wang
    // Add judgment conditions, check if the input teamMember is empty or already exists
    // Because we don't want to add empty or duplicate players
    public void addTeamMemberToList(FBPlayer teamMember) {
    	// check if the name of input teamMember is null
    	if (teamMember.getPersonName() == null) {
    		return;
    	}
    	// check if the same player already exists
    	for (int j = 0; j < this.teamList.size(); j++) {
            if (this.teamList.get(j) == teamMember) {
            	return;
            }
        }
    	// this teamMember is valid
        this.teamList.add(teamMember);
    }
    
    public void removeTeamMemberFromList(FBPlayer teamMember) {
        this.teamList.remove(teamMember);
    }


    @Override
    public String toString() {

        String member = "Team Members: ";
        if (getTeamList().size()==0){
            member+="None";
        }
        for (int i = 0; i < getTeamList().size(); i++) {
            member += "[" + i + "]: " + getTeamList().get(i).getPersonName() + "\n";
        }

        return   member ;
    }
}
