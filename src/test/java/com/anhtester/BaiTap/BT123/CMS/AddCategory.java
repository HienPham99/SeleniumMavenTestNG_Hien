package com.anhtester.BaiTap.BT123.CMS;

import com.anhtester.BaiTap.locatorsCRM.LocatorCRM;
import com.anhtester.common.BaseTest;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddCategory extends BaseTest {

    String CATEGORY_NAME= "Vai Thai Tuan";

    public void loginCMS(){
        driver.get("https://cms.anhtester.com/login");
        WebElement headerLogin = driver.findElement(By.xpath(locatorCMS.headerLoginPage));
        System.out.println("Title của Login page là: " + headerLogin.getText());
        Assert.assertTrue(headerLogin.isDisplayed(), "Không phải header của Login page");
        setText(locatorCMS.inputEmail, "admin@example.com");
        setText(locatorCMS.inputPassword, "123456");
        clickElement(locatorCMS.buttonLogin);
        Assert.assertTrue(driver.findElement(By.xpath(locatorCMS.itemDashboards)).isDisplayed(), "Không pải trang Dashboard");
        System.out.println("Title của Dashboard page hiển thị một số thông tin: " + driver.findElement(By.xpath(locatorCMS.itemDashboards)).getText());

    }

    @Test
    public void addNewCategory() {
        loginCMS();
        clickElement(locatorCMS.menuProducts);
        clickElement(locatorCMS.menuCategory);
        sleep(1);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(By.xpath(locatorCMS.headerCategoryPage)).isDisplayed(), "Failed. Không đến đc trang Customer.");
        softAssert.assertEquals(driver.findElement(By.xpath(locatorCMS.headerCategoryPage)).getText(), "All categories", "Failed. Không pải header của của trang Customer.");
        System.out.println("Title của Customer page là: " + driver.findElement(By.xpath(locatorCMS.headerCategoryPage)).getText());
        clickElement(locatorCMS.buttonAddNewCategory);
        sleep(2);
        softAssert.assertTrue(driver.findElement(By.xpath(locatorCMS.headerAddNewCategory)).isDisplayed(), "Failed. Không hiển thị form Add new category.");
        softAssert.assertEquals(driver.findElement(By.xpath(locatorCMS.headerAddNewCategory)).getText(), "Category Information", "Failed. Header trang add new categor not match.");
        setText(locatorCMS.inputName,CATEGORY_NAME);
       // clickElement(locatorCMS.dropdownParentCategory);
       // driver.findElement(By.xpath(locatorCMS.searchParentCategory)).sendKeys("Hat", Keys.ENTER);
        setText(locatorCMS.inputOrderingNumber,"98765");
        clickElement(locatorCMS.buttonBanner200x200);
        setText(locatorCMS.inputSearchFileImg,"play");
        clickElement(locatorCMS.optionImg);
        clickElement(locatorCMS.buttonAddFiles);
        setText(locatorCMS.inputMetaTitle, "meta");
        //setText(locatorCMS.inputMetaDescription,"Một đoan văn");
        clickElement(locatorCMS.dropdownFilteringAttributes);
        setText(locatorCMS.searchFilteringAttribute, "Size, Fabric");
        clickElement(locatorCMS.dropdownFilteringAttributes);
        sleep(2);
        clickElement(locatorCMS.buttonSave);
        sleep(2);

        clickElement(locatorCMS.menuCategory);
        //setText(locatorCMS.searchCategoryPage,CATEGORY_NAME);
        driver.findElement(By.xpath(locatorCMS.searchCategoryPage)).sendKeys(CATEGORY_NAME,Keys.ENTER);

        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(locatorCMS.fistItemlCategories)).isDisplayed(), "Failed. Không tìm thấy Category đã nhập.");
        sleep(2);
        clickElement(locatorCMS.iconEditCategories);
        sleep(2);
        softAssert.assertEquals(driver.findElement(By.xpath(locatorCMS.inputName)).getAttribute("value"), CATEGORY_NAME, "Failes. Category name not match.");
        softAssert.assertEquals(driver.findElement(By.xpath(locatorCMS.inputOrderingNumber)).getAttribute("value"), "98765", "Failes. Order number not match.");
        softAssert.assertAll();
    }
}
