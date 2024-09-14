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
 * Use the [JourneyPlanListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class JourneyPlanListFragment : Fragment() {
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_journey_plan_list, container, false)
//
//        val ra1 = view.findViewById<RelativeLayout>(R.id.ra1)
//        val ra2 = view.findViewById<RelativeLayout>(R.id.ra2)
//
//
//        ra1.setOnClickListener {
//            val bundle = Bundle()
//            bundle.putString("pdfFileName", "ra.pdf")
//
//            findNavController().navigate(R.id.action_restArea_to_readerFragment, bundle)
//
//        }
//        ra2.setOnClickListener {
//            val bundle = Bundle()
//            bundle.putString("pdfFileName", "lbs.pdf")
//
//            findNavController().navigate(R.id.action_restArea_to_readerFragment, bundle)
//
//        }
        val pdfFileNames = arrayOf("aafs.pdf", "afs.pdf", "ahmfs.pdf", "akfs.pdf", "alafs.pdf", "amps.pdf", "ap.pdf","aps.pdf",
            "araheem.pdf" , "arss.pdf", "ass.pdf", "ats.pdf", "ayfs.pdf", "bfs.pdf","bg.pdf", "bmss.pdf","bvfs.pdf", "ca.pdf",
            "cfs.pdf", "cg.pdf", "cngs.pdf", "dfs.pdf", "efs.pdf", "exfs.pdf", "fss.pdf", "fts.pdf", "gwss.pdf", "hbfs.pdf",
            "hsfs.pdf" , "hsss.pdf", "jfs.pdf" , "jp.pdf", "jss.pdf", "kemari.pdf", "kfs.pdf", "kps.pdf", "ksfs.pdf",
            "lfs.pdf", "ma.pdf", "madfs.pdf", "makkaa.pdf", "malfs.pdf","mfs.pdf","mmfs.pdf", "mp.pdf", "msmf.pdf",
            "mss.pdf", "nbfs.pdf", "nfs.pdf", "northfs.pdf", "pfs.pdf", "qss.pdf","r2p.pdf", "rajss.pdf","rmfs.pdf","rss.pdf",
            "sabfs.pdf", "saifp.pdf", "salsafs.pdf", "salss.pdf", "sanafs.pdf", "sayara.pdf", "sfs.pdf", "sg.pdf", "shfs.pdf",
            "shujafs.pdf", "smss.pdf", "sp.pdf", "sss.pdf", "subaa.pdf", "sunfs.pdf", "tss.pdf", "yb.pdf", "yss.pdf"

        )
        val raIds = arrayOf(
            R.id.rs1, R.id.rs2, R.id.rs3, R.id.rs4, R.id.rs5, R.id.rs6, R.id.rs7, R.id.rs8, R.id.rs9, R.id.rs10,
            R.id.rs11, R.id.rs12, R.id.rs13, R.id.rs14, R.id.rs15, R.id.rs16, R.id.rs17, R.id.rs18, R.id.rs19, R.id.rs20,
            R.id.rs21, R.id.rs22, R.id.rs23, R.id.rs24, R.id.rs25, R.id.rs26, R.id.rs27, R.id.rs28, R.id.rs29, R.id.rs30,
            R.id.rs31, R.id.rs32, R.id.rs33, R.id.rs34, R.id.rs35, R.id.rs36, R.id.rs37, R.id.rs38, R.id.rs39, R.id.rs40,
            R.id.rs41, R.id.rs42, R.id.rs43, R.id.rs44, R.id.rs45, R.id.rs46, R.id.rs47, R.id.rs48, R.id.rs49, R.id.rs50,
            R.id.rs51, R.id.rs52, R.id.rs53, R.id.rs54, R.id.rs55, R.id.rs56, R.id.rs57, R.id.rs58, R.id.rs59, R.id.rs60,
            R.id.rs61, R.id.rs62, R.id.rs63, R.id.rs64, R.id.rs65, R.id.rs66, R.id.rs67, R.id.rs68, R.id.rs69, R.id.rs70,
            R.id.rs71, R.id.rs72, R.id.rs73, R.id.rs74
        )

        for (i in raIds.indices) {
            view.findViewById<RelativeLayout>(raIds[i]).setOnClickListener {
                val bundle = Bundle()
                bundle.putString("pdfFileName", pdfFileNames[i])
                findNavController().navigate(R.id.action_journeyPlanListFragment_to_readerFragment, bundle)
            }
        }
        return view
    }




    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment JourneyPlanListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            JourneyPlanListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}