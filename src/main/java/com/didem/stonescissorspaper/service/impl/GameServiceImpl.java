package com.didem.stonescissorspaper.service.impl;

import com.didem.stonescissorspaper.exception.ValueCanNotBeNull;
import com.didem.stonescissorspaper.model.dto.ResponseDto;
import com.didem.stonescissorspaper.model.enums.Choice;
import com.didem.stonescissorspaper.service.GameRepositoryService;
import com.didem.stonescissorspaper.service.GameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

import static com.didem.stonescissorspaper.utility.Converter.*;
import static com.didem.stonescissorspaper.utility.GameUtil.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    private static final int GAME_CHOICE_SIZE = 3;

    private final GameRepositoryService gameRepositoryService;

    @Override
    public ResponseDto playGameAndSaveResult(String playerChoice) {
        Optional.ofNullable(playerChoice)
                .orElseThrow(() -> new ValueCanNotBeNull("Player Choice"));

        var convertedPLayerChoice = convertPlayerChoiceToEnumAndUppercase(playerChoice);
        var computerChoice = generateRandomComputerChoice();
        var result = determineWinner(convertedPLayerChoice, computerChoice);

        gameRepositoryService.saveResult(convertWinnerToResultEntity(result));

        return createResponseDto(result.toString(), computerChoice.toString());
    }

    private Choice generateRandomComputerChoice(){
        int randomIndex = new Random().nextInt(GAME_CHOICE_SIZE);
        return choiceList.get(randomIndex);
    }

}
