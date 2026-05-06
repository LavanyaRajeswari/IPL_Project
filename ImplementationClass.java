
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ImplementationClass {

    public static void main(String[] args) throws IOException {
        final String FILE_PATH_MATCHES = "./archive/matches.csv";
        final String FILE_PATH_DELIVERIES = "./archive/deliveries.csv";

        List<Match> Matches = getMatches(FILE_PATH_MATCHES);
        List<Delivery> Deliveries = getDeliveries(FILE_PATH_DELIVERIES);

        Map<Integer, Integer> MatchesPerYear = getMatchesPerYear(Matches);
        Map<String, Integer> MatchesWonByTeam = getMatchesWonTeams(Matches);
        Map<String, Integer> MatchesExtraRunsPerTeam = getExtraRunsPerTeam(Matches, Deliveries);
        Map<String, Double> MatchesTopEconomicalBowlers = getTopEconomicalBowlers2015(Matches, Deliveries);

        Display("MatchesPerYear", MatchesPerYear);
        Display("MatchesWonByTeam", MatchesWonByTeam);
        Display("MatchesExtraRunsPerTeam", MatchesExtraRunsPerTeam);
        Display("MatchesTopEconomicalBowlers", MatchesTopEconomicalBowlers);

    }

    static List<Match> getMatches(String path) throws IOException {
        List<Match> Matches = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);
                Match m = new Match(
                        Integer.parseInt(values[0]), Integer.parseInt(values[1]), values[2], values[3], values[4], values[5],
                        values[6], values[7], values[8], Integer.parseInt(values[9]), values[10], Integer.parseInt(values[11]),
                        Integer.parseInt(values[12]), values[13], values[14], values[15], values[16], values[17]
                );
                Matches.add(m);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return Matches;
    }

    static List<Delivery> getDeliveries(String path) throws IOException {
        List<Delivery> deliveries = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);

                Delivery d = new Delivery(
                        Integer.parseInt(values[0]), Integer.parseInt(values[1]), values[2], values[3], Integer.parseInt(values[4]),
                        Integer.parseInt(values[5]), values[6], values[7], values[8], Integer.parseInt(values[9]), Integer.parseInt(values[10]),
                        Integer.parseInt(values[11]), Integer.parseInt(values[12]), Integer.parseInt(values[13]), Integer.parseInt(values[14]),
                        Integer.parseInt(values[15]), Integer.parseInt(values[16]), Integer.parseInt(values[17]), values[18], values[19], values[20]
                );
                deliveries.add(d);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return deliveries;
    }

    static Map<Integer, Integer> getMatchesPerYear(List<Match> matches) {
        Map<Integer, Integer> MatchesPerYear = new HashMap<>();

        for (Match mc : matches) {
            int season = mc.matchSeason;
            MatchesPerYear.put(season, MatchesPerYear.getOrDefault(season, 0) + 1);
        }
        return MatchesPerYear;
    }

    static Map<String, Integer> getMatchesWonTeams(List<Match> matches) {
        Map<String, Integer> MatchesWonTeams = new HashMap<>();

        for (Match mc : matches) {
            String winner = mc.matchWinner;
            MatchesWonTeams.put(winner, MatchesWonTeams.getOrDefault(winner, 0) + 1);
        }
        return MatchesWonTeams;
    }

    static Map<String, Integer> getExtraRunsPerTeam(List<Match> matches, List<Delivery> deliveries) {
        Map<Integer, Integer> MatchSeasons = new HashMap<>();
        for (Match mc : matches) {
            MatchSeasons.put(mc.matchId, mc.matchSeason);
        }

        Map<String, Integer> ExtraRunsPerTeam = new HashMap<>();

        for (Delivery ds : deliveries) {
            Integer season = MatchSeasons.get(ds.matchId);
            if (season != null && season == 2016) {
                String team = ds.bowlingTeam;
                int extras = ds.extraRuns;
                ExtraRunsPerTeam.put(team, ExtraRunsPerTeam.getOrDefault(team, 0) + extras);
            }
        }
        return ExtraRunsPerTeam;
    }

    static Map<String, Double> getTopEconomicalBowlers2015(List<Match> matches, List<Delivery> deliveries) {
        Map<Integer, Integer> MatchSeasons = new HashMap<>();
        for (Match mc : matches) {
            MatchSeasons.put(mc.matchId, mc.matchSeason);
        }

        Map<String, Integer> runsConceded = new HashMap<>();
        Map<String, Integer> ballsBowled = new HashMap<>();

        for (Delivery d : deliveries) {
            Integer season = MatchSeasons.get(d.matchId);
            if (season != null && season == 2015) {
                String bowler = d.bowler;
                runsConceded.put(bowler, runsConceded.getOrDefault(bowler, 0) + (d.batsmanRuns + d.noBallRuns + d.wideRuns));
                if (d.noBallRuns == 0 && d.wideRuns == 0) {
                    ballsBowled.put(bowler, ballsBowled.getOrDefault(bowler, 0) + 1);
                }
            }
        }

        Map<String, Double> TopEconomicalBowlers = new HashMap<>();
        for (String bowler : runsConceded.keySet()) {
            int balls = ballsBowled.getOrDefault(bowler, 0);
            double overs = balls / 6.0;
            TopEconomicalBowlers.put(bowler, runsConceded.get(bowler) / overs);
        }
        Map<String, Double> TopEconomicalBowlers2015 = TopEconomicalBowlers.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(5)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> Math.round(e.getValue() * 100.0) / 100.0,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
        return TopEconomicalBowlers2015;
    }

    static <K, V> void Display(String title, Map<K, V> map) {
        System.out.println(title + ":");
        System.out.println();
        map.forEach((key, value) -> System.out.println(key + " - " + value));
        System.out.println();
    }
}
