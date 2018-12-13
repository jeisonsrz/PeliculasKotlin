package com.example.creatic_04b1.contrainlayout

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.transition.TransitionManager
import com.example.creatic_04b1.contrainlayout.databinding.ActivityMainExpandedBinding
import com.example.creatic_04b1.contrainlayout.models.Movie
import kotlinx.android.synthetic.main.activity_main_expanded.*

class MainActivity : AppCompatActivity() {

    val setExpanded:ConstraintSet = ConstraintSet()
    val setCollapsed:ConstraintSet = ConstraintSet()

    var expanded:Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val binding:ActivityMainExpandedBinding = DataBindingUtil.setContentView(this,R.layout.activity_main_expanded)

    setExpanded.clone(root)
        setCollapsed.clone(this, R.layout.activity_main)

        val movie = Movie ("Acuaman",
            "https://heroichollywood.com/wp-content/uploads/2018/11/Aquaman_DC_Comics_Banner_Home.jpg",
            "12 de Diciembre",
            "2 Horas",
            "La mejor Peli de todas!!")

        binding.movie = movie



        btnInfo.setOnClickListener{

            TransitionManager.beginDelayedTransition(root)
            if(expanded) setCollapsed.applyTo(root)
            else setExpanded.applyTo(root)
            expanded = !expanded

        }
    }
}
