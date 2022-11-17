package com.codingwitharif.ppmtool.services;

import com.codingwitharif.ppmtool.domain.Project;
import com.codingwitharif.ppmtool.exception.ProjectIdException;
import com.codingwitharif.ppmtool.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    public  Project saveOrUpdateProject (Project project){
        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch (Exception e){
            throw new ProjectIdException("Project ID '"+project.getProjectIdentifier().toUpperCase()+"' already exists");
        }

    }

    public Project findProjectByIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if(project == null){
            throw new ProjectIdException("Project Identifier'"+projectId.toUpperCase()+"' does'nt exists");
        }
        return project;
    }
    public List<Project> findAllProjects(){
        return  projectRepository.findAll();

    }
    public void deleteProjectByIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId);
        if(project==null){
            throw new ProjectIdException(("Cannot Project with ID: '"+projectId+"'.This project Doesnt exist"));
        }
         projectRepository.delete(project);
    }
}
