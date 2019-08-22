package com.service;

import java.io.IOException;

import com.pojo.PageInfo;

public interface LogService  {
	/**
	 * ∑÷“≥œ‘ æ
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 */
	PageInfo showPage(int pageSize,int pageNumber) throws IOException;
}
