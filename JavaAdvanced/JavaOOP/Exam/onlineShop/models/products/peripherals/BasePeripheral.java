package onlineShop.models.products.peripherals;

import onlineShop.common.constants.OutputMessages;
import onlineShop.models.products.BaseProduct;

public abstract class BasePeripheral extends BaseProduct implements Peripheral {
    private String connectionType;

    protected BasePeripheral(int id, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        super(id, manufacturer, model, price, overallPerformance);
        this.connectionType = connectionType;
    }

    @Override
    public String getConnectionType() {
        return connectionType;
    }

    @Override
    public String toString() {
        return String.format(OutputMessages.PRODUCT_TO_STRING + OutputMessages.PERIPHERAL_TO_STRING, super.getOverallPerformance(), super.getPrice(),
                super.getClass().getSimpleName(), super.getManufacturer(), super.getModel(), super.getId(), this.connectionType);
    }
}
