package service.impl;

import model.Service;
import repository.ServiceRepository;
import service.ServService;
import service.base.BaseServiceImpl;

public class ServServiceImpl extends BaseServiceImpl<ServiceRepository, Service,Integer> implements ServService {
    public ServServiceImpl(ServiceRepository repository) {
        super(repository, Service.class);
    }
}
