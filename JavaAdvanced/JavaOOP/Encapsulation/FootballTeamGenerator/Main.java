package Tasks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Team> mapTeam = new LinkedHashMap<>();

        while (!input.equals("END")) {
            String[] tokens = input.split(";");
            String command = tokens[0];
            String teamName = tokens[1];
            try {
                switch (command) {
                    case "Team":
                        Team team = new Team(teamName);
                        mapTeam.putIfAbsent(teamName, team);
                        break;
                    case "Add":
                        String namePlayer = tokens[2];
                        int endurance = Integer.parseInt(tokens[3]);
                        int sprint = Integer.parseInt(tokens[4]);
                        int dribble = Integer.parseInt(tokens[5]);
                        int passing = Integer.parseInt(tokens[6]);
                        int shooting = Integer.parseInt(tokens[7]);
                        if (!mapTeam.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        }else {
                            Player player = new Player(namePlayer, endurance, sprint, dribble, passing, shooting);
                            mapTeam.get(teamName).addPlayer(player);
                        }
                        break;
                    case "Remove":
                        String playerName = tokens[2];
                        mapTeam.get(teamName).removePlayer(playerName);
                        break;
                    case "Rating":
                        if (!mapTeam.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        }else {
                            System.out.println(teamName + " - " + Math.round(mapTeam.get(teamName).getRating()));
                        }
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

            }
            input = scanner.nextLine();
        }
    }
}
