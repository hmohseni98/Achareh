package repository.impl;

import model.Admin;
import repository.AdminRepository;
import repository.PersonRepository;
import repository.base.BaseRepositoryImpl;

public class AdminRepositoryImpl extends BaseRepositoryImpl<Admin, Integer>
        implements AdminRepository, PersonRepository<Admin> {

    @Override
    public Class<Admin> getEntityClass() {
        return Admin.class;
    }


}
