package bd.edu.seu.finalproject.dto;

public class Registrationdto {
private String email;
private String password;
    private String comformpassword;

    public Registrationdto() {

    }
    public Registrationdto(String email, String password, String comformpassword) {
        this.email = email;
        this.password = password;
        this.comformpassword = comformpassword;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getComformpassword() {
        return comformpassword;
    }

    public void setComformpassword(String comformpassword) {
        this.comformpassword = comformpassword;
    }
}
