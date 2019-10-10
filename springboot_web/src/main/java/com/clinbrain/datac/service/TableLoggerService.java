package com.clinbrain.datac.service;

import com.clinbrain.datac.common.base.BaseService;
import com.clinbrain.datac.common.support.Convert;
import com.clinbrain.datac.mapper.auto.TableConfigMapper;
import com.clinbrain.datac.mapper.auto.TableLoggerMapper;
import com.clinbrain.datac.model.auto.TableConfig;
import com.clinbrain.datac.model.auto.TableLoggerExample;
import com.clinbrain.datac.model.auto.TableLoggerWithBLOBs;
import com.clinbrain.datac.model.custom.Tablepar;
import com.clinbrain.datac.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service
 * @Title: TableLoggerService.java 
 * @Package com.clinbrain.datac.service 
 * @author liaopan
 * @date 2019-08-06 11:32:39  
 */
@Service
public class TableLoggerService implements BaseService<TableLoggerWithBLOBs, TableLoggerExample>{
    @Autowired
    private TableLoggerMapper tableLoggerMapper;

    @Autowired
    private TableConfigMapper tableConfigMapper;

    @Value("${table.config.ignore}")
    private Boolean ignore;

    /**
     * 分页查询
     * @param
     * @return
     */
    public PageInfo<TableLoggerWithBLOBs> list(Tablepar tablepar){
        TableLoggerExample testExample=new TableLoggerExample();
        String sortName = StringUtils.isEmpty(tablepar.getSortName()) ? "id":tablepar.getSortName();
        testExample.setOrderByClause(sortName + " " + tablepar.getSortOrder());
        String name = tablepar.getSearchText();
        if(StringUtils.isNotEmpty(name)){
            try {
                testExample.or().andTableIdEqualTo(Integer.parseInt(name));
            }catch (Exception e) {}
            TableLoggerExample.Criterion cc = new TableLoggerExample.Criterion("tc.task_name like ","%"+name+"%");
            testExample.or().getAllCriteria().add(cc);
        }

        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        List<TableLoggerWithBLOBs> list= tableLoggerMapper.selectByExampleWithBLOBs(testExample);
        PageInfo<TableLoggerWithBLOBs> pageInfo = new PageInfo<TableLoggerWithBLOBs>(list);
        return  pageInfo;
    }

    @Override
    public int deleteByPrimaryKey(String ids) {
        List<String> lista=Convert.toListStrArray(ids);
        TableLoggerExample example = new TableLoggerExample();
        if(lista != null) {
            example.createCriteria().andIdIn(lista.stream().map(Integer::parseInt).collect(Collectors.toList()));
        }
        return tableLoggerMapper.deleteByExample(example);
    }


    @Override
    public TableLoggerWithBLOBs selectByPrimaryKey(String id) {
        TableLoggerWithBLOBs logger = tableLoggerMapper.selectByPrimaryKey(Integer.parseInt(id));
        TableConfig config = tableConfigMapper.selectByPrimaryKey(logger.getTableId());
        logger.setTableConfig(config);
        return logger;
    }


    @Override
    public int updateByPrimaryKeySelective(TableLoggerWithBLOBs record) {
        return tableLoggerMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 添加
     */
    @Override
    public int insertSelective(TableLoggerWithBLOBs record) {
        return tableLoggerMapper.insertSelective(record);
    }


    @Override
    public int updateByExampleSelective(TableLoggerWithBLOBs record, TableLoggerExample example) {

        return tableLoggerMapper.updateByExampleSelective(record, example);
    }


    @Override
    public int updateByExample(TableLoggerWithBLOBs record, TableLoggerExample example) {

        return tableLoggerMapper.updateByExample(record, example);
    }

    @Override
    public List<TableLoggerWithBLOBs> selectByExample(TableLoggerExample example) {

        return tableLoggerMapper.selectByExampleWithBLOBs(example);
    }


    @Override
    public long countByExample(TableLoggerExample example) {

        return tableLoggerMapper.countByExample(example);
    }


    @Override
    public int deleteByExample(TableLoggerExample example) {

        return tableLoggerMapper.deleteByExample(example);
    }

    public Boolean getIgnore() {
        return ignore;
    }
}
