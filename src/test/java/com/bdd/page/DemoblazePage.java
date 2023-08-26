package com.bdd.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class DemoblazePage extends BasePage {

    public DemoblazePage() {
        super(driver);
    }

    // Xpath - Sign Up
    private String singUp = "//a[@id='signin2']";
    private String registerUsername = "//input[@id='sign-username']";
    private String registerPassword = "//input[@id='sign-password']";
    private String btnSingUp = "//button[contains(text(),'Sign up')]";

    // Xpath - Log In
    private String logIn = "//a[@id='login2']";
    private String logInUsername = "//input[@id='loginusername']";
    private String logInPassword = "//input[@id='loginpassword']";
    private String btnLogIn = "//button[contains(text(),'Log in')]";

    private String userProfile = "//a[@id='nameofuser']";
    private String logOut = "//a[@id='logout2']";

    // Add product
    private String btnAddToCart = "//a[contains(text(),'Add to cart')]";
    private String cart = "//a[@id='cartur']";

    // Methods
    public void navigateToDemoblaze() {
        navigateTo("https://www.demoblaze.com/");
        driver.manage().window().maximize();
    }

    public void clickSignUp() {
        clickElement(singUp);
    }

    public void enterCriteria(String user, String password) {
        write(registerUsername, user);
        write(registerPassword, password);
    }

    public void clickBtnRegister() {
        clickElement(btnSingUp);
    }

    public String registerUserMessage() {
        return getAlertText();
    }

    // Log In
    public void clickLogIn() {
        clickElement(logIn);
    }

    public void enterCriteriaLogIn(String user, String password) {
        write(logInUsername, user);
        write(logInPassword, password);
    }

    public void clickBtnLogIn() {
        clickElement(btnLogIn);
    }

    public String logInValidateProfile() {
        try {
            return textFromElement(userProfile);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void clicToLogOut() {
        clickElement(logOut);
    }

    // Add product
    public void agregoAlCarritoUn(String product) {
        By productLocator = By.xpath("//body/div[@id='contcont']/div[1]/div[2]/div[1]/div/div[1]/div[1]/h4[1]");
        waitForElementToBeVisible(productLocator);
        List<WebElement> productElements = driver.findElements(productLocator);
        for (WebElement productElement : productElements) {
            String productName = productElement.getText();
            if (product.contains(productName)) {
                productElement.click();
                return;
            }
        }
    }

    public void addToCart() {
        clickElement(btnAddToCart);
        System.out.println("Haciendo clic en el botón 'Agregar al carrito'");
        acceptAlert();
    }

    public void clickToCart() {
        clickElement(cart);
    }

    public boolean isProductAdded(String product) {
        By productLocator = By.xpath("//*[@id='tbodyid']/tr/td[2]");
        waitForElementToBeVisible(productLocator);
        List<WebElement> productElements = driver.findElements(productLocator);
        for (WebElement productElement : productElements) {
            String productName = productElement.getText();
            if (product.equals(productName)) {
                return true;
            }
        }
        return false;
    }
}






