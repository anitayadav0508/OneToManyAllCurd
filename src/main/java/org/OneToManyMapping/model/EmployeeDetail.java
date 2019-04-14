package org.OneToManyMapping.model;

import org.OneToManyMapping.model.Employee;

import javax.persistence.*;

@Entity
@Table(name = "emp_detail")
public class EmployeeDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "skill")
    private String skills;
    @Column(name = "exp")
    private Long experience;

    @OneToOne(mappedBy = "employeeDetail")
    private Employee employee;

    public EmployeeDetail() {
    }

    public EmployeeDetail(String skills, Long experience) {
        this.skills = skills;
        this.experience = experience;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public Long getExperience() {
        return experience;
    }

    public void setExperience(Long experience) {
        this.experience = experience;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
