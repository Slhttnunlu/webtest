package com.kaan;

import com.thoughtworks.gauge.Step;
import driver.Driver;
import java.io.IOException;

public class StepImplementation extends Driver {


    @Step("Open The homepage")
    public void implementation() {
        System.out.println("Url'e Gidiyor");
        String url="https://www.youtube.com";
        webDriver.get(url);
        System.out.println("Url'e Gitti");
    }

    @Step("Ekrani tam yap")
    public void fullsize1() throws IOException, InterruptedException {
        webDriver.manage().window().maximize();
        Thread.sleep(10000);
    }
}
