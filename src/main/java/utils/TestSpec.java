package utils;

import env.Test;
import org.apache.log4j.Logger;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.LinkedHashSet;

class TestSpec {
    private static final Logger log = Logger.getLogger(TestSpec.class);

    private static final String TEST_FAILED = "'%s' FAILED:";
    private static final String TEST_PASSED = "'%s' PASSED.";

    private static final Class<? extends Annotation> ANNOTATION = Test.class;

    private Object clazzObject;

    private HashSet<Method> testCases = new LinkedHashSet<>();

    TestSpec(Class<?> clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ANNOTATION)) {
                testCases.add(method);
            }
        }
        try {
            this.clazzObject = clazz.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            log.error(e.getMessage());
        }
    }

    void invokeTestCases() {
        testCases.forEach(this::invokeTestCase);
    }

    private void invokeTestCase(Method testCase) {
        try {
            testCase.invoke(clazzObject);
        } catch (InvocationTargetException e) {
            log.info(String.format(TEST_FAILED, testCase.getName()), e.getCause());
            return;
        } catch (IllegalAccessException e) {
            log.error(e.getMessage());
            return;
        }
        log.info(String.format(TEST_PASSED, testCase.getName()));
    }
}
