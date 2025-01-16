package webElement;

import org.openqa.selenium.Keys;

public interface ElementAction {
    void moveToElement();
    void click();
    void setText(String text);
    String getAttribute(String attributeValue);
    String getCssProperty(String cssValue);
    String getText();
    boolean isDisplayed();
    void uploadFile(String filePath);
}
