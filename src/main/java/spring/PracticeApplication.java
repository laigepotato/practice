package spring; /**
 * @program: practice
 * @description:
 * @author: Sansanli
 * @create: 2021-10-26 17:26
 **/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeApplication.class, args);
        //String tmp = "{\"useTtl\":false,\"degrade\":false,\"exceptionThreshold\":1000,\"sampleRate\":10000,\"pluginsPath\":null,\"httpEntrancePatterns\":[\"^/.*account/get\"],\"customEntranceBehaviors\":[],\"customSubInvokeBehaviors\":[{\"name\":\"调用Midas\",\"classPattern\":\"com.tencent.ams.billing.account.broker.midas.MidasClient\",\"methodPatterns\":[\"sendAndReceive\"],\"includeSubClasses\":true},{\"name\":\"PB\",\"classPattern\":\"app.qzap.gdt.api.proto.DIServiceHelper\",\"methodPatterns\":[\"*\"],\"includeSubClasses\":true},{\"name\":\"调用计费中心\",\"classPattern\":\"com.tencent.ams.billing.account.broker.bc.BillingCenterClient\",\"methodPatterns\":[\"invoke\"],\"includeSubClasses\":true},{\"name\":\"访问DI\",\"classPattern\":\"com.tencent.ams.billing.broker.di.service.*\",\"methodPatterns\":[\"*\"],\"includeSubClasses\":true},{\"name\":\"访问CKV\",\"classPattern\":\"com.tencent.ams.billing.broker.ckv.*Service\",\"methodPatterns\":[\"*\"],\"includeSubClasses\":true},{\"name\":\"调用计费账户服务\",\"classPattern\":\"com.tencent.ams.billing.account.service.BillingAccountProxyService\",\"methodPatterns\":[\"*\"],\"includeSubClasses\":true}],\"pluginIdentities\":[\"http\",\"custom-subInvoke\",\"custom-entrance\"],\"repeatIdentities\":[\"http\"]}"
    }
}
