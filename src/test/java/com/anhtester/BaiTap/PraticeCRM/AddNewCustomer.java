package com.anhtester.BaiTap.PraticeCRM;

import com.anhtester.BaiTap.locatorsCRM.LocatorCRM;
import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddNewCustomer extends BaseTest {
    String COMPANY_NAME = "aaaaaaa";

    public void loginCRM() {
        driver.get("https://crm.anhtester.com/admin/authentication");
        WebElement headerLogin = driver.findElement(By.xpath(LocatorCRM.headerLoginPage));
        System.out.println("Title của Login page là: " + headerLogin.getText());
        Assert.assertTrue(headerLogin.isDisplayed(), "Không phải header của Login page");
        setText(LocatorCRM.inputEmail, "admin@example.com");
        setText(LocatorCRM.inputPassword, "123456");
        clickElement(LocatorCRM.buttonLogin);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerDashboard)).isDisplayed(), "Không pải trang Dashboard");
        System.out.println("Title của Dashboard page hiển thị một số thông tin: " + driver.findElement(By.xpath(LocatorCRM.headerDashboard)).getText());

    }

    @Test
    public void addNewCustomer() {

        loginCRM();
//        driver.get("https://crm.anhtester.com/admin/authentication");
//
//        //Check header của Login page
//        WebElement headerLogin = driver.findElement(By.xpath(LocatorCRM.headerLoginPage));
//        System.out.println("Title của Login page là: " + headerLogin.getText());
//        Assert.assertTrue(headerLogin.isDisplayed(), "Không phải header của Login page");
        //Nhập data và login (Viết theo nomal)
//        driver.findElement(By.xpath(LocatorCRM.inputEmail)).sendKeys("admin@example.com");
//        driver.findElement(By.xpath(LocatorCRM.inputPassword)).sendKeys("123456");
//        driver.findElement(By.xpath(LocatorCRM.buttonLogin)).click();

        //Nhập data và login (Cách 2: viết theo hàm rút gọn extend từ Basetest)
//        setText(LocatorCRM.inputEmail, "admin@example.com");
//        setText(LocatorCRM.inputPassword, "123456");
//        clickElement(LocatorCRM.buttonLogin);


        //Check đã login success chưa = cách kiểm tra menu trang hiển thị sau kh login success
//        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerDashboard)).isDisplayed(), "Không pải trang Dashboard");
//
//        System.out.println("Title của Dashboard page hiển thị một số thông tin: " + driver.findElement(By.xpath(LocatorCRM.headerDashboard)).getText());
        //Click vào menCustomer và check hiển thị đúng title của customer page
        // driver.findElement(By.xpath(LocatorCRM.menuCustomers)).click();
        clickElement(LocatorCRM.menuCustomers);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerCustomesrPage)).isDisplayed(), "Failed. Không đến đc trang Customer.");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.headerCustomesrPage)).getText(), "Customers Summary", "Failed. Không pải header của của trang Customer.");
        System.out.println("Title của Customer page là: " + driver.findElement(By.xpath(LocatorCRM.headerCustomesrPage)).getText());
        //Tạo mới customer
//        driver.findElement(By.xpath(LocatorCRM.buttonAddNewCustomers)).click();
//        driver.findElement(By.xpath(LocatorCRM.inputCompany)).sendKeys(COMPANY_NAME);
//        driver.findElement(By.xpath(LocatorCRM.inputVAT)).sendKeys("10");
//        driver.findElement(By.xpath(LocatorCRM.inputPhone)).sendKeys("0987654321");
//        driver.findElement(By.xpath(LocatorCRM.inputWebsite)).sendKeys("hienpham.com");
//        driver.findElement(By.xpath(LocatorCRM.dropdownGroup)).click();
//        driver.findElement(By.xpath(LocatorCRM.inputSearchGroup)).sendKeys("Gold", Keys.ENTER);
//        driver.findElement(By.xpath(LocatorCRM.dropdownGroup)).click();
//        driver.findElement(By.xpath(LocatorCRM.dropdownCurrency)).click();
//        driver.findElement(By.xpath(LocatorCRM.inputSearchCurrency)).sendKeys("EUR", Keys.ENTER);
//        driver.findElement(By.xpath(LocatorCRM.dropdownDefaultLanguage)).click();
//        driver.findElement(By.xpath(LocatorCRM.optionDefaultLanguage)).click();
//        driver.findElement(By.xpath(LocatorCRM.inputAddress)).sendKeys("Hà nội");
//        driver.findElement(By.xpath(LocatorCRM.inputCity)).sendKeys("Đông Anh");
//        driver.findElement(By.xpath(LocatorCRM.dropdownCountry)).click();
//        driver.findElement(By.xpath(LocatorCRM.inputSearchCountry)).sendKeys("Vietnam", Keys.ENTER);
//        driver.findElement(By.xpath(LocatorCRM.buttonSave)).click();

        clickElement(LocatorCRM.buttonAddNewCustomers);
        setText(LocatorCRM.inputCompany, COMPANY_NAME);
        setText(LocatorCRM.inputVAT, "10");
        setText(LocatorCRM.inputPhone, "0987654321");
        setText(LocatorCRM.inputWebsite, "hienpham.com");
        clickElement(LocatorCRM.dropdownGroup);
        setText(LocatorCRM.inputSearchGroup, "VIP");
        clickElement(LocatorCRM.dropdownGroup);
        clickElement(LocatorCRM.dropdownCurrency);
        setText(LocatorCRM.inputSearchCurrency, "EUR");
        clickElement(LocatorCRM.dropdownDefaultLanguage);
        clickElement(LocatorCRM.optionDefaultLanguage);
        setText(LocatorCRM.inputAddress, "Hà Nội");
        setText(LocatorCRM.inputCity, "Ha Noi");
        clickElement(LocatorCRM.dropdownCountry);
        setText(LocatorCRM.inputSearchCountry, "Hanquoc");
        clickElement(LocatorCRM.buttonSave);

        sleep(2);
        //search lại customer vừa thêm có đúng ko
