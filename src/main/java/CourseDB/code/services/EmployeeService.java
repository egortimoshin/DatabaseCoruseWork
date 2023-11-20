package CourseDB.code.services;

import CourseDB.code.models.Department;
import CourseDB.code.models.Employee;
import CourseDB.code.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    public void edit(Employee newEmployee) {
        Employee oldEmployee = findById(newEmployee.getId());
        oldEmployee.setFirstName(newEmployee.getFirstName());
        oldEmployee.setPatherName(newEmployee.getPatherName());
        oldEmployee.setLastName(newEmployee.getLastName());
        oldEmployee.setPosition(newEmployee.getPosition());
        oldEmployee.setSalary(newEmployee.getSalary());
        employeeRepository.save(oldEmployee);
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }
}
