package CourseDB.code.controllers;

import CourseDB.code.models.Department;
import CourseDB.code.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/departments")
@Controller
@ComponentScan("services")
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping()
    public String findAll(Model model) {
        model.addAttribute("departments", departmentService.findAll());
        return "department/showAllDepartments";
    }

    @GetMapping("/{id}")
    public String showDepartment(Model model, @PathVariable("id") int id) {
        model.addAttribute("department", departmentService.findById(id));
        return "department/show";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        departmentService.delete(id);
        return "redirect:/departments";
    }

    @GetMapping("/{id}/edit")
    public String showEdition(Model model, @PathVariable("id") int id) {
        model.addAttribute("department", departmentService.findById(id));
        return "department/edit";
    }

    @PostMapping("/{id}")
    public String edit(@ModelAttribute("department") Department department) {
        departmentService.edit(department);
        return "redirect:/departments";
    }

    @GetMapping("/new")
    public String showNew(@ModelAttribute("department") Department department) {
        return "/department/new";
    }

    @PostMapping("/new")
    public String addNew(@ModelAttribute("department") Department department) {
        departmentService.save(department);
        return "redirect:/departments";
    }
}
