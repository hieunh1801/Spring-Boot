package com.websystique.springboot.service;

import java.util.List;

import com.websystique.springboot.model.User;
import com.websystique.springboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	public User findById(Long id) {
		// Tìm kiếm theo Id
		return userRepository.findOne(id);
	}

	public User findByName(String name) {
		// Tìm kiếm theo tên
		return userRepository.findByName(name);
	}

	public void saveUser(User user) {
		// Lưu
		userRepository.save(user);
	}

	public void updateUser(User user){
		// Cập nhật : ghi đè lại
		saveUser(user);
	}

	public void deleteUserById(Long id){
		// Xóa theo Id
		userRepository.delete(id);
	}

	public void deleteAllUsers(){
		// Xóa tất cả
		userRepository.deleteAll();
	}

	public List<User> findAllUsers(){
		// Trả về list User
		return userRepository.findAll();
	}

	public boolean isUserExist(User user) {
		return findByName(user.getName()) != null;
	}

}
