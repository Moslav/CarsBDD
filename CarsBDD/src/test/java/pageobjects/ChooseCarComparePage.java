package pageobjects;

import framework.BaseForm;
import framework.elements.Button;
import framework.elements.ComboBox;
import models.Car;
import models.DataHolder;
import org.openqa.selenium.By;

import java.io.BufferedReader;
import java.util.ArrayList;

public class ChooseCarComparePage extends BaseForm {
    private static By chooseCarComparePageLocator = By.xpath("//div[@id = 'researchCompareRoot']");
    private Button btnStartComparingNow = new Button(By.xpath("//button[@data-linkname = 'Compare-Now']"));
    private String locatorForCombobox = "//div[contains(@class, 'dropdown')]//select[@name = '%s']";
    private String[] nameComboBox = {"makeDropdown", "modelDropdown", "yearDropdown"};
    private ComboBox cmbCarFillIn;
    private int helpInt = 0;
    private int firstObject = 0;

    public ChooseCarComparePage() {
        super(chooseCarComparePageLocator);
    }

    public ArrayList<String> getFieldFirstCar(){
        ArrayList<String> fieldFirstCar = new ArrayList<>();
        fieldFirstCar.add(DataHolder.getObjectCar(firstObject).getCarMake());
        fieldFirstCar.add(DataHolder.getObjectCar(firstObject).getModel());
        fieldFirstCar.add(DataHolder.getObjectCar(firstObject).getYear());
        return fieldFirstCar;
    }

    public void fillFieldForComparingCarAndClick(){
        getFieldFirstCar();
        for (int i = helpInt; i < nameComboBox.length; i++){
            cmbCarFillIn = new ComboBox(By.xpath(String.format(locatorForCombobox, nameComboBox[i])));
            cmbCarFillIn.findWebElementBy();
            cmbCarFillIn.chooseElementFromSelectByValue(getFieldFirstCar().get(i));
        }
        btnStartComparingNow.clickAndWAit();
    }


}
