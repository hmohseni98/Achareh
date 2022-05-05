package service;

import model.Expert;
import model.enumration.AccountStatus;
import service.base.BaseService;
import service.dto.ExpertDTO;

import java.util.List;

public interface ExpertService extends BaseService<Expert, Integer> {
    Expert login(String email, String password);

    Expert findByEmail(String email);

    List<ExpertDTO> findAllByStatus(AccountStatus status);

    List<ExpertDTO> findAllByCategory(String categoryName);

    List<Expert> girdSearch(Integer id, String firstName, String lastName, String email,String serviceName);

}
