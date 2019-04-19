package com.sun.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.helloworld.entity.business_revoke_companyinfo_temp;
import com.sun.helloworld.mapper.business_revoke_companyinfo_tempMapper;
import com.sun.helloworld.model.DtoRevokeCompanyPushInfo;
import com.sun.helloworld.model.RevokeOAResult;

@Service
public class apiService {

	@Autowired
	private business_revoke_companyinfo_tempMapper mapper;

	public RevokeOAResult createCompany(DtoRevokeCompanyPushInfo company) {

		RevokeOAResult result = new RevokeOAResult();

		if (company == null || company.collecterName == null || company.collecterName.equals("")
				|| company.collecterNo == null || company.collecterNo.equals("")) {
			result.errorMessage = "未通过数据校验";
			result.success = false;
			result.hasErrors = false;
		}

		business_revoke_companyinfo_temp entity = new business_revoke_companyinfo_temp();
		entity.collecter_name = company.collecterName;
		entity.collecter_no = company.collecterNo;
		entity.account_name = company.accountName;
		entity.account_no = company.accountNo;
		entity.contract_flag = company.contractFlag;
		entity.deleted = company.deleted;
		
		
		int num = mapper.insert(entity);

		if (num < 1) {
			result.errorMessage = "保存失败";
			result.success = false;
			result.hasErrors = false;
		}

		return result;
	}

}
