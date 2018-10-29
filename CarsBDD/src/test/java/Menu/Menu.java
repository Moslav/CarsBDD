package Menu;

import framework.BaseForm;
import framework.elements.Label;
import org.openqa.selenium.By;

public class Menu extends BaseForm {

    public Menu(By locator) {
        super(locator);
    }

    public enum MainMenu {
        CarsForSale ("buy"),
        SellYourCar ("sell"),
        ServiceRepair ("service"),
        Research ("research"),
        VideosReviews ("news");

        private String locatorMenu;
        private String commonLocatorMenu = "//nav/ul//a[contains(@data-linkname,'%s')]";

        MainMenu(String locator) {
            this.locatorMenu = locator;
        }

        public By getWebElementMenu(){
            return By.xpath(String.format(commonLocatorMenu, locatorMenu));
        }
    }

    public void navigateToMenu(MainMenu mainMenu){
        Label labelMenu = new Label(mainMenu.getWebElementMenu());
        labelMenu.clickAndWAit();
    }
}