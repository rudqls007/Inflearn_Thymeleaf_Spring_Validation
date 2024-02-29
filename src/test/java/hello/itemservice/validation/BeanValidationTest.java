package hello.itemservice.validation;

import hello.itemservice.domain.item.Item;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class BeanValidationTest {


    @Test
    void beanValidation() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Item item = new Item();
        item.setItemName(" ");
        item.setPrice(0);
        item.setQuantity(10000);

        Set<ConstraintViolation<Item>> voilations = validator.validate(item);

        for (ConstraintViolation<Item> voilation : voilations) {
            System.out.println("voilation = " + voilation);
            System.out.println("voilation.getMessage() = " + voilation.getMessage());
            
        }
    }
}
