package com.penghy.gymnasium.core.mapper;

import com.penghy.gymnasium.core.entity.Game;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HY-001
 * @date 2020-07-06 17:38:31
 * @description
 */
public interface GameMapper {
    void addGame(Game game);

    Game getGame(@Param("id") String id);

    List<Game> getAllGames();

    void deleteGame(@Param("id") String id);

    void setGame(Game game);

    long getCount();
}
