import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BugorDmitriyTest {

    //    /TC_1_1  - Тест кейс:
//    //1. Открыть страницу https://openweathermap.org/
//    //2. Набрать в строке поиска город Paris
//    //3. Нажать пункт меню Search
//    //4. Из выпадающего списка выбрать Paris, FR
//    //5. Подтвердить, что заголовок изменился на "Paris, FR"
    @Test
    public void testH2TextWhenSearchingCityCountry() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\Пользователь\\Desktop\\ChromDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        driver.get(url);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        Thread.sleep(5000);

        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id='weather-widget']//input[@placeholder='Search city']")
        );
        searchCityField.click();
        searchCityField.sendKeys(cityName);

        WebElement searchButton = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//button[@type = 'submit']")
        );
        searchButton.click();

        Thread.sleep(1000);
        WebElement parisFRChoiceDropdownMenu = driver.findElement(
                By.xpath("//ul[@class = 'search-dropdown-menu']/li/span[text() = 'Paris, FR ']")
        );
        parisFRChoiceDropdownMenu.click();

        WebElement h2CityCountryHeader = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//h2")
        );
        Thread.sleep(1000);
        String actualResult = h2CityCountryHeader.getText();

        Assert.assertEquals(actualResult, expectedResult);
//        Thread.sleep(5000);

        driver.quit();

    }
//    TC_11_02
//1.  Открыть базовую ссылку
//2.  Нажать на единицы измерения Imperial: °F, mph
//
//3.  Подтвердить, что температура для города показана в Фарингейтах

    @Test
    public void testChangeTemperatureInF() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\Пользователь\\Desktop\\ChromDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "65°F";

        driver.get(url);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        Thread.sleep(5000);

        WebElement selectMeasurement = driver.findElement(
                By.xpath("//div[@class='option'][text() = 'Imperial: °F, mph']")
        );
        selectMeasurement.click();

        Thread.sleep(1500);

        WebElement temperatureInF = driver.findElement(
                By.xpath("//span[@class='heading']")
        );

        String actualResult = temperatureInF.getText();

        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();

    }
//    TC_11_03
//1.  Открыть базовую ссылку
//2. Подтвердить, что внизу страницы есть панель с текстом “We use cookies which are essential for the site to work.
// We also use non-essential cookies to help us improve our services. Any data collected is anonymised.
// You can allow all cookies or manage them individually.”
//3. Подтвердить, что на панели внизу страницы есть 2 кнопки “Allow all” и “Manage cookies”


    @Test
    public void testConfirmText() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\Пользователь\\Desktop\\ChromDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult1 = "We use cookies which are essential for the site to work. We also use non-essential"
                + " cookies to help us improve our services. Any data collected is anonymised. You can allow all "
                + "cookies or manage them individually.";
        String expectedResult2 = "Allow all";
        String expectedResult3 = "Manage cookies";

        driver.get(url);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        Thread.sleep(5000);

        WebElement cookiesDiscriptionText = driver.findElement(
                By.xpath("//div[@class='stick-footer-panel__container']//p[text()='We use cookies which are essential for the site to work. We also use non-essential cookies to help us improve our services. Any data collected is anonymised. You can allow all cookies or manage them individually.']")
        );
        String actualResult1 = cookiesDiscriptionText.getText();

        WebElement buttonAllowAll = driver.findElement(
                By.xpath("//button[@class='stick-footer-panel__link']")
        );
        String actualResult2 = buttonAllowAll.getText();

        WebElement buttonManageCookies = driver.findElement(
                By.xpath("//div[@class='stick-footer-panel__btn-container']//a")
        );
        String actualResult3 = buttonManageCookies.getText();

        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);
        Assert.assertEquals(actualResult3, expectedResult3);

        driver.quit();

    }
//    TC_11_04
//1.  Открыть базовую ссылку
//2.  Подтвердить, что в меню Support есть 3 подменю с названиями “FAQ”, “How to start” и “Ask a question”

    @Test
    public void testMenuSupport() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\Пользователь\\Desktop\\ChromDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";
        String expectedResult1 = "FAQ";
        String expectedResult2 = "How to start";
        String expectedResult3 = "Ask a question";

        driver.get(url);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        Thread.sleep(6000);

        WebElement headingSupportDropdown = driver.findElement(
                By.xpath("//div[@id='support-dropdown']")
        );
        headingSupportDropdown.click();
        Thread.sleep(1000);

        WebElement supportDropdownMenuFAQ = driver.findElement(
                By.xpath("//ul[@class='dropdown-menu dropdown-visible']//a")
        );
        String actualResult1 = supportDropdownMenuFAQ.getText();

        WebElement supportDropdownMenuHowToStart = driver.findElement(
                By.xpath("//ul[@class='dropdown-menu dropdown-visible']//li/a[@href='/appid']")
        );
        String actualResult2 = supportDropdownMenuHowToStart.getText();

        WebElement supportDropdownMenuAskAQuestion = driver.findElement(
                By.xpath("//ul[@class='dropdown-menu dropdown-visible']//a[text()='Ask a question']")
        );
        String actualResult3 = supportDropdownMenuAskAQuestion.getText();

        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);
        Assert.assertEquals(actualResult3, expectedResult3);

        driver.quit();

    }

