package env;

/**
 * This class is a subclass of {@link Error} should be used for indication assert fails.
 */
class AssertError extends Error {

    private static final String ASSERT_INFO = "Assertion fail:%n%s";

    /**
     * The constructor of a new error without detail message
     */
    AssertError() {
        super();
    }

    /**
     * The constructor of a new error with detail message
     *
     * @param message The detail message
     */
    AssertError(String message) {
        super(String.format(ASSERT_INFO, message));
    }
}
