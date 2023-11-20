package CourseDB.code.controllers;

import CourseDB.code.models.Project;
import CourseDB.code.services.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import util.ProjectValidator;

@Controller
@RequestMapping("/projects")
@ComponentScan("services")
@ComponentScan("util")
public class ProjectController {
    private final ProjectService projectService;
    private final util.ProjectValidator projectValidator;

    @Autowired
    public ProjectController(ProjectService projectService, ProjectValidator projectValidator) {
        this.projectService = projectService;
        this.projectValidator = projectValidator;
    }

    @GetMapping()
    public String findAll(Model model) {
        model.addAttribute("projects", projectService.findAll());
        return "project/showAllProjects";
    }

    @GetMapping("/{id}")
    public String showProject(Model model, @PathVariable("id") int id) {
        model.addAttribute("project", projectService.findById(id));
        return "project/show";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        projectService.delete(id);
        return "redirect:/projects";
    }

    @GetMapping("/{id}/edit")
    public String showEdition(Model model, @PathVariable("id") int id) {
        model.addAttribute("project", projectService.findById(id));
        return "project/edit";
    }

    @PostMapping("/{id}")
    public String edit(@ModelAttribute("project") Project project) {
        projectService.edit(project);
        return "redirect:/projects";
    }

    @GetMapping("/new")
    public String showNew(@ModelAttribute("project") Project project) {
        return "/project/new";
    }

    @PostMapping("/new")
    public String addNew(@ModelAttribute("project") @Valid Project project, BindingResult br) {
        projectValidator.validate(project, br);
        if (br.hasErrors()) return "/project/new";
        projectService.save(project);
        return "redirect:/projects";
    }
}
