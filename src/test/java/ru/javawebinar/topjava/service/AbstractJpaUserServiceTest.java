package ru.javawebinar.topjava.service;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.repository.JpaUtil;

abstract public class AbstractJpaUserServiceTest extends AbstractUserServiceTest{

    @Autowired
    private JpaUtil jpaUtil;

    @Before
    public void setUp() throws Exception{
        super.setup();
        jpaUtil.clear2ndLevelHibernateCache();
    }
}

