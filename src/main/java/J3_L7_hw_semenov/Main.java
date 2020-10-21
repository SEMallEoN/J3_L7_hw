package J3_L7_hw_semenov;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        start(Testing.class);
    }

    public static void start(Class classObject) {
        Method[] methods = classObject.getDeclaredMethods();
        try {
            for (int i = 1; i < 11; i++) {
                for (Method o : methods) {
                    if (o.getAnnotation(Test.class) != null) {
                        Test test = o.getAnnotation(Test.class);
                        if (test.value() == i) {
                            System.out.println(o);
                            System.out.println("value: " + test.value());
                        }
                    }
                    if (o.getAnnotation(BeforeSuite.class) != null) {
                        BeforeSuite beforeTest = o.getAnnotation(BeforeSuite.class);
                        if (beforeTest.value() == i) {
                            System.out.println(o);
                            System.out.println("value: " + beforeTest.value());
                        }
                    }
                    if (o.getAnnotation(AfterSuite.class) != null) {
                        AfterSuite afterSuite = o.getAnnotation(AfterSuite.class);
                        if (afterSuite.value() == i) {
                            System.out.println(o);
                            System.out.println("value: " + afterSuite.value());
                        }
                    }
                }
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
