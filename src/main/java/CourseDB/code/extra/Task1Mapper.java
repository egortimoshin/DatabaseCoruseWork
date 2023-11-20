package CourseDB.code.extra;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Task1Mapper implements RowMapper<Task1> {
    @Override
    public Task1 mapRow(ResultSet rs, int rowNum) throws SQLException {
        Task1 task1 = new Task1();
        task1.setEmployeeId(rs.getInt("employee_id"));
        task1.setDepartmentName(rs.getString("department_name"));
        return task1;
    }
}