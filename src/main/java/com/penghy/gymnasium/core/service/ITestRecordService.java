package com.penghy.gymnasium.core.service;

import com.penghy.gymnasium.core.entity.TestRecord;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/3/3 21:36
 * @description
 */
public interface ITestRecordService {
    void addTestRecord(TestRecord testRecord);
    TestRecord getTestRecord(String id);
    List<TestRecord> getAllTestRecords();
    void deleteTestRecord(String id);
    void setTestRecord(TestRecord testRecord);
    long getCount();
}
