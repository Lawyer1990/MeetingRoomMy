import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseTest {

    protected String testCasesId;

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
