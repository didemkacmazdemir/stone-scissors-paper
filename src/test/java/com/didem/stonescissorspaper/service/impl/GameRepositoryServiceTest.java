package com.didem.stonescissorspaper.service.impl;

import com.didem.stonescissorspaper.exception.DatabaseRelatedException;
import com.didem.stonescissorspaper.model.entity.ResultEntity;
import com.didem.stonescissorspaper.repository.GameRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameRepositoryServiceTest {
    @Mock
    GameRepository gameRepository;

    @InjectMocks
    GameRepositoryServiceImpl gameRepositoryService;

    @Test
    void saveTestResult() {
        ResultEntity resultEntity = ResultEntity.builder().id(1L).winner("COMPUTER").build();

        when(gameRepository.save(resultEntity)).thenReturn(resultEntity);
        gameRepositoryService.saveResult(resultEntity);

        verify(gameRepository, times(1)).save(resultEntity);
    }

    @Test
    void throwException_WhenResultEntityIsNull() {
        String expected = "During database action an error occurred";

        Exception actual = assertThrows(DatabaseRelatedException.class, () ->
                gameRepositoryService.saveResult(null));

        verify(gameRepository, times(0)).save(null);
        assertEquals(actual.getMessage(), expected);
    }

}