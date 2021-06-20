package com.fcoach.booking;

import com.fcoach.player.Player;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@Entity
public class Booking {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private int court;

  @ManyToOne
  @JoinColumn(name = "player_id", nullable = false)
  private Player player;

  private OffsetDateTime startTime;

  private OffsetDateTime endTime;

}
