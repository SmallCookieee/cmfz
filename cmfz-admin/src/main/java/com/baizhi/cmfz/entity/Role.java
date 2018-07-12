package com.baizhi.cmfz.entity;

/**
 * Created by zxl on 2018/7/12.
 */
public class Role {
    private String roleId;
    private String roleName;
    private String roleTag;

    public Role() {
    }

    public Role(String roleId, String roleName, String roleTag) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleTag = roleTag;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleTag='" + roleTag + '\'' +
                '}';
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleTag() {
        return roleTag;
    }

    public void setRoleTag(String roleTag) {
        this.roleTag = roleTag;
    }
}
