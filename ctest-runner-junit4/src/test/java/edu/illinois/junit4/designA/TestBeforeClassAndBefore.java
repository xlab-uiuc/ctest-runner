package edu.illinois.junit4.designA;

import edu.illinois.CTest;
import edu.illinois.CTestJUnit4Runner;
import edu.illinois.Configuration;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 * Author: Shuai Wang
 * Date:  11/4/23
 */
@RunWith(CTestJUnit4Runner.class)
public class TestBeforeClassAndBefore {
    Configuration conf = null;
    @BeforeClass
    public static void setUp() {
        Configuration conf = new Configuration();
        conf.get("beforeClass");
    }

    @Before
    public void setUp2() {
        conf = new Configuration();
        conf.get("before");
    }

    @CTest(value = {"beforeClass", "before", "param1"})
    public void test() {
        conf.get("param1");
    }

    @CTest(value = {"beforeClass", "before", "param2"})
    public void test2() {
        conf.get("param2");
    }
}
