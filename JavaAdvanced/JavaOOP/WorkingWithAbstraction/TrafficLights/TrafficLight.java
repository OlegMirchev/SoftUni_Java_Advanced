package JavaAdvanced2021.JavaOPP.WorkingWithAbstractionExercise2810.TrafficLights;

public class TrafficLight {
    private Lights lights;

    public TrafficLight(Lights lights) {
        this.lights = lights;
    }

    public void changeLight() {
        switch (this.lights) {
            case RED:
                this.lights = Lights.GREEN;
                break;
            case GREEN:
                this.lights = Lights.YELLOW;
                break;
            case YELLOW:
                this.lights = Lights.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return this.lights.toString();
    }
}
