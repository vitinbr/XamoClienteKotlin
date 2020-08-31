package com.example.xamoclientekotlin.ui.pedidos

import android.view.View
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.tcqq.timelineview.R
import com.tcqq.timelineview.TimelineView
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
import eu.davidea.flexibleadapter.items.IFlexible
import eu.davidea.viewholders.FlexibleViewHolder

data class Rastreio_Item(
    val id: String,
    val title: String,
    val status: Rastreio_Item_Status
) : AbstractFlexibleItem<Rastreio_Item.ViewHolder>() {

    override fun getLayoutRes(): Int {
        return com.example.xamoclientekotlin.R.layout.card_rastreio_pedido
    }

    override fun createViewHolder(
        view: View,
        adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>
    ): ViewHolder {
        return ViewHolder(
            view,
            adapter
        )
    }

    override fun bindViewHolder(
        adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>,
        holder: ViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        holder.title.text = title
        holder.timeline.initLine(TimelineView.getTimeLineViewType(position, adapter.itemCount))
        when (status) {
            Rastreio_Item_Status.COMPLETED -> setStatus(
                holder.timeline,
                com.example.xamoclientekotlin.R.drawable.ic_check_circle_black_24dp,
                holder.status,
                com.example.xamoclientekotlin.R.string.completed
            )
            Rastreio_Item_Status.AGUARDANDO -> setStatus(
                holder.timeline,
                com.example.xamoclientekotlin.R.drawable.ic_radio_button_checked_black_24dp,
                holder.status,
                com.example.xamoclientekotlin.R.string.request_to_modify_the_contract
            )
            Rastreio_Item_Status.INACTIVE -> setStatus(
                holder.timeline,
                com.example.xamoclientekotlin.R.drawable.ic_radio_button_unchecked_black_24dp,
                holder.status,
                com.example.xamoclientekotlin.R.string.inactive
            )
        }
    }

    private fun setStatus(
        timeline: TimelineView, @DrawableRes iconRes: Int,
        statusTextView: AppCompatTextView, @StringRes statusTextRes: Int
    ) {
        val context = timeline.context
        statusTextView.text = context.getString(statusTextRes)
        timeline.marker =
            VectorDrawableUtils.getDrawable(
                context,
                iconRes,
                ThemeUtils.getThemeValue(
                    com.example.xamoclientekotlin.R.attr.colorSecondary,
                    context
                )
            )
    }

    class ViewHolder(view: View, adapter: FlexibleAdapter<*>) : FlexibleViewHolder(view, adapter) {
        var timeline: TimelineView = view.findViewById(com.example.xamoclientekotlin.R.id.timeline)
        var title: AppCompatTextView = view.findViewById(R.id.title)
        var status: AppCompatTextView = view.findViewById(com.example.xamoclientekotlin.R.id.status)
    }
}