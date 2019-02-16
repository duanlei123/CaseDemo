package com.duanlei.productDemo.testcase.basicdemo;

import com.duanlei.productDemo.common.Constants;
import com.duanlei.productDemo.testcase.TestCase;
import org.databene.benerator.anno.Source;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileProviderDemo extends TestCase {

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
     * 具体测试例示例，写作注意事项：
     * */
    @Test(description = "测试从 csv 文件引入测试数据", groups = {Constants.CASE_TYPE_UT},
            dataProvider = "fileProvider")
    @Source(value = "data/dataFromCSVTest.csv")
    public void dataFromCSVTest(String sInstanceId, Integer iNumber, Boolean result) {
        logger.info("测试从 csv 文件加载测试数据 \n    是否可以转换参数为 Integer Boolean \n    测试传入判断结果" );
        logger.info("注意： 文件第一行为标题行，不作为参数数据传入 !!!!!" );
        logger.info(" ===> [param]:  sInstanceId = " + sInstanceId + "   ,iNumber =" + iNumber+ " ,result = " + result);

        Assert.assertTrue(result);
    }


    @Test(description = "测试从文件引入测试数据2", groups = {Constants.CASE_TYPE_UT},
            dataProvider = "fileProvider")
    @Source("data/dataFromXLSTest.xls")
    public void dataFromXLSTest(String sInstanceId, String sTest) {
        logger.info("测试从  excel.xls  文件加载测试数据");
        logger.info(" ===> [param]:  sInstanceId  = " + sInstanceId + "   ,sTest =" + sTest);
        Assert.assertTrue(true);
    }

    @Test(description = "测试从 excel .xlsx 文件引入测试数据2", groups = {Constants.CASE_TYPE_UT},
            dataProvider = "fileProvider")
    @Source("conf/data/dataFromXLSXTest.xlsx")
    public void dataFromXLSXTest(String sInstanceId, String sTest) {
        logger.info("测试从 excel .xlsx  文件加载测试数据");
        logger.info(" ===> [param]:  sInstanceId  = " + sInstanceId + "   ,sTest =" + sTest);
        Assert.assertTrue(true);
    }

}
