package br.com.rocketskills.petlov;

import br.com.rocketskills.petlov.pages.SignUpPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Duration;


class Cadastro {

    WebDriver driver;
    SignUpPage signUpPage;

    @BeforeEach
    void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        signUpPage = new SignUpPage(driver);
    }

    @AfterEach
    void finish() {
        driver.quit();
    }

    @Test
    @DisplayName("Deve poder cadastrar um ponto de doação")
    void createPoint() {
        signUpPage.openUrl("https://petlov.vercel.app/signup");

        signUpPage.fillForm("Estação pet", "rafayahoo@gmail.com", "60761510", "10000", "apartamento", "Cachorros");
        signUpPage.submitForm();

        String expectedMessage = "Seu ponto de doação foi adicionado com sucesso. Juntos, podemos criar um mundo onde todos os animais recebam o amor e cuidado que merecem.";
        assertEquals(expectedMessage, signUpPage.getSuccessMessage(), "Verificando a mensagem de sucesso.");
    }

    @Test
    @DisplayName("Não deve cadastrar com email inválido")
    void emailIncorreto() {
        signUpPage.openUrl("https://petlov.vercel.app/signup");

        signUpPage.fillForm("Lar dos Peludos", "atendimento&lardospeludos.com.br", "60761510", "10000", "apartamento", "Gatos");
        signUpPage.submitForm();

        String expectedErrorMessage = "Informe um email válido";
        assertEquals(expectedErrorMessage, signUpPage.getErrorMessage(), "Verificando a mensagem de erro.");
    }
}