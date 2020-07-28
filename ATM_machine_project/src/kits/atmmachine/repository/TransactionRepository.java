package kits.atmmachine.repository;

import java.util.List;

import kits.atmmachine.HistoryTransaction;
import kits.atmmachine.entity.Transaction;

public interface TransactionRepository {

	void addTransaction(Transaction transaction,int flag);

	void deleteTransaction(long transactionID);

	void updateTrans(HistoryTransaction transaction);

	// read all tất cả
	List<HistoryTransaction> findAllTransaction();

	// read transaction by account id
	HistoryTransaction findTransactionById(long transactionID);

}
