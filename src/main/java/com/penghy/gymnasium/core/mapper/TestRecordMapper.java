package com.penghy.gymnasium.core.mapper;

import com.penghy.gymnasium.core.entity.TestRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HY-001
 * @date 2020-07-06 17:38:31
 * @description
 */
public interface TestRecordMapper {
    void addTestRecord(TestRecord testRecord);

    TestRecord getTestRecord(@Param("id") String id);

    List<TestRecord> getAllTestRecords();

    void deleteTestRecord(@Param("id") String id);

    void setTestRecord(TestRecord testRecord);

    long getCount();
}
