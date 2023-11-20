package CourseDB.code.extra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Task1> task1() {
        return jdbcTemplate.query("SELECT * FROM employees_in_departments", new Task1Mapper());
    }

    public List<Task2> task2() {
        return jdbcTemplate.query("SELECT * FROM sdeck(1, 3)", new Task2Mapper());
    }
}
