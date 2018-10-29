package pageobjects;

import framework.BaseForm;
import framework.elements.Button;
import framework.elements.ComboBox;
import framework.elements.Label;
import models.DataHolder;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class CompareCarsPage extends BaseForm {
    private static By compareCarsPageLocator = By.xpath("//div//h2[@id = 'sub-headline']");
    private Label lblAddAnotherCar = new Label(By.xpath("//div[@id = 'icon-div']"));
    private String locatorForEngine = "//cars-compare-compare-info[@header = 'Engine']//span['%s']";
    private String locatorForTransmission = "//cars-compare-compare-info[@header = 'Transmission']//span['%s']";
    private String numberOneBlock = "1";
    private String numberTwoBlock = "2";
    private Label lblForEngine;
    private Label lblForTransmission;
    private String locatorForComboBox = "//select[@id = '%s']";
    private String[] nameComboBox = {"make-dropdown", "model-dropdown", "year-dropdown"};
    private ComboBox cmbCarFillIn;
    private Button btnDone = new Button(By.xpath("//button[@data-linkname = 'add-car-select']"));
    private int secondCarIndex = 1;
    private int firstCarIndex = 0;
    private int helpInt = 0;

    public CompareCarsPage() {
        super(compareCarsPageLocator);
    }

    public ArrayList<String> getFieldSecondCar(){
        ArrayList<String> fieldSecondCar = new ArrayList<>();
        fieldSecondCar.add(DataHolder.getObjectCar(secondCarIndex).getCarMake());
        fieldSecondCar.add(DataHolder.getObjectCar(secondCarIndex).getModel());
        fieldSecondCar.add(DataHolder.getObjectCar(secondCarIndex).getYear());
        return fieldSecondCar;
    }

    public void addSecondCarToCompare(){
        lblAddAnotherCar.clickOnElement();

        for (int i = helpInt; i < nameComboBox.length; i++){
            cmbCarFillIn = new ComboBox(By.xpath(String.format(locatorForComboBox, nameComboBox[i])));
            cmbCarFillIn.findWebElementBy();
            cmbCarFillIn.chooseElementFromSelectByValue(getFieldSecondCar().get(i));
        }

        btnDone.clickOnElement();
    }

    public String getEngineOfFirstCar() {
        String result;
        lblForEngine = new Label(By.xpath(String.format(locatorForEngine, numberOneBlock)));
        lblForEngine.getTextElement();
        if(lblForEngine.getTextElement().contains(DataHolder.getObjectCar(firstCarIndex).getAvailableEngines())){
            result = DataHolder.getObjectCar(firstCarIndex).getAvailableEngines();
            return result;
        }
        return "";
    }

    public String getTransmissionOfFirstCar() {
        String result;
        lblForTransmission = new Label(By.xpath(String.format(locatorForTransmission, numberOneBlock)));
        lblForTransmission.getTextElement();
        if(lblForTransmission.getTextElement().contains(DataHolder.getObjectCar(firstCarIndex).getTransmissions())){
            result = DataHolder.getObjectCar(firstCarIndex).getTransmissions();
            return result;
        }
        return "";
    }

    public String getEngineOfSecondCar() {
        String result;
        lblForEngine = new Label(By.xpath(String.format(locatorForEngine, numberTwoBlock)));
        lblForEngine.getTextElement();
        if(lblForEngine.getTextElement().contains(DataHolder.getObjectCar(secondCarIndex).getAvailableEngines())){
            result = DataHolder.getObjectCar(secondCarIndex).getAvailableEngines();
            return result;
        }
        return "";
    }

    public String getTransmissionOfSecondCar() {
        String result;
        lblForTransmission = new Label(By.xpath(String.format(locatorForTransmission, numberTwoBlock)));
        lblForTransmission.getTextElement();
        if(lblForTransmission.getTextElement().contains(DataHolder.getObjectCar(secondCarIndex).getTransmissions())){
            result = DataHolder.getObjectCar(secondCarIndex).getTransmissions();
            return result;
        }
        return "";
    }

}
