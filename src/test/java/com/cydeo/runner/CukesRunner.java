package com.cydeo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        features ="src/test/resources/features",
        glue = "src/test/java/com/cydeo/stepdefination",
        dryRun = false,
        tags = ""
)

 class cooksrunner {

}
