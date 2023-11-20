package CourseDB.code.services;

import CourseDB.code.models.Department;
import CourseDB.code.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentService  {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> findAll(){
        return departmentRepository.findAll();
    }

    public Department findById(int id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
        departmentRepository.deleteById(id);
    }

    public void edit(Department newDepartment) {
        Department oldDepartment = findById(newDepartment.getId());
        oldDepartment.setName(newDepartment.getName());
        departmentRepository.save(oldDepartment);
    }

    public void save(Department department) {
        departmentRepository.save(department);
    }
}
