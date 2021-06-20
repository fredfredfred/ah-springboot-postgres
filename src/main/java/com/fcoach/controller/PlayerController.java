package com.fcoach.controller;

import com.fcoach.model.Player;
import com.fcoach.service.PlayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/players")
public class PlayerController {

  private final PlayerService playerService;

  public PlayerController(PlayerService playerService) {
    this.playerService = playerService;
  }

  @GetMapping(value = "", produces = {"application/json"})
  public @ResponseBody
  List<Player> findAll() {
    return playerService.findAll();
  }

}
