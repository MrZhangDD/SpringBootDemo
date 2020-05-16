package com.zhang.test03;

public class test4 {
    static {
        System.out.println("main被加载");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        //1.初始化对象都会加载
        // Son son = new Son();
        //2.反射获取子类对象,都会加载
        //Class<?> aClass = Class.forName("com.zhang.test03.Son");

        //3.调用父类静态域,子类不会加载
        //int b = Father.b;

        //4.数组类,只有main会加载
        //Father[] fathers = new Father[123];

        //5.调用子类静态常量,初始化已经存在，不会调用父类和子类初始化
        //System.out.println(Son.ss);
    }
}

class Father {
    static int b = 6;
    static {
        System.out.println("父类被加载");
    }

}
class Son extends Father{
    static {
        System.out.println("子类被加载");
    }

    static int m = 12;
    static final int ss = 23;
}
