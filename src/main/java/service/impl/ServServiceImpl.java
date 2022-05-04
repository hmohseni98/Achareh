package service.impl;

import customException.ServiceNameAlreadyExist;
import model.Category;
import model.Service;
import repository.ServiceRepository;
import service.ServService;
import service.base.BaseServiceImpl;

import java.util.List;

public class ServServiceImpl extends BaseServiceImpl<ServiceRepository, Service, Integer> implements ServService {
    private final ServiceRepository serviceRepository;

    public ServServiceImpl(ServiceRepository serviceRepository) {
        super(serviceRepository, Service.class);
        this.serviceRepository = serviceRepository;
    }

    @Override
    public void save(Service service) {
        try {
            super.save(service);
            if (service.getId() == null)
                throw new ServiceNameAlreadyExist();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Service> findAllByCategory(Category category) {
        List<Service> serviceList;
        try (var session = getSessionFactory().getCurrentSession()) {
            var transaction = session.beginTransaction();
            try {
                serviceList = serviceRepository.findAllByCategory(category);
                transaction.commit();
            } catch (Exception ex) {
                transaction.rollback();
                System.out.println(ex.getMessage());
                return null;
            }
        }
        return serviceList;
    }
}
