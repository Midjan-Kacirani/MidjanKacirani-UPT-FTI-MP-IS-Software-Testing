import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Objects;

public class testimui {

    static WebDriver driver;

    @BeforeAll
    public static void init() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        driver.manage().window().maximize();

        //Inicializojme variablat qe do te perdoren gjate metodave

    }

//    @AfterAll
//    public static void destroy() {
//        driver.close();
//    }


    @Test
    public void ex1234() {
        //body > div.master-wrapper-page > div.header > div.header-upper > div.header-links-wrapper > div.header-links > ul > li:nth-child(2) > a
        //Navigoni ne
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.className("ico-login")).click();
        System.out.println(driver.findElement(By.className("register-button")).getText());
        driver.findElement(By.className("register-button")).click();
        String title = driver.getTitle();
        System.out.println(title);
        Assertions.assertEquals("nopCommerce demo store. Register", title);
    }

    @Test
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
        String firstName = "FirstName" + System.currentTimeMillis() / 1000L;

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
        driver.findElement(By.id("Email")).sendKeys("email" + System.currentTimeMillis() / 1000L + "@dummyemail.com");

        //Plotesojme kompanine
        driver.findElement(By.id("Company")).sendKeys("Kompani " + System.currentTimeMillis() / 1000L + " CO.");

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
        password.sendKeys("123456");


        confirmPassword.sendKeys("nonMatchingPassword");

        //Klikojme trupin e faqes ne menyre qe te afishojme mesazhin qe password nuk ben match
        driver.findElement(By.className("master-wrapper-page")).click();

        Assertions.assertEquals("The password and confirmation password do not match.", driver.findElement(By.id("ConfirmPassword-error")).getText());
        //Fshijme vleren e meparshme
        confirmPassword.clear();
        //Vendosim vleren e re
        confirmPassword.sendKeys("123456");

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("div[class='buttons']>button")).click();

        Thread.sleep(2000);

        Assertions.assertEquals("Your registration completed", driver.findElement(By.className("result")).getText());

        //Klikojme continue per te vazhduar ne fillim qe te bejme log-in.
        driver.findElement(By.className("button-1 register-continue-button")).click();
    }


}
