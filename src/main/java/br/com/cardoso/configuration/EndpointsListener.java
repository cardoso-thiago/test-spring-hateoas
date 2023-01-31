package br.com.cardoso.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class EndpointsListener {


    @Autowired
    RequestMappingHandlerMapping requestMappingHandlerMapping;

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        AtomicInteger count = new AtomicInteger();
        requestMappingHandlerMapping.getHandlerMethods().forEach((key, value) -> {
            if(key.getPatternValues().stream().anyMatch(pattern -> pattern.contains("/test"))) {
                Method method = value.getMethod();
                Link link = linkTo(method).withRel("test" + count);
                count.getAndIncrement();
                System.out.println("href => " + link.getHref());
                System.out.println("rel => " + link.getRel());
                System.out.println("rel_2 => " + method.getName());
            }
        });
    }
}