package cc.wenshixin.action;

import cc.wenshixin.entity.AdRole;
import cc.wenshixin.entity.RdType;
import cc.wenshixin.entity.User;
import cc.wenshixin.service.AdRoleService;
import cc.wenshixin.service.RdTypeService;
import cc.wenshixin.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

public class UserAction extends ActionSupport implements ModelDriven<User> {
    // 模型驱动封装
    private User user = new User();

    @Override
    public User getModel() {
        return user;
    }

    // 属性注入
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private RdTypeService rdTypeService;

    public void setRdTypeService(RdTypeService rdTypeService) {
        this.rdTypeService = rdTypeService;
    }

    private AdRoleService adRoleService;

    public void setAdRoleService(AdRoleService adRoleService) {
        this.adRoleService = adRoleService;
    }

    // 属性封装
    private File photo;
    private String photoFileName;

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }


    // 原密码
    private String oldPassword;
    // 新密码
    private String newPassword;
    // 确认新密码
    private String confirmPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    // 登录的方法
    public String login() throws IOException {
        User userExit = userService.login(user);
        HttpServletRequest request = ServletActionContext.getRequest();
        if (userExit != null) {
            if ("有效".equals(userExit.getUsStatus())) {
                // 有效情况
                request.getSession().setAttribute("loginUser", userExit);
                return "loginSuccess";
            } else if ("挂失".equals(userExit.getUsStatus())) {
                // 挂失情况
                request.setAttribute("errormsg", "账号已挂失！");
                return "loginFail";
            }
        }
        // 用户密码不匹配
        request.setAttribute("errormsg", "用户密码不匹配！");
        return "loginFail";
    }

    //  安全退出的方法
    public String loginOut() {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession(false);
        session.removeAttribute("loginUser");
        session.invalidate();
        return "loginOut";
    }

    // 转到个人信息页面
    public String toInfoPage() {
        HttpServletRequest request = ServletActionContext.getRequest();
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        User u = userService.findOne(loginUser.getUsId());
        request.setAttribute("user",u);
        return "toInfoPage";
    }

    public String toChangePasswordPage() {
        return "toChangePasswordPage";
    }

    // 修改个人密码
    public String changePassword() {
        // 从数据库中查询原密码
        String id = user.getUsId();
        System.out.println("id:"+id);
        User u = userService.findOne(id);
        String password = u.getUsPassword();
        HttpServletRequest request = ServletActionContext.getRequest();
        if(!newPassword.equals(confirmPassword)){
            request.setAttribute("errormsg", "两次输入的密码不一致！");
            return "changeFail";
        } else if(!oldPassword.equals(password)){
            request.setAttribute("errormsg", "原密码错误！");
            return "changeFail";
        }
        u.setUsPassword(newPassword);
        userService.update(u);
        return "changeSuccess";
    }


    // 转到办理借书证页面
    public String toAddPage() {
        List<RdType> rdTypeList = rdTypeService.findAll();
        List<AdRole> adRoleList = adRoleService.findAll();
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("rdTypeList", rdTypeList);
        request.setAttribute("adRoleList", adRoleList);
        return "toAddPage";
    }

    public String toAddAdminPage(){
        List<RdType> rdTypeList = rdTypeService.findAll();
        List<AdRole> adRoleList = adRoleService.findAllNotCondition();
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("rdTypeList", rdTypeList);
        request.setAttribute("adRoleList", adRoleList);
        return "toAddAdminPage";
    }

    // 添加用户的方法
    public String add() throws IOException {
        if (photo != null) {
            // 将文件转为二进制文件
            user.setUsPhoto(FileUtils.readFileToByteArray(photo));
        }
        userService.add(user);
        return "add";
    }

    // 添加管理的方法
    public String addAdmin() throws IOException {
        if (photo != null) {
            // 将文件转为二进制文件
            user.setUsPhoto(FileUtils.readFileToByteArray(photo));
        }
        userService.add(user);
        return "addAdmin";
    }

    // 查询读者用户的方法
    public String list() {
        List<User> userList = userService.findAllByCondition(0);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("userList", userList);
        return "list";
    }

    // 查询管理用户的方法
    public String listAdmin() {
        List<User> userList = userService.findAllByNotCondition(0);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("adminList", userList);
        return "listAdmin";
    }

    // 转到借书证信息修改页面
    public String toEditPage() throws IOException {
        String usId = user.getUsId();
        User u = userService.findOne(usId);
        List<RdType> rdTypeList = rdTypeService.findAll();
        List<AdRole> adRoleList = adRoleService.findAll();
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("rdTypeList", rdTypeList);
        request.setAttribute("adRoleList", adRoleList);
        request.setAttribute("user", u);
        // 将用户的头像先写入到 photo 中
       /* OutputStream out = new FileOutputStream(photo);
        out.write(u.getUsPhoto());
        out.close();*/
        return "toEditPage";
    }

    // 转到借书证信息修改页面
    public String toEditAdminPage() throws IOException {
        String usId = user.getUsId();
        User u = userService.findOne(usId);
        List<RdType> rdTypeList = rdTypeService.findAll();
        List<AdRole> adRoleList = adRoleService.findAllNotCondition();
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("rdTypeList", rdTypeList);
        request.setAttribute("adRoleList", adRoleList);
        request.setAttribute("user", u);
        return "toEditAdminPage";
    }

    // 显示图片的方法
    public String showImg() throws IOException {
        String usId = user.getUsId();
        User u = userService.findOne(usId);
        HttpServletResponse response = ServletActionContext.getResponse();
        ServletOutputStream out =  response.getOutputStream();
        // 测试图片是否正确存入数据库，经测试是正确的
        /*System.out.println(new File("").getAbsolutePath()+"//text.jpg");
        OutputStream out = new FileOutputStream(new File("").getAbsolutePath()+"//text.jpg");*/
        out.write(u.getUsPhoto());
        out.flush();
        out.close();
        return NONE;
    }


    // 删除用户的方法
    public String delete() {
        String usId = user.getUsId();
        User u = userService.findOne(usId);
        if (u != null) {
            userService.delete(u);
        }
        return "delete";
    }

    // 删除管理的方法
    public String deleteAdmin() {
        String usId = user.getUsId();
        User u = userService.findOne(usId);
        if (u != null) {
            userService.delete(u);
        }
        return "deleteAdmin";
    }

    // 修改用户的方法
    public String edit() throws IOException {
        if (photo != null) {
            // 将文件转为二进制文件
            user.setUsPhoto(FileUtils.readFileToByteArray(photo));
        }
        userService.update(user);
        return "edit";
    }

    // 修改管理的方法
    public String editAdmin() throws IOException {
        if (photo != null) {
            // 将文件转为二进制文件
            user.setUsPhoto(FileUtils.readFileToByteArray(photo));
        }
        userService.update(user);
        return "editAdmin";
    }
}
