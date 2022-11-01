package JavaAdvanced2021.JavaOPP.Exam.ViceCity.src.main.java.viceCity.models.neighbourhood;

import JavaAdvanced2021.JavaOPP.Exam.ViceCity.src.main.java.viceCity.models.guns.Gun;
import JavaAdvanced2021.JavaOPP.Exam.ViceCity.src.main.java.viceCity.models.players.Player;
import JavaAdvanced2021.JavaOPP.Exam.ViceCity.src.main.java.viceCity.repositories.interfaces.Repository;

import java.util.ArrayDeque;
import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood {

    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        Repository<Gun> gunRepository = mainPlayer.getGunRepository();
        ArrayDeque<Player> players = new ArrayDeque<>(civilPlayers);
        ArrayDeque<Gun> guns = new ArrayDeque<>(gunRepository.getModels());
        Player player = players.poll();
        Gun gun = guns.poll();

        while (player != null && gun != null) {
            while (gun.canFire() && player.isAlive()) {
                int fire = gun.fire();
                player.takeLifePoints(fire);
            }
            if (gun.canFire()) {
                player = players.poll();
            }else if (player.isAlive()) {
                gun = guns.poll();
            }
        }
        for (Player civilPlayer : civilPlayers) {
            if (civilPlayer.isAlive()) {
                ArrayDeque<Gun> playerGuns = new ArrayDeque<>(civilPlayer.getGunRepository().getModels());
                Gun gunPlayer = playerGuns.poll();

                while (gunPlayer != null) {
                    while (gunPlayer.canFire() && mainPlayer.isAlive()) {
                        int fire = gunPlayer.fire();
                        mainPlayer.takeLifePoints(fire);
                    }
                    if (!mainPlayer.isAlive()) {
                        return;
                    }
                    gunPlayer = playerGuns.poll();
                }
            }
        }
    }
}
