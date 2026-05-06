public class Delivery {
    public int matchId;
    public int inning;
    public String battingTeam;
    public String bowlingTeam;
    public int over;
    public int ball;
    public String batsman;
    public String nonStriker;
    public String bowler;
    public int isSuperOver;
    public int wideRuns;
    public int byeRuns;
    public int legByeRuns;
    public int noBallRuns;
    public int penaltyRuns;
    public int batsmanRuns;
    public int extraRuns;
    public int totalRuns;
    public String playerDismissed;
    public String dismissalKind;
    public String fielder;

    public Delivery(int matchId, int inning, String battingTeam, String bowlingTeam, int over, int ball,
                    String batsman, String nonStriker, String bowler, int isSuperOver, int wideRuns,
                    int byeRuns, int legByeRuns, int noBallRuns, int penaltyRuns, int batsmanRuns,
                    int extraRuns, int totalRuns, String playerDismissed, String dismissalKind, String fielder) {

        this.matchId = matchId;
        this.inning = inning;
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.over = over;
        this.ball = ball;
        this.batsman = batsman;
        this.nonStriker = nonStriker;
        this.bowler = bowler;
        this.isSuperOver = isSuperOver;
        this.wideRuns = wideRuns;
        this.byeRuns = byeRuns;
        this.legByeRuns = legByeRuns;
        this.noBallRuns = noBallRuns;
        this.penaltyRuns = penaltyRuns;
        this.batsmanRuns = batsmanRuns;
        this.extraRuns = extraRuns;
        this.totalRuns = totalRuns;
        this.playerDismissed = playerDismissed;
        this.dismissalKind = dismissalKind;
        this.fielder = fielder;
    }

    @Override
    public String toString() {
        return matchId + ", " + inning + ", " + battingTeam + ", " + bowlingTeam + ", " + over + ", " + ball + ", " +
               batsman + ", " + nonStriker + ", " + bowler + ", " + isSuperOver + ", " + wideRuns + ", " + byeRuns + ", " +
               legByeRuns + ", " + noBallRuns + ", " + penaltyRuns + ", " + batsmanRuns + ", " + extraRuns + ", " +
               totalRuns + ", " + playerDismissed + ", " + dismissalKind + ", " + fielder;
    }
}