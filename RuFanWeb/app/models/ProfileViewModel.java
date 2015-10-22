package models;

import is.rufan.user.domain.UserRegistration;

import java.util.Date;

public class ProfileViewModel {
    public UserRegistration user;
    // Favourite team
    public long favTeam;
    // Credit card data
    public String type;
    public String cardNumber;
    public Date expires;
}
