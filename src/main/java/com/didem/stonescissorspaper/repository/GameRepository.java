package com.didem.stonescissorspaper.repository;

import com.didem.stonescissorspaper.model.entity.ResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<ResultEntity, Long> {
}
