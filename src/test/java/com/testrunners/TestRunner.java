package com.testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/appfeatures",
		glue = {"stepdefinitions", "apphooks"},
		plugin = {"json:target/jsonReports/cucumber-report.json",
				"html:target/CucumberReport/cucumber-report.html",
				"rerun:target/failedRerun.txt"},
		publish = true,
		tags = "@Test")
public class TestRunner {

}
