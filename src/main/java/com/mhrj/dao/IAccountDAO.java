package com.mhrj.dao;


import com.mhrj.entity.Account;

import java.util.List;

public interface IAccountDAO {
    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountById(int id);

    List<Account> findAccountList();

    List<Account> findAccountByPage(int curPage,int pageSize);
}
