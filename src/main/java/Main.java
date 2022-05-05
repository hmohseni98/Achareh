import customException.ScoreOutOfRange;
import model.Admin;
import model.Category;
import model.Expert;
import model.Service;
import model.enumration.AccountStatus;
import repository.AdminRepository;
import repository.CategoryRepository;
import repository.ExpertRepository;
import repository.ServiceRepository;
import repository.impl.AdminRepositoryImpl;
import repository.impl.CategoryRepositoryImpl;
import repository.impl.ExpertRepositoryImpl;
import repository.impl.ServiceRepositoryImpl;
import service.AdminService;
import service.CategoryService;
import service.ExpertService;
import service.ServService;
import service.impl.AdminServiceImpl;
import service.impl.CategoryServiceImpl;
import service.impl.ExpertServiceImpl;
import service.impl.ServServiceImpl;
import util.ApplicationContext;
import util.ApplicationTest;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Main {
    private static final CategoryRepository categoryRepository = new CategoryRepositoryImpl();
    private static final CategoryService categoryService = new CategoryServiceImpl(categoryRepository);

    private static final ServiceRepository serviceRepository = new ServiceRepositoryImpl();
    private static final ServService servService = new ServServiceImpl(serviceRepository);

    private static final ExpertRepository expertRepository = new ExpertRepositoryImpl();
    private static final ExpertService expertService = new ExpertServiceImpl(expertRepository);

    private static final AdminRepository adminRepository = new AdminRepositoryImpl();
    private static final AdminService adminService = new AdminServiceImpl(adminRepository);

    public static void main(String[] args) {
        ApplicationTest applicationTest = new ApplicationTest();
        System.out.println("******");
        Category category1 = new Category("manzel");
        categoryService.save(category1);


        Admin admin = new Admin("hassan","mohseni","email");
        ApplicationContext.getAdminService().save(admin);
        System.out.println(ApplicationContext.getAdminService().girdSearch(null,"h","","em"));

        Service service1 = new Service("naghashi","description",50000,category1);
        Service service2 = new Service("naghashi","description",50000,category1);
        Service service3 = new Service("tamiz kari","description",50000,category1);
        servService.save(service1);
        servService.save(service2);
        servService.save(service3);

        Set<Service> serviceSetExpert1 = new HashSet<>();
        serviceSetExpert1.add(service1);

        Expert expert1 = new Expert("hassan","mohseni","email","password", Date.valueOf(LocalDate.now()),
                Time.valueOf(LocalTime.now()),AccountStatus.active,null,serviceSetExpert1,50000);

        expertService.save(expert1);
        expert1.getServices().add(service1);
        expert1.getServices().add(service2);
        expert1.getServices().add(service3);
        expertService.update(expert1);
        System.out.println(expertService.login("email1", "password"));
    }
}
