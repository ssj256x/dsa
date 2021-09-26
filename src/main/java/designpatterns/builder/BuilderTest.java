package designpatterns.builder;

public class BuilderTest {

    public static void main(String[] args) throws Exception {
        Employee employee = Employee
                .builder()
                .address("addr")
                .age(30)
                .email("test@email.com")
                .firstName("Sanjeet")
                .build();

        System.out.println(employee);
    }
}
