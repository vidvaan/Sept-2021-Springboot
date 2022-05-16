package com.create.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.create.demo.entity.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Integer>{
   //select * from Employee where ename = ?;
   //select * from Employee where esal =?;
	
	//select * from Employee where ename = ?;
	List<Employee> findByEname(String ename);
	
	//select * from Employee where esal =?;
	List<Employee> findByEsal(Double esal);
	
	//select * from Employee where eid =? and ename = ?
	List<Employee> findByEidAndEname(Integer eid,String ename);
	
	List<Employee> findByEsalBetween(Double startEsal,Double endEsal);
	
	@Query("select e from Employee e where e.ename = ?1")
	List<Employee> findByEnameUsingHQL(String ename);
	
	List<Employee> getByEname(@Param("ename") String ename);
	
	List<Employee> getByEsal(@Param("esal") Double esal);
	
}
