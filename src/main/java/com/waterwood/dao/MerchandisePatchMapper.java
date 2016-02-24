package com.waterwood.dao;

import com.waterwood.entity.MerchandisePatch;

public interface MerchandisePatchMapper {
    int deleteByPrimaryKey(Integer merchandisepatchId);

    int insert(MerchandisePatch record);

    int insertSelective(MerchandisePatch record);

    MerchandisePatch selectByPrimaryKey(Integer merchandisepatchId);
    
    MerchandisePatch selectByCode(String merchandisepatchCode);

    int updateByPrimaryKeySelective(MerchandisePatch record);

    int updateByPrimaryKey(MerchandisePatch record);
}