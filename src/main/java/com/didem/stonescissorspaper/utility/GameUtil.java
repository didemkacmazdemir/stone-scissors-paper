package com.didem.stonescissorspaper.utility;

import com.didem.stonescissorspaper.exception.ChoiceCanNotBeNull;
import com.didem.stonescissorspaper.model.enums.Choice;
import com.didem.stonescissorspaper.model.enums.Winner;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.*;

import static com.didem.stonescissorspaper.model.enums.Choice.*;
import static com.didem.stonescissorspaper.model.enums.Winner.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GameUtil {
    public static final List<Choice> choiceList = Arrays.asList(PAPER, STONE, SCISSORS);

    private static final Map<Choice, Choice> winnerMap = new HashMap<>();

    static {
        winnerMap.put(STONE, SCISSORS);
        winnerMap.put(PAPER, STONE);
        winnerMap.put(SCISSORS, PAPER);
    }

    public static Winner determineWinner(Choice player, Choice computer) {

        if (Objects.isNull(player) || Objects.isNull(computer)) throw new ChoiceCanNotBeNull();

        return Objects.equals(player, computer)
                ? TIE
                : Optional.ofNullable(winnerMap.get(player))
                        .filter(winner -> winner.equals(player))
                        .map(winner -> CLIENT)
                        .orElse(COMPUTER);
    }

}
