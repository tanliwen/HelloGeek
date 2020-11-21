package base.proxy;

public class LogoutImpl implements ILogout {
    @Override
    public void logout(String username, String password) {
        System.out.println("logout: username = " + username + ", password = " + password);
    }
}
