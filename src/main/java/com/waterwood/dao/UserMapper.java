package com.waterwood.dao;

import java.util.Set;

import com.waterwood.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    public User createUser(User user);
    public void updateUser(User user);
    public void deleteUser(Long userId);
    public void correlationRoles(Long userId, Long... roleIds);
    public void uncorrelationRoles(Long userId, Long... roleIds);
    User findOne(Long userId);
    User findByUsername(String userName);
    Set<String> findRoles(String username);
    Set<String> findPermissions(String username);
}