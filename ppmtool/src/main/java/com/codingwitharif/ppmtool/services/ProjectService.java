package com.codingwitharif.ppmtool.services;

import com.codingwitharif.ppmtool.domain.Project;
import com.codingwitharif.ppmtool.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    public  Project saveOrUpdateProject (Project project){

        return  projectRepository.save(project);
    }
}
