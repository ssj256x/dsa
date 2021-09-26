package designpatterns.builder;

/**
 * This is an implementation of the Builder Design Pattern. This pattern is useful in creating complex
 * objects where if there are many fields in the class and some of them are not mandatory, it can help
 * create them efficiently without adding too much complexity.
 * <p>
 * It uses a Builder class internally to create the object.
 * <p>
 * The problem is that its verbose but still offers much more flexibility
 */
public class Employee {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String email;
    private final String address;
    private final String phone;


    public Employee(Builder emp) {
        this.firstName = emp.firstName;
        this.lastName = emp.lastName;
        this.age = emp.age;
        this.email = emp.email;
        this.address = emp.address;
        this.phone = emp.phone;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    /**
     * This is a Builder class that implements the Fluent design where we chain
     * functions for adding values to the variables
     */
    public static class Builder {
        private String firstName;
        private String lastName;
        private int age;
        private String email;
        private String address;
        private String phone;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Employee build() throws Exception {
            Employee emp = new Employee(this);
            if (!validate(emp)) throw new Exception("Error in creating");
            return emp;
        }

        private boolean validate(Employee employee) {
            // Can perform some validations here if required
            return true;
        }
    }
}
