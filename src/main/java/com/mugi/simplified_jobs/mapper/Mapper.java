package com.mugi.simplified_jobs.mapper;

import com.mugi.simplified_jobs.model.ClientData;
import com.mugi.simplified_jobs.model.Company;

public class Mapper 
{
	public static Company clientDataTodbData(ClientData clientData) 
	{
		Company company = new 
				Company(
						clientData.getId(), 
						clientData.getName(),
						clientData.getPercentage(),
						clientData.getFreshness(),
						clientData.getLocation(),
						clientData.getLink()
						);
		
		return company;
	}
	
	public static ClientData dbDataToclientData(Company company) 
	{
		ClientData clientData = new 
				ClientData(
						company.getId(),
						company.getName(),
						company.getPercentage(),
						company.getFreshness(),
						company.getLocation(),
						company.getLink()
						);

		
		return clientData;
	}

}
