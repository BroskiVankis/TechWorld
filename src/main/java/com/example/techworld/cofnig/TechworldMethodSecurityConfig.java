package com.example.techworld.cofnig;

import com.example.techworld.service.OfferService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class TechworldMethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    private final OfferService offerService;


    public TechworldMethodSecurityConfig(OfferService offerService) {
        this.offerService = offerService;
    }

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        return new TechworldSecurityExpressionHandler(offerService);
    }
}
