package com.bilarn.deploycrm.controller;

import com.bilarn.deploycrm.model.Customer;
import com.bilarn.deploycrm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Display the home page with the list of all customers
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listCustomers", customerService.getAllCustomers());
        return "index"; // Renders the 'index.html' template
    }

    // Show the form to add a new customer
    @GetMapping("/showNewCustomerForm")
    public String showNewCustomerForm(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "new_customer"; // Renders the 'new_customer.html' template
    }

    // Save a new or updated customer
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/"; // Redirects back to the home page after saving
    }

    // Show the form to update an existing customer by ID
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "update_customer"; // Renders the 'update_customer.html' template
    }

    // Delete a customer by ID
    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") long id) {
        customerService.deleteCustomer(id);
        return "redirect:/"; // Redirects back to the home page after deletion
    }
}
