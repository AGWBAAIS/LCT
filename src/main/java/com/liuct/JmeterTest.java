package com.liuct;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.slf4j.Logger;

public class JmeterTest extends AbstractJavaSamplerClient {

    @Override
    protected Logger getNewLogger() {
        return super.getNewLogger();
    }

    /**
     * 设置需要的请求参数并设置参数默认值，会在jmeter GUI 显示
     * @return
     */
    @Override
    public Arguments getDefaultParameters() {
        Arguments arguments = new Arguments();
        arguments.addArgument("apiId","123");
        arguments.addArgument("token","456");
        arguments.addArgument("appKey","789");
        getNewLogger().info("getDefaultParameters()");
        System.out.println("getDefaultParameters");
        return arguments;
    }

    /**
     * 测试之前的初始化工作
     * @param context
     */
    @Override
    public void setupTest(JavaSamplerContext context) {
        getNewLogger().info("setupTest()");
        System.out.println("setupTest");
        int apiId = context.getIntParameter("apiId");
        System.out.println("apiId:" + apiId);
        super.setupTest(context);
    }

    /**
     * 测试的业务逻辑
     * @param context
     * @return
     */
    public SampleResult runTest(JavaSamplerContext context) {
        getNewLogger().info("runTest()");
        System.out.println("runTest");
        int appKey = context.getIntParameter("appKey");
        System.out.println("appKey:" + appKey);
        return null;
    }

    /**
     * 测试结束时候调用
     * @param context
     */
    @Override
    public void teardownTest(JavaSamplerContext context) {
        getNewLogger().info("teardownTest()");
        System.out.println("teardownTest");
        super.teardownTest(context);
    }
}

