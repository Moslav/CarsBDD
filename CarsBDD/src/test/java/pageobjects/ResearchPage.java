package pageobjects;

import framework.BaseForm;
import framework.elements.Button;
import framework.elements.ComboBox;
import framework.elements.Label;
import org.openqa.selenium.By;

import java.util.Random;

public class ResearchPage extends BaseForm {
    /** сделать
     * комбобокы с помощью
     * стринг формата */

    private static By researchPageLocator = By.xpath("//div[contains(@class, '_1jPxd')]");
    private Button btnSearch = new Button(By.xpath("//input[@value = 'Search']"));
    private Label lblSideBySide = new Label(By.xpath("//a[@data-linkname= 'compare-cars']"));
    private String locatorForComboBox = "//form//select[contains(@name, '%s')]";
    private String[] nameComboBox = {"makeId", "modelId", "year"};
    private ComboBox cmbCarFillIn;
    private int helpInt = 1;
    private int zero = 0;


    public ResearchPage() {
        super(researchPageLocator);
    }

    public void clickOnSideBySideCompare(){
        lblSideBySide.clickAndWAit();
    }

    public void getRandomIndexFromComboBoxAndFillIn() {
            for(int i = zero; i< nameComboBox.length; i++){
                cmbCarFillIn = new ComboBox(By.xpath(String.format(locatorForComboBox, nameComboBox[i])));
                cmbCarFillIn.findWebElementBy();
                int random = new Random().nextInt(cmbCarFillIn.getSizeSelect()-helpInt)+helpInt;
                cmbCarFillIn.chooseElementFromSelectByIndex(random);
            }

        btnSearch.clickAndWAit();
    }

}
