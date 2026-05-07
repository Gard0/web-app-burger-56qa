package ru.praktikum.web.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class ConstructorSectionTest extends BaseUiTest {

    @Test
    @DisplayName("Переход в булки")
    @Description("Активация вкладки Булки после переключения раздела")
    public void shouldOpenBunsSection() {
        mainPage.open();
        mainPage.clickSaucesTab();
        mainPage.clickBunsTab();

        Assert.assertTrue("После клика вкладка Булки должна стать активной", mainPage.isBunsTabActive());
    }

    @Test
    @DisplayName("Переход в соусы")
    @Description("Активация вкладки соусы после клика по разделу")
    public void shouldOpenSaucesSection() {
        mainPage.open();
        mainPage.clickSaucesTab();

        Assert.assertTrue("После клика вкладка Соусы должна стать активной", mainPage.isSaucesTabActive());
    }

    @Test
    @DisplayName("Переход в начинки")
    @Description("Вкладка начинки активируется после клика")
    public void shouldOpenFillingsSection() {
        mainPage.open();
        mainPage.clickFillingsTab();

        Assert.assertTrue("После клика вкладка 'Начинки' должна стать активной", mainPage.isFillingsTabActive());
    }
}
