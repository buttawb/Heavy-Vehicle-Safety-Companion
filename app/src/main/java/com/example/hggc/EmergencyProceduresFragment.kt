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
 * Use the [EmergencyProceduresFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EmergencyProceduresFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val Ep1 = view.findViewById<RelativeLayout>(R.id.EP1)
        Ep1.setOnClickListener {
            // Navigate to Policy1Fragment when the button is clicked
            findNavController().navigate(R.id.action_emergencyProceduresFragment_to_emergProc1Fragment)
        }

        val Ep2 = view.findViewById<RelativeLayout>(R.id.EP2)
        Ep2.setOnClickListener {
            // Navigate to Policy1Fragment when the button is clicked
            findNavController().navigate(R.id.action_emergencyProceduresFragment_to_emergProc2Fragment)
        }

        val Ep3 = view.findViewById<RelativeLayout>(R.id.EP3)
        Ep3.setOnClickListener {
            // Navigate to Policy1Fragment when the button is clicked
            findNavController().navigate(R.id.action_emergencyProceduresFragment_to_emergProc3Fragment)
        }

        val Ep4 = view.findViewById<RelativeLayout>(R.id.EP4)
        Ep4.setOnClickListener {
            // Navigate to Policy1Fragment when the button is clicked
            findNavController().navigate(R.id.action_emergencyProceduresFragment_to_emergProc4Fragment)
        }

        val Ep5 = view.findViewById<RelativeLayout>(R.id.EP5)
        Ep5.setOnClickListener {
            // Navigate to Policy1Fragment when the button is clicked
            findNavController().navigate(R.id.action_emergencyProceduresFragment_to_emergProc5Fragment)
        }

        val Ep6 = view.findViewById<RelativeLayout>(R.id.EP6)
        Ep6.setOnClickListener {
            // Navigate to Policy1Fragment when the button is clicked
            findNavController().navigate(R.id.action_emergencyProceduresFragment_to_emergProc6Fragment)
        }

        val Ep7 = view.findViewById<RelativeLayout>(R.id.EP7)
        Ep7.setOnClickListener {
            // Navigate to Policy1Fragment when the button is clicked
            findNavController().navigate(R.id.action_emergencyProceduresFragment_to_emergProc7Fragment)
        }

        val Ep8 = view.findViewById<RelativeLayout>(R.id.EP8)
        Ep8.setOnClickListener {
            // Navigate to Policy1Fragment when the button is clicked
            findNavController().navigate(R.id.action_emergencyProceduresFragment_to_emergProc8Fragment)
        }
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
        return inflater.inflate(R.layout.fragment_emergency_procedures, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EmergencyProceduresFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EmergencyProceduresFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}