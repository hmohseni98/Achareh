package customException;

public class ServiceNameAlreadyExist extends  RuntimeException{
    public ServiceNameAlreadyExist() {
        super("Service name already exist");
    }
}
