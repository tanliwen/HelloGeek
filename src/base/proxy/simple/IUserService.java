package base.proxy.simple;

/**
 * 用户处理接口
 */
public interface IUserService {
    /*
      用户登录
     */
    public void login(String username, String password);

    /**
     * 用户注销
     * @param uid
     */
    public void logout(String uid);
}
