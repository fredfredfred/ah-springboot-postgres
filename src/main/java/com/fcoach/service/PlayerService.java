package com.fcoach.service;

import com.fcoach.model.Player;
import com.fcoach.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

  private final PlayerRepository playerRepository;

  public PlayerService(PlayerRepository playerRepository) {
    this.playerRepository = playerRepository;
  }

  public List<Player> findAll() {
    return playerRepository.findAll();
  }
}
