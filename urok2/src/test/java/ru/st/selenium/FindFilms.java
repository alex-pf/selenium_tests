package ru.st.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import org.testng.annotations.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FindFilms extends ru.st.selenium.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testFindFilms() throws Exception {    // Объявляем переменняе
    // фильм 1
    String fTitle1 = "Буратино";
    String fAka1 = "По дрова";
    String fYear1 = "2000";
    String fGenres1 = "Фантастика";
    // фильм 2
    String fTitle2 = "Space";
    String fAka2 = "Космические дрова";
    String fYear2 = "1990";
    String fGenres2 = "Фантастика";
    // фильм 3
    String fTitle3 = "911 в дрова";
    String fAka3 = "скорая помощь";
    String fYear3 = "1995";
    String fGenres3 = "Сериал";
    // фильм 4
    String fTitle4 = "Сказочка";
    String fAka4 = "Сказание на скорую руку";
    String fYear4 = "1990";
    // фильм 5
    String fTitle5 = "Мультик";
    String fAka5 = "multic";
    String fYear5 = "1990";
    String fGenres5 = "Мульт";
    // фильм 6
    String fTitle6 = "Лунтик";
    String fAka6 = "1995";
    String fYear6 = "3000";
    String fGenres6 = "Мульт";
    String uLocale = "nl_NL";
    String outMes = "Weet je zeker dat je wilt uitloggen?";
    // Поехали уже, тестировать
    driver.get(baseUrl + "/php4dvd/");
    // Вабрали язук приложения
    driver.findElement(By.xpath("//a[contains(@href, '" + uLocale + "')]")).click();
    // Авторизация
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("admin");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("submit")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//li[3]/a"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Набиваем базу фильмами
    // фильм 1
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//a[contains(@href,'go=add')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//a[contains(@href,'go=add')]")).click();
    // Заполним поля формы
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.name("name"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys(fTitle1);
    driver.findElement(By.name("aka")).clear();
    driver.findElement(By.name("aka")).sendKeys(fAka1);
    driver.findElement(By.name("year")).clear();
    driver.findElement(By.name("year")).sendKeys(fYear1);
    driver.findElement(By.id("own_no")).click();
    driver.findElement(By.id("seen_no")).click();
    driver.findElement(By.name("genres")).clear();
    driver.findElement(By.name("genres")).sendKeys(fGenres1);
    driver.findElement(By.xpath("//a[contains(@onclick,'submit')]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//h2[contains(text(),'" + fTitle1 + "')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//nav//li[1]/a")).click();
    // фильм 2
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//a[contains(@href,'go=add')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//a[contains(@href,'go=add')]")).click();
    // Заполним поля формы
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.name("name"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys(fTitle2);
    driver.findElement(By.name("aka")).clear();
    driver.findElement(By.name("aka")).sendKeys(fAka2);
    driver.findElement(By.name("year")).clear();
    driver.findElement(By.name("year")).sendKeys(fYear2);
    driver.findElement(By.id("own_no")).click();
    driver.findElement(By.id("seen_no")).click();
    driver.findElement(By.name("genres")).clear();
    driver.findElement(By.name("genres")).sendKeys(fGenres2);
    driver.findElement(By.xpath("//a[contains(@onclick,'submit')]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//h2[contains(text(),'" + fTitle2 + "')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//nav//li[1]/a")).click();
    // фильм 3
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//a[contains(@href,'go=add')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//a[contains(@href,'go=add')]")).click();
    // Заполним поля формы
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.name("name"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys(fTitle3);
    driver.findElement(By.name("aka")).clear();
    driver.findElement(By.name("aka")).sendKeys(fAka3);
    driver.findElement(By.name("year")).clear();
    driver.findElement(By.name("year")).sendKeys(fYear3);
    driver.findElement(By.id("own_no")).click();
    driver.findElement(By.id("seen_no")).click();
    driver.findElement(By.name("genres")).clear();
    driver.findElement(By.name("genres")).sendKeys(fGenres3);
    driver.findElement(By.xpath("//a[contains(@onclick,'submit')]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//h2[contains(text(),'" + fTitle3 + "')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//nav//li[1]/a")).click();
    // фильм 4
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//a[contains(@href,'go=add')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//a[contains(@href,'go=add')]")).click();
    // Заполним поля формы
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.name("name"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys(fTitle4);
    driver.findElement(By.name("aka")).clear();
    driver.findElement(By.name("aka")).sendKeys(fAka4);
    driver.findElement(By.name("year")).clear();
    driver.findElement(By.name("year")).sendKeys(fYear4);
    driver.findElement(By.id("own_no")).click();
    driver.findElement(By.id("seen_no")).click();
    driver.findElement(By.xpath("//a[contains(@onclick,'submit')]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//h2[contains(text(),'" + fTitle4 + "')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//nav//li[1]/a")).click();
    // фильм 5
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//a[contains(@href,'go=add')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//a[contains(@href,'go=add')]")).click();
    // Заполним поля формы
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.name("name"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys(fTitle5);
    driver.findElement(By.name("aka")).clear();
    driver.findElement(By.name("aka")).sendKeys(fAka5);
    driver.findElement(By.name("year")).clear();
    driver.findElement(By.name("year")).sendKeys(fYear5);
    driver.findElement(By.id("own_no")).click();
    driver.findElement(By.id("seen_no")).click();
    driver.findElement(By.name("genres")).clear();
    driver.findElement(By.name("genres")).sendKeys(fGenres5);
    driver.findElement(By.xpath("//a[contains(@onclick,'submit')]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//h2[contains(text(),'" + fTitle5 + "')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//nav//li[1]/a")).click();
    // фильм 6
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//a[contains(@href,'go=add')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//a[contains(@href,'go=add')]")).click();
    // Заполним поля формы
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.name("name"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys(fTitle6);
    driver.findElement(By.name("aka")).clear();
    driver.findElement(By.name("aka")).sendKeys(fAka6);
    driver.findElement(By.name("year")).clear();
    driver.findElement(By.name("year")).sendKeys(fYear6);
    driver.findElement(By.id("own_no")).click();
    driver.findElement(By.id("seen_no")).click();
    driver.findElement(By.name("genres")).clear();
    driver.findElement(By.name("genres")).sendKeys(fGenres6);
    driver.findElement(By.xpath("//a[contains(@onclick,'submit')]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//h2[contains(text(),'" + fTitle6 + "')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//nav//li[1]/a")).click();
    // Поехали уже, тестировать
    // Кейс 1 - по части русского имени
    // Чистим строку поиска
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("q"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("q")).clear();
    driver.findElement(By.id("q")).sendKeys("");
    driver.findElement(By.id("q")).sendKeys(Keys.ENTER);
    driver.findElement(By.id("q")).clear();
    driver.findElement(By.id("q")).sendKeys("тик");
    driver.findElement(By.id("q")).sendKeys(Keys.ENTER);
    // Проверяем результат
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//div[@id='results']/a"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (2 == driver.findElements(By.xpath("//div[@id='results']/a")).size()) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    assertEquals(fTitle6, driver.findElement(By.xpath("//a[1]//div[contains(@class,'title')]")).getText());
    assertEquals(fTitle5, driver.findElement(By.xpath("//a[2]//div[contains(@class,'title')]")).getText());
    // Меняем сортировку по алфавиту
    // ERROR: Caught exception [ERROR: Unsupported command [mouseDown | //*[@id='sort-button']/span[2] | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [mouseDown | //*[@id='sort-menu']/li[2] | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [mouseUp | //*[@id='sort-menu']/li[2] | ]]
    // Проверяем результат
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//div[@id='results']/a"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (2 == driver.findElements(By.xpath("//div[@id='results']/a")).size()) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    assertEquals(fTitle5, driver.findElement(By.xpath("//a[1]//div[contains(@class,'title')]")).getText());
    assertEquals(fTitle6, driver.findElement(By.xpath("//a[2]//div[contains(@class,'title')]")).getText());
    // Возвращаем сортировку
    // ERROR: Caught exception [ERROR: Unsupported command [mouseDown | //*[@id='sort-button']/span[2] | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [mouseDown | //*[@id='sort-menu']/li[1] | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [mouseUp | //*[@id='sort-menu']/li[1] | ]]
    // Проверяем результат
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//div[@id='results']/a"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (2 == driver.findElements(By.xpath("//div[@id='results']/a")).size()) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    assertEquals(fTitle6, driver.findElement(By.xpath("//a[1]//div[contains(@class,'title')]")).getText());
    assertEquals(fTitle5, driver.findElement(By.xpath("//a[2]//div[contains(@class,'title')]")).getText());
    // Кейс 2 - по категориям
    // Чистим строку поиска
    driver.findElement(By.id("q")).clear();
    driver.findElement(By.id("q")).sendKeys("");
    driver.findElement(By.id("q")).sendKeys(Keys.ENTER);
    // Меняем категорию
    // ERROR: Caught exception [ERROR: Unsupported command [mouseDown | //*[@id='category-button']/span[2] | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [mouseDown | //*[@id='category-menu']/li[2] | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [mouseUp | //*[@id='category-menu']/li[2] | ]]
    // Проверяем результат
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//div[@id='results']/a"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (2 == driver.findElements(By.xpath("//div[@id='results']/a")).size()) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    assertEquals(fTitle6, driver.findElement(By.xpath("//a[1]//div[contains(@class,'title')]")).getText());
    assertEquals(fTitle5, driver.findElement(By.xpath("//a[2]//div[contains(@class,'title')]")).getText());
    // Меняем категорию
    // ERROR: Caught exception [ERROR: Unsupported command [mouseDown | //*[@id='category-button']/span[2] | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [mouseDown | //*[@id='category-menu']/li[3] | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [mouseUp | //*[@id='category-menu']/li[3] | ]]
    // Проверяем результат
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//div[@id='results']/a"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (1 == driver.findElements(By.xpath("//div[@id='results']/a")).size()) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    assertEquals(fTitle3, driver.findElement(By.xpath("//a[1]//div[contains(@class,'title')]")).getText());
    // Возвращаем все категории
    // ERROR: Caught exception [ERROR: Unsupported command [mouseDown | //*[@id='category-button']/span[2] | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [mouseDown | //*[@id='category-menu']/li[1] | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [mouseUp | //*[@id='category-menu']/li[1] | ]]
    // Проверяем результат
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//div[@id='results']/a"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (6 == driver.findElements(By.xpath("//*[@id='results']/*/div")).size()) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Кейс 3 - количество фильмов на странице
    // Чистим строку поиска
    driver.findElement(By.id("q")).clear();
    driver.findElement(By.id("q")).sendKeys("");
    driver.findElement(By.id("q")).sendKeys(Keys.ENTER);
    // Меняем количество элементов на странице на 4
    // ERROR: Caught exception [ERROR: Unsupported command [mouseDown | //*[@id='n-button']/span[2] | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [mouseDown | //*[@id='n-menu']/li[2] | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [mouseUp | //*[@id='n-menu']/li[2] | ]]
    // Проверяем результат
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("results"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (4 == driver.findElements(By.xpath("//div[@id='results']/a")).size()) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    try {
      assertEquals(2, driver.findElements(By.xpath("//*[@class='pager']/*")).size());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Возвращаем значение по умолчанию
    // ERROR: Caught exception [ERROR: Unsupported command [mouseDown | //*[@id='n-button']/span[2] | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [mouseDown | //*[@id='n-menu']/li[1] | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [mouseUp | //*[@id='n-menu']/li[1] | ]]
    // Проверяем результат
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("results"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (6 == driver.findElements(By.xpath("//div[@id='results']/a")).size()) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Уходим
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//a[contains(@href,\"logout\")]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//a[contains(@href,\"logout\")]")).click();
    assertEquals(outMes, closeAlertAndGetItsText());
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//form[@id='loginform']"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//a[contains(@href, './?lang=en_US')]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//td[contains(text(),'User name')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
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