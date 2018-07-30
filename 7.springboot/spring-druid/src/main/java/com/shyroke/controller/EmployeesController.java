package com.shyroke.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shyroke.dao.EmployeesDao;
import com.shyroke.model.Employees;

@Controller
@RequestMapping(value="/emp")
public class EmployeesController {

	@Autowired
	private EmployeesDao employeesDao;
	
	@ResponseBody
	@RequestMapping(value="/get")
	public Employees get() {
		return employeesDao.selectByPrimaryKey(10001);
	}
	
	@ResponseBody
	@RequestMapping(value="/list")
	public List<Employees> list() {
		return employeesDao.selectAll();
	}
	
	
}
