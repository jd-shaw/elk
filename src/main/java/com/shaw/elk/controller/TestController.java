package com.shaw.elk.controller;

import com.shaw.elk.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author shaw
 * @date 2022/11/24
 */
@RestController
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/print-log")
    public void printLog() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            logger.info("测试Log日志打印，time:{}", new Date());
            TimeUnit.SECONDS.sleep(5);
        }
    }

    @GetMapping("/error-log")
    public void errorLog() {
        Exception e = new ServiceException("springboot + elk 错误日志测试......");
        logger.error(e.getMessage(), e);
    }

}
