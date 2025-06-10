package dev.annopud.spring_clients.first;

import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration(proxyBeanMethods = false)
public class FirstConfig {
    @Bean
    @LoadBalanced
    public RestClient.Builder loadBalancedRestClientBuilder() {
        return RestClient.builder();
    }

//    @Bean
//    @LoadBalanced
//    RestClient restClient(KubernetesClient kubernetesClient) {
//        // This RestClient is used for the FirstClient
//        Service service = kubernetesClient.services()
//            .inNamespace("default")
//            .withName("spring-clients-service")
//            .get();
//        String serviceName = service.getMetadata().getName();
//        Integer port = service.getSpec().getPorts().getFirst().getPort();
//        String baseUrl = "http://" + serviceName + ":" + port;
//        return RestClient.create(baseUrl);
//    }

    @Bean
    FirstClient firstClient(RestClient.Builder loadBalancedRestClientBuilder) {
//        RestClient restClient = RestClient.builder().baseUrl("http://spring-clients-service.default.svc.cluster.local:8080")
//        RestClient restClient = RestClient.builder()
////            .baseUrl("http://spring-clients-service")
//            .build();

//        RestClient restClient = RestClient.create("http://spring-clients-service");





        HttpServiceProxyFactory factory = HttpServiceProxyFactory
            .builderFor(RestClientAdapter.create(loadBalancedRestClientBuilder.build()))
            .build();
        return factory.createClient(FirstClient.class);
    }

}
