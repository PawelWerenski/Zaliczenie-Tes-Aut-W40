package pl.coderslab.task2;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/Cucumber/Features/Task2", plugin = {"pretty", "html:out.html"})

public class ShoppingTest {
}