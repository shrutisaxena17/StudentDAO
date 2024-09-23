package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
   private EntityManager entityManager;

   //inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }


    //override the save method -> to save the data into the database
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student  findById(Integer id){
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll(){
        TypedQuery<Student> theQuery= entityManager.createQuery("FROM Student", Student.class);
        List<Student> students= theQuery.getResultList();
        return students;
    }

    @Override
    public List<Student> findByLastName(){
        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student where lastName='Saxena'",Student.class);
        List<Student> students= theQuery.getResultList();
        return students;
    }

    @Override
    public  List<Student> findByLastName(String theLastName){
        //using named parameters
        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student where lastName=:theData",Student.class);
        theQuery.setParameter("theData",theLastName);
        List<Student> students= theQuery.getResultList();
        return students;
    }

    @Override
    @Transactional
    public void update(Student theStudent){
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id){
        Student student = entityManager.find(Student.class,id);
        entityManager.remove(student);
    }
}










