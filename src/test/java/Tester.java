import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:customers.feature",
                plugin = "html:target/cucumber/wikipedia.html"
)
public class Tester {
}
