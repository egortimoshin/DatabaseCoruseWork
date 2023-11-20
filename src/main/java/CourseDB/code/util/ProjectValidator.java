package util;

import CourseDB.code.models.Project;
import CourseDB.code.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

@Component
public class ProjectValidator implements Validator {
    private final ProjectService projectService;

    @Autowired
    public ProjectValidator(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Project.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Project project = (Project)  target;
        if (Objects.isNull(project.getDateBeg())) {
            errors.rejectValue("dateBeg", "", "date_beg is null");
        }
        else if (project.getDateBeg().after(project.getDateEnd())) {
            errors.rejectValue("dateEnd", "", "date_end is before date_beg");
        }
    }
}
