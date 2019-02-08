package me.stamwoo.gateway;

import me.stamwoo.gateway.filter.ElapsedFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}


	@Bean
	public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
		// @formatter:off
		return builder.routes()
				.route(r -> r.path("/customer/**")
						.filters(f -> f.stripPrefix(2)
								.filter(new ElapsedFilter())
								.addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
						.uri("lb://EUREKA-CONSUMER")
						.order(0)
						.id("service_customer")
				)
				.build();
		// @formatter:on
	}
}

