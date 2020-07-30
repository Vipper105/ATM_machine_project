package kits.atmmachine.repository;

import java.util.List;

import kits.atmmachine.entity.Account;

public interface AccountRepository {

	void addAccount(Account acc);

	void deleteAccount(long accountID);
	
	void deleteAccountByUserID(long userID,int flag);
	
	
	void updateAccount(Account acc);


	// Show tất cả
	List<Account> findAllAccount();

	// Tìm kiếm
	Account findAccountById(long id);

}
