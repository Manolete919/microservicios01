package com.conecel.claro;

import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanA {
    public Bar1 doSomething(final Foo arg) {
        return new Bar1(arg.getFoo() + "A");
    }
}
