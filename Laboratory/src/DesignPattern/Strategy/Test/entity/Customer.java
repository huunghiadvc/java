package entity;

public class Customer {
    private String name;
    private String email;
    private String tel;

    public Customer(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.tel = phone;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Customer : " +
                "Name = " + name + " | " +
                "Email = " + email + " | " +
                "Phone=" + tel +"\n";
    }
}
