package fairyShop.repositories;

import fairyShop.models.Helper;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class HelperRepository implements Repository<Helper> {
    private Map<String ,Helper> helpers;

    public HelperRepository() {
        this.helpers = new LinkedHashMap<>();
    }

    @Override
    public Collection<Helper> getModels() {
        return Collections.unmodifiableCollection(this.helpers.values());
    }

    @Override
    public void add(Helper helper) {
        if (!this.helpers.containsKey(helper.getName())) {
            this.helpers.put(helper.getName(), helper);
        }
    }

    @Override
    public boolean remove(Helper helper) {
        return this.helpers.values().removeIf(h -> h.getName().equals(helper.getName()));

//        for (Helper h : helpers.values()) {
//            if (h.getName().equals(helper.getName())) {
//                this.helpers.remove(helper.getName());
//                return true;
//            }
//        }
//        return false;
    }

    @Override
    public Helper findByName(String name) {
        return this.helpers.get(name);
    }
}
