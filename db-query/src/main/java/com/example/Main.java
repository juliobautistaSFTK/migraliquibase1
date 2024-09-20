package com.example;

import org.hibernate.Session; 
import org.hibernate.SessionFactory; 
import org.hibernate.cfg.Configuration; 
 
public class Main { 
    public static void main(String[] args) { 
        // Configuración de Hibernate 
        Configuration configuration = new Configuration(); 
        configuration.configure("hibernate.cfg.xml"); 
        configuration.addAnnotatedClass(com.example.Medidas2.class); 
 
        // Creación del SessionFactory 
        SessionFactory sessionFactory = configuration.buildSessionFactory(); 
 
        // Creación de una sesión 
        Session session = sessionFactory.openSession(); 
        session.beginTransaction(); 
 
        // Ejemplo de uso de la entidad Medidas2 
        Medidas2 medidas = new Medidas2(); 
        medidas.setIdd(1); 
        medidas.setTipo(2); 
        medidas.setCantidad((short) 10); 
        medidas.setTipoCambio("Cambio de ejemplo"); 
 
        session.save(medidas); 
        session.getTransaction().commit(); 
        session.close(); 
    } 
}
