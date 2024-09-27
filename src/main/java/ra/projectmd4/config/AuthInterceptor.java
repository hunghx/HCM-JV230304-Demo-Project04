package ra.projectmd4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import ra.projectmd4.model.dto.response.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       // kiem tra quyen
        UserInfo u = (UserInfo) request.getSession().getAttribute("userLogin");
        if (u==null){
            // chua co nguoi dang nhap
            response.sendRedirect("/login");
            return false;
        }
        if (!u.isRole()){
            // ko co quyen truy cap
            response.sendRedirect("/");
            return  false;
        }
        return true;
    }

}
