package service;

import model.Customer;
import model.Expert;
import model.enumration.AccountStatus;
import service.base.BaseService;

import java.util.List;

public interface ExpertService extends BaseService<Expert, Integer> {
    Expert login(String email, String password);

    Expert findByEmail(String email);

    List<Expert> findAllByStatus(AccountStatus status);

    List<Expert> findAllByCategory(String categoryName);
}
