package util;

import CourseDB.code.models.DepartmentEmployee;
import CourseDB.code.models.Project;
import CourseDB.code.services.DepartmentEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component
public class DEValidator implements Validator {
    private final DepartmentEmployeeService des;

    @Autowired
    public DEValidator(DepartmentEmployeeService des) {
        this.des = des;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return DepartmentEmployee.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        DepartmentEmployee de = (DepartmentEmployee)  target;
        List<DepartmentEmployee> list = des.findAllByDep(de.getDepartment());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getEmployee().equals(de.getEmployee())) {
                errors.rejectValue("employee", "", "already exists this employee in this der");
            }
        }
    }
}
