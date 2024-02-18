/**
 * 
 */
package com.executor;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

/**
 *  Author : Vikas S Pawar
 */

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(

		features = {"src/test/resources/MyFeatures/LoginPage.feature",
				"src/test/resources/MyFeatures/MyAccountPage.feature"}, 
		glue = { "com/stepdefs","com/hooks" }, 
		dryRun = false, 
		publish = true, 
		tags = "@smoke or @regression",
		plugin = { "pretty", "html:CucumberReports/report.html",
					"junit:CucumberReports/report.xml", "json:CucumberReports/report.json",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class MySerenityRunnerTest {

}
