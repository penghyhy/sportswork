package com.penghy.gymnasium.mapper;

import com.penghy.gymnasium.core.entity.GameEnroll;
import com.penghy.gymnasium.core.mapper.GameEnrollMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/4 18:16
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GameEnrollMapperTest {
    @Resource
    private GameEnrollMapper gameEnrollMapper;

    @Test
    @Transactional
    public void getAllGameEnrolls() throws Exception {
        List<GameEnroll> gameEnrollList = gameEnrollMapper.getAllGameEnrolls();
        System.out.println(gameEnrollList.toString());
    }
}
