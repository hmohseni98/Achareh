package service.impl;

import customException.OldPasswordIsIncorrect;
import model.Expert;
import model.enumration.AccountStatus;
import repository.impl.ExpertRepositoryImpl;
import service.ExpertService;
import service.base.BaseServiceImpl;
import service.dto.ExpertDTO;

import java.util.List;

public class ExpertServiceImpl extends BaseServiceImpl<ExpertRepositoryImpl, Expert, Integer>
        implements ExpertService {

    private final ExpertRepositoryImpl expertRepository;

    public ExpertServiceImpl(ExpertRepositoryImpl repository) {
        super(repository, Expert.class);
        expertRepository = repository;
    }

    @Override
    public void changePassword(Integer id, String oldPassword, String newPassword) {
        Expert expert;
        expert = super.findById(id);
        try {
            if (!expert.getPassword().equals(oldPassword)) {
                throw new OldPasswordIsIncorrect();
            }
            expert.setPassword(newPassword);
            super.update(expert);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    @Override
    public Expert login(String email, String password) {
        Expert expert;
        try (var session = getSessionFactory().getCurrentSession()) {
            var transaction = session.beginTransaction();
            try {
                expert = expertRepository.login(email, password);
                transaction.commit();
            } catch (Exception ex) {
                transaction.rollback();
                System.out.println(ex.getMessage());
                return null;
            }
        }
        return expert;
    }

    @Override
    public Expert findByEmail(String email) {
        Expert expert;
        try (var session = getSessionFactory().getCurrentSession()) {
            var transaction = session.beginTransaction();
            try {
                expert = expertRepository.findByEmail(email);
                transaction.commit();
            } catch (Exception ex) {
                transaction.rollback();
                System.out.println(ex.getMessage());
                return null;
            }
        }
        return expert;
    }

    @Override
    public List<ExpertDTO> findAllByStatus(AccountStatus status) {
        List<ExpertDTO> expertList;
        try (var session = getSessionFactory().getCurrentSession()) {
            var transaction = session.beginTransaction();
            try {
                expertList = expertRepository.findAllByStatus(status);
                transaction.commit();
            } catch (Exception ex) {
                transaction.rollback();
                System.out.println(ex.getMessage());
                return null;
            }
        }
        return expertList;
    }

    @Override
    public List<ExpertDTO> findAllByCategory(String categoryName) {
        List<ExpertDTO> expertList;
        try (var session = getSessionFactory().getCurrentSession()) {
            var transaction = session.beginTransaction();
            try {
                expertList = expertRepository.findAllByCategory(categoryName);
                transaction.commit();
            } catch (Exception ex) {
                transaction.rollback();
                System.out.println(ex.getMessage());
                return null;
            }
        }
        return expertList;
    }


//    public List<Expert> girdSearch(Integer id, String firstName, String lastName, String email, String serviceName) {
//        List<Expert> expertList;
//        try (var session = getSessionFactory().getCurrentSession()) {
//            var transaction = session.beginTransaction();
//            try {
//                expertList = expertRepository.girdSearch(id, firstName, lastName, email,serviceName);
//                transaction.commit();
//            } catch (Exception ex){
//                transaction.rollback();
//                System.out.println(ex.getMessage());
//                return null;
//            }
//        }
//        return expertList;
//    }


}
