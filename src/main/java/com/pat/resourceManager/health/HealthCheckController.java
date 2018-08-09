package com.pat.resourceManager.health;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @RequestMapping("/health")
    public String index() {
        return "Budget Planner Application is running!!";
    }

}
