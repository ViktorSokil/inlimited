package com.inlimited.springmvc.repository.impl;

import com.inlimited.springmvc.entity.Product;
import com.inlimited.springmvc.entity.User;
import com.inlimited.springmvc.repository.api.IProductDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements IProductDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveProduct(Product product) {
        currentSession().saveOrUpdate(product);
    }

    @Override
    public Product findProductById(int product_id) {
        return currentSession().find(Product.class, product_id);
    }

    @Override
    public List<Product> findAllProducts() {
        /*CriteriaBuilder criteriaBuilder = currentSession().getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);
        CriteriaQuery<Product> all = criteriaQuery.select(root);
        TypedQuery<Product> allQuery = currentSession().createQuery(all);
        return allQuery.getResultList();*/

        CriteriaQuery<Product> criteria=getCriteriaBuilder().createQuery(Product.class);
        Root<Product> root=criteria.from(Product.class);
        criteria.select(root);
        return currentSession().createQuery(criteria).getResultList();
    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void deleteProduct(Integer productId) {

    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    private CriteriaBuilder getCriteriaBuilder(){
        return currentSession().getCriteriaBuilder();
    }
}
