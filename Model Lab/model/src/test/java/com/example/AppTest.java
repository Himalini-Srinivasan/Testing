package com.example;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest 
{
      // @Test
//     // public void shouldAnswerWithTrue()
//     // {
//     //     assertTrue( true );
//     // }

      @Test
      public void Test1() throws InterruptedException, IOException
      {
          WebDriverManager.edgedriver().setup();
          WebDriver driver=new EdgeDriver();
          driver.manage().window().maximize();
          driver.get("https://www.abhibus.com/");
          Thread.sleep(3000);
          driver.findElement(By.xpath("//*[@id='train-link']/span[2]")).click();
          Thread.sleep(3000);
          Assert.assertTrue(driver.getCurrentUrl().contains("trains"));
          driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[1]/a/img")).click();
          Thread.sleep(3000);
          driver.findElement(By.xpath("//*[@id=\"login-link\"]/span[2]")).click();
          Thread.sleep(3000);
          String s=driver.findElement(By.xpath("//*[@id=\"login-heading\"]/div[1]/h4")).getText();
          if(s.contains("Login to AbhiBus"))
          {
            System.out.println("Present");
          }
          else
          {
            System.out.println("Not Present");
          }

          File screenshot1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
          String path1="C:\\Users\\lenovo\\Desktop\\Model Lab\\img1.png";
          FileUtils.copyFile(screenshot1, new File(path1));
    }
    @Test
    public void Test2() throws IOException, InterruptedException
    {
        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.abhibus.com/");
        Thread.sleep(3000);
        FileInputStream fs=new FileInputStream("C:\\Users\\lenovo\\Desktop\\Model Lab\\Bus.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(fs);
        XSSFSheet sheet=workbook.getSheetAt(0);
        String from=sheet.getRow(0).getCell(0).getStringCellValue();
        String to=sheet.getRow(0).getCell(1).getStringCellValue();
        driver.findElement(By.xpath("//*[@id='search-from']/div/div/div/div/div[2]/input")).sendKeys(from);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"search-from\"]/div/div[2]/ul/li[1]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"search-to\"]/div/div/div/div/div[2]/input")).sendKeys(to);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"search-to\"]/div/div[2]/ul/li[1]/div")).click();
        driver.findElement(By.xpath("//*[@id='search-button']/button")).click();
        Thread.sleep(3000);
        String ft=driver.getCurrentUrl();
        if(ft.contains("Mumbai") && ft.contains("Pune"))
        {
          System.out.println(from+" and "+to+" are Presented");
        }
        else
        {
          System.out.println(from+" and "+to+" are not Presented");
        }
    }
    @Test
    public void Test3() throws InterruptedException, IOException
    {
      WebDriverManager.edgedriver().setup();
      WebDriver driver=new EdgeDriver();
      driver.manage().window().maximize();
      driver.get("https://www.abhibus.com/");
      Thread.sleep(3000);
      JavascriptExecutor js=(JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0,6000)","");
      driver.findElement(By.xpath("//*[@id=\"footer-routes\"]/div/div[1]/div/div/div/div/button[5]")).click();
      Thread.sleep(3000);
      driver.findElement(By.linkText("News")).click();
      String m=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/h2")).getText();
      Assert.assertEquals(m, "Media");
      File screenshot2=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      String path2="C:\\Users\\lenovo\\Desktop\\Model Lab\\img2.png";
      FileUtils.copyFile(screenshot2, new File(path2));
    }



    
}
