package com.fcoach.player;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlayerService {

  private final PlayerRepository playerRepository;

  public PlayerService(PlayerRepository playerRepository) {
    this.playerRepository = playerRepository;
  }

  public Page<Player> findAllPaged(Pageable pageable) {
    return playerRepository.findAll(pageable);
  }

  public Page<Player> findAllAdults(Pageable pageable) {
    var since = LocalDate.now().minusYears(18);
    return playerRepository.findPlayerByBirthdayLessThanEqual(since, pageable);
  }

  public List<Player> findMaxAge(int age) {
    var since = LocalDate.now().minusYears(age);
    return playerRepository.findPlayersBornSince(since);
  }

  public Optional<Player> findById(Long id) {
    return playerRepository.findById(id);
  }

  public Player update(Player player, String name, LocalDate birthday) {
    player.setName(name);
    player.setBirthday(birthday);
    return player; // transaction will handle the commit
  }

  public List<Player> findByName(String name) {
    return playerRepository.findPlayerByName(name);
  }

  public Player createPlayer(String name, LocalDate birthday) {
    return playerRepository.save(new Player(name, birthday));
  }
}
