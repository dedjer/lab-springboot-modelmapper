package com.example.controller;

import com.example.dto.PlayerDTO;
import com.example.model.Player;
import com.example.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @GetMapping("/players")
    public ResponseEntity<List<Player>> getAllPlayers() {
        try
        {
            List<Player> list = playerService.getPlayers();

            if (list.isEmpty() || list.size() == 0)
            {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/players/dto/{id}")
    public ResponseEntity<PlayerDTO> getPlayerDTO(@PathVariable int id) {
        PlayerDTO playerDTO = playerService.getPlayerDTO(id);

        if (playerDTO != null)
        {
            return new ResponseEntity<PlayerDTO>(playerDTO, HttpStatus.OK);
        }

        return new ResponseEntity<PlayerDTO>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/players/dto/mapper/{id}")
    public ResponseEntity<PlayerDTO> getPlayerDTOWithMapper(@PathVariable int id) {
        PlayerDTO playerDTO = playerService.getPlayerDTOWithMapper(id);

        if (playerDTO != null)
        {
            return new ResponseEntity<PlayerDTO>(playerDTO, HttpStatus.OK);
        }

        return new ResponseEntity<PlayerDTO>(HttpStatus.NOT_FOUND);
    }
}
