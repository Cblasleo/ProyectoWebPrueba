package com.nttdata.ct.web.page;

import com.nttdata.ct.web.base.WebBase;
import com.nttdata.ct.web.service.util.UtilWeb;
import org.openqa.selenium.WebElement;

public class GoogleSettinsPage extends WebBase {

    protected String searchInput = "settings-ui;cr-toolbar;cr-toolbar-search-field#search;div#searchTerm #searchInput";
    protected String result = "settings-ui;settings-main;settings-basic-page;#basicPage settings-section[page-title=Autocompletar];#header h2";

    public void searchSettings(String option) {
        WebElement inputElement = js().getWebElement(searchInput);
        type(inputElement, option);
        UtilWeb.waitForSeconds(1);
    }

    public String getValueResult() {
        return js().getTextFromWebElement(result);
    }
}