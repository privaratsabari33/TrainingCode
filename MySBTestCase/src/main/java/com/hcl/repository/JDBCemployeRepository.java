package com.hcl.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.hcl.model.Employe;
import com.hcl.model.LoginTimeAudit;


@Component
public class JDBCemployeRepository implements EmployeeRepository,LoginAuditRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int count() {
		// TODO Auto-generated method stub
		 return jdbcTemplate
	                .queryForObject("select count(*) from employee", Integer.class);
	}

	@Override
	public int empsave(Employe emp) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(
                "insert into employee (designation, ename,location) values(?,?,?)",
                emp.getDesignation(), emp.getEname(),emp.getLocation());
	}

	@Override
	public int auditcount() {
		// TODO Auto-generated method stub
		 return jdbcTemplate
	                .queryForObject("select count(*) from logintimeaudit", Integer.class);
	
	}

	/**
	 *
	 */
	@Override
	public int auditsave(LoginTimeAudit auditsave) {
		// TODO Auto-generated method stub
		int count=getempById(auditsave.getEid());
		if(count !=0) {
			return jdbcTemplate.update(
	                "insert into logintimeaudit (eid,flag) values(?,?)",
	                auditsave.getEid(),auditsave.getFlag());
		}else {
			return 0;
		}
		
		
	
	}

	@Override
	public int getempById(Long id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(
                "select count(*) from employee where eid = ?",
                new Object[]{id},
                Integer.class
        );
	}
	
	

}
