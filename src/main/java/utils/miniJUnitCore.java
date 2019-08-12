package utils;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class miniJUnitCore {

    private static final Logger log = Logger.getLogger(miniJUnitCore.class);

    public static void main(String[] args) {

        System.exit(miniJUnitCore.runTestClasses(args).getStatus()
                            ? 0
                            : 1);
    }

    private static Result runTestClasses(String... classes) {

        List<TestSpec> testSpecs = ArgumentParser.getTestSpecs(classes);
        testSpecs.forEach(TestSpec::invokeTestCases);
        return null; // todo
    }

    private static class ArgumentParser {

        private final static String ERR_DESCRIPTION = "Test specification class %s could not be found.";

        private static ArrayList<TestSpec> getTestSpecs(String... args) {
            ArrayList<TestSpec> testSpecs = new ArrayList<>();
            Arrays.stream(args).forEach(arg ->
                                        {
                                            try {
                                                testSpecs.add(new TestSpec(Class.forName(arg)));
                                            } catch (Exception ignored) {
                                                log.error(String.format(ERR_DESCRIPTION, arg));
                                            }
                                        });
            return testSpecs;
        }

    }

}
