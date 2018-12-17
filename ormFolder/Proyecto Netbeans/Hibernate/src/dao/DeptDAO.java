/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Dept;
import java.util.HashSet;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author alumno
 */
public class DeptDAO {
    static Session session = null;
    
    public static void insert(Dept d){
        session = SessionFactoryUtil.createSessionFactory().openSession();
        
        Transaction tx = session.beginTransaction();
        session.save(d);
        tx.commit();
        
        //session.flush();
        session.close();
    }
    
    public static void main(String[]args){
        Dept d = new Dept((byte)50, "TEST", "Madrid", new HashSet());
        insert(d);
    }
}
