package com.didem.stonescissorspaper.utility;

import com.didem.stonescissorspaper.exception.ValueCanNotBeNull;
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

    public static Winner determineWinner(Choice client, Choice computer) {

        if (Objects.isNull(client) || Objects.isNull(computer)) throw new ValueCanNotBeNull("Client or Player Choice is missing");

        return Objects.equals(client, computer)
                ? TIE
                : Optional.ofNullable(winnerMap.get(client))
                    .filter(c -> c.equals(computer))
                    .map(winner -> CLIENT)
                    .orElse(COMPUTER);
    }

}
