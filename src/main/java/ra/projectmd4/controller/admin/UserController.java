package ra.projectmd4.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.projectmd4.service.user.IUserService;

@Controller
@RequestMapping("/admin/user")
public class UserController {
    @Autowired
    private IUserService userService;
    // hiển thị danh sách
    @GetMapping
    public String list(@RequestParam(defaultValue = "") String keyword
            ,@RequestParam(defaultValue = "0") int page
            ,@RequestParam(defaultValue = "2") int size
            ,Model model){
        long totalElements = userService.getTotalElements(keyword);
        long nguyen = totalElements /size;
        long du  = totalElements%size;
        long totalPages = du == 0 ? nguyen : nguyen+1;
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("keyword",keyword);
        model.addAttribute("page",page);
        model.addAttribute("users",userService.getListUsers(keyword,page,size));
        return "admin/user";
//        model.addAttribute("users",userService.getListUsers());
//        return "admin/user";
//        model.addAttribute("users",userService.searchUsers(keyword));
//        model.addAttribute("keyword",keyword);
    }
//    @GetMapping("/search")
//    public String search(@RequestParam("keyword") String keyword, Model model){
//        model.addAttribute("users",userService.searchUsers(keyword));
//        model.addAttribute("keyword",keyword);
//        return "admin/user";
//    }
//    @GetMapping("/page")
//    public String page(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size, Model model){
//        // tinhs tong so trang
//        // tinhs phan nguyen
//        long totalElements = userService.getTotalElements();
//        long nguyen = totalElements /size;
//        long du  = totalElements%size;
//        long totalPages = du == 0 ? nguyen : nguyen+1;
//        model.addAttribute("totalPages",totalPages);
//        model.addAttribute("page",page);
//        model.addAttribute("users",userService.paginate(page,size));
//        return "admin/user";
//    }
}
