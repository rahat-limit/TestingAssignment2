package com.testing.lesson.practice.testing_lesson_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginLogoutTest {
    public static void main(String[] args) {
        // Set the path to your WebDriver
        System.setProperty("webdriver.edge.driver", "C:\\Program Files\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();

        try {
            // Open the login page
            driver.get("https://practicetestautomation.com/practice-test-login/");

            // Initialize WebDriverWait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // Find username and password fields and fill them in
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));

            // Enter valid credentials
            usernameField.sendKeys("student");
            passwordField.sendKeys("Password123");
            submitButton.click();

            // Wait for login success and verify
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Logged In Successfully']")));
            if (successMessage.isDisplayed()) {
                System.out.println("Login successful.");
            }

            // Find and click the Log out button
            WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Log out']")));
            logoutButton.click();

            // Wait for the page to load and verify logout (e.g., by checking for login button or page title)
            WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
            if (loginButton.isDisplayed()) {
                System.out.println("Logout successful.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}