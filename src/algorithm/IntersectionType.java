package algorithm;

import java.util.function.Function;

public class IntersectionType {
    interface A {
        void box();
        void text();
    }

    abstract class C implements A{
        abstract void cup();

        @Override
        public void text() {
            System.out.println("class c text");
        }
    }

    class D extends C {
        @Override
        void cup() {
            System.out.println("class D cup");
        }

        @Override
        public void box() {

        }
    }
}
