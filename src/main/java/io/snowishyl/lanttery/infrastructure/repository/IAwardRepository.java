package io.snowishyl.lanttery.infrastructure.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.snowishyl.lanttery.infrastructure.po.Award;

import javax.enterprise.context.ApplicationScoped;

/**
 * @program: quarkus-lanttery
 * @description:
 * @author: YxYL
 * @create: 2023-10-14 20:28
 **/
@ApplicationScoped
public class IAwardRepository implements PanacheRepository<Award> {
}
