package com.penghy.gymnasium.core.mapper;

import com.penghy.gymnasium.core.entity.SportsTest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HY-001
 * @date 2020-07-06 17:38:31
 * @description
 */
public interface SportsTestMapper {
    void addSportsTest(SportsTest sportsTest);

    SportsTest getSportsTest(@Param("id") String id);

    List<SportsTest> getAllSportsTests();

    void deleteSportsTest(@Param("id") String id);

    void setSportsTest(SportsTest sportsTest);

    long getCount();
}
