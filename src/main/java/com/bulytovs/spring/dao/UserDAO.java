package com.bulytovs.spring.dao;

import com.bulytovs.spring.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public UserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<User> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select u from User u", User.class).getResultList();
    }

    @Transactional(readOnly = true)
    public User show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Transactional
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Transactional
    public void update(int id, User updateUser) {
        Session session = sessionFactory.getCurrentSession();
        User userToBeUpdated = session.get(User.class, id);
        userToBeUpdated.setName(updateUser.getName());
        userToBeUpdated.setLastName(updateUser.getLastName());
        userToBeUpdated.setAge(updateUser.getAge());
        userToBeUpdated.setEmail(updateUser.getEmail());
        userToBeUpdated.setPhoneNumber(updateUser.getPhoneNumber());
        userToBeUpdated.setAddress(updateUser.getAddress());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(User.class, id));
    }
}
