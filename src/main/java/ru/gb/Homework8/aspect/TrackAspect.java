package ru.gb.Homework8.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class TrackAspect {
    // логирование информации в консоль
    private static final Logger logger = Logger.getLogger(TrackAspect.class.getName());

    // передача информации о вызванном методе в лог при использовании аннотации
    @Before("@annotation(ru.gb.Homework8.aspect.TrackUserAction)")
    public void userActionLog(JoinPoint joinPoint) {
        logger.info("User used method: " + joinPoint.getSignature().getName());
    }
}
