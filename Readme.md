# UI Test Automation Framework

This project is a Java-based UI Test Automation Framework 

It follows a clean, modular, extensible design that supports cross-browser execution, cloud execution on LambdaTest, headless mode, data-driven testing, and rich reporting with ExtentReports.


## 🚀 About Me
Hi, I'm Arjun Swami, a Test Automation Engineer with 11 years of hands-on experience in building robust, scalable automation solutions. I specialize in UI automation using Selenium WebDriver and API automation using Rest Assured, with a strong focus on designing clean frameworks, enhancing test efficiency, and ensuring high-quality software delivery.


## Authors

- [@Arjun_Swami](https://github.com/swamiarjun1)


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/swamiarjun1/)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/arjun-swami01/)


## Prerequisite

- **Java 11+** — Required to compile and run the automation framework
- **Maven 3.6+** — Used for dependency management and executing tests



## Framework Features

- **Data-driven testing**— Uses OpenCSV, Gson, and Apache POI for flexible test data handling
- **Cross-browser execution** — Supports Chrome, Firefox, and Edge for flexible testing
- **Headless mode** -Enables fast, UI-less execution for CI pipelines and local runs 
- **Cloud execution support** -Seamlessly runs tests on LambdaTest using remote WebDriver
- **Log4j logging**: Provides detailed execution logs for debugging and traceability
- **Extent Reports integration** - Generates rich HTML reports with logs and screenshots


## Technologies Used
- Java
- Maven
- TestNG
- Selenium
- OpenCSV
- Gson
- Apache POI
- Faker
- LambdaTest
- ExtentReports
- Log4j
- Git
## Setup Instructions

**Clone the reporsitory**

```bash
  git clone https://github.com/swamiarjun1/UI-Automation-Framework.git 
  cd UI-Automation-Framework
```
**Running Tests on LambdaTest**

```bash
  mvn  test -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false -X

```
**Running Tests on Local Machine in Headless Mode**

```bash
  mvn  test -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=true -X

```


## Reports & Logs
- Reports: After execution, a detailed HTML report will be generated at./reports.html. The report contains information on test cases executed, passed, failed, and skipped, along with screenshots for failed tests. 

- Logs: Logs are created during the test execution and stored in the ./logs directory.  

## Integrated with Github Actions 
This Automation framework is integrated with github actions. The Tests will be executed at 11.30 pm daily 

The reports will be archived in gh-pages branch. You can view the html reports at : 
https://swamiarjun1.github.io/UI-Automation-Framework/report.html
