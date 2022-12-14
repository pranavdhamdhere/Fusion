package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)				
@CucumberOptions(features= { "Features" },
				 glue= { "StepDefinition" },
				 plugin= {"pretty", "html:Report2"},
				 dryRun= true,
				 monochrome= false,
				 tags= ("@SmokeTest3")
)
public class Runner 				
{		

}
