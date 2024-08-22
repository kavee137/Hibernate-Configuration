package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.embed.FullName;
import lk.ijse.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        FullName name = new FullName("Kaveesha","Rukshan");
        Student student = new Student();
        student.setId(3);
        student.setName(name);
        student.setAddress("Galle");

        Transaction transaction = session.beginTransaction();

//        save
        session.save(student);
//        delete
//        session.delete(student);
        Student student1 = session.get(Student.class,1);
        System.out.println(student1.toString());
        transaction.commit();
        session.close();
    }
}