package com.nttdata.ct.web.step;

import com.nttdata.ct.web.page.StepPages;
import com.nttdata.ct.web.service.aspect.evidence.ScreenShot;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ScreenShot
@Component
public class SauceSearchStep {

    @Autowired
    private StepPages page;

    public void searchData(String data) {
        page.searchPage().writeSearch(data);
        page.searchPage().search();
    }
    public void searchUserPasword(String user, String password) {
        page.searchPage().writeSearch(user,password);
        page.searchPage().search();
    }
    public void validateResults(int count) {
        Assert.assertTrue("Resultado esperado menor o igual 0.", page.resultsPage().getSearchResults().length() > count);
    }
    public void escribirUser(String user) {
        page.searchPage().writeSearch(user);

    }
    public void escribirPassword(String password) {
        page.searchPage().writeSearch(password);

    }
}
