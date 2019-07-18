package com.alipay.config;

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
	public static String app_id = "2016101000656812";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCJkpbHc7DWHtUWxitOVYvVTvdneTFlEKl194/BcoERvaJHjuwYiFO8mHTO6Ktn572TjDc8agEG/CrlsQ2Mn3napHYeRlrOMukYQCGT0Owk6Tm4da+LSBhEYgWhGZeVr6OGav7zlzxZoi9K50MAhP3w2act8O5oV2VjKgXdsASaqoEXxWcIZaCzO9TWC6ZoF/WFjrwYAjJ4+EGBXbn9rosiJgrgP0r4ty3hDQ+pE1TtmzgQPVAGgGklRPAZgg48DVdAlrcv3PjW23nKd6Xkuz8q067WWgvFrmPoUhGR/2J9+LWBoBhmEggZ6nRLN0t0b1rDtyQmxMYTBuyffIab7xYLAgMBAAECggEAMnJul/T0g5AK068XckIsZKvwTSFD26ugeIGvVWCHs9m2CEeAi/5xtlaxfq4TLKbt/Y0NNDoq5kTR9ihWr5pLNMHaDn/+DF7e2uWpamrSLTbY06tUE978BxdquQiJbXpanI/frbNnjfbLIMxs5WPfOtKVW2NeCSUDKLngLMq+5XfW4ElUjxBbwVg4NiTRBBSUMDSu3mJ+hmnog6qbKOF4jVfP4hi9FtsS3rUuhhDX2ds3om0ltzCm9DBvNPfQHIlV5iiwjQtur6RbFF/OScPqrrEuJ+TyCkIUGLIAjN25r5enhmZiAIWLRx4xHzF97T9DOTBaiFyDiWbw3d5wQtT9AQKBgQDDUYJNHysLLB1Y4JbuiqGoSXUAcdTTh4s9A21ESam1GcDVey5jgISMWRhKTokaN7NeyYObX6H9ctxvy95qregM6RBQauAtyzcS552MJuuBlcTOHVxqhcbFUan/dDy0QNfmORHX9GrXqo3rS1EN9LywHERjmNzSx5ohq80BYsUfNQKBgQC0UFDa7fLiYLpVoJvX0Bu11WbIDvuirt1ZOeaWOFDWN0MmdgSkJnhoVGXNPpg6QXZ9mt8dmKePGMN6yqq+RJXsxqqiMRa+04kEcxkigJmp9DUW/wIgPEgbEKBNcPQJyxcE0nakP3aooV6pwHfTf7pU1UIjJVoEnc5YXYkxAz/IPwKBgFP2nSokJO/XlgIYAionhFkAwwBe7tvEH/Ipn/ZEKGVG3eOn4Yg6vkBLKKsA2eVgXoZ34FCRquR2VRbmMAXyHpg2NKItX5OwEUvaL5sJPCJnzMPCUXElcw5uDcNYJ6RhX66DiA0q8CcoFXw5021JcTfP3wJlu0ANOFATN7zJxe2lAoGAaQM9k8Nw6RacbrITESVKfiPCsFDJjH16vDRUbrhtm9SjbwrcuR0OkvRUNax2y7bEY3KG7p2xOE2byy+tMRKQnk01ozAjpw9bhRPjV4y98ZUgNjxd6JgzBlAwi+l0tx9oUI6iOhYb7SnOD97f6nVA95cb5YwjWPzu59fRxpG129ECgYEAjwrBtqPTxbAcqwZ9NcEBdYrVrDkwxY5aD7cMDES1mX3hqKPCC4hazL6B35UAGu/hR3CaOrks9BiIb8l2rtt9OMEYB9y/8S/FRH1lPLEHx7b+wtdq8z0PcmDMNCTSfWdlJbVk45tjYpj9co0S8bA90ZN4zEisj0k37yCXakggMgI=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnltfAnpP4TzmQMCCd+OTOfNpWCopt8tpQC1WEO/OZa0wg24uquDe7VIwMdak6j1+GEOcsds3hCGBSY1igViC5T5MRm2zGn9hcky1lg7fWJWWif2Wz5+VqKvft/Hvm0DgtvmUQj87utyaQaxN+Th8vhDSQahzmDJKNXAT5So72zd1hWWShGevQKDsH8exGMgS4uASimbGkroHZZpQlQ5CwcFL8o+XJM2cMXi3yvo+GcCvoiUwI8UzX6XZz9odi4nFBNTrW2U3TuuTHIHupwx3ut1Drx3cjT5EnOP894/nFquAEafpv07R5SGXTq7p9Nl0/zN1pgf5rCjQyuh7TkX5tQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = " http://punny.free.idcfengye.com/store/success";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	
	public static String return_url = " http://punny.free.idcfengye.com/store/success";

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

