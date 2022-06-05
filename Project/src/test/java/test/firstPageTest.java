package test;

import Pages.firstPage;
import org.testng.annotations.Test;

public class firstPageTest extends test.BaseTest {

    @Test
    public void firstPageTest() {

        firstPage.getIdValue();
        firstPage.getPageUrl();
        firstPage.getValue();
        firstPage.getname();
        firstPage.validation();

    }
}

