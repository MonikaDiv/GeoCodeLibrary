package com.example.deliversystem.ui.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.deliversystem.R


class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view =  inflater.inflate(R.layout.fragment_splash, container, false)
        val anim = AnimationUtils.loadAnimation(context, R.anim.zoom_in)
        anim.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
                //
            }

            override fun onAnimationEnd(animation: Animation?) {
                findNavController().navigate(R.id.action_splashFragment_to_deliveryListFragment)
            }

            override fun onAnimationRepeat(animation: Animation?) {
                //
            }

        })
        view.findViewById<TextView>(R.id.txt_title).startAnimation(anim)
        return view
    }

}