package com.vytrack.step_definitions;

import com.vytrack.pages.*;
import com.vytrack.utilities.*;
import io.cucumber.java.en.*;
import org.junit.*;
import org.openqa.selenium.*;

public class LoginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("the user enters the driver information")
    public void gthe_user_enters_the_driver_information() {

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {

        BrowserUtils.waitFor(6);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Dashboard", actualTitle);


    }

    @When("the user enters the sales manager information")
    public void the_user_enters_the_sales_manager_information() {
        String username = ConfigurationReader.get("sales_manager_username");
        String password = ConfigurationReader.get("sales_manager_password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
    }


    @When("the user enters the store manager information")
    public void the_user_enters_the_store_manager_information() {
        String username = ConfigurationReader.get("store_manager_username");
        String password = ConfigurationReader.get("store_manager_password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
    }


    @When("the user logs in using {string} and {string}")
    public void theUserLogsInUsingAnd(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
    }

    @And("the title contains {string}")
    public void theTitleContains(String expectedTitle) {
        System.out.println("expectedTitle = " + expectedTitle);

        BrowserUtils.waitFor(5);
        System.out.println(Driver.get().getTitle());
        Assert.assertTrue(Driver.get().getTitle().contains(expectedTitle));
    }

    @Given("the user logged in as {string}")
    public void theUserLoggedInAs(String usertype) {

        Driver.get().get(ConfigurationReader.get("url"));

        //    String username= ConfigurationReader.get(usertype+"_username");
        //  String  password= ConfigurationReader.get(usertype+"_password");

        String username=null;
        String password=null;

        switch (usertype) {

            case "driver":
                username= ConfigurationReader.get("driver_username");
                password= ConfigurationReader.get("driver_password");
                break;
            case "sales manager":
                username= ConfigurationReader.get("sales_manager_username");
                password= ConfigurationReader.get("sales_manager_password");
                break;
            case "store manager":
                username= ConfigurationReader.get("store_manager_username");
                password= ConfigurationReader.get("store_manager_password");
                break;

        }
        new LoginPage().login(username, password);


    }
}
