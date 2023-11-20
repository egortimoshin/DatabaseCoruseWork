package CourseDB.code.extra;

public class Task1 {
    private int employeeId;
    private String departmentName;

    public Task1() {
    }

    public Task1(int employeeId, String departmentName) {
        this.employeeId = employeeId;
        this.departmentName = departmentName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Task1{" +
                "employeeId=" + employeeId +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
