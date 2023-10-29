package com.didem.stonescissorspaper.service;

import com.didem.stonescissorspaper.model.dto.ResponseDto;

public interface GameService {
    ResponseDto playGameAndSaveResult(String choice);
}
