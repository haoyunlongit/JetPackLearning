package com.example.jetpack.view.permissiton

import com.example.jetpack.R

abstract class AppPermissionBaseItem {
    abstract fun getType() : ItemType
}

class HeaderItem(val appInfo: AppInfo) : AppPermissionBaseItem() {
    override fun getType() : ItemType {
        return ItemType.HEAD_ITEM
    }
}

class GroupHeaderItem(var title: String, var subTitle: String) : AppPermissionBaseItem() {
    override fun getType(): ItemType {
        return ItemType.GROUP_HEADER_ITEM
    }
}

class GroupItem(var title: String, var permissionts: ArrayList<AppPermissionInfo>) : AppPermissionBaseItem() {
    override fun getType(): ItemType {
        return ItemType.GROUP_ITEM
    }
}

class GroupBottomItem() : AppPermissionBaseItem() {
    override fun getType(): ItemType {
        return ItemType.BOTTOM_ITEM
    }
}

enum class ItemType {
    HEAD_ITEM,
    GROUP_HEADER_ITEM,
    GROUP_ITEM,
    BOTTOM_ITEM;

    fun getResource(): Int {
        return when(this) {
            HEAD_ITEM -> R.layout.permission_header_item_view
            GROUP_HEADER_ITEM -> R.layout.permission_sensitive_group_item_view
            GROUP_ITEM -> R.layout.permission_group_item_view
            BOTTOM_ITEM -> R.layout.permission_bottom_item_view
        }
    }
}