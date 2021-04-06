package com.penghy.gymnasium.core.service.vo;

import com.penghy.gymnasium.core.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dengwei
 * @date 2020/3/2 2:50
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserVo {
    private String username;
    private String password;
    private String phone;
    private int isDel;
    private String roleName;
    private String roleCode;

    /**
     * 新密码
     */
    private String newPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public UserVo(User user){
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.phone = user.getPhone();
        this.isDel = user.getIsDel();
        this.roleName = user.getRoleDescription();
        this.roleCode = user.getRoleCode();
    }

    public static List<UserVo> UserDTOList(List<User> userList){
        List<UserVo> userDTOList = new ArrayList<>();
        for(User user : userList){
            userDTOList.add(new UserVo(user));
        }
        return userDTOList;
    }

    public void Assignment(User user){
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setPhone(this.phone);
        user.setIsDel(this.isDel);
    }

    public void Edit(User user){
        user.setPassword(this.password);
        user.setPhone(this.phone);
        user.setIsDel(this.isDel);
    }
}
