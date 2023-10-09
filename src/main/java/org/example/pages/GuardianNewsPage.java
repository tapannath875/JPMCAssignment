package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.ConfigReader;


import java.net.URL;
import java.util.List;
import java.util.Properties;

public class GuardianNewsPage {
    private WebDriver driver;
    String guardiannews;
    double searchResultCount;

    //Locators
    @FindBy(xpath="// button[@title='Yes, I’m happy']")
    private WebElement cookiesButton;

    @FindBy(xpath = "(//div[@class='fc-slice-wrapper'])[1]//li[1]//a[1]//span//span")
    private WebElement firstNewsText;

    @FindBy(xpath = "(//div[@class='fc-slice-wrapper'])[1]//li[1]//a[1]")
    private WebElement firstNewsLink;

    @FindBy(xpath = "//*[@title='Search']")
    private WebElement googleSearchBox;

    @FindBy(xpath = "(//*[@name='btnK' and @value='Google Search'])[2]")
    private WebElement googleSearchButton;

    @FindBy(xpath = "//h3")
    private List<WebElement> searchResults; // All search results are under h3 tags

    //Constructor - initialize page objects
    public GuardianNewsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Page methods/actions

    //this method is to accept cookies when news website is loaded
    public void acceptCookies(){
        try {
            if (cookiesButton.isDisplayed()) {
                cookiesButton.click();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    //method to find firstNews text
    public void getFirstNewsText(){
        guardiannews = firstNewsText.getText();
        System.out.println("news article is: " + guardiannews);
    }

    //method to click on firstNews link

    public void clickFirstNewsLink(){
        firstNewsLink.click();
    }

    //method to navigate to google url
    public void navigateToGoogle(){
        Properties prop = new ConfigReader().intializeProperties();
        driver.navigate().to(prop.getProperty("googleUrl"));
    }

    //method to search news in google
    public void searchNewsOnGoogle(){
       googleSearchBox.sendKeys(guardiannews);
       googleSearchButton.click();
    }

    //method to count total hyperlinks present for the news
    public void searchResultCount() {
        searchResultCount  = searchResults.size();
        System.out.println("search result size is: " +  searchResultCount);
    }

    //method to check news is valid
    public void checkNewsArticleValidity() {
        // Use TestNG assertion to check if the search result size is greater than 2
        Assert.assertTrue(searchResultCount >= 2, "the first Guardian news article is considered invalid");
    }

    //method is to check news is fake
    public void checkFakeNewsArticle() {
        // Use TestNG assertion to check if the search result size is greater than 2
        Assert.assertTrue(searchResultCount < 2, "the first Guardian news article is considered invalid");
    }

}
