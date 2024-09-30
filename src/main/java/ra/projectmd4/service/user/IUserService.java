package ra.projectmd4.service.user;

import ra.projectmd4.model.dto.request.FormLogin;
import ra.projectmd4.model.dto.request.FormRegister;
import ra.projectmd4.model.dto.response.UserInfo;
import ra.projectmd4.model.dto.response.UserResponse;

import java.util.List;

public interface IUserService {
    UserInfo login(FormLogin request);
    void register(FormRegister request);
    List<UserResponse> getListUsers(String key, int page, int size);
    List<UserResponse> searchUsers(String search);
    List<UserResponse> paginate(int page, int size);
    long getTotalElements(String key);
}
