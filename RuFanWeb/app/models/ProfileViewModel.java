package models;

import is.rufan.user.domain.UserRegistration;

import java.util.Date;
import play.data.validation.Constraints.*;

public class ProfileViewModel {
    public UserRegistration user;
    // Favourite team
    public long favTeam;
    // Credit card data
    public String type;

    @Pattern(value = "^$|\\d{16}", message = "Enter 16 letter CC number without spaces")
    public String cardNumber;

    @Max(12)
    public int expirationMonth;

    @Min(2010)
    public int expirationYear;
}
