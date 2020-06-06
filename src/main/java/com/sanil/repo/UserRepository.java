package com.sanil.repo;

import com.sanil.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserRepository {

    @PersistenceContext
    EntityManager entityManager;

    public User save(User user) {
        return entityManager.merge(user);
    }

    public User findById(int id) {
        return entityManager.find(User.class, id);
    }

    public List<User> findAll() {
        TypedQuery<User> findAllQuery = (TypedQuery<User>) entityManager.createNamedQuery("find_all");
        return findAllQuery.getResultList();
    }

    public User update(User user) {
        return entityManager.merge(user);
    }

    public void delete(User user) {
        if (entityManager.contains(user)) {
            entityManager.remove(user);
        }
    }
}
