package com.example;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * 메인 대시보드
 */
@Controller
@RequestMapping("/")
public class DashboardController {

    private final static Logger logger = getLogger(DashboardController.class);

    public String getIndex(Model model) {
        return "index";
    }
}
