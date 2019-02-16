package com.duanlei.productDemo.testcase;

import com.duanlei.productDemo.common.Constants;
import com.duanlei.productDemo.data.ServiceData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


/**
 * 测试的基类
 * <p>
 * <p>
 * 除了分组初始化函数 和 获取conf.properties 中的参数
 * 其他一般不需要修改
 * <p>
 * 1. package命名
 * 1.1 testcase上一级目录 productdemo 按照产品命名
 * 1.2 testcase 各子目录下为产品模块和具体的测试用例
 * 1）子目录按照测试产品的'模块'进行组织（一级、二级... 目录级别建议不要超过三级）
 * 2）子目录下的测试类代表最后一级产品'模块'
 * 3）测试类中@Test注解的测试方法为具体的测试用例。
 * <p>
 * 2  testcase 所有测试类都需要继承TestCase类
 * 提供日志 logger 功能，可以在测试函数中直接使用 logger.info error warn
 * 日志输出到 logs 目录，按执行时间按目录输出。
 * <p>
 * 3  测试套配置参数写在   conf.properties  中
 * 需要在 TestCase 类中初始化静态变量，并在 loadProperties 函数中读取
 * <p>
 */
public class TestCase{

    public static final Logger logger = LoggerFactory.getLogger(TestCase.class);

    // 环境参数(conf.resources保存）
    protected static String sRequestUrl = "http://rds.aliyuncs.com/";
    protected static String sUserKeyId = "trp0aFSy1VkVReaK";
    protected static String sUserKeySecret = "JPafNf7Dm4phkrfkXNOj4U3AYyU5V1";


    /**
     * @BeforeSuite 整个测试套初始化函数
     * 除特殊情况外，一定要标注 alwaysRun = true
     * <p>
     * 1 @before含糊 一般用户初始化测试环境资源，可以抛出异常，后续对应的测试函数状态为 skip。
     * 2  常用 @before 分成4种，存在对应@after函数清除资源：
     * 1） @BeforeSuite： 测试套初始化，整个测试集执行前调用
     * 2） @BeforeGroup： 分组初始化，每个测试分组（groups）执行前调用
     * 3） @BeforeClass： 类初始化，每个测试类执行前调用
     * 4） @BeforeMethod： 函数初始化，每个测试方法（用例）执行之前调用
     */
    @BeforeSuite(alwaysRun = true)
    public void suite_setup() {
        logger.info("TestSuite setup {}");
        init();
    }

    /**
     * @AfterSuite 整个测试套清除函数
     * 除特殊情况外，一定要标注 alwaysRun = true
     * <p>
     * 注意: @after 类型函数如果可能抛出异常，一定要按步骤用 try catch 处理
     * try{
     * // step 1
     * } catch (Exception e){
     * logger.error("error message",e)
     * }
     * try{
     * // step 2
     * } catch (Exception e){
     * logger.error("error message",e)
     * }
     * ....
     * <p>
     * 1 @after 函数一般用于环境清理，防止@after内部其他 后续步骤不执行
     * 2 由于框架机制问题，防止抛出异常影响到后续其他级别的@after函数执行
     */
    @AfterSuite(alwaysRun = true)
    public void suite_teardown() {
        logger.info("TestSuite teardown {}");
        clear();
    }

    /**
     * @BeforeGroups 测试用例分组初始化函数
     * 编写按组初始化的代码
     * 需要标明所属分组 groups
     * 除特殊情况外，一定要标注 alwaysRun = true
     * <p>
     * 注意: 不能假定在 @beforeClass之前 执行。
     */
    @BeforeGroups(groups = {Constants.CASE_TYPE_API}, alwaysRun = true)
    public void group_api_setup() {
        logger.info("TestGroup initial: {} " + Constants.CASE_TYPE_API);
    }

    /**
     * @AfterGroups 测试用例分组清除函数
     * 需要标明所属分组 groups
     * 除特殊情况外，一定要标注 alwaysRun = true
     * <p>
     * 注意: after 类型函数如果可能抛出异常，一定要按步骤用 try catch 处理
     * try{
     * // step 1
     * } catch (Exception e){
     * logger.error("error message",e)
     * }
     * try{
     * // step 2
     * } catch (Exception e){
     * logger.error("error message",e)
     * }
     * ....
     * 1 after 函数一般用于环境清理，防止after内部其他 后续步骤不执行
     * 2 由于框架机制问题，防止抛出异常影响到后续其他级别的after函数执行
     */
    @AfterGroups(groups = {Constants.CASE_TYPE_API}, alwaysRun = true)
    public void group_api_teardown() {
        logger.info("TestGroup teardown:  {}" + Constants.CASE_TYPE_API);
    }


    /**
     * 本函数用于脚本框架的初始化
     */
    void init() {
        //读取配置文件
        loadProperties();
    }

    void clear() {
        //to do...
    }


    /**
     * 从conf配置中解析数据，保存到基类的成员变量
     * 请将全局参数放在此处设置,如数据库IP地址、服务器IP地址/域名等
     */
    public void loadProperties() {

        Properties prop = new Properties();

        try{
            FileInputStream fis = new FileInputStream(getCfgPath());
            prop.load(fis);
            sRequestUrl = prop.getProperty("requestUrl");
            sUserKeyId = prop.getProperty("userKeyId");
            sUserKeySecret = prop.getProperty("userKeySecret");
            logger.info("Request Url is : {} , keyId is {} , keySecret is {}  ", sRequestUrl, sUserKeyId, sUserKeySecret);
            ServiceData.initInstanceId(prop.getProperty("rds.instanceId"));

        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.error("Loading Properties occurs error", e);
        }
    }

    protected static String getCfgPath() {

        String sUserPath = System.getProperty("user.dir");

        sUserPath += File.separator + "conf" + File.separator;
        sUserPath += "conf.properties";

        return sUserPath;
    }


}
