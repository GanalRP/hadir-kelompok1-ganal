package com.juaracoding.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/features/ManajemenAturanCuti.feature"

}, glue = {"com.juaracoding.definitions",
}, plugin = {"pretty","html:target/cucumber-reporting/reports.html",
        "json:target/cucumber-reporting/reports.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})


public class RunnerTest extends AbstractTestNGCucumberTests {

}
