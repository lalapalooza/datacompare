package com.clinbrain.datac.service;

import com.clinbrain.datac.compare.JobConstants;
import com.clinbrain.datac.mapper.auto.TableConfigMapper;
import com.clinbrain.datac.mapper.auto.TableLoggerMapper;
import com.clinbrain.datac.model.auto.TableConfig;
import com.clinbrain.datac.model.auto.TableLoggerWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by Liaopan on 2019/7/9.
 */
@Service
public class TableLoggerCustomService {

    @Autowired
    private TableLoggerMapper mapper;

    @Autowired
    private TableConfigMapper tableConfigMapper;

    public int saveCompareLog(TableLoggerWithBLOBs record, int range) {
        mapper.insertSelective(record);
        if (record.getStatus().equals(JobConstants.Status.SUCCESS.getCode())) {
            TableConfig tableConfig = new TableConfig();
            tableConfig.setId(record.getTableId());
            LocalDateTime localDate = LocalDateTime.now().minusDays(range);
            tableConfig.setStartDate(Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant()));
            return tableConfigMapper.updateByPrimaryKeySelective(tableConfig);
        }
        return 0;
    }
}
