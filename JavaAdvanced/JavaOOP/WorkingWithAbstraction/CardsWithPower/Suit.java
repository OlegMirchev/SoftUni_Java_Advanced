package JavaAdvanced2021.JavaOPP.WorkingWithAbstractionExercise2810.CardsWithPower;

public enum Suit {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int powerSuit;

    Suit(int powerSuit) {
        this.powerSuit = powerSuit;
    }

    public int getPowerSuit() {
        return powerSuit;
    }
}
