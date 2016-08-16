package proj.user;

/**
 * Created by SCIP on 14.08.2016.
 */
public class User {
    private String name;
    private String eMail;
    private String pass;

    public User(String name, String eMail, String pass) {
        this.name = name;
        this.eMail = eMail;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
