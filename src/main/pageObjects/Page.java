public class Page extends Verification {
    protected Driver driver;

    public Page(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void verifyTrue(boolean condition) {
        assertTrue(condition);
    }

    @Override
    public void verifyFalse(boolean condition) {
        assertFalse(condition);
    }

    @Override
    public <expectedT> void verifyEqual(expectedT actual, expectedT expected) {
        assertEquals(actual, expected);
    }
}
