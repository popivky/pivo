import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "From " + PurchaseList.class.getSimpleName();

        List<PurchaseList> purchaseLists = session.createQuery(hql).getResultList();


        for(PurchaseList list: purchaseLists){
           String courseName =  list.keyPurchase.getCourseName();
           String studentName = list.keyPurchase.getStudentName();
           Query queryCourse = session.createQuery("from Course where name = :paramName");
           queryCourse.setParameter("paramName", courseName);
           Course course;
           course = (Course) queryCourse.getSingleResult();
           Query queryStudent = session.createQuery("from Student where name = :paramName");
           queryStudent.setParameter("paramName", studentName);
           Student student;
           student = (Student) queryStudent.getSingleResult();

           LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
           linkedPurchaseList.setKeyLinkedPurchaseList(new keyLinkedPurchaseList(student.getId(),course.getId()));

           session.save(linkedPurchaseList);

        }


        transaction.commit();
        sessionFactory.close();
    }

}


