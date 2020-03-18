package com.hcl.repository;

import com.hcl.model.LoginTimeAudit;

public interface LoginAuditRepository {
	
	int auditcount();

    int auditsave(LoginTimeAudit auditsave);

    //int auditupdate(LoginTimeAudit auditupdate);
}
