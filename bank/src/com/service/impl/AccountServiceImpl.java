package com.service.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pojo.Account;
import com.service.AccountService;

public class AccountServiceImpl implements AccountService{

	@Override
	public int transfer(Account accIn, Account accOut) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		//先判断帐号和密码是否匹配
		Account accOutSelect = session.selectOne("com.mapper.AccountMapper.selByAccnoPwd",accOut);
		if(accOutSelect!=null){
			if(accOutSelect.getBalance()>=accOut.getBalance()){
				Account accInSelect  = session.selectOne("com.mapper.AccountMapper.selByAccnoName",accIn);
				if(accInSelect!=null){
					//收款
					accIn.setBalance(accOut.getBalance());
					//出款
					accOut.setBalance(-accOut.getBalance());
					int index = session.update("com.mapper.AccountMapper.updBalanceByAccno",accOut);
					index += session.update("com.mapper.AccountMapper.updBalanceByAccno",accIn);
					if(index == 2) {
						session.commit();
						session.close();
						return SUCCESS;
					}else {
						session.rollback();
						session.close();
						//转账失败
						return ERROR;
					}
					}else {
						//账户姓名不匹配
						return ACCOUNT_NAME_NOT_MATCH;
					}
			}else{
				//余额不足
				return ACCOUNT_BALANCE_NOT_ENOUGH;
			}
		}else{
			//帐号和密码不匹配
			return ACCOUNT_PASSWORD_NOT_MATCH;
		}
	}

}
