package com.example.hggc

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PoliciesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PoliciesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val policy1 = view.findViewById<RelativeLayout>(R.id.pol1)
        policy1.setOnClickListener {
            // Navigate to Policy1Fragment when the button is clicked
            findNavController().navigate(R.id.action_policiesFragment_to_policy1Fragment)
        }

        val policy2 = view.findViewById<RelativeLayout>(R.id.pol2)
        policy2.setOnClickListener {
            // Navigate to Policy1Fragment when the button is clicked
            findNavController().navigate(R.id.action_policiesFragment_to_policy2Fragment)
        }

        val policy3 = view.findViewById<RelativeLayout>(R.id.pol3)
        policy3.setOnClickListener {
            // Navigate to Policy1Fragment when the button is clicked
            findNavController().navigate(R.id.action_policiesFragment_to_policy3Fragment)
        }

        val policy4 = view.findViewById<RelativeLayout>(R.id.pol4)
        policy4.setOnClickListener {
            // Navigate to Policy1Fragment when the button is clicked
            findNavController().navigate(R.id.action_policiesFragment_to_policy4Fragment)
        }

        val policy5 = view.findViewById<RelativeLayout>(R.id.pol5)
        policy5.setOnClickListener {
            // Navigate to Policy1Fragment when the button is clicked
            findNavController().navigate(R.id.action_policiesFragment_to_policy5Fragment)
        }

        val policy6 = view.findViewById<RelativeLayout>(R.id.pol6)
        policy6.setOnClickListener {
            // Navigate to Policy1Fragment when the button is clicked
            findNavController().navigate(R.id.action_policiesFragment_to_policy6Fragment)
        }

        val policy7 = view.findViewById<RelativeLayout>(R.id.pol7)
        policy7.setOnClickListener {
            // Navigate to Policy1Fragment when the button is clicked
            findNavController().navigate(R.id.action_policiesFragment_to_policy7Fragment)
        }

        val policy8 = view.findViewById<RelativeLayout>(R.id.pol8)
        policy8.setOnClickListener {
            // Navigate to Policy1Fragment when the button is clicked
            findNavController().navigate(R.id.action_policiesFragment_to_policy8Fragment)
        }

        val policy9 = view.findViewById<RelativeLayout>(R.id.pol9)
        policy9.setOnClickListener {
            // Navigate to Policy1Fragment when the button is clicked
            findNavController().navigate(R.id.action_policiesFragment_to_policy9Fragment)
        }

        val policy10 = view.findViewById<RelativeLayout>(R.id.pol10)
        policy10.setOnClickListener {
            // Navigate to Policy1Fragment when the button is clicked
            findNavController().navigate(R.id.action_policiesFragment_to_policy10Fragment)
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
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_policies, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PoliciesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) = PoliciesFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
    }
}