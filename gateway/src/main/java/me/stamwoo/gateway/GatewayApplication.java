package me.stamwoo.gateway;

import me.stamwoo.gateway.filter.ElapsedFilter;
import me.stamwoo.gateway.filter.RateLimitByCpuGatewayFilter;
import me.stamwoo.gateway.filter.RateLimitByIpGatewayFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Autowired
    private RateLimitByCpuGatewayFilter rateLimitByCpuGatewayFilter;

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        // @formatter:off
        return builder.routes()
/*                .route(r -> r.path("/customer/**")
                        .filters(f -> f.stripPrefix(1)
                                .filter(new ElapsedFilter())
                                .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
                        .uri("lb://EUREKA-CONSUMER")
                        .order(0)
                        .id("customer_service")
                )*/
/*                .route(r -> r.path("/customer/**")
                        .filters(f -> f.stripPrefix(1)
                                .filter(new RateLimitByIpGatewayFilter(10, 1, Duration.ofSeconds(1))))
                        .uri("lb://EUREKA-CONSUMER")
                        .order(0)
                        .id("customer_service")
                )*/
/*                .route(r -> r.path("/customer/**")
                        .filters(f -> f.stripPrefix(1)
                                .filter(rateLimitByCpuGatewayFilter))
                        .uri("lb://EUREKA-CONSUMER")
                        .order(0)
                        .id("customer_service")
                )*/
                .build();
        // @formatter:on
    }

    @Bean(name = RemoteAddrKeyResolver.BEAN_NAME)
    public RemoteAddrKeyResolver remoteAddrKeyResolver() {
        return new RemoteAddrKeyResolver();
    }
}

