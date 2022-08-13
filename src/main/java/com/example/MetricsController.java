package com.example;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MetricsController {
  private MyCounterHolder myCounterHolder;
  private MyEventHandler myEventHandler;

  @GetMapping("/set")
  Double newEmployee() {
    myCounterHolder.getCounter().increment();
    return myCounterHolder.getCounter().count();
  }

  @GetMapping("/event")
  void handle(@RequestParam(name = "event") String event) {
    myEventHandler.handle(event);
  }
}
