import java.util.StringTokenizer;

public class team {
    private String creature, city,symbolize,dateTime,region;
    int win,lose,id,caculusScore,winMatch,lostMatch;
    double winRate,loseRate;

    public team(String creature, String city, String symbolize, String dateTime) {
        this.creature = creature;
        this.city = city;
        this.symbolize = symbolize;
        this.dateTime = dateTime;
        StringTokenizer str= new StringTokenizer((symbolize),"-");
        this.region=str.nextToken();
        this.id=Integer.parseInt(str.nextToken());
    }

    public int getId() { return id; }

    public String getRegion() { return region; }

    public void setId(int id) { this.id = id; }

    public void setRegion(String region) { this.region = region; }

    public void setWin(int win) { this.win = win; }

    public void setLose(int lose) { this.lose = lose; }

    public int getWin() { return win; }

    public int getLose() { return lose; }

    public String getCity() {
        return city;
    }

    public String getCreature() {
        return creature;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getSymbolize() {
        return symbolize;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCreature(String creature) {
        this.creature = creature;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setSymbolize(String symbolize) {
        this.symbolize = symbolize;
    }

    public double getWinRate() { return this.winRate; }

    public void setCaculusScore() { this.caculusScore = this.getWin()*2-this.getLose()*1; }

    public int getCaculusScore() { return this.caculusScore; }

    public void setWinRate() { this.winRate = (double)this.win/(this.win+this.lose); }

    public void setCaculusScore(int caculusScore) { this.caculusScore = caculusScore; }

    public double getLoseRate() { return loseRate; }

    public void setLoseRate() { this.loseRate=1-this.winRate; }

    public void setWinRate(double winRate) { this.winRate = winRate; }

    public void setLoseRate(double loseRate) { }

    public int getLostMatch() { return lostMatch; }

    public int getWinMatch() { return winMatch; }

    public void setLostMatch(int lostMatch) { this.lostMatch = lostMatch; }

    public void setWinMatch(int winMatch) { this.winMatch = winMatch; }
}
