package com.github.metnyov.party.presentation.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.metnyov.party.R
import com.github.metnyov.party.presentation.common.EqualsDiffCallback
import com.github.metnyov.party.presentation.view.extensions.load
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.view_item_list.view.*

class ListItemAdapter<T : Any>(
    private val itemClickListener: (T) -> Unit,
    private val getItemImageUrl: (T) -> String,
    private val getItemName: (T) -> String
) : ListAdapter<T, ListItemAdapter.ViewHolder>(EqualsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_item_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        with(holder.containerView) {
            ivItemPhoto.load(getItemImageUrl(item))
            tvItemName.text = getItemName(item)
            setOnClickListener {
                itemClickListener(item)
            }
        }
    }

    class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {

        init {
            containerView.layoutParams = RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT
            )
        }
    }
}