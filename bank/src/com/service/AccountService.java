package com.service;

import java.io.IOException;

import com.pojo.Account;

public interface AccountService {
	/**
	 * �˺����벻ƥ��״̬
	 */
	int ACCOUNT_PASSWORD_NOT_MATCH = -1;
	/**
	 * ����
	 */
	int ACCOUNT_BALANCE_NOT_ENOUGH = -2;
	/**
	 * �˻�������ƥ��
	 */
	int ACCOUNT_NAME_NOT_MATCH = -3;
	/**
	 * ת��ʧ��
	 */
	int ERROR=-4;
	/**
	 * ת�˳ɹ�
	 */
	int SUCCESS=1;
	/**
	 * ת��
	 * @param accIn �տ��˺�
	 * @param accOut ת���˺�
	 * @return
	 * @throws IOException 
	 */
	int transfer(Account accIn,Account accOut) throws IOException;
}
