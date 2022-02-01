package com.example.java_final_lab;

import java.util.ArrayList;
import java.util.Scanner;

//POJO
public class ConsoleInput {

    static ArrayList<User> users;

    private static class User{


        private String name;
        private int age;

        public User(String name, int age) {
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


    }


    public static void main(String[] args) {
        users= new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome \n Enter  ");
        String name = scanner.next();
        int age = scanner.nextInt();
        //ArrayList
        User user = new User(name,age);
        users.add(user);

    }

}
