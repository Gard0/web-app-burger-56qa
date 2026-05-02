package ru.praktikum.web.tests;

import org.junit.Assert;
import org.junit.Test;

public class ConstructorSectionTest extends BaseUiTest {

    @Test
    public void shouldOpenBunsSection() {
        mainPage.open();
        mainPage.clickSaucesTab();
        mainPage.clickBunsTab();

        Assert.assertTrue("После клика вкладка 'Булки' должна стать активной", mainPage.isBunsTabActive());
    }

    @Test
    public void shouldOpenSaucesSection() {
        mainPage.open();
        mainPage.clickSaucesTab();

        Assert.assertTrue("После клика вкладка 'Соусы' должна стать активной", mainPage.isSaucesTabActive());
    }

    @Test
    public void shouldOpenFillingsSection() {
        mainPage.open();
        mainPage.clickFillingsTab();

        Assert.assertTrue("После клика вкладка 'Начинки' должна стать активной", mainPage.isFillingsTabActive());
    }
}
