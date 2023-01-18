package com.nttdata.ct.web.page;

import org.springframework.stereotype.Component;

@Component
public class StepPages {

    public SauceSearchPage searchPage() {
        return new SauceSearchPage();
    }

    public SauceResultsPage resultsPage() {
        return new SauceResultsPage();
    }

    public GoogleSettinsPage settinsPage() {
        return new GoogleSettinsPage();
    }
}
