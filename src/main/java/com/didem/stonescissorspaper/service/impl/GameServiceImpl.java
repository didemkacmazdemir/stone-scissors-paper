package com.didem.stonescissorspaper.service.impl;

import com.didem.stonescissorspaper.exception.ValueCanNotBeNull;
import com.didem.stonescissorspaper.model.dto.ResponseDto;
import com.didem.stonescissorspaper.model.enums.Choice;
import com.didem.stonescissorspaper.service.GameRepositoryService;
import com.didem.stonescissorspaper.service.GameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Random;

import static com.didem.stonescissorspaper.utility.Converter.createResponseDto;
import static com.didem.stonescissorspaper.utility.Converter.createResultEntity;
import static com.didem.stonescissorspaper.utility.GameUtil.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    private static final int GAME_CHOICE_SIZE = 3;

    private final GameRepositoryService gameRepositoryService;

    @Override
    public ResponseDto playGameAndSaveResult(Choice playerChoice) {
        if(Objects.isNull(playerChoice)){
            throw new ValueCanNotBeNull("Player Choice");
        }

        int randomIndex = new Random().nextInt(GAME_CHOICE_SIZE);

        var computerChoice = choiceList.get(randomIndex);
        var result = determineWinner(playerChoice, computerChoice);

        gameRepositoryService.saveResult(createResultEntity(result));
        return createResponseDto(result.toString(), computerChoice.toString());
    }

}
