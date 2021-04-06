package com.penghy.gymnasium.core.service;

import com.penghy.gymnasium.core.entity.Game;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/3/3 21:49
 * @description
 */
public interface IGameService {
    void addGame(Game game);
    Game getGame(String id);
    List<Game> getAllGames();
    void deleteGame(String id);
    void setGame(Game game);
    long getCount();
}
