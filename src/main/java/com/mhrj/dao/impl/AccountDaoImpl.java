package com.mhrj.dao.impl;

import com.mhrj.dao.IAccountDAO;
import com.mhrj.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * jdbcTemplate模板工具类     
 * 基本用法 jdbcTemplate.query  查询
 *  	 jdbcTemplate.update   更新
 *       sql语句直接扔里面或提取出来看各人习惯 
 *       实际参数和其他需要可参见jdbcTemplate api
 */
@Repository
public class AccountDaoImpl implements IAccountDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //增
    public int add(Account account) {
        return jdbcTemplate.update("insert into account(name, money) values(?, ?)",
              account.getName(),account.getMoney());
    }
    //修改
    public int update(Account account) {
        return jdbcTemplate.update("UPDATE  account SET NAME=? ,money=? WHERE id=?",
                account.getName(),account.getMoney(),account.getId());
    }
    //修改
    public int delete(int id) {
        return jdbcTemplate.update("DELETE from TABLE account where id=?",id);
    }
    //条件查询
    public Account findAccountById(int id) {
        List<Account> list = jdbcTemplate.query("select * from account where id = ?", new Object[]{id}, new BeanPropertyRowMapper<Account>(Account.class));
        if(list!=null && list.size()>0){
            Account account = list.get(0);
            return account;
        }else{
            return null;
        }
    }
    //查询集合
    public List<Account> findAccountList() {
        List<Account> list = jdbcTemplate.query("select * from account", new Object[]{}, new BeanPropertyRowMapper<Account>(Account.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }
    //分页
    public List<Account> findAccountByPage(int curPage,int pageSize) {
        int start=(curPage-1)*pageSize;
        List<Account> list = jdbcTemplate.query("select * from account limit ?,?", new Object[]{start,pageSize}, new BeanPropertyRowMapper<Account>(Account.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
