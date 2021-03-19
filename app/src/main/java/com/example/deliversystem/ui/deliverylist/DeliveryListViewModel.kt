package com.example.deliversystem.ui.deliverylist

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliversystem.models.GoodsProductModel
import com.example.deliversystem.network.DeliverApi
import com.example.deliversystem.util.SingleLiveEvent
import kotlinx.coroutines.launch

class DeliveryListViewModel : ViewModel(), OnItemSelectListener {
        private val productList = ObservableArrayList<GoodsProductModel>()
        val adapter = GoodsDeliveryAdapter(this, productList)

        var sellectedProductModel:GoodsProductModel? = null

        val itemSellectEvent = SingleLiveEvent<GoodsProductModel>()

        init {
            callDeliveryApi()
        }


        private fun callDeliveryApi(){
                viewModelScope.launch {
                        try {
                                val list = DeliverApi.deliveryOrderApiSerive.getOrders()
                                if(list != null && list.isNotEmpty()){
                                        productList.clear()
                                        productList.addAll(list)
                                        adapter.notifyDataSetChanged()
                                }
                        }catch (e:Exception){
                                Log.d("TAG", e.message.toString())
                        }
                }
        }

        override fun onItemSelect(productModel: GoodsProductModel) {
                itemSellectEvent.value = productModel
                sellectedProductModel = productModel
        }


}