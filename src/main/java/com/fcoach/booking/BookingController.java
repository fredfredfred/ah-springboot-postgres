package com.fcoach.booking;

import com.fcoach.player.PlayerNotFoundException;
import com.fcoach.player.PlayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/booking")
public class BookingController {

  private final BookingService bookingService;

  private final PlayerService playerService;

  public BookingController(BookingService bookingService, PlayerService playerService) {
    this.bookingService = bookingService;
    this.playerService = playerService;
  }


  @GetMapping(value = "", produces = {"application/json"})
  @ResponseBody
  public List<Booking> findAll() {
    return bookingService.findAll();
  }

  @GetMapping(value = "/{id}", produces = {"application/json"})
  @ResponseBody
  public Booking findById(@PathVariable Long id) {
    Optional<Booking> optional = bookingService.findById(id);
    return optional.orElseThrow(BookingNotFoundException::new);
  }

  @PostMapping(value = "", produces = {"application/json"})
  @ResponseBody
  public Booking create(@RequestBody BookingRequest bookingRequest) {
    var optPlayer = playerService.findById(bookingRequest.getPlayerId());
    var player = optPlayer.orElseThrow(PlayerNotFoundException::new);
    return bookingService.createOneHourBooking(player, bookingRequest.getCourt(), bookingRequest.getStartTime());
  }

}
