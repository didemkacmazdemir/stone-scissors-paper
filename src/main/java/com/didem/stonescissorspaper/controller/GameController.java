package com.didem.stonescissorspaper.controller;

import com.didem.stonescissorspaper.model.dto.ResponseDto;
import com.didem.stonescissorspaper.service.GameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/play")
@CrossOrigin(origins = "${cors.allowed-origins}")
public class GameController {
    private final GameService gameService;
    @GetMapping("/game/{choice}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto playGameAndSaveResult(@PathVariable String choice) {
        log.info("Player selected: {}", choice);
        return gameService.playGameAndSaveResult(choice);
    }

}

