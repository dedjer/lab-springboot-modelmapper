package com.example.service.impl;

import com.example.dto.PlayerDTO;
import com.example.model.Player;
import com.example.repository.PlayerRepository;
import com.example.service.PlayerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService
{
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Player addPlayer(Player player)
    {
        return playerRepository.save(player);
    }

    @Override
    public List<Player> getPlayers()
    {
        return playerRepository.findAll();
    }

    @Override
    public Optional<Player> getPlayer(int id)
    {
        return playerRepository.findById(id);
    }

    @Override
    public void delete(int id)
    {
        if (getPlayer(id).isPresent())
        {
            playerRepository.delete((Player) getPlayer(id).get());
        }
    }

    @Override
    public PlayerDTO getPlayerDTO(int id) {

        PlayerDTO playerDTO = new PlayerDTO();

        playerDTO.setEmail(playerRepository.findById(id).get().getEmail());

        return playerDTO;
    }

    @Override
    public PlayerDTO getPlayerDTOWithMapper(int id) {

        Optional<Player> player = playerRepository.findById(id);

        PlayerDTO playerDTO = modelMapper.map(player.get(), PlayerDTO.class);

        return playerDTO;

    }
}

