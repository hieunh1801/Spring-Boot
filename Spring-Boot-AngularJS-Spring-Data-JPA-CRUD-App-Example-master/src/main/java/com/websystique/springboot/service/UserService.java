package com.websystique.springboot.service;


import com.websystique.springboot.model.User;

import java.util.List;
/*Interface User Service */
public interface UserService {
	
	User findById(Long id);
	// Tìm kiếm theo Id : trả về một User
	User findByName(String name);
	// Tìm kiếm theo tên : trả về một User
	void saveUser(User user);
	// Lưu
	void updateUser(User user);
	// Cập nhật
	void deleteUserById(Long id);
	// Xóa
	void deleteAllUsers();
	// Xoá tất cả
	List<User> findAllUsers();
	// Tìm kiếm tất cả User : trả về một List User
	boolean isUserExist(User user);
	// User có tồn tại không
}