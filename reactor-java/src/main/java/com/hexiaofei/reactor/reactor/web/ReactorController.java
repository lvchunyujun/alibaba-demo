package com.hexiaofei.reactor.reactor.web;

import com.hexiaofei.pubapi.web.RespEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * @author lcyj
 * @date 2022-03-06 18:17
 * @since
 */
@Slf4j
@RestController
public class ReactorController {

    @GetMapping("/helloworld")
    public Mono<String> helloWorld(){

        log.info("-->");
        Mono<String> mono = Mono.create(sink->{
            sink.success(getHelloWorld());
        });
        log.info("<--");
        return mono;
    }

    private String getHelloWorld(){

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello World!!!";
    }
}
