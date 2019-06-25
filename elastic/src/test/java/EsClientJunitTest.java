import com.ekfet.elastic.EsHighRestClient;
import com.ekfet.elastic.config.ElasticClientConfig;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.*;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.stream.Collectors;

public class EsClientJunitTest {

    @Test
    public void TestClient() throws IOException {

        RestHighLevelClient restClient = EsHighRestClient.initClient();
        System.out.println(restClient);
        restClient.close();

    }

    @Test
    public void createIndex() throws IOException {

        RestHighLevelClient restClient = EsHighRestClient.initClient();
        System.out.println(restClient);

        CreateIndexRequest indexRequest = new CreateIndexRequest("book");
        indexRequest.settings(Settings.builder().put("index.number_of_shards", 5).put("index.number_of_replicas", 2));
        CreateIndexResponse indexResponse = restClient.indices().create(indexRequest, RequestOptions.DEFAULT);
        boolean success = indexResponse.isAcknowledged();
        if (success) {
            ;
            System.out.println(indexResponse.index());
            System.out.println(indexResponse.isShardsAcknowledged());
        } else {
            System.out.println("success=" + success);
        }
        restClient.close();

    }

    @Test
    public void insertCocument() throws IOException {

        RestHighLevelClient restClient = EsHighRestClient.initClient();
        System.out.println(restClient);

        IndexRequest indexRequest = new IndexRequest("book", "science");



        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject();
        {
            builder.field("name", "Effective Java中文版（原书第3版");
            builder.field("author", "Joshua Bloch");
            builder.field("translator", "俞黎敏");
            builder.field("publishing", "机械工业出版社");
            builder.field("ISBN", "9787111612728");
            builder.field("version", 3);
            builder.field("publishDate", "2019-01-01");
            builder.field("introduction", "Java之父James Gosling鼎力推荐、Jolt获奖作品全新升级，针对Java 7、8、9全面更新，Java程序员必备参考书。包含大量完整的示例代码和透彻的技术分析，通过90条经验法则，探索新的设计模式和语言习惯用法，帮助读者更加有效地使用Java编程语言及其基本类库。\n" +
                    "\n" +
                    "全书共12章，90条。第1章为引言；第2章阐述何时以及如何创建和避免创建对象，如何确保对象能够适时地销毁，以及如何管理对象销毁之前必须进行的各种清除动作；第3章阐述所有对象都通用的方法，如equals、hashCode、toString、clone和finalize以及Comparable.compareTo方法等；第4章阐述作为Java语言的核心以及Java语言的基本抽象单元（类和接口）在使用上的一些指导原则，以设计出更加有用、健壮和灵活的类与接口；第5章和第6章分别阐述在Java 1.5发行版本中新增加的泛型、枚举和注解的*佳实践，教你如何*大限度地享有这些优势；第7章讨论在Java 8中新增的函数接口、Lambda、方法引用，和为处理数据元素的序列提供类库级别支持的Stream API；第8章讨论方法设计的几个方面：如何处理参数和返回值，如何设计方法签名，如何为方法编写文档，从而使方法设计在可用性、健壮性和灵活性上有进一步的提升；第9章主要讨论Java语言的具体细节，包括局部变量的处理、控制结构、类库的使用、各种数据类型的用法、反射机制和本地方法的用法，以及优化和命名惯例；第10章阐述如何充分发挥异常的优点来提高程序的可读性、可靠性和可维护性，以及减少异常使用不当所带来的负面影响，并提供了一些关于有效使用异常的指导原则；第11章阐述写出清晰、正确、文档组织良好的并发程序；第12章讲解序列化方面的技术，其中包括序列化代理模式，它可以帮助你避免对象序列化的许多缺陷。");
            builder.field("authorIntr", "Joshua Bloch　美国卡内基-梅隆大学教授，曾是Google公司首席Java架构师、Sun公司杰出工程师和Transarc公司高级系统设计师。他带领团队设计和实现过无数的Java平台特性，包括JDK 5.0语言增强版和获奖的Java Collections Framework。他拥有哥伦比亚大学的计算机科学学士学位和卡内基-梅隆大学的计算机科学博士学位。他的著作还包括《Java Puzzlers》和《Java并发编程实战》（曾获Jolt大奖提名）等。\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "俞黎敏（YuLimin，网名：阿敏总司令） 2008年7月加入IBM广州分公司，担任高级技术顾问，主要负责WebSphere系列产品以及云计算、物联网相关的技术支持工作，专注于产品新特性、系统性能调优、疑难问题诊断与解决。开源爱好者，曾参与Spring中文论坛组织的《Spring 2.0 Reference》中文翻译的一审与二审，满江红开放技术研究组织的《Seam 1.2.1 Reference》的中文翻译，组织完成了《Seam 2.0 Reference》的中文翻译工作。CSDN、CJSDN、Dev2Dev、Matrix、JavaWorldTW、Spring中文等Java论坛的版主，在各大技术社区为推动开源和敏捷开发做出了积极的贡献。翻译与审校过多本图书。\n" +
                    "\n" +
                    "个人网站：http://www.Java2Class.net；博客：http://blog.csdn.net/YuLimin/");
            builder.field("chapter","推荐序\n" +
                    "\n" +
                    "译者序\n" +
                    "\n" +
                    "前言\n" +
                    "\n" +
                    "致谢\n" +
                    "\n" +
                    "第1章　引言 1\n" +
                    "\n" +
                    "第2章　创建和销毁对象 4\n" +
                    "\n" +
                    "第1条：用静态工厂方法代替构造器 4\n" +
                    "\n" +
                    "第2条：遇到多个构造器参数时要考虑使用构建器 8\n" +
                    "\n" +
                    "第3条：用私有构造器或者枚举类型强化Singleton属性 13\n" +
                    "\n" +
                    "第4条：通过私有构造器强化不可实例化的能力 15\n" +
                    "\n" +
                    "第5条：优先考虑依赖注入来引用资源 16\n" +
                    "\n" +
                    "第6条：避免创建不必要的对象 18\n" +
                    "\n" +
                    "第7条：消除过期的对象引用 20\n" +
                    "\n" +
                    "第8条：避免使用终结方法和清除方法 23\n" +
                    "\n" +
                    "第9条：try-with-resources优先于try-f?inally 27\n" +
                    "\n" +
                    "第3章　对于所有对象都通用的方法 30\n" +
                    "\n" +
                    "第10条：覆盖equals时请遵守通用约定 30\n" +
                    "\n" +
                    "第11条：覆盖equals时总要覆盖hashCode 40\n" +
                    "\n" +
                    "第12条：始终要覆盖toString 44\n" +
                    "\n" +
                    "第13条：谨慎地覆盖clone 46\n" +
                    "\n" +
                    "第14条：考虑实现Comparable接口 53\n" +
                    "\n" +
                    "第4章　类和接口 59\n" +
                    "\n" +
                    "第15条：使类和成员的可访问性最小化 59\n" +
                    "\n" +
                    "第16条：要在公有类而非公有域中使用访问方法 62\n" +
                    "\n" +
                    "第17条：使可变性最小化 64\n" +
                    "\n" +
                    "第18条：复合优先于继承 70\n" +
                    "\n" +
                    "第19条：要么设计继承并提供文档说明，要么禁止继承 75\n" +
                    "\n" +
                    "第20条：接口优于抽象类 79\n" +
                    "\n" +
                    "第21条：为后代设计接口 83\n" +
                    "\n" +
                    "第22条：接口只用于定义类型 85\n" +
                    "\n" +
                    "第23条：类层次优于标签类 86\n" +
                    "\n" +
                    "第24条：静态成员类优于非静态成员类 88\n" +
                    "\n" +
                    "第25条：限制源文件为单个顶级类 91\n" +
                    "\n" +
                    "第5章　泛型 93\n" +
                    "\n" +
                    "第26条：请不要使用原生态类型 93\n" +
                    "\n" +
                    "第27条：消除非受检的警告 97\n" +
                    "\n" +
                    "第28条：列表优于数组 99\n" +
                    "\n" +
                    "第29条：优先考虑泛型 102\n" +
                    "\n" +
                    "第30条：优先考虑泛型方法 106\n" +
                    "\n" +
                    "第31条：利用有限制通配符来提升API的灵活性 109\n" +
                    "\n" +
                    "第32条：谨慎并用泛型和可变参数 114\n" +
                    "\n" +
                    "第33条：优先考虑类型安全的异构容器 118\n" +
                    "\n" +
                    "第6章　枚举和注解 123\n" +
                    "\n" +
                    "第34条：用enum代替int常量 123\n" +
                    "\n" +
                    "第35条：用实例域代替序数 131\n" +
                    "\n" +
                    "第36条：用EnumSet代替位域 132\n" +
                    "\n" +
                    "第37条：用EnumMap代替序数索引 134\n" +
                    "\n" +
                    "第38条：用接口模拟可扩展的枚举 138\n" +
                    "\n" +
                    "第39条：注解优先于命名模式 140\n" +
                    "\n" +
                    "第40条：坚持使用Override注解 147\n" +
                    "\n" +
                    "第41条：用标记接口定义类型 149\n" +
                    "\n" +
                    "第7章　Lambda和Stream 151\n" +
                    "\n" +
                    "第42条：Lambda优先于匿名类 151\n" +
                    "\n" +
                    "第43条：方法引用优先于Lambda 154\n" +
                    "\n" +
                    "第44条：坚持使用标准的函数接口 156\n" +
                    "\n" +
                    "第45条：谨慎使用Stream 159\n" +
                    "\n" +
                    "第46条：优先选择Stream中无副作用的函数 164\n" +
                    "\n" +
                    "第47条：Stream要优先用Collection作为返回类型 168\n" +
                    "\n" +
                    "第48条：谨慎使用Stream并行 172\n" +
                    "\n" +
                    "第8章　方法 176\n" +
                    "\n" +
                    "第49条：检查参数的有效性 176\n" +
                    "\n" +
                    "第50条：必要时进行保护性拷贝 179\n" +
                    "\n" +
                    "第51条：谨慎设计方法签名 182\n" +
                    "\n" +
                    "第52条：慎用重载 184\n" +
                    "\n" +
                    "第53条：慎用可变参数 189\n" +
                    "\n" +
                    "第54条：返回零长度的数组或者集合，而不是null 190\n" +
                    "\n" +
                    "第55条：谨慎返回optinal 192\n" +
                    "\n" +
                    "第56条：为所有导出的API元素编写文档注释 196\n" +
                    "\n" +
                    "第9章　通用编程 202\n" +
                    "\n" +
                    "第57条：将局部变量的作用域最小化 202\n" +
                    "\n" +
                    "第58条：for-each循环优先于传统的for循环 204\n" +
                    "\n" +
                    "第59条：了解和使用类库 207\n" +
                    "\n" +
                    "第60条：如果需要精确的答案，请避免使用f?loat和double 209\n" +
                    "\n" +
                    "第61条：基本类型优先于装箱基本类型 211\n" +
                    "\n" +
                    "第62条：如果其他类型更适合，则尽量避免使用字符串 213\n" +
                    "\n" +
                    "第63条：了解字符串连接的性能 215\n" +
                    "\n" +
                    "第64条：通过接口引用对象 216\n" +
                    "\n" +
                    "第65条：接口优先于反射机制 218\n" +
                    "\n" +
                    "第66条：谨慎地使用本地方法 220\n" +
                    "\n" +
                    "第67条：谨慎地进行优化 221\n" +
                    "\n" +
                    "第68条：遵守普遍接受的命名惯例 223\n" +
                    "\n" +
                    "第10章　异常 227\n" +
                    "\n" +
                    "第69条：只针对异常的情况才使用异常 227\n" +
                    "\n" +
                    "第70条：对可恢复的情况使用受检异常，对编程错误使用运行时异常 229\n" +
                    "\n" +
                    "第71条：避免不必要地使用受检异常 231\n" +
                    "\n" +
                    "第72条：优先使用标准的异常 232\n" +
                    "\n" +
                    "第73条：抛出与抽象对应的异常 234\n" +
                    "\n" +
                    "第74条：每个方法抛出的所有异常都要建立文档 235\n" +
                    "\n" +
                    "第75条：在细节消息中包含失败-捕获信息 237\n" +
                    "\n" +
                    "第76条：努力使失败保持原子性 238\n" +
                    "\n" +
                    "第77条：不要忽略异常 239\n" +
                    "\n" +
                    "第11章　并发 241\n" +
                    "\n" +
                    "第78条：同步访问共享的可变数据 241\n" +
                    "\n" +
                    "第79条：避免过度同步 245\n" +
                    "\n" +
                    "第80条：executor、task和stream优先于线程 250\n" +
                    "\n" +
                    "第81条：并发工具优先于wait和notify 251\n" +
                    "\n" +
                    "第82条：线程安全性的文档化 256\n" +
                    "\n" +
                    "第83条：慎用延迟初始化 258\n" +
                    "\n" +
                    "第84条：不要依赖于线程调度器 261\n" +
                    "\n" +
                    "第12章　序列化 263\n" +
                    "\n" +
                    "第85条：其他方法优先于Java序列化 263\n" +
                    "\n" +
                    "第86条：谨慎地实现Serializable接口 266\n" +
                    "\n" +
                    "第87条：考虑使用自定义的序列化形式 269\n" +
                    "\n" +
                    "第88条：保护性地编写readObject方法 274\n" +
                    "\n" +
                    "第89条：对于实例控制，枚举类型优先于readResolve 279\n" +
                    "\n" +
                    "第90条：考虑用序列化代理代替序列化实例 282\n" +
                    "\n" +
                    "附录　与第2版中条目的对应关系 286\n" +
                    "\n" +
                    "参考文献 289");

        }
        builder.endObject();
        indexRequest.source(builder);
        IndexResponse indexResponse = restClient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(indexResponse.status().getStatus());
        System.out.println(indexResponse.toString());
        restClient.close();

    }


    @Test
    public void TestRequest() throws IOException {
        Request request = new Request("GET", "/");
        RestClient restClient = ElasticClientConfig.getDefaultRestClient();
        Response response = restClient.performRequest(request);
        HttpEntity httpEntity = response.getEntity();
        String resultJson =
                new BufferedReader(new InputStreamReader(httpEntity.getContent()))
                        .lines()
                        .collect(Collectors.joining(System.lineSeparator()));
        System.out.println(resultJson);
    }
}
