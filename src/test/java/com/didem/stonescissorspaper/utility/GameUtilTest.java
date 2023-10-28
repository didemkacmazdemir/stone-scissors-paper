package com.didem.stonescissorspaper.utility;

import com.didem.stonescissorspaper.exception.ValueCanNotBeNull;
import org.junit.jupiter.api.Test;

import static com.didem.stonescissorspaper.model.enums.Choice.*;
import static com.didem.stonescissorspaper.model.enums.Winner.*;
import static com.didem.stonescissorspaper.utility.GameUtil.determineWinner;
import static org.junit.jupiter.api.Assertions.*;

class GameUtilTest {
    @Test
    void determineWinner_WhenClientWins() {
        assertEquals(CLIENT, determineWinner(PAPER, STONE));
        assertEquals(CLIENT, determineWinner(STONE, SCISSORS));
        assertEquals(CLIENT, determineWinner(SCISSORS, PAPER));
    }

    @Test
    void determineWinner_WhenComputerWins() {
        assertEquals(COMPUTER, determineWinner(STONE, PAPER));
        assertEquals(COMPUTER, determineWinner(SCISSORS, STONE));
        assertEquals(COMPUTER, determineWinner(PAPER, SCISSORS));
    }

    @Test
    void determine_WhenTie() {
        assertEquals(TIE, determineWinner(STONE, STONE));
        assertEquals(TIE, determineWinner(PAPER, PAPER));
        assertEquals(TIE, determineWinner(SCISSORS, SCISSORS));
    }

    @Test
    void throwException_WhenNullInputs() {
        String expectedMessage = "Value can not be null Client or Player Choice is missing";

        Exception actualMessageForClient = assertThrows(ValueCanNotBeNull.class, () ->
                determineWinner(null, STONE));

        Exception actualMessageForComputer = assertThrows(ValueCanNotBeNull.class, () ->
                determineWinner(STONE, null));

        assertEquals(actualMessageForClient.getMessage(), expectedMessage);
        assertEquals(actualMessageForComputer.getMessage(), expectedMessage);

    }
}