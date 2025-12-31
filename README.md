# OrangeHRM Test Automation Framework

A comprehensive enterprise-grade test automation framework for OrangeHRM Human Resource Management System. Built with Selenium WebDriver 4, Java 21, and TestNG 7, following industry best practices and design patterns.

---

## Table of Contents

- [Project Overview](#project-overview)
- [Technology Stack](#technology-stack)
- [Architecture](#architecture)
- [Project Structure](#project-structure)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running Tests](#running-tests)
- [Test Suites](#test-suites)
- [Test Reports](#test-reports)
- [Modules Covered](#modules-covered)
- [Design Patterns](#design-patterns)
- [CI/CD Integration](#cicd-integration)
- [Best Practices](#best-practices)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)
- [License](#license)
- [Author](#author)

---

## Project Overview

This framework provides automated end-to-end testing coverage for OrangeHRM, an open-source Human Resource Management System. The framework is designed to be maintainable, scalable, and easily integrated into CI/CD pipelines.

### Key Highlights

- 47 Test Classes covering all major OrangeHRM modules
- Page Object Model (POM) with Fluent Interface design
- Thread-safe parallel test execution support
- Allure reporting with automatic screenshot capture on failure
- Cross-browser testing (Chrome, Firefox, Edge)
- Headless execution support for CI/CD environments
- Data cleanup utilities for test isolation
- Foundation and Regression test suite separation

---

## Technology Stack

| Technology | Version | Purpose |
|------------|---------|---------|
| Java | 21 | Programming Language |
| Selenium WebDriver | 4.39.0 | Browser Automation |
| TestNG | 7.11.0 | Test Framework |
| Maven | 3.x | Build and Dependency Management |
| Allure | 2.30.0 | Test Reporting |
| AspectJ | 1.9.22 | AOP for Allure Integration |
| SLF4J | 2.0.13 | Logging Framework |

---

## Architecture

```
                    +-------------------+
                    |    TestNG XML     |
                    |    Suite Files    |
                    +--------+----------+
                             |
                    +--------v----------+
                    |    Test Classes   |
                    |  (Test Layer)     |
                    +--------+----------+
                             |
                    +--------v----------+
                    |   Page Classes    |
                    |  (Page Layer)     |
                    +--------+----------+
                             |
                    +--------v----------+
                    |    Base Classes   |
                    | (Framework Core)  |
                    +--------+----------+
                             |
              +--------------+--------------+
              |              |              |
     +--------v----+  +------v------+  +---v--------+
     |  Listeners  |  |   Utils     |  | WebDriver  |
     +-------------+  +-------------+  +------------+
```

---

## Project Structure

```
orangeHRM/
|-- pom.xml                          # Maven configuration
|-- testng-foundation.xml            # Foundation/Setup test suite
|-- testng-regression.xml            # Full regression test suite
|-- testng-cleanup.xml               # Data cleanup test suite
|-- README.md                        # Project documentation
|-- src/
|   +-- test/
|       +-- java/
|           +-- project_orangehrm/
|               |-- Base/
|               |   |-- BasePage.java        # Common page methods and utilities
|               |   +-- BaseTest.java        # Test setup/teardown, driver management
|               |-- Listeners/
|               |   +-- SimpleListener.java  # TestNG listener for logging
|               |-- Pages/
|               |   |-- CommonPage.java      # Shared page operations
|               |   |-- LoginPage.java       # Login functionality
|               |   |-- DashboardPage.java   # Dashboard operations
|               |   |-- AdminPage.java       # Admin module
|               |   |-- PIMPage.java         # PIM module
|               |   |-- RecruitmentPage.java # Recruitment module
|               |   |-- LeavePage.java       # Leave module
|               |   |-- TimePage.java        # Time module
|               |   |-- PerformancePage.java # Performance module
|               |   |-- ClaimPage.java       # Claim module
|               |   |-- BuzzPage.java        # Buzz module
|               |   |-- DirectoryPage.java   # Directory module
|               |   |-- MaintenancePage.java # Maintenance module
|               |   +-- MyInfoPage.java      # My Info module
|               |-- Test/
|               |   |-- LoginTest.java
|               |   |-- AdminJobTest.java
|               |   |-- AdminOrganizationTest.java
|               |   |-- AdminUserManagementTest.java
|               |   |-- Admin_Configuration_Test.java
|               |   |-- Admin_Nationalities_Test.java
|               |   |-- Admin_Qualifications_Test.java
|               |   |-- PIM_Employee_Test.java
|               |   |-- PIM_EmployeeDetails_Test.java
|               |   |-- PIM_Configuration_Test.java
|               |   |-- PIM_Reports_Test.java
|               |   |-- Recruitment_Vacancies_Test.java
|               |   |-- Recruitment_Candidate_E2E_Test.java
|               |   |-- Recruitment_CandidateWorkflow_Test.java
|               |   |-- Recruitment_Search_And_Data_Test.java
|               |   |-- Recruitment_Actions_Test.java
|               |   |-- Leave_ApplyLeave_Test.java
|               |   |-- Leave_Configuration_Test.java
|               |   |-- Leave_Entitlements_Test.java
|               |   |-- Leave_LeaveList_Test.java
|               |   |-- Leave_Operations_Test.java
|               |   |-- Leave_Reports_Test.java
|               |   |-- Time_Attendance_Test.java
|               |   |-- Time_Timesheets_Test.java
|               |   |-- Time_ProjectInfo_Test.java
|               |   |-- Time_BusinessLogic_Test.java
|               |   |-- Time_Reports_Test.java
|               |   |-- Time_Configuration_Test.java
|               |   |-- Claim_Configuration_Test.java
|               |   |-- Claim_Advanced_Test.java
|               |   |-- Claim_EmployeeClaims_Test.java
|               |   |-- Claim_Operations_Test.java
|               |   |-- Performance_Configuration_Test.java
|               |   |-- Performance_Reviews_Test.java
|               |   |-- Performance_MyReviews_Test.java
|               |   |-- Performance_Evaluation_Test.java
|               |   |-- Performance_Reports_Test.java
|               |   |-- Dashboard_Widgets_Test.java
|               |   |-- Dashboard_UserActions_Test.java
|               |   |-- Dashboard_Advanced_Test.java
|               |   |-- Buzz_Newsfeed_Test.java
|               |   |-- Buzz_Features_Test.java
|               |   |-- Directory_Test.java
|               |   |-- Maintenance_Authentication_Test.java
|               |   |-- Maintenance_AccessRecords_Test.java
|               |   |-- Maintenance_PurgeRecords_Test.java
|               |   +-- Maintenance_Safety_Test.java
|               |-- TestCleaning/
|               |   |-- AdminTestCleaning.java
|               |   |-- PIMTestCleaning.java
|               |   |-- RecruitmentTestCleaning.java
|               |   |-- TimeTestCleaning.java
|               |   |-- PerformanceTestCleaning.java
|               |   |-- ClaimTestCleaning.java
|               |   +-- BuzzTestCleaning.java
|               +-- Utils/
|                   +-- AllureAttachment.java  # Screenshot and attachment utilities
+-- target/
    +-- allure-results/              # Allure report data
```

---

## Features

### Core Framework Features

- **Page Object Model (POM)**: Encapsulates page elements and actions for maintainability
- **Fluent Interface**: Method chaining for readable and concise test scripts
- **FluentWait Implementation**: Intelligent waiting with configurable timeout and polling
- **Exception Handling**: Graceful handling of common Selenium exceptions
- **Thread-Safe Design**: ThreadLocal WebDriver for parallel execution

### Test Execution Features

- **Cross-Browser Support**: Chrome, Firefox, Edge
- **Headless Mode**: Configurable via system property for CI/CD
- **Parallel Execution**: Thread-safe architecture supports concurrent test runs
- **Test Groups**: Foundation, Regression, and Cleanup groups for organized execution

### Reporting Features

- **Allure Reports**: Rich HTML reports with screenshots and attachments
- **Automatic Screenshots**: Captures screenshots on test failure
- **Test Listener**: Real-time console logging of test execution status
- **Soft Assertions**: Continue test execution while collecting multiple failures

### Utility Features

- **Dynamic Locators**: Parameterized locators for flexible element identification
- **JavaScript Executor**: Fallback click mechanisms for stubborn elements
- **Scroll and Click**: Automatic scrolling to elements before interaction
- **Data Cleanup**: Dedicated cleanup suite for test data management

---

## Prerequisites

Before setting up the project, ensure you have the following installed:

1. **Java Development Kit (JDK) 21 or higher**
   ```bash
   java -version
   ```

2. **Apache Maven 3.6 or higher**
   ```bash
   mvn -version
   ```

3. **Web Browser** (Chrome, Firefox, or Edge)

4. **Allure Command Line** (for report generation)
   ```bash
   # Windows (using Scoop)
   scoop install allure
   
   # macOS (using Homebrew)
   brew install allure
   
   # Linux
   sudo apt-add-repository ppa:qameta/allure
   sudo apt-get update
   sudo apt-get install allure
   ```

---

## Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd orangeHRM
   ```

2. **Install dependencies**
   ```bash
   mvn clean install -DskipTests
   ```

3. **Verify installation**
   ```bash
   mvn test-compile
   ```

---

## Configuration

### Browser Configuration

The default browser is Chrome. To change the browser, modify the `testng-*.xml` files:

```xml
<parameter name="browser" value="chrome"/>  <!-- chrome, firefox, edge -->
```

### Headless Mode

Enable headless mode for CI/CD environments:

```bash
mvn test -Dheadless=true
```

### Test Groups

Run specific test groups:

```bash
# Run only foundation tests
mvn test -Dgroups=foundation

# Run only regression tests
mvn test -Dgroups=regression
```

---

## Running Tests

### Run All Tests

```bash
mvn clean test
```

### Run Specific Test Suite

```bash
# Foundation Suite (Data Seeding)
mvn test -Psuite -DsuiteXmlFile=testng-foundation.xml

# Regression Suite (Full Test Suite)
mvn test -Psuite -DsuiteXmlFile=testng-regression.xml

# Cleanup Suite (Data Cleanup)
mvn test -Psuite -DsuiteXmlFile=testng-cleanup.xml
```

### Run Single Test Class

```bash
mvn test -Dtest=LoginTest
```

### Run with Headless Browser

```bash
mvn test -Dheadless=true -Psuite -DsuiteXmlFile=testng-regression.xml
```

### Run on Different Browser

```bash
# Edit testng-regression.xml or pass parameter
mvn test -Dbrowser=firefox
```

---

## Test Suites

### Foundation Suite (testng-foundation.xml)

Purpose: Creates essential test data required by other tests.

**Execution Order:**
1. Admin Job Configuration
2. Admin Organization Setup
3. Admin Qualifications
4. PIM Employee Creation
5. PIM Configuration
6. User Management
7. Leave Configuration
8. Leave Entitlements
9. Claim Configuration
10. Time Project Info
11. Performance Configuration
12. Recruitment Vacancies

### Regression Suite (testng-regression.xml)

Purpose: Comprehensive test coverage for all modules.

**Included Modules:**
- Login (3 tests)
- Admin - Job, Organization, Qualifications, Configuration, Nationalities, Users
- PIM - Configuration, Employees, Details, Reports
- Recruitment - Vacancies, E2E, Workflow, Search, Actions
- Leave - Apply, List, Operations, Reports, Configuration, Entitlements
- Time - Attendance, Timesheets, Project, Business Logic, Reports
- Claim - Advanced, Employee Claims, Operations, Configuration
- Performance - Reviews, My Reviews, Evaluation, Reports, Configuration
- Dashboard - Widgets, User Actions, Advanced
- Buzz - Newsfeed, Features
- Directory
- Maintenance - Authentication, Access Records, Purge, Safety

### Cleanup Suite (testng-cleanup.xml)

Purpose: Removes test data created during test execution.

**Cleanup Order:**
1. Admin data cleanup
2. PIM data cleanup
3. Recruitment data cleanup
4. Time data cleanup
5. Performance data cleanup
6. Claim data cleanup
7. Buzz data cleanup

---

## Test Reports

### Generate Allure Report

```bash
# Generate and open report
mvn allure:serve

# Generate report only (output to target/site/allure-maven-plugin)
mvn allure:report
```

### Report Location

- **Allure Results**: `target/allure-results/`
- **Generated Report**: `target/site/allure-maven-plugin/`
- **Surefire Reports**: `target/surefire-reports/`

### Report Features

- Test execution timeline
- Test categorization by module
- Screenshots on failure
- Step-by-step execution logs
- Trend analysis across runs

---

## Modules Covered

| Module | Sub-Modules | Test Coverage |
|--------|-------------|---------------|
| Login | Authentication, Validation | Positive and Negative scenarios |
| Admin | Job Titles, Pay Grades, Employment Status, Work Shifts, Organization, Locations, Qualifications, Nationalities, Users | CRUD operations, Validation |
| PIM | Employee List, Add Employee, Configuration, Reports | Employee lifecycle, Filters |
| Recruitment | Vacancies, Candidates, Workflow | E2E candidate journey |
| Leave | Apply, Entitlements, Reports, Configuration | Leave request lifecycle |
| Time | Attendance, Timesheets, Projects, Reports | Time tracking, Punch In/Out |
| Performance | KPIs, Reviews, My Reviews, Configuration | Review workflow |
| Claim | Configuration, Claims, Expenses | Claim submission and approval |
| Buzz | Newsfeed, Posts, Comments | Social features |
| Dashboard | Widgets, Quick Launch, Actions | Dashboard components |
| Directory | Employee Search, Contact Info | Directory search |
| Maintenance | Purge Records, Access Records | Data maintenance |

---

## Design Patterns

### Page Object Model (POM)

Each page in the application is represented by a class containing:
- Page element locators
- Page-specific methods
- Inherited common functionality

```java
public class LoginPage extends CommonPage {
    private final By USERNAME_FIELD = By.cssSelector("input[placeholder='Username']");
    
    public LoginPage enterUsername(String username) {
        typeText(USERNAME_FIELD, username);
        return this;
    }
}
```

### Fluent Interface

Method chaining enables readable test scripts:

```java
loginPage
    .enterUsername("Admin")
    .enterPassword("admin123")
    .clickLogin();
```

### Factory Pattern

WebDriver instantiation based on browser configuration:

```java
if (browser.equalsIgnoreCase("chrome")) {
    currentDriver = new ChromeDriver(options);
} else if (browser.equalsIgnoreCase("firefox")) {
    currentDriver = new FirefoxDriver(options);
}
```

### Template Method Pattern

BaseTest provides hooks for setup and teardown:

```java
@BeforeMethod
public void setUp(String browser) { /* Driver setup */ }

@AfterMethod
public void tearDown(ITestResult result) { /* Cleanup and screenshot */ }
```

---

## CI/CD Integration

### GitHub Actions Example

```yaml
name: Selenium Tests

on:
  push:
    branches: [ main ]
  pull_request:
    branches: [ main ]

jobs:
  test:
    runs-on: ubuntu-latest
    
    steps:
    - uses: actions/checkout@v3
    
    - name: Set up JDK 21
      uses: actions/setup-java@v3
      with:
        java-version: '21'
        distribution: 'temurin'
    
    - name: Run Tests
      run: mvn test -Dheadless=true -Psuite -DsuiteXmlFile=testng-regression.xml
    
    - name: Generate Allure Report
      if: always()
      run: mvn allure:report
    
    - name: Upload Allure Results
      if: always()
      uses: actions/upload-artifact@v3
      with:
        name: allure-results
        path: target/allure-results
```

### Jenkins Pipeline Example

```groovy
pipeline {
    agent any
    
    tools {
        maven 'Maven-3.9'
        jdk 'JDK-21'
    }
    
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                sh 'mvn test -Dheadless=true -Psuite -DsuiteXmlFile=testng-regression.xml'
            }
        }
        
        stage('Report') {
            steps {
                allure results: [[path: 'target/allure-results']]
            }
        }
    }
}
```

---

## Best Practices

### Test Organization

1. **Group tests by functionality**: Use TestNG groups (foundation, regression)
2. **Independent tests**: Each test should be able to run in isolation
3. **Descriptive names**: Method names should describe the test scenario
4. **Clean data**: Use cleanup suite to maintain test environment

### Code Quality

1. **DRY Principle**: Common methods in BasePage/CommonPage
2. **Single Responsibility**: Each page class handles one page
3. **Meaningful locators**: Use stable selectors (IDs, data attributes)
4. **Explicit waits**: Avoid Thread.sleep, use FluentWait

### Reporting

1. **Descriptive assertions**: Include meaningful error messages
2. **Screenshots**: Automatic capture on failure
3. **Test descriptions**: Use @Test description attribute

---

## Troubleshooting

### Common Issues

**1. WebDriver not found**
```bash
# Solution: WebDriverManager handles this automatically
# Ensure internet connectivity for driver download
```

**2. Element not clickable**
```java
// Framework handles this with fallback to JavaScript click
clickWhenReady(locator);  // Tries normal click, falls back to JS
```

**3. Stale Element Exception**
```java
// FluentWait is configured to handle this
fluentWait.ignoring(StaleElementReferenceException.class);
```

**4. Tests failing in headless mode**
```bash
# Ensure window size is set
mvn test -Dheadless=true
# Window size is automatically set to 1920x1080 in headless mode
```

**5. Allure report not generating**
```bash
# Ensure AspectJ weaver is properly configured
mvn clean test
mvn allure:serve
```

---

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-feature`)
3. Commit changes (`git commit -m 'Add new feature'`)
4. Push to branch (`git push origin feature/new-feature`)
5. Create Pull Request

### Coding Standards

- Follow Java naming conventions
- Add Javadoc for public methods
- Write unit tests for utilities
- Update README for new features

---

## License

This project is licensed under the MIT License.

---

## Author

**Automation Test Engineer**

- Framework Design and Implementation
- Test Case Development
- CI/CD Integration

---

## Version History

| Version | Date | Changes |
|---------|------|---------|
| 1.0.0 | 2025 | Initial release with full module coverage |

---

## Support

For issues and questions:
1. Check the Troubleshooting section
2. Review existing issues in the repository
3. Create a new issue with detailed description

---

## Acknowledgments

- OrangeHRM Demo Environment: https://opensource-demo.orangehrmlive.com/
- Selenium WebDriver Documentation
- TestNG Framework
- Allure Framework
