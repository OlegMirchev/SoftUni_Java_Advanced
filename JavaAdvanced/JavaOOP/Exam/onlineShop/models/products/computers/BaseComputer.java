package onlineShop.models.products.computers;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.common.constants.OutputMessages;
import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;

    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public double getOverallPerformance() {
        if (this.components.isEmpty()) {
            return super.getOverallPerformance();
        }

        double average = this.components.stream().mapToDouble(Component::getOverallPerformance).average().orElse(0.0);

        return super.getOverallPerformance() + average;
    }

    @Override
    public double getPrice() {
        double sumPriceComponents = this.components.stream().mapToDouble(Component::getPrice).sum();
        double sumPricePeripherals = this.peripherals.stream().mapToDouble(Peripheral::getPrice).sum();

        return super.getPrice() + sumPriceComponents + sumPricePeripherals;
    }

    @Override
    public List<Component> getComponents() {
        return components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return peripherals;
    }

    @Override
    public void addComponent(Component component) {
        String componentType = component.getClass().getSimpleName();

        if (this.components.getClass().getSimpleName().contains(componentType)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_COMPONENT,
                    componentType, super.getClass().getSimpleName(), super.getId()));
        }

        this.components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        Component component = null;

        for (Component comp : this.components) {
            if (comp.getClass().getSimpleName().equals(componentType)) {
                component = comp;
            }
        }

        if (this.components.isEmpty() || component == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NOT_EXISTING_COMPONENT,
                    componentType, super.getClass().getSimpleName(), super.getId()));
        }

        //Component component = this.components.stream().filter(c -> c.getClass().getSimpleName().equals(componentType)).findFirst().get();

        this.components.remove(component);

        return component;
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        String peripheralType = peripheral.getClass().getSimpleName();

        if (this.peripherals.getClass().getSimpleName().contains(peripheralType)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_PERIPHERAL,
                    peripheralType, super.getClass().getSimpleName(), super.getId()));
        }

        this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        Peripheral peripheral = null;

        for (Peripheral per : peripherals) {
            if (per.getClass().getSimpleName().equals(peripheralType)) {
                peripheral = per;
            }
        }

        if (this.peripherals.isEmpty() || peripheral == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NOT_EXISTING_PERIPHERAL,
                    peripheralType, super.getClass().getSimpleName(), super.getId()));
        }

        //Peripheral peripheral = this.peripherals.stream().filter(p -> p.getClass().getSimpleName().equals(peripheralType)).findFirst().get();

        this.peripherals.remove(peripheral);

        return peripheral;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(String.format(OutputMessages.PRODUCT_TO_STRING, getOverallPerformance(), getPrice(),
                super.getClass().getSimpleName(), super.getManufacturer(), super.getModel(), super.getId())).append(System.lineSeparator());

        output.append(String.format(" " + OutputMessages.COMPUTER_COMPONENTS_TO_STRING, this.components.size())).append(System.lineSeparator());

        for (Component component : this.components) {
            output.append("  ").append(component).append(System.lineSeparator());
        }

        double average = this.peripherals.stream().mapToDouble(Peripheral::getOverallPerformance).average().orElse(0.0);

        output.append(String.format(" " + OutputMessages.COMPUTER_PERIPHERALS_TO_STRING,
                this.peripherals.size(), average)).append(System.lineSeparator());

        for (Peripheral peripheral : this.peripherals) {
            output.append("  ").append(peripheral).append(System.lineSeparator());
        }

        return output.toString().trim();
    }
}
