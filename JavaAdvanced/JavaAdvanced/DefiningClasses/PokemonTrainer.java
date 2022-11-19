package JavaAdvanced2021.JavaAdvanced.DefiningClassesExercises0410;

import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class PokemonTrainer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, Trainer> mapTrainer = new LinkedHashMap<>();
        ArrayList<Pokemon> pokemonNumb = new ArrayList<>();

        while (!command.equals("Tournament")) {
            String[] input = command.split("\\s+");
            String nameTrainer = input[0];
            String namePokemon = input[1];
            String element = input[2];
            int health = Integer.parseInt(input[3]);

            Pokemon pokemon = new Pokemon(namePokemon, element, health);

            mapTrainer.putIfAbsent(nameTrainer, new Trainer());
            mapTrainer.get(nameTrainer).addPok(pokemon);

            command = scanner.nextLine();
        }
        String newCommand = scanner.nextLine();

        while (!newCommand.equals("End")) {
            for (var entry : mapTrainer.entrySet()) {
                if (entry.getValue().pokemonSize() > 0) {
                    boolean isValid = false;
                    for (Pokemon pokemon : entry.getValue().getPokemon()) {
                        if (pokemon.getElement().equals(newCommand)) {
                            isValid = true;
                            entry.getValue().setNumbBadges();
                            break;
                        }
                    }
                    if (!isValid) {
                        entry.getValue().missingPokemon();
                    }
                }
            }
            newCommand = scanner.nextLine();
        }
        mapTrainer.entrySet().stream().sorted((value1, value2) ->
                Integer.compare(value2.getValue().getNumbBadges(), value1.getValue().getNumbBadges()))
                .forEach(e -> {
                    System.out.printf("%s %s %s%n", e.getKey(), e.getValue().getNumbBadges(), e.getValue().pokemonSize());
                });
    }

    public static class Trainer {
        private String name;
        private int numbBadges;
        private List<Pokemon> pokemon;

        public Trainer(String name, int numbBadges, ArrayList<Pokemon> pokemon) {
            this.name = name;
            this.numbBadges = 0;
            this.pokemon = pokemon;
        }

        public Trainer() {
            this.numbBadges = 0;
            this.pokemon = new ArrayList<>();
        }

        public void addPok(Pokemon pokemon) {
            this.pokemon.add(pokemon);
        }

        public int pokemonSize() {
            return this.pokemon.size();
        }

        public List<Pokemon> getPokemon() {
            return pokemon;
        }

        public void setNumbBadges() {
            this.numbBadges++;
        }

        private UnaryOperator<Pokemon> damagePokemon = pokemon ->
                new Pokemon(pokemon.getName(), pokemon.getElement(), pokemon.getHealth() - 10);

        public void missingPokemon() {
            this.pokemon = this.pokemon.stream()
                    .map(damagePokemon).filter(p -> p.getHealth() > 0).collect(Collectors.toList());
        }

        public int getNumbBadges() {
            return numbBadges;
        }
    }

    public static class Pokemon {
        private String name;
        private String element;
        private int health;

        public Pokemon(String name, String element, int health) {
            this.name = name;
            this.element = element;
            this.health = health;
        }

        public String getElement() {
            return element;
        }

        public int getHealth() {
            return health;
        }

        public String getName() {
            return name;
        }
    }
}
