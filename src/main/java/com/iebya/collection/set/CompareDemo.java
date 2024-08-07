package com.iebya.collection.set;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Data;

public class CompareDemo {
    public static void main(String[] args) {
        // 初始化一个 Student 类型的数组
        Student[] students = new Student[] { 
            new Student("Tom", 18), new Student("Jerry", 20),
            new Student("Mickey", 15),new Student("Bob", 17) };
        System.err.println("Before sort:");
        for (Student student : students) {
            System.out.println(student);
        }

        // 使用 Comparable 对数组进行排序
        Arrays.sort(students); // 会调用 Student 类的 compareTo 方法
        System.err.println("After comparable sort :");
        for (Student student : students) {
            System.out.println(student);
        }

        // 使用 Comparator 对数组进行排序
        Arrays.sort(students, (s1, s2) -> s1.getName().compareTo(s2.getName()));
        System.err.println("After comparator sort :");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}


@Data
@AllArgsConstructor
class Student implements Comparable<Student> {
    private String name;
    private int age;

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.age, other.age);
    }
}
