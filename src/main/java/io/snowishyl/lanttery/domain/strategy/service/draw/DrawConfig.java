package io.snowishyl.lanttery.domain.strategy.service.draw;

import io.snowishyl.lanttery.domain.strategy.annotation.Strategy;
import io.snowishyl.lanttery.domain.strategy.service.algorithm.IDrawAlgorithm;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: quarkus-lanttery
 * @description:
 * @author: YxYL
 * @create: 2023-10-14 20:07
 **/

public class DrawConfig {


    protected static Map<Integer, IDrawAlgorithm> drawAlgorithmMap = new ConcurrentHashMap<>();
    
    @Inject
    Instance<IDrawAlgorithm> algorithmInstances;

    @PostConstruct
    public void init() {
        algorithmInstances.forEach(algorithm -> {
            Strategy strategy = algorithm.getClass().getDeclaredAnnotation(Strategy.class);
            if (strategy != null) {
                drawAlgorithmMap.put(strategy.strategyMode().getCode(), algorithm);
            }
        });
    }

}
