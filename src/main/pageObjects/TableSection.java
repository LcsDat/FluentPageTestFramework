import java.util.List;

public class TableSection extends WebPage {
    public TableSection(Driver driver) {
        super(driver);
    }


    private CoreWebElement cell(String... rowThenColumn) {
        return driver.findElementByXpath("//div[@class='oxd-table-card'][" + getRowIndex(rowThenColumn[0]) + "]//div[@role='cell'][" + getColumnIndex(rowThenColumn[1]) + "]");
    }

    /**
     * Get list of rows above the provided locator in a table
     *
     * @param attributeToIdentify
     * @return List
     */
    public List<CoreWebElement> getAboveRows(String... attributeToIdentify) {
        return driver.findElementsByXpath("//div[text()='%s']//ancestor::div[@class='oxd-table-card']/preceding-sibling::div", attributeToIdentify);
    }

    /**
     * Get list of headers on the left side of provided locator in a table
     *
     * @param attributeToIdentify
     * @return List
     */
    public List<CoreWebElement> getLeftSideHeaders(String... attributeToIdentify) {
        return driver.findElementsByXpath("//div[text()='%s']/preceding-sibling::div", attributeToIdentify);
    }

    private CoreWebElement page(int number) {
        return driver.findElementByXpath("//button[text()='" + number + "']");
    }

    public int getColumnIndex(String... varargs) {
        return getLeftSideHeaders(varargs).size() + 1;
    }

    public int getRowIndex(String... varargs) {
        return getAboveRows(varargs).size() + 1;
    }

    public int getTotalPage() {
        return driver.findElementsByCss("ul.oxd-pagination__ul>li").size() - 1;
    }

    public void clickPage(int number) {
        page(number).click();
    }

    public String getCellText(String... rowThenColumn) {
        return cell(rowThenColumn).getText();
    }
}
