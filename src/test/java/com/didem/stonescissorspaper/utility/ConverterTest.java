package com.didem.stonescissorspaper.utility;

import com.didem.stonescissorspaper.exception.ConversationException;
import com.didem.stonescissorspaper.model.enums.Choice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {
    @Test
    void throwException_WhenClientChoiceConverterWithInvalidChoice() {
        String expectedValue = "invalid_choice";
        String expectedMessage = "String to enum conversation error with value: " + expectedValue;
        Exception actualMessage = assertThrows(ConversationException.class, () ->
                Converter.clientChoiceConverter(expectedValue));

        assertNotNull(actualMessage);
        assertEquals(actualMessage.getMessage(), expectedMessage);
    }

    @ParameterizedTest
    @CsvSource({
            "STONE, stOne",
            "SCISSORS, sciSSors",
            "PAPER, papeR"
    })
    void convertChoiceToUpperCase_WhenValidChoiceSelected(Choice expectedChoice, String inputChoice) {
        Choice actualChoice = Converter.clientChoiceConverter(inputChoice);

        assertEquals(actualChoice, expectedChoice);
    }


}