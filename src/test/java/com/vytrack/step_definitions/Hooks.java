package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.*;

import java.sql.*;

public class Hooks {
    @Before
    public void setUp(){
        System.out.println("\tthis is coming from BEFORE");
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte [] screenshot= ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");

        }
        Driver.closeDriver();
    }

    @Before("@db")
    public void setUpdb(){
        System.out.println("\tconnecting to database...");
    }

    @After("@db")
    public void closeDb(){
        System.out.println("\tdisconnecting to database...");

    }



}
