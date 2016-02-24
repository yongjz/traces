package com.waterwood.dao;

import java.util.List;

import com.waterwood.entity.Logistics;

public interface LogisticsMapper {
    int deleteByPrimaryKey(Integer logisticsId);

    int insert(Logistics record);

    int insertSelective(Logistics record);

    Logistics selectByPrimaryKey(Integer logisticsId);
    
    List<Logistics> selectByOutsideCode(String qrcodeOutsidecode);

    int updateByPrimaryKeySelective(Logistics record);

    int updateByPrimaryKey(Logistics record);
}