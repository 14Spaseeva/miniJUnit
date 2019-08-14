package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Actuator {

    private List<TestSpec> testSpecs = new ArrayList<>();

    Actuator(TestSpec... testSpecs) {
        this(Arrays.asList(testSpecs));
    }

    Actuator(List<TestSpec> testSpecs) {
        this.testSpecs.addAll(testSpecs);
    }

    void run() {

        this.testSpecs.forEach(TestSpec::invokeTestCases);

    }
}
