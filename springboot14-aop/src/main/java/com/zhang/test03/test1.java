package com.zhang.test03;

public class test1{
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是+"+person.name);
        //方法1：通过对象获得
        Class c1 = person.getClass();
        System.out.println(c1+"+hashcode+"+c1.hashCode());
        //方法2：通过forname获得
        Class c2 = Class.forName("com.zhang.test03.Student");
        System.out.println(c2+"+hashcode+"+c2.hashCode());
        //方法3：通过类名.class获得
        Class c3 = Student.class;
        System.out.println(c3+"+hashcode+"+c3.hashCode());
        //方法四：基本内置类型的包装类都有一个type属性
        Class c4 = Integer.TYPE;
        System.out.println(c4+"+hashcode+"+c4.hashCode());
        //获得父类类型
        Class c5 = c1.getSuperclass();
        System.out.println(c5+"+hashcode+"+c5.hashCode());
    }
}
class Person {
    public String name;
    public int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
class Student extends Person{
    public Student(){
        this.name = "学生";
    }
}
class Teacher extends Person{
    public Teacher(){
        this.name = "老师";
    }
}