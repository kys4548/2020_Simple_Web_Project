package tacos;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class Order {

    @NotBlank(message = "required")
    private String deliveryName;

    @NotBlank(message = "required")
    private String deliveryStreet;

    @NotBlank(message = "required")
    private String deliveryCity;

    @NotBlank(message = "required")
    private String deliveryState;

    @NotBlank(message = "required")
    private String deliveryZip;

    @CreditCardNumber(message = "required")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "required")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "required")
    private String ccCVV;
}