//        driver.findElement(By.xpath(LocatorCRM.menuCustomers)).click();
//        driver.findElement(By.xpath(LocatorCRM.inputSearchCustomers)).sendKeys(COMPANY_NAME);
        clickElement(LocatorCRM.menuCustomers);
        setText(LocatorCRM.inputSearchCustomers, COMPANY_NAME);

        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.fistItemcustomerOnTable)).isDisplayed(), "Failed. Không tìm thấy Customer đã nhập.");

        //Click vào dữ liệu và check lại thông tin sau khi add new customer success
        SoftAssert softAssert = new SoftAssert();
        //driver.findElement(By.xpath(LocatorCRM.fistItemcustomerOnTable)).click();
        clickElement(LocatorCRM.fistItemcustomerOnTable);
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputCompany)).getAttribute("value"), COMPANY_NAME, "Failes. Company name not match.");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputVAT)).getAttribute("value"), "10", "Failes. Giá trị VAT not match.");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputPhone)).getAttribute("value"), "0987654321", "Failes. Phone number not match.");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputWebsite)).getAttribute("value"), "hienpham.com", "Failes. Web name not match.");

        softAssert.assertAll();

    }

    @Test
    public void addNewContactsForCustomer() {
        String CONTACTS_NAME = "Hin";
        loginCRM();
        clickElement(LocatorCRM.menuCustomers);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerCustomesrPage)).isDisplayed(), "Failed. Không đến đc trang Customer.");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.headerCustomesrPage)).getText(), "Customers Summary", "Failed. Không pải header của của trang Customer.");
        sleep(1);
        // clickElement(LocatorCRM.menuCustomers);
        setText(LocatorCRM.inputSearchCustomers, COMPANY_NAME);
        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.fistItemcustomerOnTable)).isDisplayed(), "Failed. Không tìm thấy Customer đã nhập.");
        clickElement(LocatorCRM.fistItemcustomerOnTable);
        sleep(2);
        driver.findElement(By.xpath(LocatorCRM.menuContacts)).click();
        //clickElement(LocatorCRM.menuContacts);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerContactPage)).isDisplayed(), "Failed. Không phải header của contacts.");
        clickElement(LocatorCRM.buttonAddNewContact);
        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerAddNewContactDialog)).isDisplayed(), "Failed. Không phải header của form Add new Contacts.");
        sleep(1);

        //Upload file for Profile image
        setText(LocatorCRM.inputProfileImage, System.getProperty("user.dir") + "\\src\\test\\resources\\dataTest\\images.jpg");//System.getProperty("user.dir"): lấy từ thư mục đường dẫn của thiết bị thư mục source

        sleep(2);
        setText(LocatorCRM.inputFirstName, CONTACTS_NAME);
        setText(LocatorCRM.inputLastName, "Pham");
        setText(LocatorCRM.inputPosition, "mitmit");
        setText(LocatorCRM.inputEmailContact, "qc@gmail.com");
        setText(LocatorCRM.inputPhoneContact, "123456789");
        setText(LocatorCRM.inputPasswordContact, "123456");
        clickElement(LocatorCRM.checkboxDoNotSendEmail);
        clickElement(LocatorCRM.buttonSaveContact);
        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerContactPage)).isDisplayed(), "Failed. Không phải header của contacts.");
        clickElement(LocatorCRM.inputSearchContacts);
        setText(LocatorCRM.inputSearchContacts, CONTACTS_NAME);
        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.fistItemContactsOnTable)).isDisplayed(), "Failed. Không tìm thấy Contacts đã nhập.");
        clickElement(LocatorCRM.fistItemContactsOnTable);
        //Click vào dữ liệu và check lại thông tin sau khi add new contacts success
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputFirstName)).getAttribute("value"), CONTACTS_NAME, "Failes. FistName name not match.");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputLastName)).getAttribute("value"), "Pham", "Failes. LastName not match.");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputEmailContact)).getAttribute("value"), "qctest899@gmail.com", "Failes. Email not match.");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputPasswordContact)).getAttribute("value"), "123456", "Failes.Password not match.");

        softAssert.assertAll();


    }


}
