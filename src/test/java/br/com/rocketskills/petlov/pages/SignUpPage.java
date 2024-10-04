package br.com.rocketskills.petlov.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage {

    private By nameInput = By.cssSelector("input[placeholder='Nome do ponto de doação']");
    private By emailInput = By.cssSelector("input[placeholder='E-mail']");
    private By cepInput = By.cssSelector("input[name='cep']");
    private By cepButton = By.cssSelector("input[value='Buscar CEP']");
    private By numberInput = By.cssSelector("input[name='addressNumber']");
    private By detailsInput = By.cssSelector("input[name='addressDetails']");

    private By petsOption(String petType) {
        return By.xpath("//span[text()=\"" + petType + "\"]/..");
    }

    private By registerButton = By.className("button-register");
    private By successMessage = By.cssSelector("#success-page p ");
    private By errorMessage = By.cssSelector(".alert-error");

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void fillForm(String nome, String email, String cep, String numero, String complemento, String pets) {
        driver.findElement(nameInput).sendKeys(nome);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(cepInput).sendKeys(cep);
        driver.findElement(cepButton).click();
        driver.findElement(numberInput).sendKeys(numero);
        driver.findElement(detailsInput).sendKeys(complemento);
        driver.findElement(petsOption(pets)).click();
    }

    public void submitForm() {
        driver.findElement(registerButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
