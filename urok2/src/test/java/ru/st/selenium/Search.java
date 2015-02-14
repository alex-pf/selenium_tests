package ru.st.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Search {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSearch() throws Exception {
    driver.get(baseUrl + "/php4dvd/");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("admin");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("submit")).click();
    // Поиск фильмов по параметрам
    // Поиск по имени с одним результатом
    driver.findElement(By.xpath("//input")).clear();
    driver.findElement(By.xpath("//input")).sendKeys("1999");
    driver.findElement(By.xpath("//input")).sendKeys(Keys.ENTER);
    // Проверяем результат
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("results"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    assertEquals(1, driver.findElements(By.xpath("//div[@id='results']/a/*")).size());
    assertEquals("Space: 1999", driver.findElement(By.cssSelector("div.title")).getText());
    // Чистим строку поиска
    driver.findElement(By.xpath("//input")).clear();
    driver.findElement(By.xpath("//input")).sendKeys("");
    driver.findElement(By.xpath("//input")).sendKeys(Keys.ENTER);
    // Поиск по имени с четырмя фильмами в результате
    driver.findElement(By.xpath("//input")).clear();
    driver.findElement(By.xpath("//input")).sendKeys("space");
    driver.findElement(By.xpath("//input")).sendKeys(Keys.ENTER);
    // Проверяем результат
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("results"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    assertEquals(4, driver.findElements(By.xpath("//div[@id='results']/a/*")).size());
    assertEquals("Dark Space", driver.findElement(By.cssSelector("div.title")).getText());
    assertEquals("Space", driver.findElement(By.xpath("//a[2]/div/div[2]")).getText());
    assertEquals("Space: 1999", driver.findElement(By.xpath("//a[3]/div/div[2]")).getText());
    assertEquals("Затерянные в космосе", driver.findElement(By.xpath("//a[4]/div/div[2]")).getText());
    // Чистим строку поиска
    driver.findElement(By.xpath("//input")).clear();
    driver.findElement(By.xpath("//input")).sendKeys("");
    driver.findElement(By.xpath("//input")).sendKeys(Keys.ENTER);
    // Поиск по имени с кириллицей
    driver.findElement(By.xpath("//input")).clear();
    driver.findElement(By.xpath("//input")).sendKeys("Затерянные");
    driver.findElement(By.xpath("//input")).sendKeys(Keys.ENTER);
    // Проверяем результат
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("results"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    assertEquals(1, driver.findElements(By.xpath("//div[@id='results']/a/*")).size());
    assertEquals("Затерянные в космосе", driver.findElement(By.cssSelector("div.title")).getText());
    // Чистим строку поиска
    driver.findElement(By.xpath("//input")).clear();
    driver.findElement(By.xpath("//input")).sendKeys("");
    driver.findElement(By.xpath("//input")).sendKeys(Keys.ENTER);
    // Поиск по тексту из поля "Also known as"
    driver.findElement(By.xpath("//input")).clear();
    driver.findElement(By.xpath("//input")).sendKeys("холодный");
    driver.findElement(By.xpath("//input")).sendKeys(Keys.ENTER);
    // Проверяем результат
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("results"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    assertEquals(1, driver.findElements(By.xpath("//div[@id='results']/a/*")).size());
    assertEquals("Dark Space", driver.findElement(By.cssSelector("div.title")).getText());
    // Чистим строку поиска
    driver.findElement(By.xpath("//input")).clear();
    driver.findElement(By.xpath("//input")).sendKeys("");
    driver.findElement(By.xpath("//input")).sendKeys(Keys.ENTER);
    // Поиск по году выпуска
    driver.findElement(By.xpath("//input")).clear();
    driver.findElement(By.xpath("//input")).sendKeys("1985");
    driver.findElement(By.xpath("//input")).sendKeys(Keys.ENTER);
    // Проверяем результат
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("results"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    assertEquals(1, driver.findElements(By.xpath("//div[@id='results']/a/*")).size());
    assertEquals("Space", driver.findElement(By.cssSelector("div.title")).getText());
    // Чистим строку поиска
    driver.findElement(By.xpath("//input")).clear();
    driver.findElement(By.xpath("//input")).sendKeys("");
    driver.findElement(By.xpath("//input")).sendKeys(Keys.ENTER);
    // Уходим
    driver.findElement(By.linkText("Log out")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to log out[\\s\\S]$"));
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
