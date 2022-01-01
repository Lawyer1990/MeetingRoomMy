import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestRailController {
    public static String TEST_RUN_ID                = "3";
    public static String TESTRAIL_USERNAME          = "alexey.sklutov@mail.ru";
    public static String TESTRAIL_PASSWORD          = "RDTsX8u8lQPdg7l1gGUk";
    public static String RAILS_ENGINE_URL           = "https://meetingroommy.testrail.io/";
    public static final int TEST_CASE_PASSED_STATUS = 1;
    public static final int TEST_CASE_FAILED_STATUS = 5;
    public static final int TEST_CASE_BLOCKED_STATUS = 2;
    public static final int TEST_CASE_RETEST_STATUS = 4;



    public static void addResultForTestCase(String testCaseId, int status,
                                            String error) throws IOException, APIException {

        String testRunId = TEST_RUN_ID;

        APIClient client = new APIClient(RAILS_ENGINE_URL);
        client.setUser(TESTRAIL_USERNAME);
        client.setPassword(TESTRAIL_PASSWORD);
        Map<String, java.io.Serializable> data = new HashMap<String, java.io.Serializable>();
        data.put("status_id", status);
        data.put("comment", "Test Executed - Status updated automatically from Jenkins.");
        client.sendPost("add_result_for_case/"+testRunId+"/"+testCaseId+"",data );

    }
}
