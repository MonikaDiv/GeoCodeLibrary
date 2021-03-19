package com.example.deliversystem.ui.deliverylist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.deliversystem.R
import com.example.deliversystem.databinding.FragmentDeliveryListBinding

class DeliveryListFragment : Fragment() {

    companion object {
        fun newInstance() = DeliveryListFragment()
    }

    private val viewModel: DeliveryListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        viewModel = ViewModelProvider(this).get(DeliveryListViewModel::class.java)
        val binding = DataBindingUtil.inflate<FragmentDeliveryListBinding>(inflater, R.layout.fragment_delivery_list, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.deliveryListViewModel = viewModel
        viewModel.itemSellectEvent.observe(viewLifecycleOwner, Observer {

            findNavController().navigate(R.id.action_deliveryListFragment_to_deliveryDetailsFragment)
        })
        activity?.actionBar?.show()
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        findNavController().currentDestination!!.label = "My Deliveries"
        // TODO: Use the ViewModel
    }

}