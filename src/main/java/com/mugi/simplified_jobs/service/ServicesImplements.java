package com.mugi.simplified_jobs.service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mugi.simplified_jobs.mapper.Mapper;
import com.mugi.simplified_jobs.model.ClientData;
import com.mugi.simplified_jobs.model.Company;
import com.mugi.simplified_jobs.repository.Repository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServicesImplements implements Services{

	private Repository repository;
	
	@Override
	public ClientData createCompany(ClientData clientData) {
		
		Company company = Mapper.clientDataTodbData(clientData);
		Company savedData=repository.save(company);
		return Mapper.dbDataToclientData(savedData);
	}

	@Override
	public ClientData getCompanyDetails(long id) {
		// TODO Auto-generated method stub
		
		Company company = repository.findById(id).orElseThrow(()->new RuntimeException("id not exist"));
		return Mapper.dbDataToclientData(company);
	}

	@Override
	public List<ClientData> getAllCompanysRequirements() {
		List<Company> companies = repository.findAll();
		return companies.stream()
				.map((company)->Mapper.dbDataToclientData(company)).collect(Collectors.toList());
	}

	@Override
	public String deleteRequirementById(long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		return "id "+id+" got deleted";
	}

	@Override
	public List<ClientData> getCompanyDetailsByName(String name) {
		// TODO Auto-generated method stub
		List<Company> findByName;
		
		try 
		{
			findByName = repository.findByName(name);
		}
		catch(Exception e) 
		{
			System.out.println(e.getMessage());
			findByName = new ArrayList<>();
		}
		return findByName.stream().map((company)->Mapper.dbDataToclientData(company)).collect(Collectors.toList());
	}

	@Override
	public String deleteRequirementByName(String name) {
		// TODO Auto-generated method stub
		
		repository.deleteAll(repository.findByName(name));
		
		return "company with the name "+name+" got deleted";
	}

	@Override
	public List<ClientData> updateByName(String name,ClientData clientData) {
		// TODO Auto-generated method stub
		
		List<Company> toUpdate = repository.findByName(name);
		List<Company> updated = toUpdate.stream()
		.map((company)->
		{			
			company.setPercentage(clientData.getPercentage());
			company.setFreshness(clientData.getFreshness());
			company.setLocation(clientData.getLocation());
			company.setLink(clientData.getLink());
			return company;
		}).collect(Collectors.toList());
		
		repository.saveAll(updated);
		
		return updated.stream().map(company->Mapper.dbDataToclientData(company)).collect(Collectors.toList());
	}


	

}
