package com.alipay.config;

import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */
public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016091700531815";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCkQ1EUhGxC3FmMloAG2BVwT7gRyASOX+OwkmrCeMmyMinqCtTLQvsugRdYKPX5y4hpjM3F/R0dKBZSV5M8ET6YsZSIHGNKB6dHBadWfoi8Y94gpOhZ/eKe0UKJXcvIt4+RmrnDIuq7cboRdW2Qjr2yu+Q6LW6YiWaIkffqvPgZ7yYJZObovRQVQFbB511FRvblyTZQGoEgvFQG8WrWFOKbWqiW/J/q/WXmzIr/2+my3Wcf/wUj9RRMbhzb4/wPDB2MGeMOmqq/n763n21kXrxPVwo7SEWUkvNqzFXPuNVVZhd8dhkuFFUhiT/TVxjMm+Ii/pWbdaOsBvdpO6BHwyMVAgMBAAECggEASdqiZ9EqQ92Cvb0lDu60pOyS3BvMQJ9IZilOquVX+jCnu7zm9ATHnp8X+eFgxtEGIj7WfgBRyLwvXRJW9pjiRhEBsTjiQ3SxdzNJi5AUtm9IffDnLx8Bd1qqycxMRZCSkmq4vs3CMEjv2c2sV2R2Uhg8gxPON/L/EMRgbUBNZIrzGahZkrwVu7VDKPBjH7uHbPKsbHScqcM4/soc0Vb8I5760nunsNuow9lALQatvbLhft/E5z3lzCVCMmrSzNJ/vqVQn117BiDF3Ouu6XYViaay0RGkpqSuHvHJMZIgBwEUcMo6C12fr+h5ni/LXVUrFWqkbIVHldp3eE86KaGyuQKBgQDZv+UmUoZP/SNA3gvYjz1WaeviRM89qpsSymeq5L5/3ciOFvKRn1OQEz4hX56Cwa469tlPTBBhoFekMedVnP7XO3/3fjX50Iq7Dl1iYoe9YJQ/S63IjwAGOrz93BNc79/i0LKXhZO3lQxFNLLXNOOXyyODWLcKLJrKtjge1+y6NwKBgQDBHiaaWalkIOohtDdvyhVzKceYr8zyrWdgq2MXeF4j0SBW2f2PntAimP/KX3RxRw0Es7oaWr6nJs4UgwVqGhVd76tAF5hCdgIXirt8KreAfXe1BuIdUAA/2TLFnfQ9L9cc78ABtIeKDpkUfJtzVIowONeQEec9tUUr5KsKXoy3EwKBgDEoNAgJu06Ve/7p4cy60YMPmHPVSt/GAwoj7XFUAHmHTP5eydX8HPY6kd0g4/zq0nV3Qqm3Jz+S3hYwOeRG8/UM9p+du3uxC5Cc9pH+YlxrUCxV3l6Xgc7mNcIti6WAdY+Tw62XNzjLiiCZfAI/a13aOyMsxO2kEjHPHy4/Wq7TAoGAIcZqLficfZycFkT0pSKM2dVmyTeF+rOFLw0KiaJNpKoAo/AAPswhzss/gV9seBtbFYVxeQaB7a4FwOShX8ssDX/LTaxSvtzwxLlIzRCTg29uLkUD6uiBAqm0DYfwnXrufmsYA7RVODoRX9njPip8+K4YVWQsM0iuzlxx5aBfr+0CgYEAzhJAvRjAoIGqleKjFkqsYKrUdaHzmt0owNVQK2+19VrPQ/hOer3p8Hm44sGOmGZ2ctJ3n0eg26w5mSRSK8q+YYITz9+gRzFJ0UQzWA6sIokj52HYT05Ay8YNMwqh1ADiuG33Tcgmxpocu8i0YPYddSDtXEcr0VqX2EslO3TN+bs=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArCZ8vJUItLZz+KbpgKQ0f30hN5/G+nXgUpFvG0khdIwIG4yKAguBxYwjQnNyC4Masi29F0hcu6a9KgW6M6uq8B4rBVfhznBEvnDslFknIXLvFLXdx0eftOSCU38KbIDxtX4nXuvf8/uaY86IR2KnLoVbfHxMb0dnst6hFcWdwuiyxpxrDBNGBRNlYtJTbd2b4C2NJ9XmBdW2+Oww9Mooai+w0fXWJSm+fDpno8WX1xlVybX6JSOHWrzv8P6rMx543k3aDPGpyocVp3weU8t/4o1lI9OILePVw8cj4D/MfoArsrXuwSAYgzlNdhi2YbN7ibCch/Z80vgqhhFWyL5FRwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8000/jiajiaoProject/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8000/jiajiaoProject/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

