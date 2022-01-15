# cucumber-ui-framework
Booking.com UI scenarios are automated using Cucumber framework

1. Install **Maven**,  **Git** and **Java**

2. **Folder Structure:**
    - **_Features:_** ./src/test/resources/features
    - **_Step Definitions:_** ./src/test/java/steps
    - **_Pages:_**  ./src/test/java/pages

3. **Command to run all scenarios:**
   Open a terminal and cd to folder of your choice
   clone the repo by
   ```bash
    git clone repo link
    ```
   cd to the project directory and run
    ```bash
    mvn clean verify
    ```

4. **Run Time Parameters:**
     - **_Optional Parameters:_**
    ```bash With Tags
    -DcucumberTags="**Pass Cucumber Tag and combinations here**"
    ```
    ```bash Parallel Run
    -DforkCount="**Pass number of parallel threads here**"
    ```

5. **Examples:**
    ```bash
    mvn clean verify -DcucumberTags="@shopping" 
    ```
    ```bash
    Parallel Testing
    mvn clean verify -DcucumberTags="@carSearch" -DforkCount=2
    ```

6. **Report Generation command:**
    ```bash
    allure generate -c target/allure-results
    ```
   ```bash
    To open the report, cd till taget folder and run the following command
    allure serve
    ```

   In order to generate a report, we should install Allure command-line interpreter.

   For Windows,

   Download the latest version as a zip archive from bintray: https://bintray.com/qameta/generic/allure2/2.7.0#files/io%2Fqameta%2Fallure%2Fallure%2F2.7.0
   Unpack the archive.
   Navigate to the bin directory.
   Add allure’s bin directory to system Path variable.
   
   For Mac,
   ```bash
    brew install allure
    ```
   