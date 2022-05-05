package repository;

import model.Expert;
import model.enumration.AccountStatus;
import service.dto.ExpertDTO;

import java.util.List;

public interface ExpertRepository extends BasePersonRepository<Expert, Integer> {
    List<ExpertDTO> findAllByStatus(AccountStatus status);

    List<ExpertDTO> findAllByCategory(String categoryName);

    List<Expert> girdSearch(Integer id, String firstName, String lastName, String email,String serviceName);

}
