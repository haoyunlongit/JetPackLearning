package com.example.jetpack.view.permissiton

import com.google.gson.annotations.SerializedName
data class AppPermissionResponse(
    var categoryOrder: List<String> = arrayListOf(),
    var permissionInfoList: List<AppPermissionInfo> = arrayListOf()
)
data class AppPermissionInfo(
    @SerializedName("name")
    var name: String = "",
    @SerializedName("summary")
    var summary: String = "",
    @SerializedName("icon")
    var icon: String = "",
    @SerializedName("description")
    var description: String = "",
    //0表示是默认值 1 开发者填写的
    @SerializedName("custom")
    var custom: Int = 0,
    @SerializedName("id")
    var id: Int = -1,
    @SerializedName("category")
    var category: String = "",
    // 0 基础权限 1 敏感权限
    @SerializedName("type")
    var type: Int = 0)