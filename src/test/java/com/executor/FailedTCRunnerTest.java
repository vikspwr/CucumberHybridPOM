/**
 * 
 */
package com.executor;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * Author : Vikas S Pawar
 */
@RunWith(Cucumber.class)
@CucumberOptions(

		features = { "@target/failedTCs.txt" }, glue = { "com/stepdefs", "com/hooks" },

		publish = true, tags = "@smoke or @regression", plugin = { "pretty", "html:CucumberReports/report.html",
				"junit:CucumberReports/report.xml", "json:CucumberReports/report.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "rerun:target/failedTCs.txt" })
public class FailedTCRunnerTest {

}
