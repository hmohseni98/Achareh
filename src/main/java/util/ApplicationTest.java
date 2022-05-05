package util;

import model.Customer;
import model.Expert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;


public class ApplicationTest {
    public void fillDataBase() {
        Customer customer = new Customer();
        customer.setId(1);
        ApplicationContext.getCommentService().findAllByCustomer(customer).forEach(System.out::println);
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Hassan\\Desktop\\test.jpg");
        byte[] bFile = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ApplicationContext.getExpertService().save(new Expert(null, bFile, null, null));


        Expert expert = ApplicationContext.getExpertService().findById(1);
        byte[] gFile = expert.getImage();
        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\Hassan\\Desktop\\test11.jpg");
            fos.write(gFile);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(UUID.randomUUID().toString());
    }
}
