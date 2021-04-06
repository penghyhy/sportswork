package com.penghy.gymnasium.core.mapper;

import com.penghy.gymnasium.core.entity.GameEnroll;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HY-001
 * @date 2020-07-06 17:38:31
 * @description
 */
public interface GameEnrollMapper {
    void addGameEnroll(GameEnroll gameEnroll);

    GameEnroll getGameEnroll(@Param("id") String id);

    List<GameEnroll> getAllGameEnrolls();

    void deleteGameEnroll(@Param("id") String id);

    void setGameEnroll(GameEnroll gameEnroll);

    long getCount();
}
