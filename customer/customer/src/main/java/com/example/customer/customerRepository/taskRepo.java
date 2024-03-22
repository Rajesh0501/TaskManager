package com.example.customer.customerRepository;

import com.example.customer.customerEntity.task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface taskRepo extends JpaRepository<task,Integer> {
}
