package service.impl;

import model.Expert;
import repository.ExpertRepository;
import service.ExpertService;
import service.base.BaseServiceImpl;

public class ExpertServiceImpl extends BaseServiceImpl<ExpertRepository, Expert,Integer> implements ExpertService {
    public ExpertServiceImpl(ExpertRepository repository) {
        super(repository,Expert.class);
    }
}
