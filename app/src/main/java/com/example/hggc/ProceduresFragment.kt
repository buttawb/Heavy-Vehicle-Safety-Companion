package com.example.hggc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProceduresFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProceduresFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val p1 = view.findViewById<RelativeLayout>(R.id.P1)
        AnimationUtils.setCardClickAnimation(p1, R.id.action_proceduresFragment_to_procedure1Fragment)

        val p2 = view.findViewById<RelativeLayout>(R.id.P2)
        AnimationUtils.setCardClickAnimation(p2, R.id.action_proceduresFragment_to_procedure2Fragment)

        val p3 = view.findViewById<RelativeLayout>(R.id.P3)
        AnimationUtils.setCardClickAnimation(p3, R.id.action_proceduresFragment_to_procedure3Fragment)

        val p4 = view.findViewById<RelativeLayout>(R.id.P4)
        AnimationUtils.setCardClickAnimation(p4, R.id.action_proceduresFragment_to_procedure4Fragment)

        val p5 = view.findViewById<RelativeLayout>(R.id.P5)
        AnimationUtils.setCardClickAnimation(p5, R.id.action_proceduresFragment_to_procedure5Fragment)

        val p6 = view.findViewById<RelativeLayout>(R.id.P6)
        AnimationUtils.setCardClickAnimation(p6, R.id.action_proceduresFragment_to_procedure6Fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_procedures, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProceduresFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProceduresFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}