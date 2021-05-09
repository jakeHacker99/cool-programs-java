package udemymasterclass.lambda;

import com.sun.nio.file.SensitivityWatchEventModifier;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        new Thread(() ->{
//
//            System.out.println("Printing from runnable!!");
//            System.out.println("shu bre");
//
//        }).start();


        Employee john = new Employee("john Doe", 31);
        Employee tim = new Employee("tim Buchalka", 11);
        Employee jack = new Employee("jack snow", 51);
        Employee bakr = new Employee("bakr bre", 12);


        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(bakr);
        employees.add(jack);


        Collections.sort(employees, (employee1, employee2) -> employee1.getName().compareTo(employee2.getName()));
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }

//        String sillyString = doStringStuff(new Employee.UpperConcat() {
//            @Override
//            public String UpperAndConcat(String s1, String s2) {
//                return s1.toUpperCase() +s2.toUpperCase();
//            }
//        },employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(sillyString);
        Employee.UpperConcat uc = (String s1, String s2) -> s1.toUpperCase() + s2.toUpperCase();
        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);
    }

    public final static String doStringStuff(Employee.UpperConcat uc, String s1, String s2) {
        return uc.UpperAndConcat(s1, s2);

    }
}

class Employee {
    private String name;
    private int age;


    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    interface UpperConcat {
        public String UpperAndConcat(String s1, String s2);

    }
}

