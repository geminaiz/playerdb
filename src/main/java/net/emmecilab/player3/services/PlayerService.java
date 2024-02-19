package net.emmecilab.player3.services;

import net.emmecilab.player3.repositories.PlayerRepository;
import java.util.List;
import java.util.Optional;
import net.emmecilab.player3.models.PlayerModel;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<PlayerModel> getAllPlayers() {
        return playerRepository.findAll();
    }

    public PlayerModel getPlayer(Long id) {
        Optional<PlayerModel> player = this.playerRepository.findById(id);
        if (player.isPresent()) {
            return player.get();
        } else {
            return null;
        }
    }

    public void addPlayer(PlayerModel player) {
        playerRepository.save(player);
    }


    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

    public PlayerModel edit(PlayerModel playerModel) {
        return playerRepository.save(playerModel);
    }
}
