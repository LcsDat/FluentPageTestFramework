import org.testng.Assert;

public abstract class Verification extends Assert {
    public abstract void verifyTrue(boolean condition);
    public abstract void verifyFalse(boolean condition);
    public abstract <expectedT> void verifyEqual(expectedT expected,expectedT actual);
}
