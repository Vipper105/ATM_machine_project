package kits.atmmachine.repository;


import java.util.List;

import kits.atmmachine.entity.User;

public interface UserRepository {
	
	void addUser(User user);
	
	void delete(long userID);
	
	void update(User user);
	
	// Show tất cả
	List<User> findAll();
	
	// Tìm kiếm
	User findUserById(int id);
	
	// Hiển thị thông tin người dùng khi nhập vào số tài khoàn account(SoTK)
	User findUserByAccountID(int accountID);
	
	
	
	
	
}
