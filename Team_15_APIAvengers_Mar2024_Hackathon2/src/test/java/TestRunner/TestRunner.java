package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
        glue = {"StepDefinition"},
        		   plugin = {"pretty","html:HtmlReport/report.html",
        		    		"json:JSONReport/report.json",
        		    		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        		    		"timeline:test-output-thread/",
        		    		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},        
			monochrome=false //console output color
			
		)
public class TestRunner  {
	


}
