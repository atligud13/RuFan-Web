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
    @Pattern("\\d{16}")
    public String cardNumber;
    public int expirationMonth;
    public int expirationYear;
}
