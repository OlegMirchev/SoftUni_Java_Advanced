package fairyShop.models.ClassAndChild;

import fairyShop.common.ExceptionMessages;
import fairyShop.models.Helper;
import fairyShop.models.Instrument;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseHelper implements Helper {
    private String name;
    private int energy;
    private List<Instrument> instruments;

    protected BaseHelper(String name, int energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.instruments = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.HELPER_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public void work() {
        this.energy -= 10;

        if (this.energy < 0) {
            this.energy = 0;
        }
    }

    @Override
    public void addInstrument(Instrument instrument) {
        this.instruments.add(instrument);
    }

    @Override
    public boolean canWork() {
        if (this.energy > 0) {
            return true;
        }

        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public List<Instrument> getInstruments() {
        return instruments;
    }
}
