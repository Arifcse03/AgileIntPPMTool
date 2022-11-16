package com.codingwitharif.ppmtool.services;

import com.codingwitharif.ppmtool.domain.Project;
import com.codingwitharif.ppmtool.exception.ProjectIdException;
import com.codingwitharif.ppmtool.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    public  Project saveOrUpdateProject (Project project, String name){
        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch (Exception e){
            throw new ProjectIdException("Project ID '"+project.getProjectIdentifier().toUpperCase()+"' already exists");
        }

    }
}
