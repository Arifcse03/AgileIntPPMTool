package com.codingwitharif.ppmtool.web;

import com.codingwitharif.ppmtool.domain.Project;
import com.codingwitharif.ppmtool.exception.ProjectIdExceptionResponse;
import com.codingwitharif.ppmtool.repository.ProjectRepository;
import com.codingwitharif.ppmtool.services.MapValidationErrorService;
import com.codingwitharif.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import javax.validation.Valid;

@Controller
//@RestController
@RequestMapping("/project/")
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
 private ProjectRepository projectRepository;
    @Autowired
    private MapValidationErrorService mapValidationErrorService;



    @GetMapping("signup")
    public String showSignUpForm(Project project) {
        return "add-project";
    }
    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("project", projectService.findAllProjects());
        return "index";
    }

    @PostMapping("add")
    public String addStudent(@Valid Project project, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-project";
        }

        projectService.saveOrUpdateProject(project);
        return "redirect:list";
    }
    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid project Id:" + id));
        model.addAttribute("project", project);
        return "update-project";
    }
    @PostMapping("update/{id}")
    public String updateStudent(@PathVariable("id") long id, @Valid Project project, BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            project.setId(id);
            return "update-project";
        }

        projectRepository.save(project);
        model.addAttribute("project", projectRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid project Id:" + id));
        projectRepository.delete(project);
        model.addAttribute("students", projectRepository.findAll());
        return "index";
    }
//    @PostMapping("")
//    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){
//
//        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
//        if(errorMap!=null) return errorMap;
//
//        Project project1 = projectService.saveOrUpdateProject(project);
//        return new ResponseEntity<Project>(project1, HttpStatus.CREATED);
//    }
//    @GetMapping("/{projectId}")
//public ResponseEntity<?> getProjectById(@PathVariable String projectId){
//        Project project = projectService.findProjectByIdentifier(projectId);
//        return new ResponseEntity<Project>(project,HttpStatus.OK);
//    }
//    @GetMapping("/all")
//    public String getAllProjects(Model model){  model.addAttribute("project",projectService.findAllProjects()); return "index";}
//    @DeleteMapping("/{projectId}")
//    public ResponseEntity<?>deleteProject(@PathVariable String projectId){
//        projectService.deleteProjectByIdentifier(projectId.toUpperCase());
//        return  new ResponseEntity<String >("project with ID : '"+projectId.toUpperCase()+"' deleted.",HttpStatus.OK);
//    }

}
