package com.waterwood.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.waterwood.dao.UserMapper;
import com.waterwood.entity.User;
import com.waterwood.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private UserMapper userDao;

	@Override
	public User getUserById(int userId) {
		return this.userDao.selectByPrimaryKey(userId);
	}

}
