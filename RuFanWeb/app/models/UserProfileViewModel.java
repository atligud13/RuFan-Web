package models;

import is.rufan.user.domain.User;
import play.data.validation.Constraints.*;

public class UserProfileViewModel extends User {
    @Required(message = "Name is required")
    public String name;

    @Required(message = "Email is required")
    @Email
    public String email;

    @MinLength(value = 6, message = "Password should be at least 6 characters")
    public String password;

    @MinLength(value = 6, message = "Password should be at least 6 characters")
    public String repeatPassword;

    public int favoriteTeamId;

    public String creditCardType;

    @Pattern(value = "^$|\\d{16}", message = "Enter a 16 digit CC number without spaces")
    public String creditCardNumber;

    public int creditCardExpirationMonth;

    public int creditCardExpirationYear;

    public UserProfileViewModel() {}

    public UserProfileViewModel(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.repeatPassword = user.getPassword();
        this.favoriteTeamId = user.getFavoriteTeamId();
        this.creditCardType = user.getCreditCardType();
        this.creditCardNumber = user.getCreditCardNumber();
        this.creditCardExpirationMonth = user.getCreditCardExpirationMonth();
        this.creditCardExpirationYear = user.getCreditCardExpirationYear();
    }
}
