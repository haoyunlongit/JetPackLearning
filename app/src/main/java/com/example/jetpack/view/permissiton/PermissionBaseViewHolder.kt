package com.example.jetpack.view.permissiton

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpack.R

abstract class PermissionBaseViewHolder<T : AppPermissionBaseItem>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var mInflater: LayoutInflater = LayoutInflater.from(itemView.context)
    val mContext: Context = itemView.context

    companion object {

        fun createPermissionViewHolder(context: Context, parent: ViewGroup, viewType: Int): PermissionBaseViewHolder<AppPermissionBaseItem> {
            var type : ItemType = ItemType.values()[viewType]
            val contentView = LayoutInflater.from(context).inflate(type.getResource(), parent, false)
            return when(viewType) {
                ItemType.HEAD_ITEM.ordinal -> HeaderHolder(contentView) as PermissionBaseViewHolder<AppPermissionBaseItem>
                ItemType.GROUP_HEADER_ITEM.ordinal -> GroupHeaderHolder(contentView) as PermissionBaseViewHolder<AppPermissionBaseItem>
                ItemType.BOTTOM_ITEM.ordinal -> GroupBottomHolder(contentView) as PermissionBaseViewHolder<AppPermissionBaseItem>
                else -> GroupHolder(contentView) as PermissionBaseViewHolder<AppPermissionBaseItem>
            }
        }
    }

    abstract fun bindDate(permissionItem: T)
}

class HeaderHolder(itemView: View) : PermissionBaseViewHolder<HeaderItem>(itemView) {
    private val imageView: ImageView = itemView.findViewById<ImageView>(R.id.app_icon)
    private val title: TextView = itemView.findViewById<TextView>(R.id.app_title)
    private val versionLabel: TextView = itemView.findViewById<TextView>(R.id.app_version)

    override fun bindDate(permissionItem: HeaderItem) {
        permissionItem.appInfo?.run {
//            val url = UriUtils.connect(HostConfig.getImageHost(), iconUrl)
//
//            imageView.setBorderColorAndWidth(mContext.resources.getColor(R.color.app_detail_default_image_color), ResourceUtils.dp2px(1f))
//            GlideUtil.load(mContext, imageView, url, defaultIcon, defaultIcon, ResourceUtils.dp2px(14.54f))
//            title.text = displayName
//            versionLabel.text = mContext.getString(R.string.version_label) + versionName
        }
    }
}

class GroupHeaderHolder(itemView: View) : PermissionBaseViewHolder<GroupHeaderItem>(itemView) {
    private val titleView: TextView = itemView.findViewById(R.id.group_title_id)
    private val subTitleView: TextView = itemView.findViewById(R.id.group_subtitle_id)
    override fun bindDate(permissionItem: GroupHeaderItem) {
        titleView.text = permissionItem.title
        subTitleView.text = permissionItem.subTitle
    }
}

class GroupHolder(itemView: View) : PermissionBaseViewHolder<GroupItem>(itemView) {
    var titleView: TextView? = null

    override fun bindDate(groupItem: GroupItem) {

        (itemView as ViewGroup).removeAllViews()
        if(groupItem.title.isNotEmpty()) {
            if (titleView == null) {
                titleView = mInflater.inflate(R.layout.permission_group_sub_title, itemView as ViewGroup, false) as TextView
            }
            titleView?.run {
                text = groupItem.title
                itemView.addView(this)
            }
        }
        groupItem.permissionts.forEach {
            mInflater.inflate(R.layout.permission_group_sub_view, itemView as ViewGroup, false)?.run {

                findViewById<ImageView>(R.id.group_subview_icon)?.run {

                }

                findViewById<View>(R.id.permission_developer_report_icon)?.run {
                    visibility = if (it.custom == 1) {
                        View.VISIBLE
                    } else {
                        View.GONE
                    }
                }

                findViewById<TextView>(R.id.group_subview_title_id)?.run {
                    text = it.summary
                }

                findViewById<TextView>(R.id.group_subview_subtitle_id)?.run {
                    text = it.description
                }

                itemView.addView(this)
            }
        }
    }
}

class GroupBottomHolder(itemView: View) : PermissionBaseViewHolder<GroupBottomItem>(itemView) {

    init {
        itemView.setOnClickListener {
            startPrivacyDescActivity(mContext)
        }
    }

    private fun startPrivacyDescActivity(context: Context) {

    }

    override fun bindDate(permissionItem: GroupBottomItem) {
        //do nothing
    }
}