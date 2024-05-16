
public class Item {
    private String Name;
    private String Surname;
    private String Email;
    private String Hours;

    public Item(String name, String surname, String email, String hours) {
        Name = name;
        Surname = surname;
        Email = email;
        Hours = hours;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getHours() {
        return Hours;
    }

    public void setHours(String hours) {
        Hours = hours;
    }
}
