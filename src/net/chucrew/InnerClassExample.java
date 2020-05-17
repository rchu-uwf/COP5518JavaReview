package net.chucrew;

/*

Reference:
https://www.w3schools.com/java/java_inner_classes.asp
https://youtu.be/iqp7NQCN2ck

*/

import org.w3c.dom.ls.LSOutput;

class OuterClass {
    // This is a member variable.
    int x = 10;

    // This is a member method.
    public void show() {
        System.out.println("I am in show().");
    }

    class InnerClass {
        public int myInnerMethod() {
            System.out.println("In myInnerMethod");
            return x;
        }
    }

    static class StaticInnerClass {
        int y = 5;
    }
}

public class InnerClassExample {
    public static void main(String[] args) {
        // {class name} objectName = new {constructor}
        OuterClass myOuter = new OuterClass();

        /*
        Try using OuterClass.
        Use a method from the outer class.
        */
        myOuter.show();

        /*
        Try using InnerClass.
        Note: the inner class can reference a resource of the outerclass.
         */
        OuterClass.InnerClass myInner = myOuter.new InnerClass();
        System.out.println(myInner.myInnerMethod());

        /*
        Try using StaticInnerClass.
        referencing a static inner class
        Note: just like static attributes and methods, a static inner class does not have access to members of the outer class.
         */
        OuterClass.StaticInnerClass myStaticInner = new OuterClass.StaticInnerClass();
        System.out.println(myStaticInner.y);

    }
}

