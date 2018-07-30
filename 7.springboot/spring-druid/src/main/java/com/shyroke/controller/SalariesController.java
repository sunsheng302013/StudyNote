package com.shyroke.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shyroke.dao.EmployeesDao;
import com.shyroke.dao.SalariesDao;
import com.shyroke.model.Employees;
import com.shyroke.model.Salaries;

@Controller
@RequestMapping(value="/salaries")
public class SalariesController {

	@Autowired
	private SalariesDao salariesDao;
	
	@ResponseBody
	@RequestMapping(value="/get")
	public Salaries get() {
		return salariesDao.selectByPrimaryKey(10001);
	}
	
	@ResponseBody
	@RequestMapping(value="/list")
	public PageInfo<Salaries> list(int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<Salaries> sl = salariesDao.selectAll();
		PageInfo pageInfo = new PageInfo<Salaries>(sl);
		return pageInfo;
	}

}
