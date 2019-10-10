package com.clinbrain.datac.service;

import cn.hutool.core.lang.UUID;
import com.clinbrain.datac.common.base.BaseService;
import com.clinbrain.datac.common.support.Convert;
import com.clinbrain.datac.compare.CompareTask;
import com.clinbrain.datac.compare.Launcher;
import com.clinbrain.datac.mapper.auto.TableConfigMapper;
import com.clinbrain.datac.mapper.custom.TableConfigDao;
import com.clinbrain.datac.model.auto.TableConfig;
import com.clinbrain.datac.model.auto.TableConfigExample;
import com.clinbrain.datac.model.custom.Tablepar;
import com.clinbrain.datac.util.ApplicationContextUtil;
import com.clinbrain.datac.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service
* @Title: TableConfigService.java 
* @Package com.clinbrain.datac.service 
* @author fuce
* @email 87766867@qq.com
* @date 2019-07-29 13:47:58  
 */
@Service
public class TableConfigService implements BaseService<TableConfig, TableConfigExample>{

	@Autowired
	private TableConfigMapper tableConfigMapper;

	@Autowired
	private TableConfigDao tableConfigDao;

    @Autowired
    private ConnectionService connectionService;

    /**
     * 分页查询
     * @param tablepar
     * @param jobType
     * @return
     */
	 public PageInfo<TableConfig> list(Tablepar tablepar,String jobType){
	        TableConfigExample testExample=new TableConfigExample();
	        String sortName = StringUtils.isEmpty(tablepar.getSortName()) ? "id":tablepar.getSortName();
	        testExample.setOrderByClause(sortName + " " + tablepar.getSortOrder());
	        String name = tablepar.getSearchText();
	        if(name!=null&&!"".equals(name)){
	            String likeName = "%" + name + "%" ;
				try {
					Integer id = Integer.parseInt(name);
					testExample.or().andIdEqualTo(id);
				} catch (NumberFormatException e) {
				}
				testExample.or().andTaskNameLike(likeName);
                testExample.or().andSourceTableLike(likeName);
                testExample.or().andTargetTableLike(likeName);
                testExample.or().andTargetSqlLike(likeName);
                testExample.or().andSourceSqlLike(likeName);
	        }

	        if(StringUtils.isNotEmpty(jobType)) {
				testExample.setJobType(Integer.parseInt(jobType));
			}

	        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
	        List<TableConfig> list= tableConfigMapper.selectByExample(testExample);
	        PageInfo<TableConfig> pageInfo = new PageInfo<TableConfig>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
		List<String> lista=Convert.toListStrArray(ids);
		List<Integer> listb = lista.stream().map(Integer::parseInt).collect(Collectors.toList());
		TableConfigExample example=new TableConfigExample();
		example.createCriteria().andIdIn(listb);
		return tableConfigMapper.deleteByExample(example);
	}
	
	
	@Override
	public TableConfig selectByPrimaryKey(String id) {
		
		return tableConfigMapper.selectByPrimaryKey(Integer.parseInt(id));
	}

	
	@Override
	public int updateByPrimaryKeySelective(TableConfig record) {
		return tableConfigMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(TableConfig record) {
		return tableConfigMapper.insertSelective(record);
	}
	
	@Override
	public int updateByExampleSelective(TableConfig record, TableConfigExample example) {
		
		return tableConfigMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(TableConfig record, TableConfigExample example) {
		
		return tableConfigMapper.updateByExample(record, example);
	}

	@Override
	public List<TableConfig> selectByExample(TableConfigExample example) {
		
		return tableConfigMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(TableConfigExample example) {
		
		return tableConfigMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(TableConfigExample example) {
		
		return tableConfigMapper.deleteByExample(example);
	}
	
	/**
	 * 检查name
	 * @param tableConfig
	 * @return
	 */
	public int checkNameUnique(TableConfig tableConfig){
		TableConfigExample example=new TableConfigExample();
		example.createCriteria().andTaskNameEqualTo(tableConfig.getTaskName());
		List<TableConfig> list=tableConfigMapper.selectByExample(example);
		return list.size();
	}

    public List<TableConfig> selectAll() {
        return tableConfigDao.selectAll();
    }

    /**
     * 批量操作启用或禁用
     * @param operation
     * @param ids
     * @return
     */
    public int batchOperator(String operation,String ids) {
	    // 禁用
            TableConfigExample example=new TableConfigExample();
        TableConfig record = new TableConfig();
        List<String> idStrs = Lists.newArrayList(StringUtils.split(ids, ","));
        if(idStrs.size() > 0) {
            List<Integer> idList = idStrs.stream().map(Integer::parseInt).collect(Collectors.toList());
            if (operation.equalsIgnoreCase("disable")) {
                record.setEnable(0);
            } else if (operation.equalsIgnoreCase("enable")) { // 启用
                record.setEnable(1);
            }
            example.createCriteria().andIdIn(idList);
            return tableConfigMapper.updateByExampleSelective(record,example);
        }
        return 0;
    }

    public String execCompare(Integer id) throws Exception {
        String uuid = UUID.randomUUID().toString();
        execAsync(id,uuid);
        return uuid;
    }

    private void execAsync(Integer id,String mdcValue) throws Exception {

        ThreadPoolTaskExecutor executor = ApplicationContextUtil.getBean("taskComparePool");

        if(null == executor) {
            throw new RuntimeException("初始化线程池出错！");
        }
        //加载所有需要的表
        TableConfig config = tableConfigMapper.selectByPrimaryKey(id);
        config.setSourceConfig(connectionService.selectByPrimaryKey(config.getSourceCode()));
        config.setTargetConfig(connectionService.selectByPrimaryKey(config.getTargetCode()));

        Launcher launcher = new Launcher();
        launcher.setHisTablePartitionConfig(connectionService.getHisPartConf());
        launcher.doConfigTable(config);
        executor.submit(new CompareTask(config));
    }

}
