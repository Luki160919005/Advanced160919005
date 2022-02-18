package com.example.advanced160919005

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_main.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {
    // TODO: Rename and change types of parameters
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }
    var check = 0;
    var points = 0;
    var answer = 0;
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments != null){
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text = "$playerName's Turn"
            var numX = (0..100).random();
            var numY = (0..100).random();
            answer = numX+numY;

            textEquation.text = "$numX + $numY ";




        }







        btnBack.setOnClickListener {
            var action = GameFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
        buttonAnswer.setOnClickListener {




            var myInput = textAnswer.text.toString();

            //txtTurn.text ="$answer = $myInput = $check";
            if(answer.toString() == myInput){
                points = points + 1;
            }
            else{
                check = 1;
            }

            if(check == 1) {
                val action = GameFragmentDirections.actionResult(points.toString())
                Navigation.findNavController(it).navigate(action)
            }
            var numX = (0..100).random();
            var numY = (0..100).random();

            answer = numX+numY;

            textEquation.text = "$numX + $numY ";

        }
    }

}