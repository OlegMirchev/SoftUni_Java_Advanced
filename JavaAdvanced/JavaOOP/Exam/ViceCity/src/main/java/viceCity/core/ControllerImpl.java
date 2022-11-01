package JavaAdvanced2021.JavaOPP.Exam.ViceCity.src.main.java.viceCity.core;

import JavaAdvanced2021.JavaOPP.Exam.ViceCity.src.main.java.viceCity.common.ConstantMessages;
import JavaAdvanced2021.JavaOPP.Exam.ViceCity.src.main.java.viceCity.core.interfaces.Controller;
import JavaAdvanced2021.JavaOPP.Exam.ViceCity.src.main.java.viceCity.models.guns.Gun;
import JavaAdvanced2021.JavaOPP.Exam.ViceCity.src.main.java.viceCity.models.guns.Pistol;
import JavaAdvanced2021.JavaOPP.Exam.ViceCity.src.main.java.viceCity.models.guns.Rifle;
import JavaAdvanced2021.JavaOPP.Exam.ViceCity.src.main.java.viceCity.models.neighbourhood.GangNeighbourhood;
import JavaAdvanced2021.JavaOPP.Exam.ViceCity.src.main.java.viceCity.models.neighbourhood.Neighbourhood;
import JavaAdvanced2021.JavaOPP.Exam.ViceCity.src.main.java.viceCity.models.players.CivilPlayer;
import JavaAdvanced2021.JavaOPP.Exam.ViceCity.src.main.java.viceCity.models.players.MainPlayer;
import JavaAdvanced2021.JavaOPP.Exam.ViceCity.src.main.java.viceCity.models.players.Player;

import java.util.*;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private Player mainPlayer;
    private Map<String, Player> mapPlayer;
    private Deque<Gun> mapGun;
    private Neighbourhood neighbourhood;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.mapPlayer = new LinkedHashMap<>();
        this.mapGun = new ArrayDeque<>();
        this.neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        mapPlayer.put(name, new CivilPlayer(name));
        return String.format(ConstantMessages.PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;
        switch (type) {
            case "Pistol":
                gun = new Pistol(name);
                break;
            case "Rifle":
                gun = new Rifle(name);
                break;
            default:
                return ConstantMessages.GUN_TYPE_INVALID;
        }
        mapGun.offer(gun);

        return String.format(ConstantMessages.GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        Gun gun = mapGun.poll();
        if (gun == null) {
            return ConstantMessages.GUN_QUEUE_IS_EMPTY;
        }
        if (name.equals("Vercetti")) {
            mainPlayer.getGunRepository().add(gun);
            return String.format(ConstantMessages.GUN_ADDED_TO_MAIN_PLAYER,
                    gun.getName(), mainPlayer.getName());
        }
        Player player = mapPlayer.get(name);
        if (player == null) {
            return ConstantMessages.CIVIL_PLAYER_DOES_NOT_EXIST;
        }
        player.getGunRepository().add(gun);

        return String.format(ConstantMessages.GUN_ADDED_TO_CIVIL_PLAYER,
                gun.getName(), player.getName());
    }

    @Override
    public String fight() {
        neighbourhood.action(mainPlayer, mapPlayer.values());
       if (mainPlayer.getLifePoints() == 100 &&
               mapPlayer.values().stream().allMatch(p -> p.getLifePoints() == 50)) {
           return ConstantMessages.FIGHT_HOT_HAPPENED;
       }
       List<Player> deadPlayers = mapPlayer.values().stream().filter(p -> !p.isAlive()).collect(Collectors.toList());

       StringBuilder output = new StringBuilder(ConstantMessages.FIGHT_HAPPENED);
       output.append(System.lineSeparator())
               .append(String.format(ConstantMessages.MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints()))
               .append(System.lineSeparator())
               .append(String.format(ConstantMessages.MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, deadPlayers.size()))
               .append(System.lineSeparator())
               .append(String.format(ConstantMessages.CIVIL_PLAYERS_LEFT_MESSAGE, mapPlayer.size() - deadPlayers.size()));

        for (Player dp : deadPlayers) {
            mapPlayer.remove(dp.getName());
        }

       return output.toString().trim();
    }
}
