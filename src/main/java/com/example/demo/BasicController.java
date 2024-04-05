/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;


/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@RestController
@Slf4j
public class BasicController {

    @GetMapping("/helloVirtualThread")
    public String helloVirtualThread() throws InterruptedException {
//        Thread thread = Thread.startVirtualThread(() -> {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
        Thread.sleep(3000);
        return Thread.currentThread().toString();
    }


    @GetMapping("/helloWebflux")
    public Mono<String> helloWebflux() {
        return Mono.delay(Duration.ofSeconds(3))
                .thenReturn(Thread.currentThread().getName());
    }


//    @GetMapping("/hello")
//    public Mono<String> hello() {
//        Thread.startVirtualThread(() -> {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        return Mono.just(Thread.currentThread().getName());
//    }

}
