package com.clinbrain.datac.service;

import com.clinbrain.datac.common.base.BaseService;
import com.clinbrain.datac.mapper.auto.TableStatusMapper;
import com.clinbrain.datac.model.auto.TableStatus;
import com.clinbrain.datac.model.auto.TableStatusExample;
import com.clinbrain.datac.model.custom.Tablepar;
import com.clinbrain.datac.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * VIEWService
* @Title: TableStatusService.java 
* @Package com.clinbrain.datac.service 
* @author fuce
* @email 87766867@qq.com
* @date 2019-09-18 17:25:59  
 */
@Service
public class TableStatusService implements BaseService<TableStatus, TableStatusExample>{
	@Autowired
	private TableStatusMapper tableStatusMapper;
	
	/**
	 * 分页查询
	 * @param
	 * @param
	 * @return
	 */
	 public PageInfo<TableStatus> list(Tablepar tablepar,String where){
	        TableStatusExample testExample=new TableStatusExample();
             String sortName = StringUtils.isEmpty(tablepar.getSortName()) ? "table_id":tablepar.getSortName();
             testExample.setOrderByClause(sortName + " " + tablepar.getSortOrder());
             String name = tablepar.getSearchText();
	        if(name!=null&&!"".equals(name)){
	        	testExample.createCriteria().andTaskNameLike("%"+name+"%");
	        }
	        if(org.apache.commons.lang3.StringUtils.isNotEmpty(where)) {
                TableStatusExample.Criterion wheree = new TableStatusExample.Criterion(where);
                testExample.or().getAllCriteria().add(wheree);
            }
	        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
	        List<TableStatus> list= tableStatusMapper.selectByExample(testExample);
	        PageInfo<TableStatus> pageInfo = new PageInfo<TableStatus>(list);
	        return  pageInfo;
	 }


    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    /**
	 * 添加
	 */
	@Override
	public int insertSelective(TableStatus record) {
		return -1;
	}

    @Override
    public TableStatus selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(TableStatus record) {
        return 0;
    }


    @Override
	public int updateByExampleSelective(TableStatus record, TableStatusExample example) {
		
		return 0;
	}

	
	@Override
	public int updateByExample(TableStatus record, TableStatusExample example) {
		
		return 0;
	}

	@Override
	public List<TableStatus> selectByExample(TableStatusExample example) {
		
		return tableStatusMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(TableStatusExample example) {
		
		return tableStatusMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(TableStatusExample example) {
		
		return 0;
	}

	public Map mainDashboard() {
	    // 前端 -> hive ods
        Map<String,Object> resultMap = new HashMap<>();
        Map<String,Object> odsMap = new HashMap<>();
        Map<String,Object> gpMap = new HashMap<>();
        resultMap.put("1",odsMap);
        resultMap.put("2",gpMap);
        List<Map> totalList = tableStatusMapper.selectTotal();
        totalList.forEach(m ->  {
            if("0".equals(Optional.ofNullable(m.get("enable")).orElse("0").toString().intern())) {
                if("1".equals(m.get("job_type"))) {
                    odsMap.put("disabled", m.get("total"));
                }else {
                    gpMap.put("disabled", m.get("total"));
                }
            }
        });

        totalList.stream().collect(Collectors.groupingBy(m -> m.get("job_type"))).forEach((k,v) -> {
                int total = v.stream().mapToInt(mm -> Integer.parseInt("" + Optional.ofNullable(mm.get("total")).orElse(0))).sum();
            if("1".equals(k)) {
                odsMap.put("total", total);
            }else  {
                gpMap.put("total", total);
            }
        });

        // 完全成功没有数据差异
        List<Map> successList = tableStatusMapper.selectSuccessNoDiff();

        successList.forEach(m ->  {
            if("1".equals(m.get("job_type"))) {
                odsMap.put("successCount", m.get("successCount"));
                odsMap.put("successMinDate", m.get("successMinDate"));
            }else {
                gpMap.put("successCount", m.get("successCount"));
                gpMap.put("successMinDate", m.get("successMinDate"));
            }
        });

        List<Map> successHasDiff = tableStatusMapper.selectSuccessHasDiff();
        successHasDiff.forEach(m ->  {
            if("1".equals(m.get("job_type"))) {
                odsMap.put("successDiffCount", m.get("successDiffCount"));
                odsMap.put("successDiffMinDate", m.get("successDiffMinDate"));
            }else {
                gpMap.put("successDiffCount", m.get("successDiffCount"));
                gpMap.put("successDiffMinDate", m.get("successDiffMinDate"));
            }
        });
        List<Map> errorTask = tableStatusMapper.selectErrorTask();
        errorTask.forEach(m ->  {
            if("1".equals(m.get("job_type"))) {
                odsMap.put("errorCount", m.get("errorCount"));
                odsMap.put("errorMinDate", m.get("errorMinDate"));
            }else {
                gpMap.put("errorCount", m.get("errorCount"));
                gpMap.put("errorMinDate", m.get("errorMinDate"));
            }
        });
        return resultMap;
    }

}
