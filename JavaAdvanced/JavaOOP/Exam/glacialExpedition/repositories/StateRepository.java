package glacialExpedition.repositories;

import glacialExpedition.models.states.State;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StateRepository implements Repository<State> {
    private Map<String ,State> states;

    public StateRepository() {
        this.states = new LinkedHashMap<>();
    }

    @Override
    public Collection<State> getCollection() {
        return Collections.unmodifiableCollection(this.states.values());
    }

    @Override
    public void add(State state) {
        this.states.putIfAbsent(state.getName(), state);
    }

    @Override
    public boolean remove(State state) {
        return this.states.values().removeIf(s -> s.getName().equals(state.getName()));
    }

    @Override
    public State byName(String name) {
        return this.states.values().stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
    }
}
