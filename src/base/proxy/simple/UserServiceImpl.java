package base.proxy.simple;

public class UserServiceImpl implements IUserService {
    @Override
    public void login(String username, String password) {
        System.out.println("do: login username = " + username + ", password = " + password);
    }

    @Override
    public void logout(String uid) {
        System.out.println("do: logout uid = " + uid);
    }
}
