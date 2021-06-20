package com.fcoach.booking;

import com.fcoach.player.Player;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingService {

  private final BookingRepository bookingRepository;


  public BookingService(BookingRepository bookingRepository) {
    this.bookingRepository = bookingRepository;
  }

  public List<Booking> findAll() {
    return bookingRepository.findAll();
  }

  public Optional<Booking> findById(Long id) {
    return bookingRepository.findById(id);
  }

  public Booking createOneHourBooking(Player player, int court, OffsetDateTime startTime) {
    var booking = new Booking();
    booking.setCourt(court);
    booking.setPlayer(player);
    booking.setStartTime(startTime);
    booking.setEndTime(startTime.plusHours(1));
    return bookingRepository.save(booking);
  }

  public void delete(Booking booking) {
    bookingRepository.delete(booking);
  }
}
