package pers.weisg.springcloud.service;

import java.util.List;

import pers.weisg.springcloud.entities.Dept;

public interface DeptService {
	public boolean add(Dept dept);

	public Dept get(Long id);

	public List<Dept> list();
}
