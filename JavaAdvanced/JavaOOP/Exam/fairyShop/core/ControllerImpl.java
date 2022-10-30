package fairyShop.core;

import fairyShop.common.ConstantMessages;
import fairyShop.common.ExceptionMessages;
import fairyShop.models.ClassAndChild.*;
import fairyShop.models.Helper;
import fairyShop.models.Instrument;
import fairyShop.models.Present;
import fairyShop.models.Shop;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ControllerImpl implements Controller {
    private final HelperRepository helperRepository;
    private final PresentRepository presentRepository;
    private int countDonePresent;

    public ControllerImpl() {
        this.helperRepository = new HelperRepository();
        this.presentRepository = new PresentRepository();
    }

    @Override
    public String addHelper(String type, String helperName) {
        Helper helper;

        if (type.equals("Happy")) {
            helper = new Happy(helperName);
        } else if (type.equals("Sleepy")) {
            helper = new Sleepy(helperName);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_TYPE_DOESNT_EXIST);
        }

        this.helperRepository.add(helper);

        return String.format(ConstantMessages.ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        Instrument instrument = new InstrumentImpl(power);
        Helper byName = this.helperRepository.findByName(helperName);

        if (!this.helperRepository.getModels().contains(byName)) {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
        }

        this.helperRepository.findByName(helperName).addInstrument(instrument);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName, energyRequired);

        this.presentRepository.add(present);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        List<Helper> helpersAbove50 = this.helperRepository.getModels().stream().filter(h -> h.getEnergy() > 50).toList();
        Shop shop = new ShopImpl();
        List<Instrument> instruments = new ArrayList<>();

        for (Helper helper : helpersAbove50) {
            shop.craft(presentRepository.findByName(presentName), helper);
            instruments.addAll(helper.getInstruments());
        }

        if (helpersAbove50.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.NO_HELPER_READY);
        }

        String done = "";

        if (String.valueOf(presentRepository.findByName(presentName).isDone()).equals("true")) {
            done = "done";
            countDonePresent++;
        }else if (String.valueOf(presentRepository.findByName(presentName).isDone()).equals("false")) {
            done = "not done";
        }

        long countBrokenInstruments = instruments.stream().filter(i -> i.getPower() == 0).count();

        String output = String.format(ConstantMessages.PRESENT_DONE + ConstantMessages.COUNT_BROKEN_INSTRUMENTS, presentName, done, countBrokenInstruments);

        return output.trim();

    }

    @Override
    public String report() {
        List<Instrument> instruments = new ArrayList<>();
        Collection<Helper> models = this.helperRepository.getModels();

        for (Helper helper : models) {
            instruments = helper.getInstruments();
            break;
        }

        long countInstruments = instruments.stream().filter(i -> i.getPower() > 0).count();

        StringBuilder output = new StringBuilder(String.format("%d presents are done!%n", countDonePresent));
        output.append("Helpers info:").append(System.lineSeparator());

        for (Helper helper : this.helperRepository.getModels()) {
            output.append("Name: ").append(helper.getName()).append(System.lineSeparator());
            output.append("Energy: ").append(helper.getEnergy()).append(System.lineSeparator());
            output.append("Instruments: ").append(countInstruments).append(System.lineSeparator());
        }

        return output.toString().trim();
    }
}
