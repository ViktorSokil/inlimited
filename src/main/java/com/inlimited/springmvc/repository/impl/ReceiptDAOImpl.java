package com.inlimited.springmvc.repository.impl;

import com.inlimited.springmvc.entity.Receipt;
import com.inlimited.springmvc.repository.api.IReceiptDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository("receiptDAO")
@Transactional
public class ReceiptDAOImpl implements IReceiptDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Receipt saveReceipt(Receipt receipt) {
        return (Receipt) currentSession().merge(receipt);
    }

    @Override
    public Receipt findReceiptById(Long receipt_id) {
        return currentSession().find(Receipt.class, receipt_id);
    }

    @Override
    public List<Receipt> findAllReceipt() {
        CriteriaQuery<Receipt> criteria=getCriteriaBuilder().createQuery(Receipt.class);
        Root<Receipt> root=criteria.from(Receipt.class);
        criteria.select(root);
        return currentSession().createQuery(criteria).getResultList();
    }

    @Override
    public void updateReceipt(Receipt receipt) {
        currentSession().update(receipt);
    }

    @Override
    public void deleteReceipt(Integer receiptId) {
        /*Query query = currentSession().createQuery("delete from Receipt where receiptId = "receiptId);
        query.executeUpdate();*/

        CriteriaDelete<Receipt> delete = getCriteriaBuilder().createCriteriaDelete(Receipt.class);
        Root<Receipt> root=delete.from(Receipt.class);
        delete.where(root.get("receiptId"));
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    private CriteriaBuilder getCriteriaBuilder(){
        return currentSession().getCriteriaBuilder();
    }
}
