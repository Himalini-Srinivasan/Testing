package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver1 = new ChromeDriver();
        driver1.manage().window().maximize();
        driver1.get("https://www.google.co.in/");
        Thread.sleep(3000);
        driver1.close();
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver2 = new FirefoxDriver();
        driver2.manage().window().maximize();
        driver2.get("https://www.google.co.in/");
        Thread.sleep(3000);
        driver2.close();
        WebDriverManager.edgedriver().setup();
        WebDriver driver3 = new EdgeDriver();
        driver3.manage().window().maximize();
        driver3.get("https://www.google.co.in/");
        Thread.sleep(3000);
        driver3.close();

    }
}
