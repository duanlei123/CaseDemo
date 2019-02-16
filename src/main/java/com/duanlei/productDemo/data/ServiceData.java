package com.duanlei.productDemo.data;

import org.testng.annotations.DataProvider;
import org.testng.annotations.TestInstance;

/**
 *  测试用例i数据提供类
 *  实际使用的时候，建议也按照测试模块组织目录
 *
 */
public class ServiceData {

    public static String instanceId = "";

    /**
     *  测试数据提供类
     *
     */
    public static void initInstanceId(String s) {
        instanceId = s;
    }

    /**
     * 数据提供函数@DataProvider
     * 返回类型为 Object[][]
     * 可返回多组 测试数据
     * 每一组数据，对应于测试函数 ( @Test注解的函数 ) 的入参
     *
     * @return 参数
     */
    @DataProvider(name = "dataProviderTest")
    public static Object[][] dataCliTester() {
        return new Object[][]{
                {"id001", new Integer(1), 2, true},  // Cli测试数据
                {"id002", new Integer(2), 2, false},  // Cli测试数据
        };

    }

    @DataProvider(name = "dbInstanceId")
    public static Object[][] dbInstanceId() {
        return new Object[][]{
                {instanceId},  // db实例Id
        };
    }

    @DataProvider(name = "baiduTest")
    public static Object[][] baiduTest() {
        return new Object[][]{
                {"rds6grctjhymdwr1pvzqc"},  // 百度测试的参数
        };

    }


    @DataProvider(name = "fun1_testExceptionData")
    public static Object[][] fun1_testExceptionData() {
        return new Object[][]{
                {new Integer(1)},  // 正数
                {new Integer(-1)} // 负数
        };
    }

    @DataProvider(name = "dataSdkTester")
    public static Object[][] dataSdkTester() {
        return new Object[][]{
                {"rds6grctjhymdwr1pvzqc", "222"},  //sdk测试参数
        };
    }
}
