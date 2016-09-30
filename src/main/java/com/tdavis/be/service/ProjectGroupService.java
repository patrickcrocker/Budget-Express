package com.tdavis.be.service;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tdavis.be.entity.ProjectGroup;
import com.tdavis.be.repository.ProjectGroupRepository;

@Service
@Transactional
public class ProjectGroupService {
	@Autowired
	private ProjectGroupRepository projectgroupRepository;
	
	
	public Iterable<ProjectGroup> findAll () {
		
		return projectgroupRepository.findAll();
		
	}
	

}
