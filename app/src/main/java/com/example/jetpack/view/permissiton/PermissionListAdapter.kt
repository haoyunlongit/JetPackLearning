package com.example.jetpack.view.permissiton

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PermissionListAdapter : RecyclerView.Adapter<PermissionBaseViewHolder<AppPermissionBaseItem>>() {

    private var mItems: ArrayList<AppPermissionBaseItem> = ArrayList<AppPermissionBaseItem>()

    @Override
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PermissionBaseViewHolder<AppPermissionBaseItem> {
        return PermissionBaseViewHolder.createPermissionViewHolder(parent.context, parent, viewType) as PermissionBaseViewHolder<AppPermissionBaseItem>
    }

    @Override
    override fun onBindViewHolder(holder: PermissionBaseViewHolder<AppPermissionBaseItem>, position: Int) {
        var baseItem = mItems[position]
        holder.bindDate(baseItem)
    }

    @Override
    override fun getItemCount(): Int {
        return mItems.size
    }

    @Override
    override fun getItemViewType(position: Int): Int {
        return mItems[position].getType().ordinal
    }

    fun bindDate(items: List<AppPermissionBaseItem>) {
        mItems.clear()
        mItems.addAll(items)
    }
}