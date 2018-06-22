package com.networknt.server;

import com.networknt.handler.MiddlewareHandler;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;

public class Api2MiddlewareHandler implements MiddlewareHandler {

    private volatile HttpHandler next;

    @Override
    public HttpHandler getNext() {
        return next;
    }

    @Override
    public MiddlewareHandler setNext(HttpHandler next) {
        this.next = next;
        return this;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public void register() {

    }

    @Override
    public void handleRequest(HttpServerExchange httpServerExchange) throws Exception {
        System.out.println("Api2MiddlewareHandler is called");
        next.handleRequest(httpServerExchange);
    }
}
