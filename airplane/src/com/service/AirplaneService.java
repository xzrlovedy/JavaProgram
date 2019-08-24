package com.service;

import java.util.List;

import com.pojo.Airplane;

public interface AirplaneService {
	List<Airplane> show(int takeid,int landid);
}
