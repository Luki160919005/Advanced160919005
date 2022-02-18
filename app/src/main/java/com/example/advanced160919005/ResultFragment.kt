package com.example.advanced160919005

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.activity_result_fragment.*
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_main.*

class ResultFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_result_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        if(arguments != null){
            val points = ResultFragmentArgs.fromBundle(requireArguments()).playerPoints
            textScore.text = "Your Score is $points"


        }

        btnBackToMainMenu.setOnClickListener {

            val action = ResultFragmentDirections.actionResultToMain()
            Navigation.findNavController(it).navigate(action)


        }






    }


}