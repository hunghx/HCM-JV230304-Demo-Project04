package ra.projectmd4.dao.user;

import ra.projectmd4.model.dto.request.FormLogin;
import ra.projectmd4.model.dto.response.UserInfo;
import ra.projectmd4.model.entity.User;

public interface IUserDao {
    User findByUsername(String username);
    void register(User user);
}
