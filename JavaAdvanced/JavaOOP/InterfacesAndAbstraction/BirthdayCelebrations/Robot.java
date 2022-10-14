package JavaAdvanced2021.JavaOPP.InterfacesAndAbstractionExercises0811.BirthdayCelebrations;

public class Robot implements Identifiable, Model {
    private String id;
    private String model;

    public Robot(String id, String model) {
        this.id = id;
        this.model = model;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getModel() {
        return this.model;
    }
}
