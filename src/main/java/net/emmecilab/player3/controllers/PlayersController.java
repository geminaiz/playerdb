package net.emmecilab.player3.controllers;

import java.util.List;
import java.util.Optional;

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
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/getAllPlayers")
    public ResponseEntity<?> getAllPlayers() {
        List<PlayerModel> playerModelList = playerService.getAllPlayers();
        if(!playerModelList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(playerModelList);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("/findPlayer}")
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<?> getPlayer(@RequestParam Long id) {
        if (id != null){
            PlayerModel playerModel = playerService.getPlayer(id);
            return ResponseEntity.status(HttpStatus.OK).body(playerModel);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping("/addPlayer")
    public ResponseEntity<?> addPlayer(@RequestBody PlayerModel player) {
        PlayerModel playerModel = playerService.addPlayer(player); // prima fa le operazioni di destra dopo salva il risultato in quello di sinistra rispetto "="
        if(playerModel != null) {
            return ResponseEntity.status(HttpStatus.OK).body(player);
        }
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @PutMapping(value = "/edit", produces = "application/json")
    public ResponseEntity<?> editUser(@RequestBody PlayerModel playerModel){
        if(playerModel != null) {
            PlayerModel userEdit = playerService.edit(playerModel);
            return ResponseEntity.status(HttpStatus.OK).body(userEdit);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }


    @CrossOrigin(origins = "*", maxAge = 3600)
    @DeleteMapping ("/delete")
    public ResponseEntity<?> deletePlayer(@RequestParam Long id) {
        if(id > 0){
            playerService.deletePlayer(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
}