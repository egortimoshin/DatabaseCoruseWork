package CourseDB.code.repositories;

import CourseDB.code.models.Department;
import CourseDB.code.models.DepartmentEmployee;
import CourseDB.code.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentEmployeeRepository extends JpaRepository<DepartmentEmployee, Integer> {
    List<DepartmentEmployee> findDepartmentEmployeeByDepartment(Department department);

    List<DepartmentEmployee> findDepartmentEmployeeByEmployee(Employee employee);
}
