package com.fcoach.repository;

import com.fcoach.player.Player;
import com.fcoach.player.PlayerRepository;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.validation.ConstraintViolationException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ActiveProfiles("inttest") // profile config in application-inttest.yaml
class PlayerRepositoryTest {

  @ClassRule
  // postgres version configured in application-inttest.yaml
  public static final PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres");

  @Autowired
  private PlayerRepository playerRepository;

  @BeforeClass
  public static void setup() {
    postgreSQLContainer.start();
  }

  @Test
  void testCreatePlayer() {
    long initialCount = playerRepository.count(); // flyway already put some data in the DB

    assertThat(initialCount).isPositive();
    playerRepository.save(new Player("Alexander Zverev", LocalDate.of(1997, Month.APRIL, 20)));
    List<Player> allPlayers = playerRepository.findAll();

    assertThat(allPlayers).hasSize((int) initialCount + 1);
  }

  @Test
  void testCreatePlayer_FailsWithoutName() {
    var player = new Player();
    player.setBirthday(LocalDate.of(1997, Month.APRIL, 20));
    Assertions.assertThrows(ConstraintViolationException.class, () -> playerRepository.save(player));
  }

}
