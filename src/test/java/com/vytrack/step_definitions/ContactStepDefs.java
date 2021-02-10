package com.vytrack.step_definitions;

import com.vytrack.pages.*;
import com.vytrack.utilities.*;
import io.cucumber.java.en.*;
import org.junit.*;
import org.openqa.selenium.*;

import java.util.*;

public class ContactStepDefs {
    @Then("the user should see following options")
    public void the_user_should_see_following_options(List<String> menuOptions) {
        BrowserUtils.waitFor(2);
        //get the list of webelement and convert them to list of string and assert
        List<String> actualOptions = BrowserUtils.getElementsText(new DashboardPage().menuOptions);

        Assert.assertEquals(menuOptions,actualOptions);
        System.out.println("menuOptions = " + menuOptions);
        System.out.println("actualOptions = " + actualOptions);
    }

    @When("the user logs in using following credentials")
    public void the_user_logs_in_using_following_credentials(Map<String,String> userInfo) {
        System.out.println(userInfo);

        String username= userInfo.get("username");
        String password= userInfo.get("password");

        System.out.println(username);
        System.out.println(password);

        new LoginPage().login(username,password);

        BrowserUtils.waitFor(2);

       // String actualFullName= Driver.get().findElement(By.xpath("//*[@id='user-menu']/a")).getText();

        String actualFullName= new DashboardPage().getUserName();
        String expectedFullName= userInfo.get("firstname")+" "+userInfo.get("lastname");



        System.out.println(actualFullName);
        System.out.println(expectedFullName);

        Assert.assertEquals(expectedFullName,actualFullName);


    }

}
