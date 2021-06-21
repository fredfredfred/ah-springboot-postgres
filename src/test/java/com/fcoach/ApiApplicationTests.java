package com.fcoach;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("inttest")
class ApiApplicationTests {

  @Test
  void contextLoads() {
    // make sure context loads and test nothing
    Assertions.assertTrue(true);
  }

}
