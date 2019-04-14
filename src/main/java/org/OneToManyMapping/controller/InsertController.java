package org.OneToManyMapping.controller;


import org.OneToManyMapping.model.Employee;
import org.OneToManyMapping.model.EmployeeDetail;
import org.OneToManyMapping.model.KYCDocument;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/")
public class InsertController {

    SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class).
            addAnnotatedClass(EmployeeDetail.class).addAnnotatedClass(KYCDocument.class).buildSessionFactory();
    @RequestMapping("/data")
    public String insertData(Model model){

        try {

            List<KYCDocument> documentList = new ArrayList<KYCDocument>();
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Employee employee_1 = new Employee("Arul","Software developer");
            EmployeeDetail employeeDetail_1 = new EmployeeDetail("java",4L);
            employee_1.setEmployeeDetail(employeeDetail_1);

            KYCDocument kycDocument_1= new KYCDocument("PAN CARD","AYSJDK");
            KYCDocument kycDocument_2= new KYCDocument("ADHAAR CARD","AYSJDK1213456789");
            documentList.add(kycDocument_1);
            documentList.add(kycDocument_2);
            kycDocument_1.setEmployee(employee_1);
            kycDocument_2.setEmployee(employee_1);

//            employee_1.setDocumentList(documentList);
            Employee employee_2= new Employee("Suju","Software developer");
            EmployeeDetail employeeDetail_2 = new EmployeeDetail("c++",2L);
            employee_2.setEmployeeDetail(employeeDetail_2);
            session.save(employee_1);
            session.save(employee_2);
            session.save(kycDocument_1);
            session.save(kycDocument_2);
            model.addAttribute("msg","sucessfully saved");
            session.getTransaction().commit();
            session.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return "sucess";

    }

    @RequestMapping("/fetch")
    public String fetchDetail(Model model){

        List<Employee> employees = new ArrayList<Employee>();
        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            employees = (ArrayList<Employee>)session.createQuery("from Employee").list();

            for(Employee e : employees){
                System.out.println(e.toString());
            }
            model.addAttribute("listOfEmployee",employees);
            session.getTransaction().commit();
            session.close();

        }catch (Exception e){
             e.printStackTrace();
        }
      return "display";
    }

    @RequestMapping("/fetchDetail")
    public String fetchEmployeeDetail(Model model){

        List<EmployeeDetail> employees = new ArrayList<EmployeeDetail>();
        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            employees = (ArrayList<EmployeeDetail>)session.createQuery("from EmployeeDetail").list();

            for(EmployeeDetail e : employees){
                System.out.println(e.getEmployee().toString());
            }
            model.addAttribute("listOfEmployee1",employees);
            session.getTransaction().commit();
            session.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return "displayDetail";
    }

}
