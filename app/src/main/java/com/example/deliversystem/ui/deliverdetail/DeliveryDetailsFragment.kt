package com.example.deliversystem.ui.deliverdetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.deliversystem.R
import com.example.deliversystem.databinding.FragmentDeliveryDetailsBinding
import com.example.deliversystem.ui.deliverylist.DeliveryListViewModel

class DeliveryDetailsFragment : Fragment() {

    private val viewModel: DeliveryListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        viewModel = ViewModelProvider(this).get(DeliveryDetailsViewModel::class.java)
        val binding = DataBindingUtil.inflate<FragmentDeliveryDetailsBinding>(inflater,R.layout.fragment_delivery_details, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
//        args.productItem.also { binding.itemProduct = it }
        viewModel.sellectedProductModel.also { binding.itemProduct = it }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(DeliveryDetailsViewModel::class.java)
        // TODO: Use the ViewModel

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        Navigation.findNavController(view).currentDestination!!.label = "Delivery Details"
        activity?.actionBar?.setTitle("Delivery Details")
    }

}