package com.duanlei.productDemo.testcase.basicdemo;

import com.duanlei.productDemo.common.Constants;
import com.duanlei.productDemo.data.ServiceData;
import com.duanlei.productDemo.testcase.TestCase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DataProviderDemo extends TestCase {

    final boolean TRUE_RESULT = true;

    /**
     * 本方法为模块公共方法，用于编写模块公共初始化代码
     */
    @BeforeClass(alwaysRun = true)
    public void class_setup() {
    }

    /**
     * 本方法为模块公共方法，用于编写模块公共清理代码
     */
    @AfterClass(alwaysRun = true)
    public void class_teardown() {
    }

    /***
     *  测试用例i数据提供函数
     *
     * */
    @Test(description = "dataProviderTest", groups = {Constants.CASE_TYPE_UT},
    dataProvider ="dataProviderTest" ,dataProviderClass = ServiceData.class)
    public void dataProviderTest(String id, Integer num1, int num2, boolean result) {
        logger.info("ID = " + id +"\n" +
                "num1 = " + num1 +"\n" +
                "num2 = " + num1 +"\n" +
                "result = " + result +"\n");
        // 判断 num1 + num2 是否 == 2
        Assert.assertEquals(num1+ num2 == 3, result);
    }


}
