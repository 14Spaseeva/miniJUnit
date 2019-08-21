package env;

/**
 * This class provides ability to assert conditions for unit tests
 */
public class Assert {

    /**
     * Asserts the condition is true. Otherwise {@link AssertError} would be thrown
     *
     * @param condition
     * @param message   user fail description
     */
    public static void assertTrue(boolean condition, String message) {
        failAssert(condition, message);
    }

    /**
     * Asserts the condition is true. Otherwise {@link AssertError} would be thrown
     *
     * @param condition
     */
    public static void assertTrue(boolean condition) {
        failAssert(condition);
    }

    /**
     * Asserts the condition is false. Otherwise {@link AssertError} would be thrown
     *
     * @param condition
     * @param message   user fail description
     */
    public static void assertFalse(boolean condition, String message) {
        failAssert(!condition, message);
    }

    /**
     * Asserts the condition is false. Otherwise {@link AssertError} would be thrown
     *
     * @param condition boolean parameter to be asserted
     */
    public static void assertFalse(boolean condition) {
        failAssert(!condition);
    }

    private static void failAssert(boolean condition) {
        if (!condition) {
            throw new AssertError();
        }
    }

    private static void failAssert(boolean condition, String message) {
        if (!condition) {
            if ((message != null) && (!message.isEmpty())) {
                throw new AssertError(message);
            } else {
                throw new AssertError();
            }
        }
    }

    private Assert() {
        throw new IllegalStateException("Utility class cannot be initialised");
    }
}
