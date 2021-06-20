CREATE UNIQUE INDEX booking__uidx__prevent_overbooking
    ON booking (court, start_time);
