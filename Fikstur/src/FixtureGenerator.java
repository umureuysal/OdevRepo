import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FixtureGenerator {
    private List<String> teams;
    private List<String> fixtures;

    public FixtureGenerator(List<String> teams) {
        this.teams = teams;
        this.fixtures = new ArrayList<>();
    }

    public List<String> generateFixtures() {
        int numTeams = teams.size();
        int numRounds = (numTeams % 2 == 0) ? numTeams - 1 : numTeams;

        // Ekstra takım ekleme (Bay)
        if (numTeams % 2 != 0) {
            teams.add("Bay");
            numTeams++;
        }

        // Takımları karıştırma
        Collections.shuffle(teams);

        // Takımları iki gruba ayırma
        List<String> homeTeams = new ArrayList<>(teams.subList(0, numTeams / 2));
        List<String> awayTeams = new ArrayList<>(teams.subList(numTeams / 2, numTeams));

        // Fikstür oluşturma
        for (int round = 1; round <= numRounds; round++) {
            StringBuilder fixture = new StringBuilder();
            for (int i = 0; i < homeTeams.size(); i++) {
                String homeTeam = homeTeams.get(i);
                String awayTeam = awayTeams.get(i);
                fixture.append(homeTeam).append(" vs ").append(awayTeam).append(" ");
            }
            fixtures.add(fixture.toString());

            // Takımları döndürme
            Collections.rotate(homeTeams, 1);
            Collections.rotate(awayTeams, -1);
        }

        return fixtures;
    }