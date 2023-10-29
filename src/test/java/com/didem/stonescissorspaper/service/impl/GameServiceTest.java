package com.didem.stonescissorspaper.service.impl;

import com.didem.stonescissorspaper.exception.ValueCanNotBeNull;
import com.didem.stonescissorspaper.model.dto.ResponseDto;
import com.didem.stonescissorspaper.model.entity.ResultEntity;
import com.didem.stonescissorspaper.service.GameRepositoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameServiceTest {
    @InjectMocks
    GameServiceImpl gameService;

    @Mock
    GameRepositoryService gameRepositoryService;

    @Test
    void throwException_WhenPlayGameAndSaveResultWithNullPlayerChoice() {

        assertThrows(ValueCanNotBeNull.class, () ->
                gameService.playGameAndSaveResult(null));

        verify(gameRepositoryService, never()).saveResult(any(ResultEntity.class));
    }

    @Test
    void playGameAndSaveResultWithRandomChoices() {
        var playerChoice = "STONE";

        ResponseDto responseDto = gameService.playGameAndSaveResult(playerChoice);

        assertNotNull(responseDto);
        assertNotNull(responseDto.getResult());
        assertNotNull(responseDto.getComputerChoice());

        verify(gameRepositoryService, times(1)).saveResult(any(ResultEntity.class));
    }

}