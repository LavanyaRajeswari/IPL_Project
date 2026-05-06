public class Match {
    public int matchId;
    public int matchSeason;
    public String matchCity;
    public String matchDate;
    public String matchTeam1;
    public String matchTeam2;
    public String matchTossWinner;
    public String matchTossDecision;
    public String matchResult;
    public int matchDLApplied;
    public String matchWinner;
    public int matchWinByRuns;
    public int matchWinByWickets;
    public String matchPlayerOfMatch;
    public String matchVenue;
    public String matchUmpire1;
    public String matchUmpire2;
    public String matchUmpire3;

    public Match(int matchId, int matchSeason, String matchCity, String matchDate,
                 String matchTeam1, String matchTeam2, String matchTossWinner,
                 String matchTossDecision, String matchResult, int matchDLApplied,
                 String matchWinner, int matchWinByRuns, int matchWinByWickets,
                 String matchPlayerOfMatch, String matchVenue,
                 String matchUmpire1, String matchUmpire2, String matchUmpire3) {

        this.matchId = matchId;
        this.matchSeason = matchSeason;
        this.matchCity = matchCity;
        this.matchDate = matchDate;
        this.matchTeam1 = matchTeam1;
        this.matchTeam2 = matchTeam2;
        this.matchTossWinner = matchTossWinner;
        this.matchTossDecision = matchTossDecision;
        this.matchResult = matchResult;
        this.matchDLApplied = matchDLApplied;
        this.matchWinner = matchWinner;
        this.matchWinByRuns = matchWinByRuns;
        this.matchWinByWickets = matchWinByWickets;
        this.matchPlayerOfMatch = matchPlayerOfMatch;
        this.matchVenue = matchVenue;
        this.matchUmpire1 = matchUmpire1;
        this.matchUmpire2 = matchUmpire2;
        this.matchUmpire3 = matchUmpire3;
    }

    @Override
    public String toString() {
        return matchId + ", " + matchSeason + ", " + matchCity + ", " + matchDate + ", " +
               matchTeam1 + ", " + matchTeam2 + ", " + matchTossWinner + ", " +
               matchTossDecision + ", " + matchResult + ", " + matchDLApplied + ", " +
               matchWinner + ", " + matchWinByRuns + ", " + matchWinByWickets + ", " +
               matchPlayerOfMatch + ", " + matchVenue + ", " + matchUmpire1 + ", " +
               matchUmpire2 + ", " + matchUmpire3;
    }
}