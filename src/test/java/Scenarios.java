import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class Scenarios extends RunnerCucumber{

    @Given("set id test {string}")
    public void setId(String id){
        testCasesId = id;
    }

    @And("check test1")
    public void test1() {
        System.out.println("test1 - done");
    }

    @And("check test2")
    public void test2() {
        System.out.println("test2 - done");
    }

    @And("check test3")
    public void test3() {
        System.out.println("test3 - done");
    }
}
