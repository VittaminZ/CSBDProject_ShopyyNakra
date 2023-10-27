/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Product3;
import model.Shoppingcart3;

/**
 *
 * @author ItipatSongsampansakul
 */
public class CallProductTable {

    
    public static List<Product3> findAllProduct(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        List<Product3> pdList = null;
        try{
            pdList = (List<Product3>) em.createNamedQuery("Product3.findAll").getResultList();
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }finally {
            em.close();
            emf.close();
        }
        return pdList;
    }
   
    public static int findLastestCartID(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        int lastestCartID = 0;
        List<Shoppingcart3> shoppingCartList = null;
        try{
            shoppingCartList = (List<Shoppingcart3>) em.createNamedQuery("Shoppingcart3.findAll").getResultList();
            for(Shoppingcart3 spCart : shoppingCartList){
                if(spCart.getShoppingcart3PK().getCartId() > lastestCartID){
                    lastestCartID = spCart.getShoppingcart3PK().getCartId();
                }
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        } finally {
            em.close();
            emf.close();
        }
        return lastestCartID;
    }
    
    public static Product3 findProductByMovie(String movie){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        Product3 prod = null;
        try{
            prod = (Product3) em.createNamedQuery("Product3.findByMovie").setParameter("movie", movie).getSingleResult();
        } catch (Exception e){
            throw new RuntimeException(e);
        } finally {
            em.close();
            emf.close();
        }
        return prod;
    }

  public static void insertShoppingCart(Shoppingcart3 shoppingCart){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(shoppingCart);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
