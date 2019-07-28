package com.cognizant.sba.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.sba.dto.ProjectDTO;
import com.cognizant.sba.eo.ProjectEO;
import com.cognizant.sba.eo.UserEO;
import com.cognizant.sba.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;


	public ProjectDTO addProject(ProjectDTO p) {
		ProjectEO project = new ProjectEO();
		project.setProject(p.getProjectName());
		project.setStartDate(p.getStartDate());
		project.setEndDate(p.getEndDate());
		project.setPriority(p.getPriority());
		UserEO user = new UserEO();
		user.setUserId(p.getUserId());
		project.setUser(user);
		projectRepository.save(project);
		p.setCompletedTaskNumber(0L);
		p.setTaskNumber(0);
		return p;
	}

	public ProjectDTO updateProject(ProjectDTO p) {
		ProjectEO project = projectRepository.findOne(p.getProjectId());
		if (project != null) {
			project.setProject(p.getProjectName());
			project.setStartDate(p.getStartDate());
			project.setEndDate(p.getEndDate());
			project.setPriority(p.getPriority());

			UserEO user = new UserEO();
			user.setUserId(p.getUserId());
			project.setUser(user);
			projectRepository.save(project);
			return p;
		} else {
			return null;
		}
	}

	public List<ProjectDTO> getAllProject() {
		Iterable<ProjectEO> projectList = projectRepository.findAll();
		List<ProjectDTO> projectResponseList = new ArrayList<>();
		for (ProjectEO project : projectList) {
			ProjectDTO p = new ProjectDTO();
			p.setProjectId(project.getProjectId());
			p.setProjectName(project.getProject());
			p.setStartDate(project.getStartDate());
			p.setEndDate(project.getEndDate());
			p.setPriority(project.getPriority());
			p.setTaskNumber(project.getTasks().size());
			p.setCompletedTaskNumber(
					project.getTasks().stream().filter(task -> "COMPLETED".equals(task.getStatus())).count());

			if (null != project.getUser()) {
				p.setUserId(project.getUser().getUserId());
				p.setManager(project.getUser().getFirstName());
			}

			projectResponseList.add(p);
		}

		return projectResponseList;
	}

}
