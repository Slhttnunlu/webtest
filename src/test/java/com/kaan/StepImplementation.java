package com.kaan;

import com.thoughtworks.gauge.Step;
import java.io.IOException;

import static driver.Driver.webDriver;


public class StepImplementation extends BasePageUtil {


    @Step("Open The homepage")
    public void implementation() {
        String url="https://www.testinium.io/";
        webDriver.get(url);
    }

    @Step("Ekrani tam yap")
    public void fullsize1() throws IOException, InterruptedException {
        webDriver.manage().window().maximize();
        Thread.sleep(10000);
    }
}