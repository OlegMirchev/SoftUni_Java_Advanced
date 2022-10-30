package fairyShop.models.ClassAndChild;

import fairyShop.models.Helper;
import fairyShop.models.Instrument;
import fairyShop.models.Present;
import fairyShop.models.Shop;

import java.util.List;

public class ShopImpl implements Shop {

    @Override
    public void craft(Present present, Helper helper) {

        // TODO: check this method!

//        List<Instrument> instruments = helper.getInstruments();
//
//        for (Instrument instrument : instruments) {
//            instrument.use();
//            helper.work();
//            present.getCrafted();
//
//
//            if (!present.isDone() || helper.canWork()) {
//                break;
//            }
//            if (instrument.isBroken()) {
//                break;
//            }
//        }

        while (helper.canWork()) {
            present.getCrafted();
            helper.work();

            List<Instrument> instruments = helper.getInstruments();
            Instrument instrument1 = helper.getInstruments().stream().filter(i -> i.getPower() > 0).findFirst().orElse(null);
            if (instrument1 == null) {
                return;
            }

            for (Instrument instrument : instruments) {
                instrument.use();
                if (present.isDone()) {
                    return;
                }
//                Instrument instrument1 = helper.getInstruments().stream().filter(i -> i.getPower() > 0).findFirst().orElse(null);
//                if (instrument.getPower() <= 0) {
//                    if (instrument1 == null) {
//                        return;
//                    }
                if (instrument.getPower() <= 0) {
                    helper.getInstruments().add(helper.getInstruments().size() - 1, instrument);
                    helper.getInstruments().remove(instrument);
                }
                break;
            }
        }
    }
}
