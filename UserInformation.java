package tris.list;

/**
 * Created by Dell on 12/1/2017.
 */

public class UserInformation {
    private String name;
    private String email;
    private String mobile;
    private String address;
    private String password;

    public UserInformation(String name, String email, String address, String mobile, String password)
    {
        this.name = name;
        this.email = email;
        this.address = address;
        this.mobile = mobile;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
