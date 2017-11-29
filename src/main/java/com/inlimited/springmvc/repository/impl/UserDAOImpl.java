package com.inlimited.springmvc.repository.impl;

import com.inlimited.springmvc.entity.User;
import com.inlimited.springmvc.repository.api.IUserDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements IUserDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User saveUser(User user) {
        return (User) currentSession().merge(user);
    }

    @Override
    public User findUserById(Long user_id) {
        return  currentSession().find(User.class, user_id);
    }

    @Override
    public List<User> findAllUsers() {
        CriteriaBuilder criteriaBuilder = currentSession().getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        CriteriaQuery<User> all = criteriaQuery.select(root);
        TypedQuery<User> allQuery = currentSession().createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public void updateUser(User user) {
        currentSession().update(user);
    }

    @Override
    public void deleteUser(Long userId) {
        /*Query query = currentSession().createQuery("delete from Product where productId = "+productId);
        query.executeUpdate();*/

        CriteriaDelete<User> delete = getCriteriaBuilder().createCriteriaDelete(User.class);
        Root<User> root=delete.from(User.class);
        delete.where(root.get("userId"));
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    private CriteriaBuilder getCriteriaBuilder(){
        return currentSession().getCriteriaBuilder();
    }
}
