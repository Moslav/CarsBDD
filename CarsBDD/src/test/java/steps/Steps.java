package steps;

import Menu.Menu;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.DataHolder;
import org.testng.Assert;
import pageobjects.*;

public class Steps {
    private final int firstCar = 0;
    private final int iteration = 2;
    private final int zeroPoint = 0;
    MainPage mainPage;
    ResearchPage researchPage;
    ChooseCarComparePage chooseCarComparePage;
    CompareCarsPage compareCarsPage;

    @Given("^Site is opened$")
    public void siteIsOpened() {
        mainPage = new MainPage();
    }

    @When("^Add machine for comparison$")
    public void addMachineForComparison() {
          int b = zeroPoint;
          while (b<iteration) {
                  mainPage.getMenu().navigateToMenu(Menu.MainMenu.Research);
                  ResearchPage researchPage = new ResearchPage();
                  researchPage.getRandomIndexFromComboBoxAndFillIn();
                  ExpertReviewsPage expertReviewsPage = new ExpertReviewsPage();
                  if (expertReviewsPage.getVisibleElement()) {
                      expertReviewsPage.showCompareTrimResult();
                      MachineFeaturesPage machineFeaturesPage = new MachineFeaturesPage();
                      machineFeaturesPage.createObjectCarAndAddToList();
                      machineFeaturesPage.switchToMainPage();
                      b++;
                  }
          }
    }

    @When("^Go to the Research page$")
    public void goToTheResearchPage() {
        mainPage.getMenu().navigateToMenu(Menu.MainMenu.Research);
        researchPage = new ResearchPage();
    }

    @And("^Click on the Side-by-Side Comparisons section$")
    public void clickOnTheSideBySideComparisonsSection() {
        researchPage.clickOnSideBySideCompare();
        chooseCarComparePage = new ChooseCarComparePage();
    }

    @And("^Select the characteristics of the first car$")
    public void selectTheCharacteristicsOfTheFirstCar() {
        chooseCarComparePage.fillFieldForComparingCarAndClick();
        compareCarsPage = new CompareCarsPage();
    }

    @And("^Add a second machine for comparison$")
    public void addASecondMachineForComparison() {
        compareCarsPage.addSecondCarToCompare();
    }

    @Then("^The characteristics of the car on the page correspond to those obtained earlier$")
    public void theCharacteristicsOfTheCarOnThePageCorrespondToThoseObtainedEarlier() {
        Assert.assertEquals(DataHolder.getObjectCar(firstCar).getTransmissions(), compareCarsPage.getTransmissionOfFirstCar());
        Assert.assertEquals(DataHolder.getObjectCar(firstCar).getAvailableEngines(), compareCarsPage.getEngineOfFirstCar());
    }
}
