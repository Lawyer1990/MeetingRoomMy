

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

@CucumberOptions(
        features = "src/test/java/cucumber/Tests.feature",
        monochrome = true
)

public class RunnerCucumber extends AbstractTestNGCucumberTests {
    protected static String testCasesId;
    @AfterMethod
    public void tearDown(ITestResult result) throws Throwable{
        switch (result.getStatus()){
            case ITestResult.SUCCESS:{
                TestRailController.addResultForTestCase(testCasesId, TestRailController.TEST_CASE_PASSED_STATUS, "passed");
                break;
            }
            case ITestResult.FAILURE:{
                TestRailController.addResultForTestCase(testCasesId, TestRailController.TEST_CASE_FAILED_STATUS, String.valueOf(result.getThrowable()));
                break;
            }
            case ITestResult.SKIP:{
                TestRailController.addResultForTestCase(testCasesId, TestRailController.TEST_CASE_RETEST_STATUS, String.valueOf(result.getThrowable()));
                break;
            }
        }
    }
}