package org.example;

import PageObjects.BasePO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v134.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Leave extends BasePO {

    @FindBy(xpath = "//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a")
    WebElement LeaveButton;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[1]/header/div[1]/div[3]/ul/li/span")
    WebElement profileActionsDropdown;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a")
    WebElement logoutOption;

    public void openLeavePage() throws InterruptedException{
        LeaveButton.click();
    }

    public void logout() throws InterruptedException{
        profileActionsDropdown.click();
        Thread.sleep(1000);
        logoutOption.click();
        Thread.sleep(3000);
    }
}
