package com.juaracoding.definitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.module.Browser;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.drivers.utils.AuthHelper;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {
    private static WebDriver driver;

    @BeforeAll
    public static void init() {
        driver = DriverSingleton.getDriver();
        AuthHelper.executeLogin();
    }

    @After
    public static void takeScreenshot(Scenario scenario) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
        scenario.attach(fileContent, "image/png", "Screenshot");
    }

    @AfterAll
    public static void teardown() {
        AuthHelper.executeLogout();
        DriverSingleton.quitDriver();
    }
}