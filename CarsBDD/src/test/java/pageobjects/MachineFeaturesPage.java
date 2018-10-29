package pageobjects;

import Menu.Menu;
import framework.BaseForm;
import framework.elements.Label;
import models.Car;
import models.DataHolder;
import org.openqa.selenium.By;

public class MachineFeaturesPage extends BaseForm {
    private static By machineFeaturesPageLocator = By.xpath("//div[contains(@class, 'trim-top-section')]");
    private static By menuFormLocator = By.xpath("//nav/ul/li/a[contains(@data-linkname, 'header-news')]");
    private Label lblWithCarMake = new Label(By.xpath("//a[@data-linkname = 'bc-make']"));
    private Label lblWithModel = new Label(By.xpath("//a[@data-linkname = 'bc-model']"));
    private Label lblWithYear = new Label(By.xpath("//li/a[@data-linkname = 'bc-year']"));
    private Label lblWithEngine = new Label(By.xpath("//div[@id = 'trim-table']//div[contains(text() ,'hp')]"));
    private Label lblWithTransmission= new Label(By.xpath("//div[@id = 'trim-table']//div[contains(text() , 'speed')]"));
    private Label lblSwitchToMainPage = new Label(By.xpath("//a[@data-linkname = 'header-home']"));
    private Menu menu = new Menu(menuFormLocator);


    public MachineFeaturesPage() {
        super(machineFeaturesPageLocator);
    }

    public Menu getMenu(){
        return menu;
    }

    public void createObjectCarAndAddToList(){
        DataHolder.addValueInList(new Car(lblWithCarMake.getTextElement(), lblWithModel.getTextElement(),
                lblWithYear.getTextElement(), lblWithEngine.getTextElement(), lblWithTransmission.getTextElement()));
    }

    public void switchToMainPage(){
        lblSwitchToMainPage.clickAndWAit();
    }
}
