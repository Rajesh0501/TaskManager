package com.example.customer.customerController;

import com.example.customer.customerEntity.customer;
import com.example.customer.customerEntity.task;
import com.example.customer.customerService.customerService;
import com.example.customer.customerService.taskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class customerController {

    @Autowired
    customerService customerService;

    @Autowired
    taskService taskService;

    @GetMapping("/customerForm")
    public ModelAndView showCustomerList(@RequestParam(required = false) Integer id){

        String viewName = "/customerForm";
        Map<String,Object> model = new HashMap<>();

        if (id==null){
            model.put("customerList",new customer());
        }

        else {
            model.put("customerList", customerService.getCustomerById(id));
        }

        return new ModelAndView(viewName,model);
    }

    @PostMapping("/customerForm")
    public ModelAndView submitCustomerForm(customer customer){
//        Integer id = customer.getId();
//        if (id!=null){
//            customerService.updateCustomer(customer,id);
//            System.out.println(id);
//        }

        Integer id = customer.getId();
//        if (id==null){
//            customerService.create(customer);
//        }
//        else {
//            customerService.updateCustomer(customer,id);
//        }
        customerService.create(customer);
        RedirectView rd = new RedirectView();
        rd.setUrl("/customerList");
        return new ModelAndView(rd);
    }
     @GetMapping("/customerList")
    public ModelAndView getCustomerList(){
        String viewName = "customerList";
        Map<String,Object> model = new HashMap<>();
        model.put("customerListRows",customerService.getAllCustomer());
        model.put("noOfCustomer",customerService.getAllCustomer().size());
        return new ModelAndView(viewName,model);
    }

    @GetMapping("/deleteCustomer/{customerId}")
    public ModelAndView deleteCustomer(@PathVariable Integer customerId) {
        customerService.deleteCustomer(customerId);

        RedirectView rd = new RedirectView();
        rd.setUrl("/customerList");
        return new ModelAndView(rd);
    }



    //this is taskController


    @GetMapping("/taskForm")
    public ModelAndView showTaskList(@RequestParam(required = false) Integer id){

        String viewName = "/taskForm";
        Map<String,Object> model = new HashMap<>();

        if (id==null){
            model.put("taskList",new customer());
        }

        else {
            model.put("taskList", taskService.getCustomerById(id));
        }

        return new ModelAndView(viewName,model);
    }

    @PostMapping("/taskForm")
    public ModelAndView submitTaskForm(task task){
//        Integer id = customer.getId();
//        if (id!=null){
//            customerService.updateCustomer(customer,id);
//            System.out.println(id);
//        }

        // Integer id = task.getId();
//        if (id==null){
//            customerService.create(customer);
//        }
//        else {
//            customerService.updateCustomer(customer,id);
//        }
        taskService.create(task);
        RedirectView rd = new RedirectView();
        rd.setUrl("/taskList");
        return new ModelAndView(rd);
    }
    @GetMapping("/taskList")
    public ModelAndView getTaskList(){
        String viewName = "taskList";
        Map<String,Object> model = new HashMap<>();
        model.put("taskListRows",taskService.getAllCustomer());
        model.put("noOftask",taskService.getAllCustomer().size());
        return new ModelAndView(viewName,model);
    }



}
