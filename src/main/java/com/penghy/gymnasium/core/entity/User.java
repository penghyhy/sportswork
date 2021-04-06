package com.penghy.gymnasium.core.entity;


import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author HY-001
 * @date 2020-07-06 17:38:31
 * @description
 */

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Accessors(chain = true)
public class User {
    private String id;
    private String openId;
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String phone;
    private int isDel;
    private String registerTime;
    private String roleId;
    private List<Role> roleList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

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

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public User() {
    }

    public boolean getIsDelBoolean() {
        return isDel == 0;
    }

    public String getRoleCode() {
        StringBuilder roleCode = new StringBuilder();
        for (Role role : roleList) {
            if (roleCode.length() > 0) {
                roleCode.append(",");
            }
            roleCode.append(role.getName());
        }
        return roleCode.toString();
    }

    public String getRoleDescription() {
        StringBuilder roleName = new StringBuilder();
        for (Role role : roleList) {
            if (roleName.length() > 0) {
                roleName.append(",");
            }
            roleName.append(role.getDescription());
        }
        return roleName.toString();
    }

    /**
     * 判断用户信息是否合法
     *
     * @param user 用户信息
     * @return true为合法
     */
    static public boolean checkUserInfo(User user) {
        // TODO 判断合法性
        return true;
    }
}

