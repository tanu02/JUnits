package controller;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = { "model" })
@ComponentScan(basePackages = { "service", "controller" })
public class DiscountConfig {

}