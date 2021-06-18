package com.example;

import com.example.dto.PlayerDTO;
import com.example.model.Player;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ApplicationTests {

    private ModelMapper modelMapper = new ModelMapper();

    @Test
    public void whenConvertPlayerToPlayerDTO_thenCorrect(){
        Player player = new Player();
        player.setEmail("test@test.com");

        PlayerDTO playerDTO = modelMapper.map(player, PlayerDTO.class);
        assertEquals(playerDTO.getEmail(), player.getEmail());
    }

    @Test
    public void whenConvertOptionalPlayerToPlayerDTO_thenCorrect(){
        Player player = new Player();
        player.setEmail("test@test.com");

        Optional<Player> optPlayer = Optional.of(player);;

        PlayerDTO playerDTO = modelMapper.map(optPlayer.get(), PlayerDTO.class);
        assertEquals(playerDTO.getEmail(), optPlayer.get().getEmail());
    }
}
