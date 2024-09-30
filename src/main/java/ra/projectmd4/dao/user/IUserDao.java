package ra.projectmd4.dao.user;

import ra.projectmd4.model.dto.request.FormLogin;
import ra.projectmd4.model.dto.response.UserInfo;
import ra.projectmd4.model.entity.User;

import java.util.List;

public interface IUserDao {
    User findByUsername(String username);
    void register(User user);
    List<User> getListUser(String keyword,int page, int pageSize);
    List<User> searchUser(String keyword);
    List<User> paginate(int page, int pageSize);
    long getTotalElements(String keyword);
}
