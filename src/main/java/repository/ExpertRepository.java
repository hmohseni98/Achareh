package repository;

import model.Expert;
import model.enumration.AccountStatus;
import repository.base.BaseRepository;
import service.dto.ExpertDTO;

import java.util.List;

public interface ExpertRepository extends BaseRepository<Expert, Integer> {
    List<ExpertDTO> findAllByStatus(AccountStatus status);

    List<ExpertDTO> findAllByCategory(String categoryName);


}
