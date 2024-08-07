package com.iebya.base.oop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class cloneDemo {
    public static void main(String[] args) {
        // 浅拷贝
        Person person1 = new Person(new Address("武汉"));
        Person person1Copy = person1.clone(); 
        System.out.println(person1.getAddress() == person1Copy.getAddress()); // true
    
        // 深拷贝
        Person2 person2 = new Person2(new Address("武汉"));
        Person2 person2Copy = person2.clone();
        System.out.println(person2.getAddress() == person2Copy.getAddress()); // false

    }
}

@AllArgsConstructor
@Getter
@Setter
class Address implements Cloneable {
    private String name;

    // 省略构造函数、Getter&Setter方法
    @Override
    public Address clone() {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

@AllArgsConstructor
@Getter
@Setter
class Person implements Cloneable {
    private Address address;

    // 省略构造函数、Getter&Setter方法
    @Override
    public Person clone() {
        try {
            Person person = (Person) super.clone();
            return person;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

@AllArgsConstructor
@Getter
@Setter
class Person2 implements Cloneable {
    private Address address;

    // 省略构造函数、Getter&Setter方法
    @Override
    public Person2 clone() {
        try {
            Person2 person = (Person2) super.clone();
            person.address = address.clone();
            return person;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
