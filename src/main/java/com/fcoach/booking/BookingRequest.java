package com.fcoach.booking;

import lombok.Data;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.OffsetDateTime;

@Data
public class BookingRequest {
  @NotNull
  private Long playerId;
  @Positive
  private int court;
  @Future
  private OffsetDateTime startTime;
}
