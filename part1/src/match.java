import java.util.StringTokenizer;
public class match {
   private String Match_ID,Home_Team, Guest_Team,Match_Date,Guest_Region,Home_Region,Guest_Id,Home_ID;
   private int Home_Score,Guest_Score;


   match(String Match_ID,String Home_Team,String  Guest_Team,String  Home_Score,String Guest_Score,String Match_Date){
       this.Guest_Score=Integer.parseInt(Guest_Score);
       this.Guest_Team=Guest_Team;
       this.Home_Score=Integer.parseInt(Home_Score);
       this.Home_Team=Home_Team;
       this.Match_Date=Match_Date;
       this.Match_ID=Match_ID;

       StringTokenizer str1 = new StringTokenizer(Home_Team,"-");
       StringTokenizer str2 = new StringTokenizer(Guest_Team,"-");

       setHome_Region(str1.nextToken());
       setGuest_Region(str2.nextToken());
       setHome_ID(str1.nextToken());
        setGuest_Id(str2.nextToken());


   }
public void setHome_Score(int home_Score) {
    Home_Score = home_Score;
}


    public void setGuest_Score(int guest_Score) {
        Guest_Score = guest_Score;
    }


    public String getMatch_Date() {
        return Match_Date;
    }

    public void setGuest_Team(String guest_Team) {
        Guest_Team = guest_Team;
    }

    public int getHome_Score() {
        return Home_Score;
    }

    public int getGuest_Score() {
        return Guest_Score;
    }

    public String getGuest_Team() {
        return Guest_Team;
    }

    public String getHome_Team() {
        return Home_Team;
    }

    public String getMatch_ID() {
        return Match_ID;
    }

    public String getGuest_Region() {
        return Guest_Region;
    }

    public String getGuest_Id() {
        return Guest_Id;
    }

    public String getHome_Region() {
        return Home_Region;
    }

    public String getHome_ID() {
        return Home_ID;
    }

    public void setGuest_Id(String guest_Id) {
        Guest_Id = guest_Id;
    }

    public void setGuest_Region(String guest_Region) {
        Guest_Region = guest_Region;
    }

    public void setHome_ID(String home_ID) {
        Home_ID = home_ID;
    }

    public void setHome_Region(String home_Region) {
        Home_Region = home_Region;
    }

    public void setHome_Team(String home_Team) {
        Home_Team = home_Team;
    }

    public void setMatch_Date(String match_Date) {
        Match_Date = match_Date;
    }

    public void setMatch_ID(String match_ID) {
        Match_ID = match_ID;
    }

}


