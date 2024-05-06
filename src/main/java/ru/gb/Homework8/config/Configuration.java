package ru.gb.Homework8.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.gb.Homework8.aspect.TrackAspect;

@org.springframework.context.annotation.Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class Configuration {
    @Bean
    public TrackAspect aspect() {
        return new TrackAspect();
    }
}
