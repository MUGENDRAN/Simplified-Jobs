package com.mugi.simplified_jobs.service;

import java.util.List;

import com.mugi.simplified_jobs.model.ClientData;

public interface Services{
	
	ClientData createCompany(ClientData clientData);
	
	ClientData getCompanyDetails(long id);
	
	List<ClientData> getAllCompanysRequirements();
	
	String deleteRequirementById(long id);
	
	String deleteRequirementByName(String name);
	
	List<ClientData> getCompanyDetailsByName(String name);
	
	List<ClientData> updateByName(String name, ClientData clientData);
	

}
