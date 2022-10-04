package Tasks;

public class Player {
    private static final double AVERAGE_STATS = 5.00;
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    public double overallSkillLevel() {
        return (this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / AVERAGE_STATS;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
        String nameStats = "Endurance";
        getStats(nameStats, endurance);

        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        String nameStats = "Sprint";
        getStats(nameStats, sprint);

        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        String nameStats = "Dribble";
        getStats(nameStats, dribble);

        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        String nameStats = "Passing";
        getStats(nameStats, passing);

        this.passing = passing;
    }

    private void setShooting(int shooting) {
        String nameStats = "Shooting";
        getStats(nameStats, shooting);

        this.shooting = shooting;
    }

    public String getName() {
        return name;
    }

    public void getStats(String nameStats, int number) {
        if (number < 0 || number > 100) {
            throw new IllegalArgumentException(String.format("%s should be between 0 and 100.", nameStats));
        }
    }
}
