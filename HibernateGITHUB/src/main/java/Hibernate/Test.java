package Hibernate;

import Bean.Annonce;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class Test {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Session session = null;

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            List<Annonce> annonce = session.createCriteria(Annonce.class).list();
            System.out.println("With CRITERIA API : personnes : "+annonce.size());

            List<Annonce> annonceHQL = session.createQuery("FROM Annonce").list();
            System.out.println("WITH HQL QUERY : personnesHQL : "+annonceHQL.size());

            List<Annonce> annonceSQL = session.createSQLQuery("select * from Annonce").list();
            System.out.println("WITH SQL QUERY : personnesSQL : "+annonceSQL.size());

            tx.commit();
            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

}
