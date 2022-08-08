import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
public class webuitest {


    @Test
    void shouldTestWebUiValidValue(){
        open("http://localhost:9999");
        SelenideElement form = $(".form");
        form.$("[data-test-id=name] input").setValue("Сергей Петров");
        form.$("[data-test-id=phone] input").setValue("+77653984367");
        form.$("[data-test-id=agreement]").click();
        form.$(".button").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void shouldTestWebUiInvalidName(){
        open("http://localhost:9999");
        SelenideElement form = $(".form");
        form.$("[data-test-id=name] input").setValue("Sergei Petrov");
        form.$(".button").click();
        form.$("[data-test-id=name]").shouldHave(Condition.cssClass("input_invalid"));
    }

    @Test
    void shouldTestWebUiInvalidPhone(){
        open("http://localhost:9999");
        SelenideElement form = $(".form");
        form.$("[data-test-id=name] input").setValue("Сергей Петров");
        form.$("[data-test-id=phone] input").setValue("+723489");
        form.$(".button").click();
        form.$("[data-test-id=phone]").shouldHave(Condition.cssClass("input_invalid"));
    }

    @Test
    void shouldTestWebUiCheckBox(){
        open("http://localhost:9999");
        SelenideElement form = $(".form");
        form.$("[data-test-id=name] input").setValue("Сергей Петров");
        form.$("[data-test-id=phone] input").setValue("+77653984367");
        form.$(".button").click();
        form.$("[data-test-id=agreement]").shouldHave(Condition.cssClass("input_invalid"));
    }
}
