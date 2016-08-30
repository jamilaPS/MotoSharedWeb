package com.tads.motoshared.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class GenericDAO {
	 private EntityManager em = Conexao.getConexao().getEm();

	    /**
	     * Insere registro no banco de dados.
	     *
	     * @param obj
	     * @return boolean
	     */
	    public boolean inserir(Object obj) {
	        boolean resultado = false;
	        try {

	                em.getTransaction().begin();

	            em.persist(obj);
	            em.getTransaction().commit();
	            resultado = true;
	        } catch (Exception e) {
	            em.getTransaction().rollback();
	            e.printStackTrace();
	            resultado = false;
	        }
	        return resultado;
	    }

	    /**
	     * Altera registro no banco de dados.
	     *
	     * @param obj
	     * @return boolean
	     */
	    public boolean alterar(Object obj) {
	        boolean resultado = false;
	        try {
	            em.getTransaction().begin();
	            em.merge(obj);
	            em.getTransaction().commit();
	            resultado = true;
	        } catch (Exception e) {
	            em.getTransaction().rollback();
	            e.printStackTrace();
	            resultado = false;
	        }
	        return resultado;
	    }

	    /**
	     * Retorna todos os objetos encontrados com status = true.
	     * @param classe
	     * @return {@link List}
	     */
	    public List buscarTodos(Class classe) {
	        Query q = null;
	        try {
//	            if (!em.getTransaction().isActive()) {
	                em.getTransaction().begin();
//	            }
	            q = em.createQuery("from " + classe.getSimpleName() + " order by id");
	            em.getTransaction().commit();
	        } catch (Exception e) {
	            em.getTransaction().rollback();
	            e.printStackTrace();
	        }
	        List resultado = q.getResultList();
	        if(resultado.size() > 0){
	        	return resultado;
	        }
	        else{
	        	return new ArrayList<>();
	        }
	    }
	    
	    /**
	     * Retorna o objeto por id.
	     * @param classe
	     * @param id
	     * @return {@link List}
	     */
	    public Object buscarPorId(Class classe, Long id) {
	        Object obj = null;
	        em.getTransaction().begin();
	        obj = em.find(classe, id);
	        em.getTransaction().commit();
	        return obj;
	    }

	    /**
	     * Exclui registro no banco de dados.
	     *
	     * @param obj
	     * @return boolean
	     */
	    public boolean excluir(Object obj) {
	        boolean resultado = false;
	        try {
	            em.getTransaction().begin();
	            em.remove(obj);
	            em.getTransaction().commit();
	            resultado = true;
	        } catch (Exception e) {
	            em.getTransaction().rollback();
	            e.printStackTrace();
	            resultado = false;
	        }
	        return resultado;
	    }
}
