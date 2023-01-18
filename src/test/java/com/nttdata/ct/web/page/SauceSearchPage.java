package com.nttdata.ct.web.page;

import com.nttdata.ct.web.base.WebBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class SauceSearchPage extends WebBase {

    //@FindBy(xpath = "//input[@class='gLFyf gsfi']")
    @FindBy(xpath = "//input[@id='user-name']")
    protected WebElement searchUser;

    @FindBy(xpath = "//input[@id='password']")
    protected WebElement searchPassword;
    @FindBy(xpath = "(//input[@class='gNO89b'])[1]")
    protected WebElement buscarButton;

    public void writeSearch(String data) {
        var wait = webDriverWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(searchUser));
        type(searchUser, data);
    }

    public void writeSearch(String user, String password) {
        var wait = webDriverWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(searchUser));
        type(searchUser, user);
        type(searchPassword,password);
    }

    public void search() {
        var wait = webDriverWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(buscarButton));
        click(buscarButton);
    }

}