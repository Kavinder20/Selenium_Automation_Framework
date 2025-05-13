# Selenium Automation Framework

This is a test automation framework built using **Selenium WebDriver**, **TestNG**, **Maven**, and **Page Object Model (POM)** to automate and validate common e-commerce application flows.

## Features

- Uses Selenium WebDriver for browser automation
- TestNG framework for test execution and reporting
- Page Object Model (POM) for better structure and reusability
- Maven for dependency and build management
- Chrome runs in incognito mode to avoid browser popups
- Assertions used to validate test outcomes

## Project Structure

src
├── main
│ └── java
│ └── pages # Page classes like LoginPage, HomePage
├── test
│ └── java
│ └── tests # Test classes like LoginTest
│ └── utils # Utility classes like DriverFactory
├── pom.xml # Maven dependencies and build settings
├── testing.xml # TestNG suite configuration


Test-Cases

| Test Case | Test Scenario                | Status   |
|-----------|------------------------------|----------|
| TC01      | Valid login                  | Passed   |
| TC02      | Invalid login                | Passed   |
| TC03      | Logout after login           | Passed   |
| TC04      | Add item to cart             | Passed   |
| TC05      | Remove item from cart        | Passed   |
| TC06      | Locked-out user login        | Planned  |
| TC07      | Login with empty credentials | Planned  |

## Tech Stack

- Java 17+
- Selenium WebDriver
- TestNG
- Maven
- Chrome (Incognito mode)
- Eclipse IDE
- Git & GitHub

## How to Run the Tests

1. Clone the repository:

2. Open the project in Eclipse or IntelliJ

3. Run tests from Eclipse-

- Right-click on `testing.xml` → Run As → TestNG Suite

  ## Planned Improvements

- Add negative test cases like locked-out user and empty credentials
- Integrate screenshot capture on test failure
- Generate HTML reports using ExtentReports or Allure
- Run tests using GitHub Actions (CI/CD pipeline)
- Add test data parameterization using TestNG data providers





