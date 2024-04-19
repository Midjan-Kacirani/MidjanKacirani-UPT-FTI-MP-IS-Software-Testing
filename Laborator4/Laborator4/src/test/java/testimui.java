import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Objects;

/**
 * Shenim:
 * Ne varesi te rrjedhes, jane krijuar tre teste. Sigursht kane varesi ndaj njera tjetres, prandaj eshte e rendesishme qe te ekzekutohen ne nje radhe te percaktuar.
 * Per te evidentuar kete, mund te shtohet nje kusht qe kontrollohet URL e faqes, dhe nqs jena ne faqen e duhur te behen asserts, nqs jo te behet nje assertFalse qe te bej fail testi.
 * Gjithesesi, nuk eshte ky qellim i laboratorit por testimi i website.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class testimui {

    static WebDriver driver;
    static String firstName;
    static String lastName;
    static String email;
    static String passwordStr;
    static String kompani;

    @BeforeAll
    public static void init() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        driver.manage().window().maximize();

        //Inicializojme variablat qe do te perdoren gjate metodave
        firstName = "FirstName" + System.currentTimeMillis() / 1000L;
        lastName = "LastName" + System.currentTimeMillis() / 1000L;
        email = "email" + System.currentTimeMillis() / 1000L + "@dummyemail.com";
        passwordStr = "password" + System.currentTimeMillis() / 1000L;
        kompani = "Kompani " + System.currentTimeMillis() / 1000L + " CO.";
    }

    @AfterAll
    public static void destroy() {
        driver.close();
    }

    @Test
    @Order(1)
    public void ex1234() {
        //Navigoni ne https://demo.nopcommerce.com/
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.className("ico-login")).click();
        System.out.println(driver.findElement(By.className("register-button")).getText());
        driver.findElement(By.className("register-button")).click();
        String title = driver.getTitle();
        System.out.println(title);
        Assertions.assertEquals("nopCommerce demo store. Register", title);
    }

    @Test
    @Order(2)
    public void ex56() throws InterruptedException {
        //Ruajme radio buttons
        WebElement maleRadioButton = driver.findElement(By.id("gender-male"));
        WebElement femaleRadioButton = driver.findElement(By.id("gender-female"));

        Thread.sleep(2000);

        Assertions.assertFalse(maleRadioButton.isSelected() && femaleRadioButton.isSelected());
        //Selektojme gender-male dhe sigurohemi qe gender-female nuk eshte selektuar
        maleRadioButton.click();
        Assertions.assertTrue(maleRadioButton.isSelected() && !femaleRadioButton.isSelected());

        Thread.sleep(2000);


        driver.findElement(By.id("FirstName")).sendKeys(firstName);

        String lastName = "LastName" + System.currentTimeMillis() / 1000L;
        driver.findElement(By.id("LastName")).sendKeys(lastName);
        Thread.sleep(2000);
        //Selektojme dropdowns ne lidhje me moshen
        Select date = new Select(driver.findElement(By.name("DateOfBirthDay")));
        Select month = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        Select year = new Select(driver.findElement(By.name("DateOfBirthYear")));

        //Zgjedhim vlerat perkatese:
        date.selectByVisibleText("18");
        month.selectByVisibleText("March");
        year.selectByVisibleText("2002");

        //Sigurohemi qe vendosja e vlerave funksionon si duhet
        Assertions.assertFalse(Objects.equals(date.getFirstSelectedOption().getText(), date.getOptions().get(0).getText()) || Objects.equals(month.getFirstSelectedOption().getText(), month.getOptions().get(0).getText()) || Objects.equals(year.getFirstSelectedOption().getText(), year.getOptions().get(0).getText()));

        //Plotesojme email
        driver.findElement(By.id("Email")).sendKeys(email);

        //Plotesojme kompanine
        driver.findElement(By.id("Company")).sendKeys(kompani);

        //E hekum opsionin per te marr te rejat/newsletter
        driver.findElement(By.id("Newsletter")).click();

        //Shikojme nqs veprimi i mesiperm ishte i suksesshem.
        Assertions.assertFalse(driver.findElement(By.id("Newsletter")).isSelected());

        //Plotesimi i password
        //Jane dy fusha qe duhen plotesuar
        //Password, ka 2 test cases,
        //Password me me pak se 6 karaktere - marrim mesazhin qe afishohet
        //Password me me shume se 6 karaktere
        //////////
        //ConfirmPassword, ka 2 test cases,
        //ConfirmPassword me password jo te njejte - marrim mesazhin qe afishohet
        //ConfirmPassword = Password

        WebElement password = driver.findElement(By.cssSelector("div[class='inputs']>input[name='Password']"));
        password.sendKeys("12345");

        //Klikojme fushen per konfirmim ne menyre qe te afishojme mesazhin qe password duhet te kete me shume karaktere
        WebElement confirmPassword = driver.findElement(By.xpath("(//input[@type='password'])[position()=2]"));
        confirmPassword.click();

        Assertions.assertEquals("Password must meet the following rules:", driver.findElement(By.cssSelector("#Password-error > p")).getText());
        //Fshijme vleren e meparshme
        password.clear();
        //Vendosim vleren e re
        password.sendKeys(passwordStr);


        confirmPassword.sendKeys("nonMatchingPassword");

        //Klikojme trupin e faqes ne menyre qe te afishojme mesazhin qe password nuk ben match
        driver.findElement(By.className("master-wrapper-page")).click();

        Assertions.assertEquals("The password and confirmation password do not match.", driver.findElement(By.id("ConfirmPassword-error")).getText());
        //Fshijme vleren e meparshme
        confirmPassword.clear();
        //Vendosim vleren e re
        confirmPassword.sendKeys(passwordStr);

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("div[class='buttons']>button")).click();

        Assertions.assertEquals("Your registration completed", driver.findElement(By.className("result")).getText());
        Thread.sleep(2000);
        //Klikojme continue per te vazhduar ne fillim qe te bejme log-in.
        driver.findElement(By.className("register-continue-button")).click();

        Thread.sleep(2000);
    }

    @Test
    @Order(3)
    public void ex8910() throws InterruptedException {
        //Klikojme Log in
        driver.findElement(By.className("ico-login")).click();

        //Plotesojme fushat
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(passwordStr);

        //Klikojme login
        driver.findElement(By.className("login-button")).click();

        Assertions.assertEquals("nopCommerce demo store", driver.getTitle());
        Assertions.assertTrue(driver.findElement(By.className("ico-logout")).isDisplayed());

    }

}
