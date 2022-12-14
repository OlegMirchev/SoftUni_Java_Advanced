package onlineShop.models.products.components;

import onlineShop.common.constants.OutputMessages;
import onlineShop.models.products.BaseProduct;

public abstract class BaseComponent extends BaseProduct implements Component {
    private int generation;

    protected BaseComponent(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance);
        this.generation = generation;
    }

    @Override
    public int getGeneration() {
        return generation;
    }

    @Override
    public String toString() {
        return String.format(OutputMessages.PRODUCT_TO_STRING + OutputMessages.COMPONENT_TO_STRING, super.getOverallPerformance(), super.getPrice(),
                super.getClass().getSimpleName(), super.getManufacturer(), super.getModel(), super.getId(), this.generation);
    }
}
