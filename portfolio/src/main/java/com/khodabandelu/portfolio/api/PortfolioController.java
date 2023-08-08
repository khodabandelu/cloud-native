package com.khodabandelu.portfolio.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioController {
    @GetMapping("/get")
    public String getPortfolio() {
        return "Your request of get portfolio is processed successfully";
    }
}
