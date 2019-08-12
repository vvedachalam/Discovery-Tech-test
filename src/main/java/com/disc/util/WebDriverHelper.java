package com.disc.util;

import com.disc.context.Context;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class WebDriverHelper {
  @Autowired
  private Context context;

  public void navigateToURL(final String url) {
    context.getBrowser().get(url);
  }

  public List<WebElement> getElements(final By locator) {
    return context.getBrowser().findElements(locator);
  }
  public WebElement getElement(final By locator) {
    return context.getBrowser().findElement(locator);
  }

  public void clickOnElement(final By locator) {
    context.getBrowser().findElement(locator).click();
  }

  public void setTextInTextbox(final By locator, final String text) {
    context.getBrowser().findElement(locator).clear();
    context.getBrowser().findElement(locator).sendKeys(text);
  }

  public void addCookie(final String cookName, final String cookVal){
    Cookie cookie=new Cookie(cookName,cookVal);
    context.getBrowser().manage().addCookie(cookie);
  }
  public void refreshPage(){
    context.getBrowser().navigate().refresh();
  }
  public String getPageURL(){
    return context.getBrowser().getCurrentUrl();
  }


//  public void waitForElementToPresent(final By element, final int waitTime) {
//    try {
//      (new WebDriverWait(context.getBrowser(), waitTime))
//          .until(ExpectedConditions.presenceOfElementLocated(element));
//    } catch (TimeoutException te) {
////            if catches time out exception do nothing
//
//    }
//  }

  public void waitImp(int sec){
    context.getBrowser().manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
  }

  public void screenshot() {
    byte[] screenshot = context.getBrowser().getScreenshotAs(OutputType.BYTES);
    context.getScenario().embed(screenshot, "image/png");
  }

}
