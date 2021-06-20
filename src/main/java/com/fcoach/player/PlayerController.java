package com.fcoach.player;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/players")
public class PlayerController {

  private final PlayerService playerService;

  public PlayerController(PlayerService playerService) {
    this.playerService = playerService;
  }


  @GetMapping(value = "", produces = {"application/json"})
  @ResponseBody
  public Page<Player> findAll(Pageable pageable) {
    return playerService.findAllPaged(pageable);
  }

  @GetMapping(value = "/adults", produces = {"application/json"})
  @ResponseBody
  public Page<Player> findAdults(Pageable pageable) {
    return playerService.findAllAdults(pageable);
  }

  @GetMapping(value = "/age", produces = {"application/json"})
  @ResponseBody
  public List<Player> findAge(@RequestParam Integer ageParam) {
    int age = ageParam == null ? 18 : ageParam;
    return playerService.findMinAge(age);
  }


  @GetMapping(value = "/{id}", produces = {"application/json"})
  @ResponseBody
  public Player findById(@PathVariable Long id) {
    Optional<Player> optional = playerService.findById(id);
    return optional.orElseThrow(PlayerNotFoundException::new);
  }

  @PutMapping(value = "/{id}", produces = {"application/json"})
  @ResponseBody
  public Player update(@PathVariable Long id, @RequestBody PlayerRequest playerRequest) {
    var optional = playerService.findById(id);
    return optional.map(player -> playerService.update(player, playerRequest.getName(), playerRequest.getBirthday()))
      .orElseThrow(PlayerNotFoundException::new);

  }

  @PostMapping(value = "", produces = {"application/json"})
  @ResponseBody
  public Player create(@RequestBody PlayerRequest playerRequest) {
    var existingPlayers = playerService.findByName(playerRequest.getName());
    if (existingPlayers.isEmpty()) {
      return playerService.createPlayer(playerRequest.getName(), playerRequest.getBirthday());
    } else {
      throw new PlayerNameTakenException(String.format("name %s already exists", playerRequest.getName()));
    }

  }
}
