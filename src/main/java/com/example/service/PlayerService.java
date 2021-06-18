package com.example.service;

import com.example.dto.PlayerDTO;
import com.example.model.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService
{
    public List<Player> getPlayers();

    public Optional<Player> getPlayer(int id);

    public void delete(int id);

    public Player addPlayer(Player player);

    public PlayerDTO getPlayerDTO(int id);

    public PlayerDTO getPlayerDTOWithMapper(int id);

}

