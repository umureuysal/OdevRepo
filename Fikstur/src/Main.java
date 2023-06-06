import java.nio.charset.Charset;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> teams = new ArrayList<>();
        teams.add("Galatasaray");
        teams.add("Bursaspor");
        teams.add("Fenerbahçe");
        teams.add("Beşiktaş");
        teams.add("Başakşehir");
        teams.add("Trabzonspor");

        FixtureGenerator fixtureGenerator = new FixtureGenerator(teams);
        List<String> fixtures = fixtureGenerator.generateFixtures();

        // Fikstürleri yazdırma
        int round = 1;
        for (String fixture : fixtures) {
            System.out.println("Round " + round++);
            System.out.println(fixture);
            System.out.println();
        }
    }
}