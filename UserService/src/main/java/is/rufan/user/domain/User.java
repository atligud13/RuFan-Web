package is.rufan.user.domain;

public class User
{
  protected int id;
  protected String name;
  protected String username;
  protected String email;
  protected String password;
  protected int favoriteTeamId;
  protected String creditCardNumber;
  protected String creditCardType;
  protected int creditCardExpirationYear;
  protected int creditCardExpirationMonth;

  public User()
  {
  }

  public User(int id, String name, String username, String email, String password)
  {
    this.id = id;
    this.name = name;
    this.username = username;
    this.email = email;
    this.password = password;
  }

  public User(String name, String username, String email, String password)
  {
    this.name = name;
    this.username = username;
    this.email = email;
    this.password = password;
  }

  public User(int id, String name, String username, String email, String password, int favoriteTeamId, String creditCardNumber, String creditCardType, int creditCardExpirationMonth, int creditCardExpirationYear)
  {
    this.id = id;
    this.name = name;
    this.username = username;
    this.email = email;
    this.password = password;
    this.favoriteTeamId = favoriteTeamId;
    this.creditCardExpirationMonth = creditCardExpirationMonth;
    this.creditCardExpirationYear = creditCardExpirationYear;
    this.creditCardNumber = creditCardNumber;
    this.creditCardType = creditCardType;
  }

  public int getId()
  {
    return id;
  }


  public void setId(int id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public int getFavoriteTeamId() {
    return favoriteTeamId;
  }

  public void setFavoriteTeamId(int favoriteTeamId) {
    this.favoriteTeamId = favoriteTeamId;
  }

  public String getCreditCardNumber() {
    return creditCardNumber;
  }

  public void setCreditCardNumber(String creditCardNumber) {
    this.creditCardNumber = creditCardNumber;
  }

  public String getCreditCardType() {
    return creditCardType;
  }

  public void setCreditCardType(String creditCardType) {
    this.creditCardType = creditCardType;
  }

  public int getCreditCardExpirationYear() {
    return creditCardExpirationYear;
  }

  public void setCreditCardExpirationYear(int creditCardExpirationYear) {
    this.creditCardExpirationYear = creditCardExpirationYear;
  }

  public int getCreditCardExpirationMonth() {
    return creditCardExpirationMonth;
  }

  public void setCreditCardExpirationMonth(int creditCardExpirationMonth) {
    this.creditCardExpirationMonth = creditCardExpirationMonth;
  }

  @Override
  public String toString()
  {
    return "username: " + username;
  }
}
