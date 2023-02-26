package com.example.account.service;

import java.util.Optional;
import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.account.exception.InsufficientBalanceException;
import com.example.account.exception.InvalidAccountIdException;
import com.example.account.model.Account;
import com.example.account.repository.AccountRepository;
import com.example.account.utils.AccountConsts;


@Service
@Transactional
public class AccountServiceImpl   implements AccountService  , AccountConsts {
	
	
	@Autowired
	AccountRepository accountRepository;
	
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public void deleteAccount(int accountId) throws InsufficientBalanceException, InvalidAccountIdException {
		Optional<Account> account=accountRepository.findById(accountId);
		if(account.isEmpty())
			throw new InvalidAccountIdException("the given accountId is invalid");
		else
			accountRepository.delete(account.get());
		
	}

	@Override
	public Account createAccount(Account account) {
		
		Account addedAccount=accountRepository.save(account);
		return addedAccount;
	}

	@Override
	public Account updateAccount(Account account, int accountId)
			throws InvalidAccountIdException, InsufficientBalanceException {
		Account accountFromDB=this.accountRepository.findById(accountId)
                .orElseThrow(()->new InvalidAccountIdException("the given accountID is invalid"));
		if(account.getBalance()<AccountConsts.M_BALANCE)
			throw new InsufficientBalanceException("the given balance is insufficient");
		accountFromDB.setBalance(account.getBalance());
		accountFromDB.setActive(account.Active());
		return this.accountRepository.save(accountFromDB);
		
		
	}

	@Override
	public Account findByAccountId(int accountId) throws InvalidAccountIdException {
		return this.accountRepository.findById(accountId)
				    .orElseThrow(()->new InvalidAccountIdException("the given accountID is invalid"));
	}
}
