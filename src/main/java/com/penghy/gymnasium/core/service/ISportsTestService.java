package com.penghy.gymnasium.core.service;

import com.penghy.gymnasium.core.entity.SportsTest;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/3/3 21:32
 * @description
 */
public interface ISportsTestService {
    void addSportsTest(SportsTest sportsTest);
    SportsTest getSportsTest(String id);
    List<SportsTest> getAllSportsTests();
    void deleteSportsTest(String id);
    void setSportsTest(SportsTest sportsTest);
    long getCount();
}
