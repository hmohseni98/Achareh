package customException;

public class ServiceNameAlreadyExist extends  Exception{
    public ServiceNameAlreadyExist() {
        super("Service name already exist");
    }
}
