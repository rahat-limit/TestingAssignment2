package com.testing.lesson.practice.testing_lesson_practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class FlightBookingTest {
    public static void main(String[] args) {
        // Set WebDriver path
    	System.setProperty("webdriver.edge.driver", "C:\\Program Files\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();
        try {
            // Open the flight booking page
            driver.get("https://www.blazedemo.com/");
            
            // Select departure and destination
            WebElement departureCity = driver.findElement(By.name("fromPort")); // CSS selector
            WebElement destinationCity = driver.findElement(By.name("toPort"));
            WebElement findFlightsButton = driver.findElement(By.xpath("//input[@value='Find Flights']"));
            
            departureCity.sendKeys("Paris");
            destinationCity.sendKeys("Buenos Aires");
            findFlightsButton.click();
            
            // Wait for flight selection page
            Thread.sleep(3000);
            
            // Select a flight
            WebElement chooseFlightButton = driver.findElement(By.xpath("//input[@value='Choose This Flight']"));
            chooseFlightButton.click();

            // Fill in booking details
            WebElement nameField = driver.findElement(By.id("inputName"));
            WebElement addressField = driver.findElement(By.id("address"));
            WebElement cityField = driver.findElement(By.id("city"));
            WebElement stateField = driver.findElement(By.id("state"));
            WebElement zipCodeField = driver.findElement(By.id("zipCode"));
            WebElement cardType = driver.findElement(By.id("cardType"));
            WebElement creditCardNumber = driver.findElement(By.id("creditCardNumber"));
            WebElement purchaseButton = driver.findElement(By.xpath("//input[@value='Purchase Flight']"));
            
            nameField.sendKeys("John Doe");
            addressField.sendKeys("123 Elm St");
            cityField.sendKeys("Springfield");
            stateField.sendKeys("IL");
            zipCodeField.sendKeys("62704");
            cardType.sendKeys("Visa");
            creditCardNumber.sendKeys("4111111111111111");
            purchaseButton.click();

            // Wait for confirmation
            Thread.sleep(3000);
            WebElement confirmation = driver.findElement(By.tagName("h1"));
            if (confirmation.getText().equals("Thank you for your purchase today!")) {
                System.out.println("Flight booked successfully.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}