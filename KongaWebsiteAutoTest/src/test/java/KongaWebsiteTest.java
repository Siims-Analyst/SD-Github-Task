import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaWebsiteTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        // Locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "/Users/simisola/Desktop/Simisola/KongaWebsiteAutoTest/resources/chromedriver");
        // Open your Chrome browser
        driver = new ChromeDriver();
        // Maximize browser window
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void openKongaUrl() throws InterruptedException {
        // Opening of Konga website
        driver.get("https://konga.com");
        System.out.println("Open Konga Url");
    }

    @Test(priority = 1)
    public void successfulSignIn() throws InterruptedException {
        // Successfully sign in
        Thread.sleep(10000);
        // Click on the Login/Signup button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);
        // Locate and enter email address or phone number
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("verzotesting+paul@gmail.com");
        // Locate password field and input password
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Paultest1234");
        // Locate login button and click to sign in
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        // Wait for home page to load
        Thread.sleep(10000);
        // Verify home page has loaded by locating my account button
        WebElement myAccountButton = driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/a/span"));
        Thread.sleep(5000);
        System.out.println(myAccountButton.getText());
    }

    @Test(priority = 2)
    public void addToCart() throws InterruptedException {
        // Successfully add product to cart
        // From the Categories, click on "Computers and Accessories"
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        // Locate and click on the Laptop SubCategory
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span")).click();
        Thread.sleep(5000);
        // Locate and click on the Apple MacBooks
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/ul/li[1]/a/label/span")).click();
        Thread.sleep(5000);
        // Locate and add item to the cart by clicking add to cart button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[1]/div/div/div[3]/form/div[2]/button")).click();
        Thread.sleep(10000);
        // Verify the product is in the cart
        WebElement cartItem = driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]"));
        cartItem.click();
        Thread.sleep(10000);
        System.out.println(cartItem.getText());
    }

    @Test(priority = 3)
    public void checkout() throws InterruptedException {
        // Successfully checkout product
        // Locate checkout button and click
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(10000);
        System.out.println("CheckOut");
    }

    @Test(priority = 4)
    public void addAddress() throws InterruptedException {
        // Locate and click on the add address button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        Thread.sleep(10000);
        // Locate the first name field and enter first name
        driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys("Paul");
        // Locate the last name field and enter last name
        driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys("Scholes");
        // Locate the phone number field and enter phone number
        driver.findElement(By.xpath("//*[@id=\"telephone\"]")).sendKeys("08165302515");
        // Locate street address field and input street address
        driver.findElement(By.xpath("//*[@id=\"street\"]")).sendKeys("23 Awolowo street, ikoyi");
        // Locate city field and input city
        driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Ikoyi");
        // Locate state field and input state
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/form/div[6]/div/div/select")).sendKeys("Lagos");
        Thread.sleep(10000);
        // Locate LGA field and input LGA
        driver.findElement(By.name("areaId")).sendKeys("Eti osa");
        // Locate and click on the save changes button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/form/div[8]/div[1]/button")).click();
        Thread.sleep(10000);
        // Select added address to use
        WebElement addedAddress = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div/form/button"));
        addedAddress.click();
        Thread.sleep(10000);
        // Locate use address button and click
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        Thread.sleep(5000);
        // Verify address was added successfully
        WebElement address = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/p[2]"));
        Thread.sleep(10000);
        System.out.println("AddAddress");
    }

    @Test(priority = 5)
    public void selectCardMethod() throws InterruptedException {
        // Locate pay now and click
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        // Locate continue to payment button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(10000);
        // Switch to the iframe that displays payment modal
        WebElement iframe = driver.findElement(By.xpath("//*[@id=\"kpg-frame-component\"]"));
        driver.switchTo().frame(iframe);
        Thread.sleep(10000);
        // Locate card payment method and select
        driver.findElement(By.className("Card")).click();
        Thread.sleep(10000);
        System.out.println("Select Card Method");

    }

    @Test(priority = 6)
    public void inputInvalidCardDetails() throws InterruptedException {
        // Input invalid card details
        // Locate card number field and enter invalid card number
        driver.findElement(By.id("card-number")).sendKeys("5399836629192672");
        Thread.sleep(5000);
        // Locate date field and enter invalid expiry date
        driver.findElement(By.id("expiry")).sendKeys("0128");
        Thread.sleep(5000);
        // Locate cvv field and enter invalid cvv
        driver.findElement(By.id("cvv")).sendKeys("526");
        Thread.sleep(5000);
        System.out.println("Input card details");
        // Locate card pin field and click
        driver.findElement(By.xpath("//*[@id=\"card-pin-new\"]")).click();
        Thread.sleep(5000);
        // Locate button 1 on password keypad and click
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[1]")).click();
        Thread.sleep(5000);
        // Locate button 2 on password keypad and click
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[2]")).click();
        Thread.sleep(5000);
        // Locate button 3 on password keypad and click
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[3]")).click();
        Thread.sleep(5000);
        // Locate button 4 on password keypad and click
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[4]")).click();
        Thread.sleep(5000);
        // Locate submit button and click
        driver.findElement(By.xpath("//*[@id=\"validateCardForm\"]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"validateCardForm\"]")).click();
        Thread.sleep(5000);
        System.out.println("Input card pin");
    }

    @Test(priority = 7)
    public void errorMessage() throws InterruptedException {
        // Print out the error message: Invalid card number
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"card-number\"]"));
        // Print out error message
        System.out.println(errorMessage.getText());
        Thread.sleep(5000);
    }

    @Test(priority = 8)
    public void closePaymentModal() throws InterruptedException {
        // Locate x button on payment modal and click to close modal
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).click();
        Thread.sleep(5000);
        System.out.println("Close Payment Modal");
    }

    @Test(priority = 9)
    public void returnToDefaultFrame() throws InterruptedException {
        // Switch back to default frame
        driver.switchTo().defaultContent();
        System.out.println("Close Iframe");
    }

    @AfterTest
    public void tearDown() {
        // Quit the browser
        if (driver != null) {
            driver.quit();
        }
    }


}
