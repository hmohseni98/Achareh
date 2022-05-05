package repository;

import model.Customer;
import repository.base.BaseRepository;

import java.util.List;

public interface CustomerRepository extends BasePersonRepository<Customer,Integer> {

    List<Customer> gridSearch(Integer id, String firstName, String lastName, String email);

}
