package com.service;

import java.io.IOException;

import com.pojo.PageInfo;

public interface LogService  {
	/**
	 * ��ҳ��ʾ
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 */
	PageInfo showPage(int pageSize,int pageNumber) throws IOException;
}
