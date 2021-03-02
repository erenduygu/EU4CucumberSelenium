package com.vytrack.step_definitions;

import com.vytrack.utilities.*;
import com.vytrack.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.*;

import java.sql.*;
import java.util.concurrent.*;

public class Hooks {
    @Before
    public void setUp(){
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
