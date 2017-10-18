package cn.yearcon.shop.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpClientConfiguration {

    @Value("${http.maxTotal}")
    private Integer maxTotal;//最大连接数

    @Value("${http.defaultMaxPerRoute}")
    private Integer defaultMaxPerRoute;//并发数

    @Value("${http.connectTimeout}")
    private Integer connectTimeout;//创建连接的最长时间

    @Value("${http.connectionRequestTimeout}")
    private Integer connectionRequestTimeout;//从连接池中获取到连接的最长时间

    @Value("${http.socketTimeout}")
    private Integer socketTimeout;//数据传输的最长时间

    @Value("${http.staleConnectionCheckEnabled}")
    private boolean staleConnectionCheckEnabled;//提交请求前测试连接是否可用

    /**
     * 首先实例化一个连接池管理器，设置最大连接数、并发连接数
     *
     * @return
     */
    @Bean(name = "httpClientConnectionManager")
    public PoolingHttpClientConnectionManager getHttpClientConnectionManager() {


        PoolingHttpClientConnectionManager httpClientConnectionManager = new PoolingHttpClientConnectionManager();
        //设置最大连接数
        httpClientConnectionManager.setMaxTotal(maxTotal);
        //设置并发数
        httpClientConnectionManager.setDefaultMaxPerRoute(defaultMaxPerRoute);

        return httpClientConnectionManager;
    }

    /**
     * 实例化连接池,设置连接池管理器.
     * 这里需要以参数的形式注入上面的连接池管理器
     * @param httpClientConnectionManager 连接池管理器
     * @return
     */
    @Bean(name = "httpClientBuilder")
    public HttpClientBuilder getHttpClientBuilder(@Qualifier("httpClientConnectionManager") PoolingHttpClientConnectionManager httpClientConnectionManager) {
        //HttpClientBuilder中的构造方法被protected修饰，所以这里不能直接使用new来实例化一个HttpClientBuilder，
        // 可以使用HttpClientBuilder提供的静态方法create()来获取HttpClientBuilder对象
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        httpClientBuilder.setConnectionManager(httpClientConnectionManager);

        return httpClientBuilder;
    }

    /**
     * 注入连接池,用于获取 HttpClient
     * @param httpClientBuilder
     * @return
     */
    @Bean
    public CloseableHttpClient getCloseableHttpclient(@Qualifier("httpClientBuilder") HttpClientBuilder httpClientBuilder){
        CloseableHttpClient httpClient = httpClientBuilder.build();
        return httpClient;
    }

    /**
     * Builder 是RequestConfig 的一个内部类,
     * 通过 RequestConfig.custom() 来获取一个builder对象.
     * 设置builder的连接信息
     * @return
     */
    @Bean(name = "builder")
    public RequestConfig.Builder getBuilder(){
        RequestConfig.Builder builder = RequestConfig.custom();
        builder.setConnectTimeout(connectTimeout);//连接的最长时间
        builder.setSocketTimeout(socketTimeout);//数据传输的最长时间
        builder.setStaleConnectionCheckEnabled(staleConnectionCheckEnabled);//提交请求前测试连接是否可用

        return builder;

    }

    /**
     * 使用builder构造一个RequestConfig对象
     * @param builder
     * @return
     */
    @Bean
    public RequestConfig getRequestConfig(@Qualifier("builder") RequestConfig.Builder builder){
        RequestConfig requestConfig = builder.build();
        return requestConfig;

    }







}
