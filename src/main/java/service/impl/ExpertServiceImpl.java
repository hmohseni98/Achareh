package service.impl;

import model.Expert;
import model.enumration.AccountStatus;
import repository.ExpertRepository;
import service.ExpertService;
import service.base.BaseServiceImpl;
import java.util.List;

public class ExpertServiceImpl extends BaseServiceImpl<ExpertRepository, Expert, Integer> implements ExpertService {
    private final ExpertRepository expertRepository;

    public ExpertServiceImpl(ExpertRepository expertRepository) {
        super(expertRepository, Expert.class);
        this.expertRepository = expertRepository;
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
    public List<Expert> findAllByStatus(AccountStatus status) {
        List<Expert> expertList;
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
    public List<Expert> findAllByCategory(String categoryName) {
        List<Expert> expertList;
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
}
