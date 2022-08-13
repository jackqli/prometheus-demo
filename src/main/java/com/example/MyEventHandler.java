package com.example;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyEventHandler {

  @Timed(value = "my.event.handle.time")
  @Counted(value = "my.event.handle.error")
  public void handle(String event) {
    if (event.equals("error")) {
      throw new RuntimeException("get an error");
    }

//    if (event.equals("error")) {
//      extracted();
//    }

//    try {
//      if (event.equals("error")) {
//        throw new RuntimeException("get an error");
//      }
//    }
//    catch (Exception e) {
//      log.error("error", e);
//    }

    log.info("event handler");
  }

//  @Counted("my.second.event.error")
//  private void extracted() {
//    throw new RuntimeException("get an error");
//  }
}
