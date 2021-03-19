package com.example.deliversystem.ui.deliverylist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.example.deliversystem.R
import com.example.deliversystem.databinding.ItemDeliveryBinding
import com.example.deliversystem.models.GoodsProductModel

class GoodsDeliveryAdapter(private  val itemSelectListener: OnItemSelectListener, private val list: ObservableArrayList<GoodsProductModel>) : RecyclerView.Adapter<GoodsDeliveryAdapter.DeliveryViewHolder>() {

    class DeliveryViewHolder(val itemBinding: ItemDeliveryBinding): RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeliveryViewHolder {
        val binding = DataBindingUtil.inflate<ItemDeliveryBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_delivery, parent, false
        )
        binding.itemSellectListener = itemSelectListener
        return DeliveryViewHolder(binding)

    }

    override fun onBindViewHolder(holder: DeliveryViewHolder, position: Int) {
            holder.itemBinding.itemProduct = list[position]
    }

    override fun getItemCount() = list.count()

}

interface OnItemSelectListener{

    fun onItemSelect(productModel: GoodsProductModel)
}




