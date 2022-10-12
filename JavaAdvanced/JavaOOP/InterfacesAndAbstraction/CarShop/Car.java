package JavaAdvanced2021.JavaOPP.InterfacesAndAbstractionLAB0511.CarShop;

import java.io.Serializable;

public interface Car extends Serializable {

    int TIRES = 4;

    String getModel();
    String getColor();
    Integer getHorsePower();
    String countryProduced();
}
