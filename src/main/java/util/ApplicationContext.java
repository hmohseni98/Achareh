package util;

import repository.*;
import repository.impl.*;
import service.*;
import service.impl.*;


public class ApplicationContext {
    private static final AdminRepositoryImpl adminRepository;

    private static final CategoryRepository categoryRepository;

    private static final CommentRepository commentRepository;

    private static final CustomerRepositoryImpl customerRepository;

    private static final ExpertRepositoryImpl expertRepository;

    private static final OfferRepository offerRepository;

    private static final OrderRepository orderRepository;

    private static final ServiceRepository serviceRepository;

    private static final AdminService adminService;

    private static final CategoryService categoryService;

    private static final CommentService commentService;

    private static final CustomerService customerService;

    private static final ExpertService expertService;

    private static final OfferService offerService;

    private static final OrderService orderService;

    private static final ServService servService;

    static {
        adminRepository = new AdminRepositoryImpl();

        categoryRepository = new CategoryRepositoryImpl();

        commentRepository = new CommentRepositoryImpl();

        customerRepository = new CustomerRepositoryImpl();

        expertRepository = new ExpertRepositoryImpl();

        offerRepository = new OfferRepositoryImpl();

        orderRepository = new OrderRepositoryImpl();

        serviceRepository = new ServiceRepositoryImpl();

        adminService = new AdminServiceImpl(adminRepository);

        categoryService = new CategoryServiceImpl(categoryRepository);

        commentService = new CommentServiceImpl(commentRepository);

        customerService = new CustomerServiceImpl(customerRepository);

        expertService = new ExpertServiceImpl(expertRepository);

        offerService = new OfferServiceImpl(offerRepository);

        orderService = new OrderServiceImpl(orderRepository);

        servService = new ServServiceImpl(serviceRepository);
    }
    public static AdminService getAdminService() {
        return adminService;
    }

    public static CategoryService getCategoryService() {
        return categoryService;
    }

    public static CommentService getCommentService() {
        return commentService;
    }

    public static CustomerService getCustomerService() {
        return customerService;
    }

    public static ExpertService getExpertService() {
        return expertService;
    }

    public static OfferService getOfferService() {
        return offerService;
    }

    public static OrderService getOrderService() {
        return orderService;
    }

    public static ServService getServService() {
        return servService;
    }
}
