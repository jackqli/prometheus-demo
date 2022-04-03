package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetricsController {
  @Autowired
  private MyCounterHolder myCounterHolder;

  @GetMapping("/set")
  Double newEmployee() {
    myCounterHolder.getCounter().increment();
    return myCounterHolder.getCounter().count();
  }
}
