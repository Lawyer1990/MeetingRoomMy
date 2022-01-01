import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestCases extends BaseTest{
    @Test
    public void test1() {
        testCasesId = "1";
        System.out.println("test1 - done");
    }

    @Test
    public void test2() {
        testCasesId = "2";
        System.out.println("test2 - skip");
        throw new SkipException("skip");
    }
    @Test
    public void test3() {
        testCasesId = "3";
        System.out.println("test3 - fail");
        Assert.fail();
    }
}
