package org.OneToManyMapping.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectid")
    private  Long projectId;
    @Column(name = "projectname")
    private  String projectName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "emp_project_detail",joinColumns ={@JoinColumn(name = "p_id")},inverseJoinColumns = {@JoinColumn(name = "e_id")})
    List<Employee> employeeList;

    public Project() {
    }

    public Project(String projectName) {
        this.projectName = projectName;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
