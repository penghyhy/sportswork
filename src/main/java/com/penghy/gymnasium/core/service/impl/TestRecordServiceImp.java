package com.penghy.gymnasium.core.service.impl;

import com.penghy.gymnasium.core.entity.TestRecord;
import com.penghy.gymnasium.core.mapper.TestRecordMapper;
import com.penghy.gymnasium.core.service.ITestRecordService;
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
public class TestRecordServiceImp implements ITestRecordService {
    @Resource
    private TestRecordMapper testRecordMapper;

    @Override
    public void addTestRecord(TestRecord testRecord) {
        testRecordMapper.addTestRecord(testRecord);
    }

    @Override
    public TestRecord getTestRecord(String id) {
        return testRecordMapper.getTestRecord(id);
    }

    @Override
    public List<TestRecord> getAllTestRecords() {
        return testRecordMapper.getAllTestRecords();
    }

    @Override
    public void deleteTestRecord(String id) {
        testRecordMapper.deleteTestRecord(id);
    }

    @Override
    public void setTestRecord(TestRecord testRecord) {
        testRecordMapper.setTestRecord(testRecord);
    }

    @Override
    public long getCount() {
        return testRecordMapper.getCount();
    }
}
