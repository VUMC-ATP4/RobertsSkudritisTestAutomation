package classroomSix;

import com.github.javafaker.Faker;

import java.util.Scanner;

public class Example {

    public static void main(String[] args) {
//        Customer customer = new Customer("Juris");
//        customer.setMember(true);
//        customer.setMemberType("Gold");
//        customer.isMember();
//        System.out.println(customer.toString());
        Employee employee1 = new Employee("Roberts", "Uzv", 21);
//        Faker datuGenerators = new Faker();
        Faker faker = new Faker();
//        String animalName = faker.animal().name();
//        System.out.println(animalName);
      String name = faker.name().firstName();
        String lastName = faker.name().lastName();
        int age = faker.number().numberBetween(1,100);

      Employee employee2 = new Employee(name,lastName,age);
        System.out.println(employee1.toString());
        System.out.println(employee2.toString());



    }
}