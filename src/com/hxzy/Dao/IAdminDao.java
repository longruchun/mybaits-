package com.hxzy.Dao;

import java.util.List;

import com.hxzy.entity.Admin;

public interface IAdminDao {
	 List<Admin> getAll();
	 int insert(Admin admin);
	 List<Admin> getEntityByName();
}
