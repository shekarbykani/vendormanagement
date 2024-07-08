package tcl.vendor.management.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tcl.vendor.management.model.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer> {

}
