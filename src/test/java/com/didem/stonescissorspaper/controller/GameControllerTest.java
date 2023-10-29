package com.didem.stonescissorspaper.controller;

import com.didem.stonescissorspaper.model.dto.ResponseDto;
import com.didem.stonescissorspaper.service.impl.GameServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GameController.class)
class GameControllerTest {

    private static final String PLAY_GAME_ENDPOINT = "/api/v1/play/game/";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameServiceImpl gameService;

    @Test
    void playGameAndSaveResult_AsClient() throws Exception {
        var playerChoice = "STONE";
        var actualResult = "TIE";
        var actualComputerChoice = "STONE";
        var expectedResult = "TIE";
        var expectedComputerChoice = "STONE";

        ResponseDto responseDto = ResponseDto.builder().result(actualResult).computerChoice(actualComputerChoice).build();

        when(gameService.playGameAndSaveResult(playerChoice)).thenReturn(responseDto);

        mockMvc.perform(get( PLAY_GAME_ENDPOINT + playerChoice))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(expectedResult))
                .andExpect(jsonPath("$.computerChoice").value(expectedComputerChoice));
    }
}
