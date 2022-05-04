package repository;

import model.Expert;
import model.enumration.AccountStatus;

import java.util.List;

public interface ExpertRepository extends BasePersonRepository<Expert, Integer> {
    List<Expert> findAllByStatus(AccountStatus status);

    List<Expert> findAllByCategory(String categoryName);
}
