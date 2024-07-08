package tcl.vendor.management.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tcl.vendor.management.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{

}
