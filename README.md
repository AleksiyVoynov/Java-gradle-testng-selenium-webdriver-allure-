# Requirements:
* MacOS Sonoma and above
* Java 17
* Gradle
* Chrome
* Safari
* FireFox


# Guide:

## To run tests and generate Allure report:
* open terminal
* cd (path to /SeleniumWebDriverAutotest)
* run `gradle clean`
* run `gradle test`

## You can run auto test in parallel with Safari, Firefox and Chrome browsers
* open terminal
* cd (path to /SeleniumWebDriverAutotest)
* run `gradle clean`
* run `gradle parallelTest`

## To see a report:
1. run `allure serve build/allure-results `
