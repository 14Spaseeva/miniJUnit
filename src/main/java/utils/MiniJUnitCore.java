package utils;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;

public class MiniJUnitCore {

    private static final Logger log = Logger.getLogger(MiniJUnitCore.class);

    public static void main(String[] args) {

        //as an example u use test class "debug.MySpec";

        Actuator actuator = new Actuator(ArgumentParser.getTestSpecs(args));
        actuator.run();

    }

    private static class ArgumentParser {

        private final static String ERR_DESCRIPTION = "Test specification class %s could not be found.";

        private static ArrayList<TestSpec> getTestSpecs(String... jsuits) {
            ArrayList<TestSpec> testSpecs = new ArrayList<>();
            Arrays.stream(jsuits).forEach(jsuit ->
                                          {
                                              try {
                                                  testSpecs.add(new TestSpec(Class.forName(jsuit)));
                                              } catch (ClassNotFoundException e) {
                                                  log.error(String.format(ERR_DESCRIPTION, jsuit));
                                              }
                                          });
            return testSpecs;
        }

    }

}
