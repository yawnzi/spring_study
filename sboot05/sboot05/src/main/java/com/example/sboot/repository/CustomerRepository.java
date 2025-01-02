package com.example.sboot.repository;

import com.example.sboot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //JpaRepository에서 제공해주는 기본 CRUD Method
    //CrudRepository

    //save() -> insert SQL

    //findAll() -> select SQL


}
