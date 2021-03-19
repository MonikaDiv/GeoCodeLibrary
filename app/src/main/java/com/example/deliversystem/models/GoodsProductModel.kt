package com.example.deliversystem.models

import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
class GoodsProductModel(val id:String, val remarks:String, val pickupTime:String,
                        val goodsPicture:String, val deliveryFee:String,
                        private val surcharge:String, val route: Route, val sender: Sender,
                        @get:Bindable
                        var favorite:Boolean = false  ): BaseObservable(), Parcelable {
    @IgnoredOnParcel
    var totalBill :Float
    init {
        val deliveryCharges = deliveryFee.removePrefix("$").toFloat()
        val surchargeFee = surcharge.removePrefix("$").toFloat()
        totalBill = deliveryCharges + surchargeFee
    }

    fun changeFavorite(){
        favorite = !favorite
        notifyPropertyChanged(BR.favorite)
    }
}
@Parcelize
data class Route(val start: String, val end: String) : Parcelable
@Parcelize
data class Sender(val phone: String, val name: String, val email: String) : Parcelable
