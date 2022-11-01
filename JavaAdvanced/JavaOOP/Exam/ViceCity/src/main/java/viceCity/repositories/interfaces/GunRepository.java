package JavaAdvanced2021.JavaOPP.Exam.ViceCity.src.main.java.viceCity.repositories.interfaces;

import JavaAdvanced2021.JavaOPP.Exam.ViceCity.src.main.java.viceCity.models.guns.Gun;

import java.util.*;

public class GunRepository implements Repository<Gun> {
    private Map<String, Gun> models;

    public GunRepository() {
        this.models = new LinkedHashMap<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableCollection(models.values());
    }

    @Override
    public void add(Gun model) {
        models.putIfAbsent(model.getName(), model);
    }

    @Override
    public boolean remove(Gun model) {
        Gun removeGun = models.remove(model.getName());
        return removeGun != null;
    }

    @Override
    public Gun find(String name) {
        return models.get(name);
    }
}
