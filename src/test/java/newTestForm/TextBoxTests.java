package newTestForm;
import com.github.javafaker.Faker;
import newTestForm.steps.RegistrationStep;
import newTestForm.testBase.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TextBoxTests extends TestBase {

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String mail = faker.internet().emailAddress();
    String numberPhone = faker.numerify("##########");
    String address = faker.address().country() + " " +
            faker.address().cityName() + " " +
            faker.address().buildingNumber();
    String subject = "Eng";

    @Test
    void fillFormTest() {
        new RegistrationStep()
                .openRegistrationPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(mail)
                .setUserMale()
                .setUserPhoneNumber(numberPhone)
                .setBirthDate()
                .setSubject(subject)
                .setHobbies("Sports", "Reading", "Music")
//                .setFile()
                .setUserAddress(address)
                .setStateAndCity()
                .pressSubmit()

                .checkModalIsVisible()

                .checkFieldFromResultPracticeForm("Student Name", firstName + " " + lastName)
                .checkFieldFromResultPracticeForm("Student Email", mail)
                .checkFieldFromResultPracticeForm("Mobile", numberPhone)
                .checkFieldFromResultPracticeForm("Gender", "Male")
                .checkFieldFromResultPracticeForm("Subjects", subject)
                .checkFieldFromResultPracticeForm("Date of Birth", "07 March,1996")
                .checkFieldFromResultPracticeForm("Hobbies", "Sports, Reading, Music")
//                .checkFieldFromResultPracticeForm("Picture", "1.png")
                .checkFieldFromResultPracticeForm("Address", address)
                .checkFieldFromResultPracticeForm("State and City", "NCR Delhi");

    }
}
