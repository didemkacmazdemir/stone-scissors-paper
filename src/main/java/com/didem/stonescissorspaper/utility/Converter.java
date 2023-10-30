package com.didem.stonescissorspaper.utility;

import com.didem.stonescissorspaper.exception.ConversionException;
import com.didem.stonescissorspaper.model.dto.ResponseDto;
import com.didem.stonescissorspaper.model.entity.ResultEntity;
import com.didem.stonescissorspaper.model.enums.Choice;
import com.didem.stonescissorspaper.model.enums.Winner;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Converter {
    public static Choice convertPlayerChoiceToEnumAndUppercase(String choice) {
        try {
            return Optional.ofNullable(choice)
                    .map(String::toUpperCase)
                    .map(Choice::valueOf)
                    .orElse(null);
        } catch (IllegalArgumentException e) {
            throw new ConversionException(choice);
        }
    }

    public static ResultEntity convertWinnerToResultEntity(Winner winner) {
        return ResultEntity.builder()
                .winner(winner.toString())
                .build();
    }

    public static ResponseDto createResponseDto(String result, String computerChoice){
        return ResponseDto.builder()
                .result(result)
                .computerChoice(computerChoice)
                .build();
    }
}
