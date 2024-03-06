import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.time.Duration;



public class Main {

    public static void main(String[] args) {
        // Sample WebDriver instance
 System.setProperty("webdriver.chrome.driver", "C:\\Users\\SOUMY\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Set Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions", "--disable-user-media-security=true",
                "--allow-file-access-from-files", "--use-fake-device-for-media-stream",
                "--use-fake-ui-for-media-stream", "--disable-popup-blocking", "--disable-infobars",
                "--enable-usermedia-screen-capturing", "--disable-dev-shm-usage", "--no-sandbox",
                "--auto-select-desktop-capture-source=Screen 1", "--disable-blink-features=AutomationControlled");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver(options);

        // Maximize the browser window
        driver.manage().window().maximize();
        // Call the methods in sequence
        login(driver);
        navigateToCertificates(driver);
        searchAndSelectStudent(driver, "Sam");
        selectOrganisationType(driver, "Group of Schools");
        nameOfGroup(driver,"samGroup");
        numberOfBranches(driver,"2");
         phoneNumber(driver,"8847811630");
        selectRole(driver, "Teacher");
        // clickGenerate(driver);

        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }

    public static void login(WebDriver driver) {
    // Navigate to the login page
    driver.get("https://www.teachmint.com/login");

    // Find the username and password input fields
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    WebElement userInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#user-input")));
  

    // Enter the username and password
    userInput.sendKeys("8847811630");

    // Find and click the login button
    WebElement nextButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#send-otp-btn-id")));
    nextButton.click();

    // Wait for the page to load after login
    driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

    
    driver.get("https://www.teachmint.com/features/certificate-generation#:~:text=Teachmint's%20Online%20Certificate%20Generator%20feature,such%20as%20salary%20slips%");
}


   public static void navigateToCertificates(WebDriver driver) {
    // Simulate navigation to certificates page
    // For example:
    WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(30));
WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#fp-ips-banner")));
element.click();

}



public static void searchAndSelectStudent(WebDriver driver, String studentName) {
    // Simulate searching and selecting a student
    // For example:
    
    WebElement name = driver.findElement(By.cssSelector("#tm-tfi-contact-form-name-mobile"));
    name.sendKeys(studentName);
    
    
}
public static void selectOrganisationType(WebDriver driver, String organisationType) {
    // Find the radio button element for the organisation type
    WebElement organisationTypeRadioButton = null;
    if (organisationType.equals("Independent School")) {
        organisationTypeRadioButton = driver.findElement(By.cssSelector("#tm-tfi-contact-form-independent-school-mobile"));
    } else if (organisationType.equals("Group of Schools")) {
        organisationTypeRadioButton = driver.findElement(By.cssSelector("#tm-tfi-contact-form-group-of-schools-mobile"));
    }

    // Check if the radio button is found and click it
    if (organisationTypeRadioButton != null) {
        organisationTypeRadioButton.click();
    } else {
        System.out.println("Invalid organisation type provided: " + organisationType);
    }
}

public static void nameOfGroup(WebDriver driver,String groupName) {
    // Simulate clicking the generate button
    // For example:
   WebElement nameOfGroup = driver.findElement(By.cssSelector("#tm-tfi-contact-form-name-of-group-mobile"));
    nameOfGroup.sendKeys(groupName);
}
public static void numberOfBranches(WebDriver driver,String noB) {
    // Simulate clicking the generate button
    // For example:
   WebElement numberOfBranches = driver.findElement(By.cssSelector("#tm-tfi-contact-form-number-of-branches-mobile"));
    
    numberOfBranches.sendKeys(noB);
}
public static void phoneNumber(WebDriver driver,String number) {
    // Simulate clicking the generate button
    // For example:
   WebElement phoneNumber = driver.findElement(By.cssSelector("#tm-tfi-contact-form-phone-mobile"));
    phoneNumber.sendKeys(number);
}
public static void selectRole(WebDriver driver, String role) {
    // Find the role dropdown element
    WebElement roleDropdown = driver.findElement(By.cssSelector("#tm-tfi-contact-form-role-mobile"));

    // Create a Select object for the dropdown
    Select dropdown = new Select(roleDropdown);

    // Select the option by visible text
    dropdown.selectByVisibleText(role);
}




public static void clickGenerate(WebDriver driver) {
     WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#tmd-submit")));
element.click();
}


}
