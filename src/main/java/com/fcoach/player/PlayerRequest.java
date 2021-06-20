package com.fcoach.player;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PlayerRequest {
  private String name;
  private LocalDate birthday;
}
