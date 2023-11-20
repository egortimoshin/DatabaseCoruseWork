package CourseDB.code.services;

import CourseDB.code.models.Employee;
import CourseDB.code.models.Project;
import CourseDB.code.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project findById(int id) {
        return projectRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
        projectRepository.deleteById(id);
    }

    public void edit(Project newProject) {
        Project oldProject = findById(newProject.getId());
        oldProject.setName(newProject.getName());
        oldProject.setCost(newProject.getCost());
        oldProject.setDepartment(newProject.getDepartment());
        oldProject.setDateBeg(newProject.getDateBeg());
        oldProject.setDateEnd(newProject.getDateEnd());
        oldProject.setDateEndReal(newProject.getDateEndReal());
        projectRepository.save(oldProject);
    }

    public void save(Project project) {
        projectRepository.save(project);
    }
}
