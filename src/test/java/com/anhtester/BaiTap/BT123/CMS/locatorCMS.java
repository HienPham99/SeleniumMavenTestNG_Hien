package com.anhtester.BaiTap.BT123.CMS;

public class locatorCMS {

    //Locator Login page
    public static String headerLoginPage = "//div[@class='card text-left']//h1";
    public static String inputEmail = "//input[@id='email']";
    public static String inputPassword = "//input[@id='password']";
    public static String checkboxRememberMe = "//span[normalize-space()='Remember Me']";
    public static String buttonLogin = "//button[normalize-space()='Login']";
    public static String linkForgotPassword = "//a[normalize-space()='Forgot password ?']";
    public static String buttonCopy = "//button[normalize-space()='Copy']";

    //Locator dashboard
    public static String itemDashboards = "//ul[@id='main-menu']";
    public static String menuProducts = "//span[normalize-space()='Products']";
    public static String menuCategory = "//span[normalize-space()='Category']";
    public static String headerCategoryPage = "//div[@class='aiz-main-content']//h1";
    public static String buttonAddNewCategory = "//span[normalize-space()='Add New category']";
    public static String searchCategoryPage = "//form[@id='sort_categories']//input[@id='search']";

    //locator add new category
    public static String headerAddNewCategory = "//div[@class='card']//div//h5";
    public static String inputName = "//input[@id='name']";
    public static String dropdownParentCategory = "//div[contains(text(),'---- Shorts')]";
    public static String searchParentCategory = "//div[@class='dropdown-menu show']//input[@aria-label='Search']";
    public static String inputOrderingNumber = "//input[@id='order_level']";
    public static String buttonBanner200x200 = "  //label[normalize-space()='Banner (200x200)']/following-sibling::div/div/div[normalize-space()='Browse']";
    public static String inputSearchFileImg = "//div[@id='aiz-select-file']//input[@type='text']";
    public static String optionImg = "//div[@id='aiz-select-file']//img";
    public static String buttonAddFiles = "//button[normalize-space()='Add Files']";
    public static String buttonIcon32x32 = "  //label[normalize-space()='Icon (32x32)']/following-sibling::div/div/div[normalize-space()='Browse']";
    public static String buttonCoverImege250x250 = "  //label[normalize-space()='Cover Image (250x250)']/following-sibling::div/div/div[normalize-space()='Browse']";
    public static String buttonUploadNew = "//div[@id='aizUploaderModal']//a[normalize-space()='Upload New']";
    public static String inputMetaTitle = "//input[@placeholder='Meta Title']";
    public static String inputMetaDescription = "//label[normalize-space()='Meta Description']/following-sibling::div/textarea[@rows='5']";
    public static String dropdownFilteringAttributes = "//label[normalize-space()='Filtering Attributes']/following-sibling::div//button[@type='button']";
    public static String searchFilteringAttribute = "//div[@class='dropdown-menu show']//input[@aria-label='Search']";
    public static String buttonSave = "//button[@type='submit']";
    public static String fistItemlCategories = "//table//tbody//tr//td[2]";
    public static String iconEditCategories = "//i[@class='las la-edit']";

}
