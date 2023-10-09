package org.example.stepdefs;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.GuardianNewsPage;
import org.openqa.selenium.WebDriver;

public class guardianNewsPageStepDef {

    private WebDriver driver;
    private GuardianNewsPage guardianNewsPage;

    @Given("user is on guardian news page")
    public void the_user_is_on_guardian_news_page() {
        driver = DriverFactory.getDriver();
        guardianNewsPage =  new GuardianNewsPage(driver);
    }

    @When("they select the first news article on the page")
    public void they_select_the_first_news_article_on_the_page() {
        guardianNewsPage.getFirstNewsText();

    }

    @When("they search for similar information on Google or other resources")
    public void they_search_for_similar_information_on_google_or_other_resources() {
        guardianNewsPage.navigateToGoogle();
        guardianNewsPage.searchNewsOnGoogle();
    }

    @Then("they find two or more articles on the same topic")
    public void they_find_two_or_more_articles_on_the_same_topic() {
        guardianNewsPage.searchResultCount();
    }

    @Then("the first Guardian news article is considered valid")
    public void the_first_guardian_news_article_is_considered_valid() {
    guardianNewsPage.checkNewsArticleValidity();
    }

    @Then("the first Guardian news article is considered fake")
    public void the_validity_of_the_first_guardian_news_article_fake() {
    guardianNewsPage.checkFakeNewsArticle();
    }

}
