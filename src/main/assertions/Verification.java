import org.testng.Assert;

public interface Verification {
    public abstract void verifyTrue(boolean condition);
    public abstract void verifyFalse(boolean condition);
    public abstract <expectedT> void verifyEqual(expectedT expected,expectedT actual);
}
