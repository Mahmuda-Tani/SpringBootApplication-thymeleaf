package com.example.springbootthymeleafwebApp.repository;

import com.example.springbootthymeleafwebApp.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class searchRepositoryImpl implements  searchRepository{

    @Autowired
    private EntityManager em;

    @Override
    public List<Employee> findBy_(Employee employee) {




        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        List<Predicate> predicates = new ArrayList<>();

        Root<Employee> root =criteriaQuery.from(Employee.class);


        if (employee.getFirstName()!=null){
            Predicate firstNamePredicate = criteriaBuilder
                    .like(root.get("firstName"),"%"+employee.getFirstName()+"%");
            predicates.add(firstNamePredicate);
        }


        if (employee.getLastName()!=null){
            Predicate lastNamePredicate = criteriaBuilder
                    .like(root.get("lastName"),"%"+employee.getLastName()+"%");
            predicates.add(lastNamePredicate);
        }

        if (employee.getEmail()!=null){
            Predicate emailPredicate = criteriaBuilder
                    .like(root.get("firstName"),"%"+employee.getEmail()+"%");
            predicates.add(emailPredicate);
        }

        if (employee.getSalary()!=null){
            Predicate salaryPredicate = criteriaBuilder
                    .like(root.get("salary"),"%"+employee.getSalary()+"%");
            predicates.add(salaryPredicate);
        }


        criteriaQuery.where(
                criteriaBuilder.and(predicates.toArray(new Predicate[0]))
        );


        TypedQuery<Employee> query = em.createQuery(criteriaQuery);

        return query.getResultList();



    }
}
