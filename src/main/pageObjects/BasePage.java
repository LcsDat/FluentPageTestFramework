public class BasePage {
    protected Driver driver;
    protected CoreVerification coreVerification;

    public BasePage(Driver driver, CoreVerification coreVerification) {
        this.driver = driver;
        this.coreVerification = coreVerification;
    }
}
