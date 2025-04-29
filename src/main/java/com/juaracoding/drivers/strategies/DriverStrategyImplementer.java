package com.juaracoding.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriverInfo;

import com.juaracoding.drivers.managers.ChromeDriverManager;
import com.juaracoding.drivers.managers.EdgeDriverManager;
import com.juaracoding.drivers.managers.FirefoxDriverManager;
import com.juaracoding.drivers.utils.BrowserType;

public class DriverStrategyImplementer implements IDriverStrategy {
    @Override
    public WebDriver setStrategy(String strategy) {
        switch (strategy) {
            case BrowserType.CHROME:
                return ChromeDriverManager.make();
            case BrowserType.EDGE:
                return EdgeDriverManager.make();
            case BrowserType.FIREFOX:
                return FirefoxDriverManager.make();
            default:
                return ChromeDriverManager.make();

        }
    }
}
