package com.ekfet.common.java11;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author radish.zhou
 * @version v 1.0
 * @ClassName: HttpClientTest
 * @date 2018/12/23 21:20
 */
public class HttpClientTest {
    public static void main(String[] args) {
        HttpClientTest.get1();
    }

    public static void get() {
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/user/getUser"))
                .build();
        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();

    }

    public static void get1() {
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/user/getUser"))
                .build();
        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenAccept(response -> {
                    System.out.println(
                            response.statusCode()
                    );
                })
                .thenAccept(System.out::println)
                .join();

    }

    public void script(String[] args) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");

        // evaluate JavaScript code that defines a function with one parameter
        engine.eval("function hello(name) { print('Hello, ' + name) }");

        // create an Invocable object by casting the script engine object
        Invocable inv = (Invocable) engine;

        // invoke the function named "hello" with "Scripting!" as the argument
        inv.invokeFunction("hello", "Scripting!");
    }
}
