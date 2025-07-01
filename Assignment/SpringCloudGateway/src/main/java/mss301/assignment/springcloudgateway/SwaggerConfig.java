package mss301.assignment.springcloudgateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("customer_service", r -> r
                        .path("/customers/**")
                        .filters(f -> f
                                .addRequestHeader("X-Service1", "Service1HeaderValue"))
                        .uri("http://localhost:8081"))

                .route("car_route", r -> r
                        .path("/car/**")
                        .filters(f -> f
                                .addRequestParameter("param", "value"))
                        .uri("http://localhost:8082"))

                .route("renting_route", r -> r
                        .path("/renting/**")
                        .filters(f -> f
                                .rewritePath("/renting/(?<segment>.*)", "/${segment}"))
                        .uri("http://localhost:8083"))

                .build();
    }

}
