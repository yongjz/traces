package com.waterwood.dao;

import com.waterwood.entity.QuickResponseCode;

public interface QuickResponseCodeMapper {
    int deleteByPrimaryKey(Integer qrcodeId);

    int insert(QuickResponseCode record);

    int insertSelective(QuickResponseCode record);

    QuickResponseCode selectByPrimaryKey(Integer qrcodeId);
    
    QuickResponseCode selectByOutsideCode(String qrcodeOutsidecode);
    
    QuickResponseCode selectByInsideCode(String qrcodeInsidecode);

    int updateByPrimaryKeySelective(QuickResponseCode record);

    int updateByPrimaryKey(QuickResponseCode record);
}