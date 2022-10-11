package JavaAdvanced2021.JavaOPP.InterfacesAndAbstractionLAB0511.BorderControl;

import JavaAdvanced2021.JavaOPP.InterfacesAndAbstractionLAB0511.BorderControl.Identifiable;

public class Robot implements Identifiable {
    private String model;
    private String id;

    public Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
