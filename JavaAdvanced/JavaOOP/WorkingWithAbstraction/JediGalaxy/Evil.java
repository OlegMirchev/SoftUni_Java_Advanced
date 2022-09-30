package JavaAdvanced2021.JavaOPP.WorkingWithAbstractionExercise2810.JediGalaxy;

public class Evil {
    private Galaxy galaxy;

    public Evil(Galaxy galaxy) {
        this.galaxy = galaxy;
    }

    public void destroyStars(int row, int col) {
        while (row >= 0 && col >= 0) {
            if (row < this.galaxy.getLength()
                    && col < this.galaxy.getInnerLength(row)) {
                this.galaxy.setStar(row, col, 0);
            }
            row--;
            col--;
        }
    }
}
