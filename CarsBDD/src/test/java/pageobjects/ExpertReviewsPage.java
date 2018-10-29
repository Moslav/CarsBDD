package pageobjects;

import framework.BaseForm;
import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class ExpertReviewsPage extends BaseForm {
    private static By expertReviewsPageLocator = By.xpath("//a[@id = 'matchmakerBanner']");
    private Label lblSwitchToMainPage = new Label(By.xpath("//a[@data-linkname = 'header-home']"));
    private Button btnShowTrim = new Button(By.xpath("//div[contains(@class, 'mmy-hero__buttons')]/a[@data-linkname = 'trim-compare']"));

    public ExpertReviewsPage() {
        super(expertReviewsPageLocator);
    }

    public void showCompareTrimResult(){
        btnShowTrim.clickAndWAit();
    }

    public boolean getVisibleElement(){
        return btnShowTrim.checkVisibleElement();
    }

    public void switchToMainPage(){
        lblSwitchToMainPage.clickAndWAit();
    }
}
