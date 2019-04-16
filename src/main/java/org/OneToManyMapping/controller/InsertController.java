package org.OneToManyMapping.controller;


import org.OneToManyMapping.model.Employee;
import org.OneToManyMapping.model.EmployeeDetail;
import org.OneToManyMapping.model.KYCDocument;
import org.OneToManyMapping.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/")
public class InsertController {

    SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class).
            addAnnotatedClass(EmployeeDetail.class).addAnnotatedClass(KYCDocument.class).addAnnotatedClass(Project.class).buildSessionFactory();
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

    @RequestMapping("/fetchDocumnet")
    private String fetchDocumentDetail(Model model){

        List<Employee> employees = new ArrayList<Employee>();
        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            employees = (ArrayList<Employee>)session.createQuery("from Employee").list();

           /* for(Employee e : employees){
                System.out.println(e.getDocumentList().toString());
            }*/
            model.addAttribute("listofDocument",employees);
            session.getTransaction().commit();
            session.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return "documentList";
    }

    @RequestMapping("/kycDetail")
    private String fetchKYC(Model model){
        List<KYCDocument> kycDocuments = new ArrayList<KYCDocument>();
        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            kycDocuments = (ArrayList<KYCDocument>)session.createQuery("from KYCDocument").list();

            for(KYCDocument kycDocument : kycDocuments){
                System.out.println(kycDocument.getEmployee().toString());
            }
            model.addAttribute("listOfkycdocument",kycDocuments);
            session.getTransaction().commit();
            session.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return "kycList";
    }


    @RequestMapping("/deleteEmployee")
    private String deleteEmployee(@RequestParam(name = "id") Long id,Model model){

      Session session =   sessionFactory.getCurrentSession();
      session.beginTransaction();

      Employee employee = (Employee) session.get(Employee.class,id);

      session.delete(employee);
      session.getTransaction().commit();
      session.close();

      model.addAttribute("msg","deleted Sucessfully" + id);
      return "delete";

    }


    @RequestMapping(name = "/assignedProject")
    private String project_empDetails(Model model){
        List<Employee> employeeList= new ArrayList<Employee>();

        List<Project> projects = new ArrayList<Project>();


       Session session =  sessionFactory.getCurrentSession();
       session.beginTransaction();

        Project project_1 =new Project("Banking Projects");
        Project project_2 =new Project("IT Projects");

        Employee employee_1 = new Employee("Arul","developer");
        Employee employee_2 = new Employee("Ankita","developer");
//        employeeList.add(employee_1);
//        employeeList.add(employee_2);

//        project_1.setEmployeeList(employeeList);
//        session.save(project_1);
//        session.save(employee_1);
//        session.save(employee_2);


     /*   projects.add(project_1);
        projects.add(project_2);
        employee_1.setProjectList(projects);
        session.save(employee_1);*/

     employee_1.setProjectList(projects);
     employee_1.getProjectList().add(project_1);
     employee_1.getProjectList().add(project_2);
     session.save(employee_1);
//     session.save(project_1);
//     session.save(project_2);
        session.getTransaction().commit();
        session.close();
        model.addAttribute("msg","Assigned Project Sucessfully");

        return "projectList";
    }

}
