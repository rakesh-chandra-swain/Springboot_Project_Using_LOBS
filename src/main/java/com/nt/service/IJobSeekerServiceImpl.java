package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.JobSeeker;
import com.nt.repository.IJobSeekerRepository;
@Service("jsService")
public class IJobSeekerServiceImpl implements IJobSeekerService {
	
	@Autowired
	private IJobSeekerRepository repo;

	@Override
	public String registerJobSeeker(JobSeeker js) {
		int idVal=repo.save(js).getJsId();
		return "job seeker is registered with the id val::"+idVal;
	}

}
