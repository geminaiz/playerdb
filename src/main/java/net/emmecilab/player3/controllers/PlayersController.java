package net.emmecilab.player3.controllers;

import java.util.List;
import net.emmecilab.player3.models.PlayerModel;
import net.emmecilab.player3.services.PlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/players") //v1 = version1
public class PlayersController {

    @Autowired
    private PlayerService playerService;

    //TODO: refatoring of all mappingß
    @GetMapping("/players")
    public List<PlayerModel> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/players/{id}")
    public PlayerModel getPlayer(@PathVariable Long id) {
        return playerService.getPlayer(id);
    }

    @PostMapping("/players")
    //Alternative
    //@RequestMapping(value = "/players", method = RequestMethod.POST)
    public void addPlayer(@RequestBody PlayerModel player) {
        playerService.addPlayer(player);
    }

   // @RequestMapping(value = "/players/{id}", method = RequestMethod.PUT)
    //public void updatePlayer(@PathVariable Long id, @RequestBody Player player) {
      //  playerService.updatePlayer(id, player);
    //}


    @CrossOrigin(origins = "*", maxAge = 3600)
    @PutMapping(value = "/edit", produces = "application/json")
    public ResponseEntity<?> editUser(@RequestBody PlayerModel playerModel){
        if(playerModel != null) {
            PlayerModel userEdit = playerService.edit(playerModel);
            return ResponseEntity.status(HttpStatus.OK).body(userEdit);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }



    @RequestMapping(value = "/players/{id}", method = RequestMethod.DELETE)
    public void deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
    }
}