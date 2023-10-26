package com.didem.stonescissorspaper.controller;

import com.didem.stonescissorspaper.model.enums.Choice;
import com.didem.stonescissorspaper.service.GameService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/play")
@CrossOrigin(origins = "http://localhost:4200")
public class GameController {
    private final GameService gameService;

    @PostMapping("/game")
    @ResponseStatus(HttpStatus.OK)
    public String playGame(@Valid @RequestBody Choice choice) {
        log.info("Player selected: {}", choice.toString());
        return gameService.playGameAndSaveResult(choice);
    }

}

