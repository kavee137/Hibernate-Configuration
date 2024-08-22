package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.embed.FullName;
import lk.ijse.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();

        FullName fullName = new FullName("Kaveesha", "Rukshan");

        Student student = new Student();
        student.setId(1);
        student.setName(fullName);
        student.setAddress("Agalawatta");
        //open transaction
        Transaction transaction = session.beginTransaction();

        session.save(student);
        //delete, get another table
        transaction.commit();
        session.close();
    }
}