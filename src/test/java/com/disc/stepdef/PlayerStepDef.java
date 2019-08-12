package com.disc.stepdef;

import com.disc.pages.PlayerPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.sikuli.script.App;
import org.sikuli.script.Image;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@ContextConfiguration("classpath:cucumber.xml")
public class PlayerStepDef {


  @Value("${test.url}")
  private String testUrl;
  @Value("${test.email}")
  private String testEmail;
  @Value("${test.password}")
  private String testPass;
  @Value("${browser.name}")
  private String browser;
  @Autowired
  private PlayerPage playerPage;
  private String Title;
  private String Link;


  @Given("^I am an Eurosport Customer$")
  public void iAmAnEurosportCustomer() throws Throwable {
    playerPage.navigateToHomePage(testUrl);
    playerPage.setUserCookies();
    playerPage.acceptCookiesPolicy();
    playerPage.refreshPage();

  }

  @Given("^On Videos Hub Page$")
  public void onVideosHubPage() throws Throwable {
    String URL= playerPage.getCurrentURL();
    System.out.println("Page URL is :"+URL);
    Assert.assertEquals("Not in Video page",testUrl,URL);

  }

//  @When("^I select to watch the videos from Tennis Section$")
  @When("^I select to watch the videos from '([^\"]*)' Section$")
  public void iSelectToWatchTheVideosFromTennisSection(String sport) throws Throwable {
    playerPage.selectAvatar();
    playerPage.waitForSeconds(5);
    switch (sport) {
      case("tennis"): {
        playerPage.selectTennis();
        break;
      }
      case("football"): {
        playerPage.selectFootball();
        break;
      }
      case("champions league"): {
        playerPage.selectChampionsLeague();
        break;
      }
      default: {
        playerPage.selectTennis();
      }

    }
    Title=playerPage.getFirstVideoTitle();
    System.out.println(Title);
    Link=playerPage.getFirstVideoLink();
    System.out.println(Link);
    playerPage.selectFirstTennisVideo();
  }

  @Then("^the selected video is playing$")
  public void theSelectedVideoIsPlaying() throws Throwable {
    String URL= playerPage.getCurrentURL();
    System.out.println("First video Page URL is :"+URL);
    Assert.assertEquals("Not in the right Video page",Link,URL);
  }

  @Then("^the following player controls are displayed$")
  public void theFollowingPlayerControlsAreDisplayed(DataTable list) throws Throwable {
    List<String> controls = list.asList(String.class);
    String path  = System.getProperty("user.dir") + "/src/test/resources/images/";
//    App.focus(browser);
    Screen screen = new Screen();
    System.out.println("path dir is: "+ path);
    screen.wait(new Pattern(path+"pause.png").similar(0.3f),1);
    Pattern pause=new Pattern(path+controls.get(0)+".png").similar(0.4f);
    Pattern play=new Pattern(path+controls.get(1)+".png").similar(0.4f);
    Pattern maximise=new Pattern(path+controls.get(2)+".png").similar(0.4f);
    if (screen.exists(maximise)==null) {
      throw new AssertionError("maximise button does not exist");
    }
    screen.hover(pause);
    if(screen.exists(pause)!=null) {
      screen.click(pause);
      System.out.println("pause button exists");
    }
    else {
      System.out.println("pause button does not exist");

    }
    screen.exists(play);
    screen.wait(play,5);
  }



}
