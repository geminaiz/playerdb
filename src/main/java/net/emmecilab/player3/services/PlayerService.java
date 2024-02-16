package net.emmecilab.player3.services;

import java.util.List;
import net.emmecilab.player3.models.Player;

/**
 *
 * @author Mauro Cicolella
 */
public interface PlayerService {

    public List<Player> getAllPlayers();

    public Player getPlayer(Long id);

    public void addPlayer(Player player);

    public void updatePlayer(Long id, Player player);

    public void deletePlayer(Long id);

}