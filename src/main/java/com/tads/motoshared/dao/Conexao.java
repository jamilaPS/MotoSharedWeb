package com.tads.motoshared.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.jpa.internal.EntityManagerImpl;

public class Conexao{
    //atributos
    private static Conexao conexao;
    private EntityManager em;

    //construtor
    public Conexao() {
        em = Persistence.createEntityManagerFactory("MotoSharedWeb").createEntityManager();
    }

    //métodos de acesso
    public synchronized static Conexao getConexao() {
        if (conexao == null) {
            conexao = new Conexao();
        }
        return conexao;
    }

    public EntityManager getEm() {
        return em;
    }

    public Connection getConnection(){
        EntityManagerImpl factory = (EntityManagerImpl) em;
             SessionFactoryImpl sessionFactoryImpl = (SessionFactoryImpl) factory.getSession().getSessionFactory();
         try {
             return sessionFactoryImpl.getConnectionProvider().getConnection();
         } catch (SQLException ex) {
             Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
     }
}