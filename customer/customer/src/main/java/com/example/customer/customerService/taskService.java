package com.example.customer.customerService;

import com.example.customer.customerEntity.customer;
import com.example.customer.customerEntity.task;
import com.example.customer.customerRepository.customerRepo;
import com.example.customer.customerRepository.taskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class taskService {
    @Autowired
    taskRepo taskRepo;


    public void create(task task){
        taskRepo.save(task);
    }
    public List<task> getAllCustomer(){
        return taskRepo.findAll();
    }

    public task getCustomerById(Integer id) {
        return taskRepo.findById(id).get();
    }

//    public void updateCustomer(customer customer, Integer id) {
//        customer customerToUpdate = getCustomerById(id);
//        customerToUpdate.setAddress(customer.getAddress());
//        customerToUpdate.setCity(customer.getCity());
//        customerToUpdate.setEmail(customer.getEmail());
//        customerToUpdate.setPhone(customer.getPhone());
//        customerToUpdate.setFirstName(customer.getFirstName());
//        customerToUpdate.setLastName(customer.getLastName());
//        customerToUpdate.setStreet(customer.getStreet());
//        customerToUpdate.setState(customer.getState());
//        customerRepo.save(customerToUpdate);
//    }


//    public void deleteCustomer(Integer customerId) {
//        taskRepo.deleteById(customerId);
//    }
}
