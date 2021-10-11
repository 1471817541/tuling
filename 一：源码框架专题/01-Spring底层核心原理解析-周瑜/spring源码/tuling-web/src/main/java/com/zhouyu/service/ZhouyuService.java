package com.zhouyu.service;

import com.zhouyu.controller.ZhouyuController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletRequest;

@Service
public class ZhouyuService {

	@Autowired
	private ServletRequest servletRequest;

	public String test(){
		servletRequest.getAttribute("123");
		return "123123";
	}


}