//    TC_11_05
//1. Открыть базовую ссылку
//2. Нажать пункт меню Support → Ask a question
//3. Заполнить поля Email, Subject, Message
//4. Не подтвердив CAPTCHA, нажать кнопку Submit
//5. Подтвердить, что пользователю будет показана ошибка “reCAPTCHA verification failed, please try again.”

        @Test
    public void testSupportAskAQuestionWithoutCaptcha() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\Пользователь\\Desktop\\ChromDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String email = "bugord1983@gmail.com";
        String message = "Help";
        String expectedResult = "reCAPTCHA verification failed, please try again.";

            driver.get(url);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            Thread.sleep(6000);
            WebElement idSupportDropDown = driver.findElement(
                    By.xpath("//li[@class='with-dropdown']")
                     );
            idSupportDropDown.click();

            WebElement supportDropdownMenuAskAQuestion = driver.findElement(
                    By.xpath("//ul[@class='dropdown-menu dropdown-visible']//a[text()='Ask a question']")
            );
//            WebElement askAQuestionMenu = driver.findElement(By.linkText("Ask a question"));
            supportDropdownMenuAskAQuestion.click();
            Thread.sleep(1500);

//            WebElement askAQuestionEmailField = driver.findElement(
//                    By.xpath("//input[@class='form-control string email required']")
//            );
            driver.get("https://home.openweathermap.org/questions");
            WebElement askAQuestionEmailField = driver.findElement(By.id("question_form_email"));
            askAQuestionEmailField.click();
            askAQuestionEmailField.sendKeys(email);
            Thread.sleep(5000);
            WebElement askAQuestionSubjectField = driver.findElement(
                    By.xpath("//select[@class='form-control select required']//option [@value='Other']")
            );
            askAQuestionSubjectField.click();

            WebElement askAQuestionMessageField = driver.findElement(
                    By.xpath("//div[@class='col-sm-8']//textarea[@id='question_form_message']")
            );
            askAQuestionMessageField.click();
            askAQuestionMessageField.sendKeys(message);
            Thread.sleep(1000);
            WebElement submitButton = driver.findElement(
                    By.xpath("//div[@class='col-sm-8']//input[@type='submit']")
            );
            submitButton.click();

            WebElement reCapcha = driver.findElement(
                    By.xpath("//div[@class='has-error']//div[@class='help-block']")
            );

           String actualResult = reCapcha.getText();

           Assert.assertEquals(actualResult, expectedResult);
        driver.quit();

    }
//    TC_11_06
//1.  Открыть базовую ссылку
//2.  Нажать пункт меню Support → Ask a question
//3.  Оставить значение по умолчанию в checkbox Are you an OpenWeather user?
//4. Оставить пустым поле Email
//5. Заполнить поля  Subject, Message
//6. Подтвердить CAPTCHA
//7. Нажать кнопку Submit
//8. Подтвердить, что в поле Email пользователю будет показана ошибка “can't be blank”

        @Test
    public void testEmptyEmailField() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\Пользователь\\Desktop\\ChromDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
            String url = "https://openweathermap.org/";
            String message = "Help";
            String expectedResult = "can't be blank";

            driver.get(url);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            Thread.sleep(8000);
            WebElement idSupportDropDown = driver.findElement(
                    By.xpath("//li[@class='with-dropdown']")
            );
            idSupportDropDown.click();

            WebElement supportDropdownMenuAskAQuestion = driver.findElement(
                    By.xpath("//ul[@class='dropdown-menu dropdown-visible']//a[text()='Ask a question']")
            );
//            WebElement askAQuestionMenu = driver.findElement(By.linkText("Ask a question"));
            supportDropdownMenuAskAQuestion.click();
            Thread.sleep(1500);

            driver.get("https://home.openweathermap.org/questions");
            Thread.sleep(1500);

            WebElement askAQuestionSubjectField = driver.findElement(
                    By.xpath("//select[@class='form-control select required']//option [@value='Other']")
            );
            askAQuestionSubjectField.click();

            WebElement askAQuestionMessageField = driver.findElement(
                    By.xpath("//div[@class='col-sm-8']//textarea[@id='question_form_message']")
            );
            askAQuestionMessageField.click();
            askAQuestionMessageField.sendKeys(message);

            WebElement recaptchaCheckbox = driver.findElement(
                    By.xpath("//label[@class='rc-anchor-center-item rc-anchor-checkbox-label']")
            );
            recaptchaCheckbox.click();

            WebElement submitButton = driver.findElement(
                    By.xpath("//div[@class='col-sm-8']//input[@type='submit']")
            );
            submitButton.click();

            WebElement emailFieldMistake = driver.findElement(
                    By.xpath("//div[@class='col-sm-8']//span[@class='help-block']")
            );

            String actualResult = emailFieldMistake.getText();

            Assert.assertEquals(actualResult, expectedResult);


            driver.quit();

    }

    //    @Test
//    public void test_name() {
//        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\Пользователь\\Desktop\\ChromDriver\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//
//
//        driver.quit();
//
//    }
}
