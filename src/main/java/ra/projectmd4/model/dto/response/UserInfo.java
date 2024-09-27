package ra.projectmd4.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.projectmd4.model.entity.User;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserInfo {
    private Long userId;
    private String fullName;
    private String avatar;
    private boolean status;
    private boolean role;

    public UserInfo(User user) {
        this.userId = user.getUserId();
        this.fullName = user.getFullName();
        this.avatar = user.getAvatar();
        this.status = user.isStatus();
        this.role = user.isRole();
    }
    public static UserInfo builder(User user){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userInfo.getUserId());
        return userInfo;
    }
}
