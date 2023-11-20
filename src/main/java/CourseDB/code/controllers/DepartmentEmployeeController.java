package CourseDB.code.controllers;

import CourseDB.code.models.DepartmentEmployee;
import CourseDB.code.services.DepartmentEmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import util.DEValidator;

@Controller
@RequestMapping("/de")
@ComponentScan("services")
public class DepartmentEmployeeController {
    private final DepartmentEmployeeService departmentEmployeeService;
    private final util.DEValidator deValidator;

    @Autowired
    public DepartmentEmployeeController(DepartmentEmployeeService departmentEmployeeService, DEValidator deValidator) {
        this.departmentEmployeeService = departmentEmployeeService;
        this.deValidator = deValidator;
    }

    @GetMapping()
    public String findAll(Model model) {
        model.addAttribute("allDE", departmentEmployeeService.findAll());
        return "de/showAllDE";
    }

    @GetMapping("/{id}")
    public String showDE(Model model, @PathVariable("id") int id) {
        model.addAttribute("de", departmentEmployeeService.findById(id));
        return "de/show";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        departmentEmployeeService.delete(id);
        return "redirect:/de";
    }

    @GetMapping("/{id}/edit")
    public String showEdition(Model model, @PathVariable("id") int id) {
        model.addAttribute("de", departmentEmployeeService.findById(id));
        return "de/edit";
    }

    @PostMapping("/{id}")
    public String edit(@ModelAttribute("de") DepartmentEmployee de) {
        departmentEmployeeService.edit(de);
        return "redirect:/de";
    }

    @GetMapping("/new")
    public String showNew(@ModelAttribute("de") DepartmentEmployee de) {
        return "/de/new";
    }

    @PostMapping("/new")
    public String addNew(@ModelAttribute("de") @Valid DepartmentEmployee de, BindingResult br) {
        deValidator.validate(de, br);
        if (br.hasErrors()) return "/de/new";
        departmentEmployeeService.save(de);
        return "redirect:/de";
    }
}
