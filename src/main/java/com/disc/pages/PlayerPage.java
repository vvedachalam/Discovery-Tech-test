package com.disc.pages;

import com.disc.util.WebDriverHelper;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerPage {
  private final By HOMEPAGE_SINGOUT_SELECTOR = By.cssSelector("div.nav--connect-mode");
  private final By TENNIS_SECTION_SELECTOR =
      By.cssSelector("#favorites-suggested-container > div:nth-child(3) > a > div");
  private final By FOOTBALL_SECTION_SELECTOR =
      By.cssSelector("#favorites-suggested-container > div:nth-child(1) > a > div");
  private final By CHAMPIONS_LEAGUE_SECTION_SELECTOR =
      By.cssSelector("#favorites-suggested-container > div:nth-child(2) > a > div");
  private final By TENNIS_FIRST_VIDEO_SELECTOR =
      By.cssSelector(" #video-list__container > div > div > a:nth-child(1)");


  @Autowired
  private WebDriverHelper webDriverHelper;

  public void navigateToHomePage(String url) {
    webDriverHelper.navigateToURL(url);
  }

  public void acceptCookiesPolicy() {
    webDriverHelper.addCookie("euconsent", "BOlJpU2OlJpU2AKANBENCg-AAAApppNYVLimZ4AqUfoFBmRDEC6hIC5G"
                                           + "wQUYhAIMBAaAAGBTtAggyAAIkcgAQgQgIAxIBABggAAQAQiEkmAAABAAAQBAAAAAAAAAAAAAAA"
                                           + "AAAAAAAAAA");
    webDriverHelper.addCookie("eupubconsent", "BOlJpU2OlJpU2AKANAENAAAACAAAAA");
  }

  public void setUserCookies() {
    webDriverHelper.addCookie("CommunityUserCheck", "True");
    webDriverHelper.addCookie("CommunityUserNew", "pseudo=disctest&lastname=&firstname=&userId=7332291"
                                                  + "&avatarUrl=https%3A%2F%2Flayout.eurosport"
                                                  + ".com%2Fi%2Fv8%2Favatar%2Favatar"
                                                  + ".png&avatarType=0&socialType=None&activationhash=471d3db71ab4c66785bcd4ab18ee4783&email=discoverytest842%40gmail.com&md5=5d536f72deabfd85a9058427a46bf923&sha256=264a82957f54ddb1db850290dd6cc6db566c0f341a71261c58cdfdf65668bc70&nl=0&lfToken=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJkb21haW4iOiJldXJvc3BvcnQtZW4uZnlyZS5jbyIsInVzZXJfaWQiOiI3MzMyMjkxIiwiZXhwaXJlcyI6NjM3MDM3NDQ0ODYzMTgzMDA2LCJkaXNwbGF5X25hbWUiOiJkaXNjdGVzdCJ9.cDp4qyGRAxJ6w5GtShMoRXiwRdrQZHCFM9kitvsXKKo");

  }

  public void refreshPage() {webDriverHelper.refreshPage();}

  public void waitForSeconds(int sec) throws InterruptedException {
//    sleep(sec * 1000);
    webDriverHelper.waitImp(sec);
  }

  public String getCurrentURL() {
    return webDriverHelper.getPageURL();
  }

  public String getFirstVideoTitle() {
    return getTextFromElement(TENNIS_FIRST_VIDEO_SELECTOR);
  }

  public String getFirstVideoLink() {
    return getLinkFromElement(TENNIS_FIRST_VIDEO_SELECTOR);
  }

  private String getTextFromElement(By locator) {
    return webDriverHelper.getElement(locator).getText();
  }

  private void selectElement(By locator) {
    webDriverHelper.clickOnElement(locator);
  }

  private String getLinkFromElement(By locator) {
    return webDriverHelper.getElement(locator).getAttribute("href");
  }

  public void selectAvatar() {
    selectElement(HOMEPAGE_SINGOUT_SELECTOR);
  }

  public void selectTennis() {
    selectElement(TENNIS_SECTION_SELECTOR);
  }

  public void selectFootball() {
    selectElement(FOOTBALL_SECTION_SELECTOR);
  }

  public void selectChampionsLeague() {
    selectElement(CHAMPIONS_LEAGUE_SECTION_SELECTOR);
  }

  public void selectFirstTennisVideo() {
    selectElement(TENNIS_FIRST_VIDEO_SELECTOR);
  }

}


