package com.fcoach.player;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "player not found")
public class PlayerNotFoundException extends RuntimeException {
}
