package net.emmecilab.player3.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.emmecilab.player3.models.PlayerModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceMock {

    @Autowired
    PlayerService playerService;

    private List<PlayerModel> players = new ArrayList<>(Arrays.asList(new PlayerModel(Long.valueOf(1), "Francesco", "Totti", "Roma", "midfielder"),
            new PlayerModel(Long.valueOf(2), "Gonzalo", "Higuain", "Juventus", "forward"), new PlayerModel(Long.valueOf(3), "Mauro", "Icardi", "Inter", "forward")));

    public List<PlayerModel> getAllPlayers() {
        return players;
    }

    public PlayerModel getPlayer(Long id) {

        return players.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .get();
    }

    public void addPlayer(PlayerModel player) {
        players.add(player);
    }

    public void updatePlayer(Long id, PlayerModel player) {
        for (int i = 0; i < players.size(); i++) {
            PlayerModel p = players.get(i);
            if (p.getId() == id) {
                players.set(i, player);
            }
        }

    }

    public void deletePlayer(Long id) {
        players.removeIf(p -> p.getId() == id);

    }

}