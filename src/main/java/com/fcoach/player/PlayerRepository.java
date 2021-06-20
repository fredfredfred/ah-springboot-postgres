package com.fcoach.player;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

  List<Player> findPlayerByName(String name);

  @Query("select p from Player p where p.birthday >= :sinceDate")
  List<Player> findPlayersBornSince(@Param("sinceDate") LocalDate since);

  Page<Player> findPlayerByBirthdayLessThanEqual(LocalDate since, Pageable pageable);

}
