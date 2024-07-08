package tcl.vendor.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tcl.vendor.management.model.Customer;
import tcl.vendor.management.respositories.CustomerRepository;


@RestController
public class CustomerController {
	
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/customer")
	public List<Customer> showAll() {
		return customerRepository.findAll();
	}

	@PostMapping("/customer")
	public String Addcustomer(@RequestBody Customer Customer) {
	customerRepository.save(Customer);
	return "Inserted   successfully ";
	}
	
	
	@PutMapping("/customer")
	public String updatecustomer(@RequestBody Customer newcustomer) {
		try {
			
			Customer oldcustomer=customerRepository.findById(newcustomer.getCustomerId()).get();
			
			oldcustomer.setCustomername(newcustomer.getCustomername());
			oldcustomer.setCustomeraddress(newcustomer.getCustomeraddress());
			oldcustomer.setContactno(newcustomer.getContactno());
			customerRepository.save(oldcustomer);
			return " updated successfully";
		}
		catch(Exception e) {
			return "no records found";
		}
	}	
	
	@DeleteMapping("/customer/{customerId}")
	
	public  String deletecustomer(@PathVariable("customerId")int customerId) {
	try {
		 
		  Customer customer= customerRepository.findById(customerId).get();
		customerRepository.delete(customer);
		return " successfully deleted..";
	}
	catch(Exception e) {
		return" no record found";
	}
	
	}
}
	
	
