package CourseDB.code.controllers;

import CourseDB.code.models.Department;
import CourseDB.code.models.Employee;
import CourseDB.code.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/employees")
@Controller
@ComponentScan("services")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public String showAll(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employee/showAllEmployees";
    }

    @GetMapping("/{id}")
    public String showEmployee(Model model, @PathVariable("id") int id) {
        model.addAttribute("employee", employeeService.findById(id));
        return "employee/show";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }

    @GetMapping("/{id}/edit")
    public String showEdition(Model model, @PathVariable("id") int id) {
        model.addAttribute("employee", employeeService.findById(id));
        return "employee/edit";
    }

    @PostMapping("/{id}")
    public String edit(@ModelAttribute("employee") Employee employee) {
        employeeService.edit(employee);
        return "redirect:/employees";
    }

    @GetMapping("/new")
    public String showNew(@ModelAttribute("employee") Employee employee) {
        return "/employee/new";
    }

    @PostMapping("/new")
    public String addNew(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }
}
