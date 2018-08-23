package com.conecel.claro;

import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanB {
    public Bar2 doSomething(final Foo arg) {
        return new Bar2(arg.getFoo() + "B");
    }
}
