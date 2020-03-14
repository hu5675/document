package com.huize.polaris.web;

import com.huize.polaris.colletion.annotation.EnablePloarisLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnablePloarisLog
public class PolarisWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(PolarisWebApplication.class, args);
    }

}
