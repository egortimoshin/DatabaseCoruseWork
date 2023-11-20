package CourseDB.code.controllers;

import CourseDB.code.extra.Task1;
import CourseDB.code.extra.Task2;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import CourseDB.code.extra.DAO;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/tasks")
@Controller
public class TaskController {
    private final DAO dao;

    public TaskController(DAO dao) {
        this.dao = dao;
    }

    @GetMapping("/1")
    public String first(Model model) {
        List<Task1> list = dao.task1();
        model.addAttribute("list", list);
        return "tasks/1";
    }

    @GetMapping("/2")
    public String second(Model model) {
        List<Task2> list = dao.task2();
        model.addAttribute("list", list);
        return "tasks/2";
    }
}
