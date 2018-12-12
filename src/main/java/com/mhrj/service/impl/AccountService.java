package com.mhrj.service.impl;


import com.mhrj.dao.IAccountDAO;
import com.mhrj.entity.Account;
import com.mhrj.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    IAccountDAO accountDAO;
    public int add(Account account) {
        return accountDAO.add(account);
    }

    public int update(Account account) {
        return accountDAO.update(account);
    }

    public int delete(int id) {
        return accountDAO.delete(id);
    }

    public Account findAccountById(int id) {
        return accountDAO.findAccountById(id);
    }

    public List<Account> findAccountList() {
        return accountDAO.findAccountList();
    }

    public List<Account> findAccountByPage(int curPage,int pageSize) {
        return accountDAO.findAccountByPage(curPage,pageSize);
    }

}
