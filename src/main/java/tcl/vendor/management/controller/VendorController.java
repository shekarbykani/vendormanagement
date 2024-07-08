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

import tcl.vendor.management.model.Vendor;
import tcl.vendor.management.respositories.VendorRepository;

@RestController
public class VendorController {
	
	
	@Autowired
	private VendorRepository vendorRepository;
		
	@GetMapping("/vendor")
	public List<Vendor> showAll(){
		
		return vendorRepository.findAll();
	}
	
	@PostMapping("/vendor")
	public String addVendor(@RequestBody Vendor vendor) {
		
		
		vendorRepository.save(vendor);
		return "Inserted successfully";
		
	}
	
	@PutMapping("vendor")	
	public String updateVendor(@RequestBody Vendor newVendor) {
		
		try {
			 Vendor oldVendor =   vendorRepository.findById(newVendor.getVendorId()).get();
			 oldVendor.setVendorName(newVendor.getVendorName());
			 oldVendor.setAddress(newVendor.getAddress());
			 oldVendor.setContactno(newVendor.getContactno());
			 vendorRepository.save(oldVendor);
			 return "updated successfully..";
			 
		}
		catch(Exception e) {
			return "No record found....";
		}
				
	}
		
	@DeleteMapping("vendor/{vendorId}")

	public String deleteVendor(@PathVariable("vendorId")int vendorId) {
		
		
		try {
		 Vendor vendor =   vendorRepository.findById(vendorId).get();
		
		 vendorRepository.delete(vendor);
		 return "successfully Deleted...";
		}
		catch(Exception e) {
			
			return "No Record Found...";
		}
	}
	
}
