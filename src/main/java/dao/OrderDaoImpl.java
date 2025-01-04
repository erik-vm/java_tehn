package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public Order saveOrder(Order order) {
        if (order.getId() == null) {
            em.persist(order);
        } else {
            em.merge(order);
        }
        return order;
    }

    @Override
    public List<Order> getAllOrders() {
        return em.createQuery("select o from Order o", Order.class).getResultList();

    }

    @Transactional
    @Override
    public void deleteOrderById(Integer id) {
        Query query = em.createQuery("delete from Order p where p.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();

    }


    @Transactional
    @Override
    public Order findOrderById(int id) {
        TypedQuery<Order> query = em.createQuery("select p from Order p where p.id = :id", Order.class);

        query.setParameter("id", id);


        return query.getSingleResult();
    }


}
