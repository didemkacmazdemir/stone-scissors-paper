package com.didem.stonescissorspaper.service.impl;

import com.didem.stonescissorspaper.exception.DatabaseRelatedError;
import com.didem.stonescissorspaper.model.entity.ResultEntity;
import com.didem.stonescissorspaper.repository.GameRepository;
import com.didem.stonescissorspaper.service.GameRepositoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameRepositoryServiceImpl implements GameRepositoryService {
    private final GameRepository gameRepository;
    @Override
    @Transactional
    public void saveResult(ResultEntity resultEntity) {
        Optional.ofNullable(resultEntity)
                .map(gameRepository::save)
                .orElseThrow(DatabaseRelatedError::new);
    }
}
