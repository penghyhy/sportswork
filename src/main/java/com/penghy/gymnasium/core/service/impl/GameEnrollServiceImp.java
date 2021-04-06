package com.penghy.gymnasium.core.service.impl;

import com.penghy.gymnasium.core.entity.GameEnroll;
import com.penghy.gymnasium.core.mapper.GameEnrollMapper;
import com.penghy.gymnasium.core.service.IGameEnrollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author HY-001
 * @date 2020-07-06 17:38:31
 * @description
 */

@Slf4j
@Service
@Transactional
public class GameEnrollServiceImp implements IGameEnrollService {
    @Resource
    private GameEnrollMapper gameEnrollMapper;

    @Override
    public void addGameEnroll(GameEnroll gameEnroll) {
        gameEnrollMapper.addGameEnroll(gameEnroll);
    }

    @Override
    public GameEnroll getGameEnroll(String id) {
        return gameEnrollMapper.getGameEnroll(id);
    }

    @Override
    public List<GameEnroll> getAllGameEnrolls() {
        return getAllGameEnrolls();
    }

    @Override
    public void deleteGameEnroll(String id) {
        gameEnrollMapper.deleteGameEnroll(id);
    }

    @Override
    public void setGameEnroll(GameEnroll gameEnroll) {
        gameEnrollMapper.setGameEnroll(gameEnroll);
    }

    @Override
    public long getCount() {
        return gameEnrollMapper.getCount();
    }
}
