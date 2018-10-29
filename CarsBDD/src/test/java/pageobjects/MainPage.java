package pageobjects;

import Menu.Menu;
import framework.BaseForm;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {
    private static By menuFormLocator = By.xpath("//label[@id = 'profile_menu-avatar']");
    private static By mainPageLocator = By.xpath("//a[@id = 'navLogoLink']");
    private Menu menu = new Menu(menuFormLocator);

    public MainPage() {
        super(mainPageLocator);
    }

    public Menu getMenu() {
        return menu;
    }





}
