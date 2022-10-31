package onlineShop.core;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.common.constants.OutputMessages;
import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.*;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private List<Computer> listComputer;
    private Map<String, Component> componentMap;
    private Map<String, Peripheral> peripheralMap;

    public ControllerImpl() {
        this.listComputer = new ArrayList<>();
        this.componentMap = new LinkedHashMap<>();
        this.peripheralMap = new LinkedHashMap<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        Computer computer = computerType.equals("Laptop")
                ? new Laptop(id, manufacturer, model, price)
                : new DesktopComputer(id, manufacturer, model, price);

        for (Computer comp : this.listComputer) {
            if (comp.getId() == id) {
                throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPUTER_ID);
            }
        }

        if (!computer.getClass().getSimpleName().equals(computerType)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPUTER_TYPE);
        }

        this.listComputer.add(computer);

        return String.format(OutputMessages.ADDED_COMPUTER, id);
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        Peripheral peripheral = null;

        Computer computer = this.listComputer.stream().filter(c -> c.getId() == computerId).findFirst().orElse(null);

        if (computer == null) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }

        switch (peripheralType) {
            case "Headset":
                peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Keyboard":
                peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Monitor":
                peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Mouse":
                peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
        }

        for (Peripheral peripheralValue : this.peripheralMap.values()) {
            if (peripheralValue.getId() == id) {
                throw new IllegalArgumentException(ExceptionMessages.EXISTING_PERIPHERAL_ID);
            }
        }

        if (!(peripheralType.equals("Headset")) && !(peripheralType.equals("Keyboard")) && !(peripheralType.equals("Monitor")) && !(peripheralType.equals("Mouse"))) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PERIPHERAL_TYPE);
        }

        computer.addPeripheral(peripheral);
        this.peripheralMap.put(peripheralType, peripheral);

        return String.format(OutputMessages.ADDED_PERIPHERAL, peripheralType, id, computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        Computer computer = this.listComputer.stream().filter(c -> c.getId() == computerId).findFirst().orElse(null);

        if (computer == null) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }

        computer.removePeripheral(peripheralType);

        Peripheral peripheral = this.peripheralMap.values().stream().filter(p -> p.getClass().getSimpleName().equals(peripheralType)).findFirst().get();

        this.peripheralMap.remove(peripheralType, peripheral);

        return String.format(OutputMessages.REMOVED_PERIPHERAL, peripheralType, peripheral.getId());
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
        Component component = null;

        Computer computer = this.listComputer.stream().filter(c -> c.getId() == computerId).findFirst().orElse(null);

        if (computer == null) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }

        switch (componentType) {
            case "CentralProcessingUnit":
                component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "Motherboard":
                component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "PowerSupply":
                component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "RandomAccessMemory":
                component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "SolidStateDrive":
                component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "VideoCard":
                component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
                break;
        }

        for (Component comp : this.componentMap.values()) {
            if (comp.getId() == id) {
                throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPONENT_ID);
            }
        }

        if (!(componentType.equals("CentralProcessingUnit")) && !(componentType.equals("Motherboard")) && !(componentType.equals("PowerSupply")) &&
                !(componentType.equals("RandomAccessMemory")) && !(componentType.equals("SolidStateDrive")) && !(componentType.equals("VideoCard"))) {

            throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPONENT_TYPE);
        }

        computer.addComponent(component);
        this.componentMap.put(componentType, component);

        return String.format(OutputMessages.ADDED_COMPONENT, componentType, id, computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        Computer computer = this.listComputer.stream().filter(c -> c.getId() == computerId).findFirst().orElse(null);

        if (computer == null) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }

        computer.removeComponent(componentType);

        Component component = this.componentMap.values().stream().filter(c -> c.getClass().getSimpleName().equals(componentType)).findFirst().get();

        this.componentMap.remove(componentType, component);

        return String.format(OutputMessages.REMOVED_COMPONENT, componentType, component.getId());
    }

    @Override
    public String buyComputer(int id) {
        Computer computer = this.listComputer.stream().filter(c -> c.getId() == id).findFirst().orElse(null);

        if (computer == null) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }

        this.listComputer.remove(computer);

        return computer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {
        List<Computer> collect = this.listComputer.stream().filter(c -> c.getPrice() <= budget).collect(Collectors.toList());

        if (this.listComputer.isEmpty() || collect.isEmpty()) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAN_NOT_BUY_COMPUTER, budget));
        }

        Computer computerOverall = collect.stream().max(Comparator.comparing(Computer::getOverallPerformance)).get();
        Computer computerPrice = collect.stream().max(Comparator.comparing(Computer::getPrice)).get();

        if (computerOverall.getClass().getSimpleName().equals(computerPrice.getClass().getSimpleName())) {
            Computer computer = computerPrice;

            this.listComputer.remove(computer);

            return computer.toString();
        }

        return null;
    }

    @Override
    public String getComputerData(int id) {
        Computer computer = this.listComputer.stream().filter(c -> c.getId() == id).findFirst().orElse(null);

        if (computer == null) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }

        return computer.toString();
    }
}
