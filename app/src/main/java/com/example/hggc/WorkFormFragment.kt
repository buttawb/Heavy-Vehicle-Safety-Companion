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
 * Use the [WorkFormFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WorkFormFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val wf1 = view.findViewById<RelativeLayout>(R.id.wf1)
        val wf2 = view.findViewById<RelativeLayout>(R.id.wf3)
        val wf3 = view.findViewById<RelativeLayout>(R.id.wf4)
        val wf4 = view.findViewById<RelativeLayout>(R.id.wf5)
        val wf5 = view.findViewById<RelativeLayout>(R.id.wf6)

        wf1.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "stl.pdf")

            findNavController().navigate(R.id.action_workFormFragment_to_readerFragment, bundle)

        }
        wf2.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "trip_log.pdf")

            findNavController().navigate(R.id.action_workFormFragment_to_readerFragment, bundle)

        }
        wf3.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "ddc.pdf")

            findNavController().navigate(R.id.action_workFormFragment_to_readerFragment, bundle)

        }
        wf4.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "nmpi.pdf")

            findNavController().navigate(R.id.action_workFormFragment_to_readerFragment, bundle)

        }
        wf5.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "vts.pdf")

            findNavController().navigate(R.id.action_workFormFragment_to_readerFragment, bundle)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_work_form, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment WorkFormFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WorkFormFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}