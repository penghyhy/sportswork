package com.penghy.gymnasium.core.service.impl;

import com.penghy.gymnasium.core.entity.SportsTest;
import com.penghy.gymnasium.core.mapper.SportsTestMapper;
import com.penghy.gymnasium.core.service.ISportsTestService;
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
public class SportsTestServiceImp implements ISportsTestService {
    @Resource
    private SportsTestMapper sportsTestMapper;

    @Override
    public void addSportsTest(SportsTest sportsTest) {
        sportsTestMapper.addSportsTest(sportsTest);
    }

    @Override
    public SportsTest getSportsTest(String id) {
        return sportsTestMapper.getSportsTest(id);
    }

    @Override
    public List<SportsTest> getAllSportsTests() {
        return sportsTestMapper.getAllSportsTests();
    }

    @Override
    public void deleteSportsTest(String id) {
        sportsTestMapper.deleteSportsTest(id);
    }

    @Override
    public void setSportsTest(SportsTest sportsTest) {
        sportsTestMapper.setSportsTest(sportsTest);
    }

    @Override
    public long getCount() {
        return sportsTestMapper.getCount();
    }
}
