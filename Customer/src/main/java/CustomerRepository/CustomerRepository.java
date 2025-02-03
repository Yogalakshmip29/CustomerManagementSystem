package CustomerRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Customer;

@Repository(value="rep")
public interface CustomerRepository extends CrudRepository<Customer,Integer>{

}
