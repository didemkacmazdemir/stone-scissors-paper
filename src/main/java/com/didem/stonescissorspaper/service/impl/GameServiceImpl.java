package com.didem.stonescissorspaper.service.impl;

import com.didem.stonescissorspaper.model.entity.ResultEntity;
import com.didem.stonescissorspaper.model.enums.Choice;
import com.didem.stonescissorspaper.model.enums.Winner;
import com.didem.stonescissorspaper.repository.GameRepository;
import com.didem.stonescissorspaper.service.GameRepositoryService;
import com.didem.stonescissorspaper.service.GameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;

import static com.didem.stonescissorspaper.utility.GameUtil.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    private static final int GAME_CHOICE_SIZE = 3;

    private final GameRepositoryService gameRepositoryService;

    @Override
    public String playGameAndSaveResult(Choice playerChoice) {
        var computerChoice = choiceList.get(new Random().nextInt(GAME_CHOICE_SIZE));
        log.info("Computer has chosen: {}", computerChoice.toString());

        var result = determineWinner(playerChoice, computerChoice);
        log.info("The result is: {}", result);

        gameRepositoryService.saveResult(createResultEntity(result));

        return result.toString();
    }

    private ResultEntity createResultEntity(Winner winner) {
        return ResultEntity.builder()
                .winner(winner.toString())
                .build();
    }

}
