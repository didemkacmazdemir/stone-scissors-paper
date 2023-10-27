package com.didem.stonescissorspaper.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResponseDto {
    private String result;
    private String computerChoice;
}