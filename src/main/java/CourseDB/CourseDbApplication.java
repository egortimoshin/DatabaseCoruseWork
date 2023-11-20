package CourseDB;

import CourseDB.code.extra.DAO;
import CourseDB.code.models.Project;
import CourseDB.code.repositories.ProjectRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
public class CourseDbApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(CourseDbApplication.class, args);

	}
}
