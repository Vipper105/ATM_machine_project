package kits.atmmachine.repository;

import java.util.List;

import kits.atmmachine.entity.ATMmachine;

public interface ATMmachineRepository {

	void addATM(ATMmachine atm);

	void deleteATM(int machineID);

	void updateATM(ATMmachine atm);

	// Show tất cả
	List<ATMmachine> findAllATM();

	// Tìm kiếm
	ATMmachine findATMById(int atmID);

}
