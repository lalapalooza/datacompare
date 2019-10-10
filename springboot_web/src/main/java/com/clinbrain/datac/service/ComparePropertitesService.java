package com.clinbrain.datac.service;

import com.clinbrain.datac.mapper.auto.TComparePropertitesMapper;
import com.clinbrain.datac.model.auto.TComparePropertites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author：ligen
 * @Date: Created:10:26  2019/7/15
 * @Description: 对比配置文件service
 **/
@Service
public class ComparePropertitesService {
    @Autowired
    private TComparePropertitesMapper comparePropertitesMapper;

    public int add(TComparePropertites propertites){
        propertites.setCreateTime(new Date());
        return comparePropertitesMapper.insertSelective(propertites);
    }

    public int update(TComparePropertites propertites){
        propertites.setUpdateTime(new Date());
        return comparePropertitesMapper.updateByPrimaryKeySelective(propertites);
    }

    public TComparePropertites selectPropertites(String propertitesName){
        return comparePropertitesMapper.selectByPropertyName(propertitesName);
    }
}
