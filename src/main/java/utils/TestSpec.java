package utils;

import env.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

class TestSpec {
    private static final Class<? extends Annotation> ANNOTATION = Test.class;

    private Class       clazz;
    private Set<Method> testCases = new HashSet<>();

    TestSpec(Class clazz) {
        this.clazz = clazz;

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ANNOTATION)) {
                testCases.add(method);
            }
        }
    }

    public void invokeTestCases() {
        for (Method testCase : testCases) {
            //todo add implementation later

        }
    }
}
