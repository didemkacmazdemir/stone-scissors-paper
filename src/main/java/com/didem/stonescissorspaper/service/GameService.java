package com.didem.stonescissorspaper.service;

import com.didem.stonescissorspaper.model.dto.ResponseDto;
import com.didem.stonescissorspaper.model.enums.Choice;

public interface GameService {
    ResponseDto playGameAndSaveResult(Choice choice);
}
