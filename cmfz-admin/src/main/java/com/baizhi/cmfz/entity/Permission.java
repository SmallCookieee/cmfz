package com.baizhi.cmfz.entity;

/**
 * Created by zxl on 2018/7/12.
 */
public class Permission {
    private String permissionId;
    private String resourceName;
    private String resourceTag;
    private String resourcePath;
    private String permissionTag;

    public Permission() {
    }

    public Permission(String permissionId, String resourceName, String resourceTag, String resourcePath, String permissionTag) {
        this.permissionId = permissionId;
        this.resourceName = resourceName;
        this.resourceTag = resourceTag;
        this.resourcePath = resourcePath;
        this.permissionTag = permissionTag;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permissionId='" + permissionId + '\'' +
                ", resourceName='" + resourceName + '\'' +
                ", resourceTag='" + resourceTag + '\'' +
                ", resourcePath='" + resourcePath + '\'' +
                ", permissionTag='" + permissionTag + '\'' +
                '}';
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceTag() {
        return resourceTag;
    }

    public void setResourceTag(String resourceTag) {
        this.resourceTag = resourceTag;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String getPermissionTag() {
        return permissionTag;
    }

    public void setPermissionTag(String permissionTag) {
        this.permissionTag = permissionTag;
    }
}
