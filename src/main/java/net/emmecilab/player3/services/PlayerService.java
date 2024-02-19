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
        Optional<PlayerModel> playerOptional = playerRepository.findById(id);
        if (playerOptional.isPresent()){
            return playerOptional.get();
        }
        return null;
    }

    public PlayerModel addPlayer(PlayerModel playerModel) { return playerRepository.save(playerModel);
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

    public PlayerModel edit(PlayerModel playerModel) { return playerRepository.save(playerModel); }
}
