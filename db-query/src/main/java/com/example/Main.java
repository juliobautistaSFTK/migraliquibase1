package com.example.modelo;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Medidas2 medida = new Medidas2();
            medida.setIdd(1);
            medida.setTipo(1);
            medida.setCantidad((short) 10);
            medida.setTipoCambio("USD");
            session.save(medida);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
