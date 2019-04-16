package org.OneToManyMapping.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long empId;
    @Column(name = "empName")
    private String employeeName;
    @Column(name = "designation")
    private String designation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_detailId")
    private EmployeeDetail employeeDetail;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employee",fetch = FetchType.LAZY)
    private List<KYCDocument> documentList;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "emp_project_detail",joinColumns = {@JoinColumn(name = "e_id")},inverseJoinColumns = {@JoinColumn(name = "p_id")})
    private List<Project> projectList;

    public Employee() {
    }

    public Employee(String employeeName, String designation) {
        this.employeeName = employeeName;
        this.designation = designation;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public EmployeeDetail getEmployeeDetail() {
        return employeeDetail;
    }

    public void setEmployeeDetail(EmployeeDetail employeeDetail) {
        this.employeeDetail = employeeDetail;
    }

    public List<KYCDocument> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(List<KYCDocument> documentList) {
        this.documentList = documentList;
    }


    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    @Override
    public String toString() {
        return "org.OneToManyMapping.model.Employee{" +
                "empId=" + empId +
                ", employeeName='" + employeeName + '\'' +
                ", designation='" + designation + '\'' +
                ", employeeDetail=" + employeeDetail +
                '}';
    }
}
