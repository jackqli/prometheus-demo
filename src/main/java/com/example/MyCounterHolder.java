package com.example;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyCounterHolder {
  private MeterRegistry meterRegistry;
  private Counter counter;

  @Autowired
  public MyCounterHolder(MeterRegistry meterRegistry) {
    this.meterRegistry = meterRegistry;
    this.counter = Counter
        .builder("beer.orders")    // 2 - create a counter using the fluent API
        .tag("type", "ale")
        .tag("env", "dev")
        .description("The number of orders ever placed for Ale beers")
        .register(meterRegistry);
  }

  public Counter getCounter() {
    return counter;
  }

  public void setCounter(Counter counter) {
    this.counter = counter;
  }
}
