package com.travelplanning.user.config;


final class Circle extends Shape {
    // Common code for all subclasses
}

record Person(int id, String name){}


public class Hello {

    public static void main(String[] args) {
        Person p = new Person(1, "Asif Ahmed");
        System.out.println("hashCode:: " + p.hashCode());
    }




}
