package com.example.timelineview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.xamoclientekotlin.R
import com.example.xamoclientekotlin.ui.pedidos.Rastreio_Item
import com.example.xamoclientekotlin.ui.pedidos.Rastreio_Item_Status
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.common.SmoothScrollLinearLayoutManager
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
import eu.davidea.flexibleadapter.items.IFlexible
import kotlinx.android.synthetic.main.activity_rastreio_pedido.*
import java.util.*

/**
 * @author Perry Lance
 * @since 2019-03-27 Created
 */
class Rastreio_pedido : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rastreio_pedido)
        //setSupportActionBar(toolbar)
       // supportActionBar?.setTitle(R.string.app_name)
        val adapter: FlexibleAdapter<IFlexible<*>> = FlexibleAdapter(getItems(), this, true)
        milestones_list.layoutManager = SmoothScrollLinearLayoutManager(this)
        milestones_list.adapter = adapter
        milestones_list.setHasFixedSize(true)
    }

    private fun getItems(): List<AbstractFlexibleItem<*>> {
        val items = ArrayList<AbstractFlexibleItem<*>>()
        items.add(
            Rastreio_Item(
                "1",
                "Confirmando seu pedido",
                Rastreio_Item_Status.COMPLETED
            )
        )
        items.add(
            Rastreio_Item(
                "2",
                "Em Preparo",
                Rastreio_Item_Status.COMPLETED
            )
        )
        items.add(
            Rastreio_Item(
                "3",
                "Pronto para retirar",
                Rastreio_Item_Status.AGUARDANDO
            )
        )
        items.add(
            Rastreio_Item(
                "4",
                "Saiu para Entrega",
                Rastreio_Item_Status.AGUARDANDO
            )
        )
        items.add(
            Rastreio_Item(
                "5",
                "Entregue",
                Rastreio_Item_Status.AGUARDANDO
            )
        )
        return items
    }
}