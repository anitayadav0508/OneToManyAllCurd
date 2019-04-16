package org.OneToManyMapping.model;

import javax.persistence.*;

@Entity
@Table(name = "document")
public class KYCDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
   private Long id;
    @Column(name = "documentname")
   private String documentName;
    @Column(name = "documnentNumber")
   private String documentNumber;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="emp_id")
    private Employee employee;

    public KYCDocument() {
    }

    public KYCDocument(String documentName, String documentNumber) {
        this.documentName = documentName;
        this.documentNumber = documentNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "KYCDocument{" +
                "id=" + id +
                ", documentName='" + documentName + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", employee=" + employee +
                '}';
    }
}
