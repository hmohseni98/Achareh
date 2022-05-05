package repository;

import model.Admin;

import java.util.List;

public interface AdminRepository extends BasePersonRepository<Admin, Integer> {

    List<Admin> gridSearch(Integer id, String firstName, String lastName, String email);

}
