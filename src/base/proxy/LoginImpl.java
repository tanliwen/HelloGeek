package base.proxy;

public class LoginImpl implements ILogin {
    @Override
    public void doLogin(String username, String password) {
        System.out.println("login username = " + username + ", password = " + password);
    }
}
