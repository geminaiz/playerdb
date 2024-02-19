package net.emmecilab.player3.repositories;

import net.emmecilab.player3.models.PlayerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mauro Cicolella
 */
@Repository
public interface PlayerRepository extends JpaRepository<PlayerModel, Long> {

}
