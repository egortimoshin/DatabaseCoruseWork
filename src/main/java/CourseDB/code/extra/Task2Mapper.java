package CourseDB.code.extra;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Task2Mapper implements RowMapper<Task2> {
    @Override
    public Task2 mapRow(ResultSet rs, int rowNum) throws SQLException {
        Task2 task2 = new Task2();
        task2.setProjectId(rs.getInt("project_id"));
        task2.setProjectName(rs.getString("project_name"));
        return task2;
    }
}