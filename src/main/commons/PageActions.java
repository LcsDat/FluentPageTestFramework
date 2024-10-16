public interface PageActions<T> {
    T click(Locator strategy, String locator);
    T setText(Locator strategy, String locator, String value);
    T openBrowser(String url);

}
