package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;
import glacialExpedition.models.suitcases.Carton;
import glacialExpedition.models.suitcases.Suitcase;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MissionImpl implements Mission {

    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        List<String> exhibits = state.getExhibits().stream().collect(Collectors.toList());
        Suitcase suitcase = new Carton();

        for (Explorer explorer : explorers) {
            while (explorer.canSearch()) {

                if (exhibits.isEmpty()) {
                    return;
                }

                String exhibit = exhibits.get(0);
                explorer.search();
                suitcase.getExhibits().add(exhibit);
                explorer.getSuitcase().getExhibits().add(exhibit);
                exhibits.remove(0);
                state.getExhibits().remove(exhibit);

                if (explorer.getEnergy() <= 0) {
                    break;
                }
            }
        }
    }
}
