package CourseDB.code.services;

import CourseDB.code.models.Department;
import CourseDB.code.models.DepartmentEmployee;
import CourseDB.code.models.Employee;
import CourseDB.code.repositories.DepartmentEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentEmployeeService {
    private final DepartmentEmployeeRepository departmentEmployeeRepository;

    @Autowired
    public DepartmentEmployeeService(DepartmentEmployeeRepository departmentEmployeeRepository) {
        this.departmentEmployeeRepository = departmentEmployeeRepository;
    }

    public List<DepartmentEmployee> findAll() {
        return departmentEmployeeRepository.findAll();
    }

    public DepartmentEmployee findById(int id) {
        return departmentEmployeeRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
        departmentEmployeeRepository.deleteById(id);
    }

    public void edit(DepartmentEmployee newDepartmentEmployee) {
        DepartmentEmployee oldDepartmentEmployee = findById(newDepartmentEmployee.getId());
        oldDepartmentEmployee.setDepartment(newDepartmentEmployee.getDepartment());
        oldDepartmentEmployee.setEmployee(newDepartmentEmployee.getEmployee());
        departmentEmployeeRepository.save(oldDepartmentEmployee);
    }

    public void save(DepartmentEmployee departmentEmployee) {
        departmentEmployeeRepository.save(departmentEmployee);
    }

    public List<DepartmentEmployee> findAllByDep(Department de) {
        return departmentEmployeeRepository.findDepartmentEmployeeByDepartment(de);
    }

    public List<DepartmentEmployee> findAllByEmp(Employee de) {
        return departmentEmployeeRepository.findDepartmentEmployeeByEmployee(de);
    }
}