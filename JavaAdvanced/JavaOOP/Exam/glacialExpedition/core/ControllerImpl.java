package glacialExpedition.core;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.StateRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private ExplorerRepository explorerRepository;
    private StateRepository stateRepository;
    private long countRetireExplorers;

    public ControllerImpl() {
        this.explorerRepository = new ExplorerRepository();
        this.stateRepository = new StateRepository();
        this.countRetireExplorers = 0;
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer = null;

        if (type.equals("AnimalExplorer")) {
            explorer = new AnimalExplorer(explorerName);
        } else if (type.equals("GlacierExplorer")) {
            explorer = new GlacierExplorer(explorerName);
        } else if (type.equals("NaturalExplorer")) {
            explorer = new NaturalExplorer(explorerName);
        }

        if (explorer == null) {
            throw new IllegalArgumentException(ExceptionMessages.EXPLORER_INVALID_TYPE);
        }

        this.explorerRepository.add(explorer);

        return String.format(ConstantMessages.EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
        state.getExhibits().addAll(List.of(exhibits));

        this.stateRepository.add(state);

        return String.format(ConstantMessages.STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer byNameExplorer = this.explorerRepository.byName(explorerName);
        boolean isRemove = false;
//        boolean isRemove = this.explorerRepository.getCollection().removeIf(exp -> exp.getName().equals(explorerName));
//
//        if (!isRemove) {
//            throw new IllegalArgumentException(String.format(ExceptionMessages.EXPLORER_DOES_NOT_EXIST, explorerName));
//        }

        for (Explorer explorer : this.explorerRepository.getCollection()) {
            if (explorer.getName().equals(explorerName)) {
                this.explorerRepository.remove(byNameExplorer);
                this.countRetireExplorers++;
                isRemove = true;
                break;
            }
        }

        if (!isRemove) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXPLORER_DOES_NOT_EXIST, explorerName));
        }

        return String.format(ConstantMessages.EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        State state = this.stateRepository.byName(stateName);
        Mission mission = new MissionImpl();

        List<Explorer> explorersAbove50 = this.explorerRepository.getCollection().stream().filter(exp -> exp.getEnergy() > 50).collect(Collectors.toList());

        if (explorersAbove50.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.STATE_EXPLORERS_DOES_NOT_EXISTS);
        }

        List<State> stateListEmpty = this.stateRepository.getCollection().stream().filter(s -> s.getExhibits().isEmpty()).collect(Collectors.toList());

        for (State emptyState : stateListEmpty) {
            this.stateRepository.remove(emptyState);
        }

        mission.explore(state, explorersAbove50);
        long count = this.explorerRepository.getCollection().stream().filter(exp -> exp.getEnergy() <= 0).count();
        this.countRetireExplorers = count;

        return String.format(ConstantMessages.STATE_EXPLORER, state.getName(), this.countRetireExplorers);
    }

    @Override
    public String finalResult() {
        long exploredStatesCount = this.stateRepository.getCollection().stream().filter(s -> s.getExhibits().isEmpty()).count();

        StringBuilder output = new StringBuilder(String.format(ConstantMessages.FINAL_STATE_EXPLORED, exploredStatesCount)).append(System.lineSeparator());
        output.append(ConstantMessages.FINAL_EXPLORER_INFO).append(System.lineSeparator());

        for (Explorer explorer : this.explorerRepository.getCollection()) {
            output.append(String.format(ConstantMessages.FINAL_EXPLORER_NAME, explorer.getName())).append(System.lineSeparator());
            output.append(String.format(ConstantMessages.FINAL_EXPLORER_ENERGY, explorer.getEnergy())).append(System.lineSeparator());

            if (explorer.getSuitcase().getExhibits().isEmpty()) {
                output.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS, "None")).append(System.lineSeparator());
            } else {
                String leftExhibits = explorer.getSuitcase().getExhibits().stream().collect(Collectors.joining(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER));
                output.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS, leftExhibits)).append(System.lineSeparator());
            }
        }

        return output.toString().trim();
    }
}
