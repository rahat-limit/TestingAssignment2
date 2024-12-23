package com.testing.lesson.practice.testing_lesson_practice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SearchTest {

	public static void main(String[] args) {
        // Set the path to your WebDriver
        System.setProperty("webdriver.edge.driver", "C:\\Program Files\\msedgedriver.exe");
        
        WebDriver driver = new EdgeDriver();
        try {
            // Open YouTube
            driver.get("https://www.youtube.com");
            
            // Locate the search box on YouTube and search for "ASMR"
            WebElement searchBox = driver.findElement(By.name("search_query")); // YouTube search box
            searchBox.sendKeys("ASMR");
            searchBox.submit();
            
            // Wait for results to load (simplified with thread sleep here)
            Thread.sleep(3000);
            
            // Validate results using XPath (YouTube shows results after search)
            WebElement resultStats = driver.findElement(By.xpath("//ytd-video-renderer"));
            if (resultStats.isDisplayed()) {
                System.out.println("Search results displayed successfully.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

}
