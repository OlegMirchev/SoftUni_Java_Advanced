package JavaAdvanced2021.JavaOPP.EncapsulationLAB2910.SortByNameAndAge.FirstAndReserveTeam;

import JavaAdvanced2021.JavaOPP.EncapsulationLAB2910.SortByNameAndAge.FirstAndReserveTeam.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Person> people = new ArrayList<>();
        Team team = new Team("Black Eagle");

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);
            double salary = Double.parseDouble(input[3]);

            Person person = new Person(firstName, lastName, age, salary);
            team.addPlayer(person);
        }
        System.out.printf("First team have %d players%n", team.getFirstTeam().size());
        System.out.printf("Reserve team have %d players", team.getReserveTeam().size());
    }

    public static class Team {
        private String name;
        private List<Person> firstTeam;
        private List<Person> reserveTeam;

        public Team(String name) {
            this.setName(name);
            this.firstTeam = new ArrayList<>();
            this.reserveTeam = new ArrayList<>();
        }

        private void setName(String name) {

        }

        public String getName() {
            return name;
        }

        public void addPlayer(Person person) {
            if (person.getAge() < 40) {
                this.firstTeam.add(person);
            }else {
                this.reserveTeam.add(person);
            }
        }

        public List<Person> getFirstTeam() {
            return Collections.unmodifiableList(firstTeam);
        }

        public List<Person> getReserveTeam() {
            return Collections.unmodifiableList(reserveTeam);
        }
    }
}
