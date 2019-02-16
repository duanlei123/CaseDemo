package com.duanlei.productDemo.testcase.basicdemo;

import com.duanlei.productDemo.common.Constants;
import com.duanlei.productDemo.testcase.TestCase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;

/**
 * 测试产品  productDemo
 * 测试用例一级模块 basicdemo
 * 测试用例二级模块 AssertDemo
 * <p>
 * TestNG Assert 函数使用测试示例
 */
public class AssertDemo extends TestCase {

    final boolean TRUE_RESULT = true;

    /**
     * @BeforeClass 方法 为类初始化方法
     * 属于模块公共方法，用于编写模块公共初始化代码
     * 除特殊情况外，一定要标注 alwaysRun = true
     */
    @BeforeClass(alwaysRun = true)
    public void class_setup() {
        logger.info("  ** 按测试类初始化 **  ");
    }

    /**
     * @AfterClass 方法 为类清除方法
     * 属于模块公共方法，用于编写模块公共清理代码
     * 除特殊情况外，一定要标注 alwaysRun = true
     */
    @AfterClass(alwaysRun = true)
    public void class_teardown() {
        logger.info("  ** 按测试类清除 **  ");
    }

    /***
     * @Test 标注的方法为具体的测试用例
     * description 为用例标题
     * groups 为 测试用例所属分组，可属多个分组，用' ,'  分隔
     *            各分组名，可在组织编写测试用例的时候，在 Constants 类中统一创建
     *
     * */
    @Test(description = "assertTrueTest", groups = {Constants.CASE_TYPE_UT})
    public void assertTrueTest() {
        Assert.assertTrue(TRUE_RESULT, "测试 AssertTrue");
    }


    /***
     * 具体测试例示例
     * */
    @Test(description = "assertFalseTest", groups = {Constants.CASE_TYPE_UT})
    public void assertFalseTest() {
        Assert.assertFalse(TRUE_RESULT, "测试 AssertFalse");
    }

    /***
     * 具体测试例示例
     * */
    @Test(description = "assertFailTest", groups = {Constants.CASE_TYPE_UT})
    public void assertFailTest() {
        Assert.fail("测试 Assert 直接 fail");
    }


    /***
     * 具体测试例示例
     * */
    @Test(description = "assertEqualsTest", groups = {Constants.CASE_TYPE_UT})
    public void assertEqualsTest() {


        int number00 = 123;
        int number01 = 123;
        Assert.assertEquals(number00, number01, "测试 int AssertEquals");

        Integer number10 = new Integer(123);
        Integer number11 = new Integer(123);
        Assert.assertEquals(number10, number11, "测试 Integer AssertEquals");

        float number20 = 0.1f;
        float number21 = 0.1001f;
        // float double 需要给出精度
        Assert.assertEquals(number20, number21, 0.001f, "测试 float AssertEquals");

        char[] array00 = {'0', 'a', '*'};
        char[] array01 = {'0', 'a', '*'};
        // 数组测试
        Assert.assertEquals(array00, array01, "测试 数组 AssertEquals");

    }


    /***
     * 具体测试例示例
     * */
    @Test(description = "assertEqualsExtTest", groups = {Constants.CASE_TYPE_UT})
    public void assertEqualsExtTest() {

        Character[] array00 = {'0', 'a', '*'};
        Character[] array01 = {'0', 'a', '*'};
        // 数组测试
        Assert.assertEquals(array00, array01, "测试 数组 AssertEquals");

        List<String> list00 = new ArrayList<>();
        List<String> list01 = new ArrayList<>();

        list00.add("hello ");
        list00.add("world ");
        list00.add("!!");
        list01.add("hello ");
        list01.add("world ");
        list01.add("!!");
        // Collection 测试
        Assert.assertEquals(list00, list01, "测试 Collection AssertEquals");


        Set<String> set00 = new HashSet<>();
        Set<String> set01 = new HashSet<>();

        set00.add("hello ");
        set00.add("world ");
        set00.add("!!");
        set01.add("hello ");
        set01.add("world ");
        set01.add("!!");
        // Set 测试
        Assert.assertEquals(set00, set01, "测试 Set AssertEquals");


        Map<String, String> map00 = new HashMap<>();
        Map<String, String> map01 = new HashMap<>();

        map00.put("0", "hello ");
        map00.put("1", "world ");
        map00.put("2", "!!");
        map01.put("0", "hello ");
        map01.put("1", "world ");
        map01.put("2", "!!");
        // Map 测试
        Assert.assertEquals(map00, map01);

    }

    /***
     * 具体测试例示例
     * */
    @Test(description = "assertNotEqualsTest", groups = {Constants.CASE_TYPE_UT})
    public void assertNotEqualsTest() {


        int number00 = 123;
        int number01 = 456;
        Assert.assertNotEquals(number00, number01, "测试 int AssertEquals");

        float number20 = 0.1f;
        float number21 = 0.101f;
        // float double 需要给出精度
        Assert.assertNotEquals(number20, number21, 0.001f, "测试 float AssertNotEquals");
    }

    /***
     * 具体测试例示例
     * */
    @Test(description = "assertNullTest", groups = {Constants.CASE_TYPE_UT})
    public void assertNullTest() {
        Integer numberNull = null;
        Assert.assertNull(numberNull, "测试 assertNullTest");
    }

    /***
     * 具体测试例示例
     * */
    @Test(description = "assertNotNullTest", groups = {Constants.CASE_TYPE_UT})
    public void assertNotNullTest() {
        Integer numberNul = null;
        Assert.assertNotNull(numberNul, "测试 assertNullTest");
    }

    /***
     * 具体测试例示例
     * */
    @Test(description = "assertSameTest", groups = {Constants.CASE_TYPE_UT})
    public void assertSameTest() {
        Integer ob1 = new Integer(1);
        Integer ob2 = new Integer(1);
        Assert.assertEquals(ob1, ob2, "测试 AssertEquals");
        Assert.assertSame(ob1, ob2, "测试 AssertSame");
    }

    /***
     * 具体测试例示例
     * */
    @Test(description = "assertNotSameTest", groups = {Constants.CASE_TYPE_UT})
    public void assertNotSameTest() {
        Integer ob1 = new Integer(1);
        Integer ob2 = new Integer(1);
        Assert.assertEquals(ob1, ob2, "测试 AssertEquals");
        Assert.assertNotSame(ob1, ob2, "测试 AssertNotSame");
    }

    @Test(description = "assertExceptionTest", groups = {Constants.CASE_TYPE_UT},
            expectedExceptions = ArrayIndexOutOfBoundsException.class)
    public void assertExceptionTest() throws Exception {
        throw new ArrayIndexOutOfBoundsException("超出数组范围");
    }

    @Test(description = "assertExceptionMsgTest", groups = {Constants.CASE_TYPE_UT},
            expectedExceptions = Exception.class,
            expectedExceptionsMessageRegExp = "^超出.*")
    public void assertExceptionMsgTest() throws Exception {
        throw new ArrayIndexOutOfBoundsException("超出数组范围");
    }
}
