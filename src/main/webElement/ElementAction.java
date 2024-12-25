public interface ElementAction {
    void click();
    void setText(String text);
    String getAttribute(String attributeValue);
    String getText();
    boolean isDisplayed();
}
