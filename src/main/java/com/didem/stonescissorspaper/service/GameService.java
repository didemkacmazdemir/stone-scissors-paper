package com.didem.stonescissorspaper.service;

import com.didem.stonescissorspaper.model.enums.Choice;

public interface GameService {
    String playGameAndSaveResult(Choice choice);
}
