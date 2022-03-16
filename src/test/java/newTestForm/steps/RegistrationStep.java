package newTestForm.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import newTestForm.components.Calendar;
import newTestForm.components.StateAndCity;
import newTestForm.pages.RegistrationPage;
import org.junit.jupiter.api.DisplayName;

import java.io.File;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.open;

@DisplayName("demoqa.com tests")
@Severity(SeverityLevel.CRITICAL)
public class RegistrationStep extends RegistrationPage {

    public Calendar calendar = new Calendar();
    public StateAndCity stateAndCity = new StateAndCity();

    @Step("Открываем сайт с формой для заполнения")
    public RegistrationStep openRegistrationPage() {
        open("https://demoqa.com/automation-practice-form");
        return this;
    }

    @Step("Вводим имя")
    public RegistrationStep setFirstName(String value) {
        firstName.setValue(value);
        return this;
    }

    @Step("Вводим фамилию")
    public RegistrationStep setLastName(String value) {
        lastname.setValue(value);
        return this;
    }

    @Step("Вводим электронную почту")
    public RegistrationStep setUserEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    @Step("Вводим номер телефона")
    public RegistrationStep setUserPhoneNumber(String value) {
        userNumberPhone.setValue(value);
        return this;
    }

    @Step("Выбираем пол")
    public RegistrationStep setUserMale() {
        userMale.click();
        return this;
    }

    @Step("Вводим дату рождения")
    public RegistrationStep setBirthDate() {
        calendar.setDate();
        return this;
    }

    @Step("Выбираем учебные предметы")
    public RegistrationStep setSubject(String value) {
        userSubject.setValue(value).pressEnter();
        return this;
    }

    @Step("Выбираем хобби")
    public RegistrationStep setHobbies(String... hobbies) {
        for (int i = 0; i < hobbies.length; i++) {
            if (hobbies[i].equals("Sports")) userHobbiesSport.click();
            else if (hobbies[i].equals("Reading")) userHobbiesReading.click();
            else if (hobbies[i].equals("Music")) userHobbiesMusic.click();
        }
        return this;
    }

//    @Step("Загружаем файл из ресурсов")
//    public RegistrationStep setFile() {
//        userFile.uploadFile(new File("src/test/resources/img/1.png"));
//        return this;
//    }

    @Step("Вводим адрес")
    public RegistrationStep setUserAddress(String value) {
        userAddress.setValue(value).scrollTo();
        return this;
    }

    @Step("Вводим город и штат проживания")
    public RegistrationStep setStateAndCity() {
        stateAndCity.setStateAndCity();
        return this;
    }

    @Step("Нажимаем на кнопку 'отправить' ")
    public RegistrationStep pressSubmit() {
        buttonSubmit.click();
        return this;
    }

    @Step("Проверяем вдидимость заполненной формы")
    public RegistrationStep checkModalIsVisible() {
        modal.shouldHave(Condition.visible);
        return this;
    }

    @Step("Проверяем поля с результатами формы")
    public RegistrationStep checkFieldFromResultPracticeForm(String label, String value) {
        check.$(byText(label)).parent().shouldHave(text(value));
        return this;
    }
}
