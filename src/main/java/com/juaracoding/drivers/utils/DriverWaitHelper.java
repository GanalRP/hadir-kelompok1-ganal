package com.juaracoding.drivers.utils;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.juaracoding.drivers.DriverSingleton;

public class DriverWaitHelper {
    public final static WebDriverWait DRIVER_WAIT = new WebDriverWait(DriverSingleton.getDriver(), Duration.ofSeconds(30));
}
