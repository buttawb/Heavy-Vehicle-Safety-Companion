package com.example.hggc.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.hggc.IntroFragment
import com.example.hggc.R
import com.example.hggc.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Find your CardViews by their IDs.
        val card1 = binding.introduction
        val card2 = binding.driver
        val card3 = binding.policies
        val card4 = binding.procedures
        val card5 = binding.emergProc
        val card6 = binding.training
        val card7 = binding.workForm
        val card8 = binding.rewards
        val card9 = binding.penalties
        val card10 = binding.videos
        val card11 = binding.restarea
        val card12 = binding.map

        card1.setOnClickListener {
            findNavController().navigate(R.id.action_nav_menu_to_introFragment)
        }

        card2.setOnClickListener {
            findNavController().navigate(R.id.action_nav_menu_to_driverFragment)
        }
        card3.setOnClickListener {
            findNavController().navigate(R.id.action_nav_menu_to_policiesFragment)
        }

        card4.setOnClickListener {
            findNavController().navigate(R.id.action_nav_menu_to_proceduresFragment)
        }

        card5.setOnClickListener {
            findNavController().navigate(R.id.action_nav_menu_to_emergencyProceduresFragment)
        }

        card6.setOnClickListener {
            findNavController().navigate(R.id.action_nav_menu_to_trainingFragment)
        }

//        card7.setOnClickListener {
//            findNavController().navigate(R.id.action_nav_menu_to_workFormFragment)
//        }

        card7.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pdfFileName", "handbook.pdf")

            findNavController().navigate(R.id.action_nav_menu_to_readerFragment, bundle)

        }

        card8.setOnClickListener {
            findNavController().navigate(R.id.action_nav_menu_to_rewardsAndPenaltiesFragment)
        }

        card9.setOnClickListener {
            findNavController().navigate(R.id.action_nav_menu_to_workFormFragment)
        }

        card10.setOnClickListener {
            findNavController().navigate(R.id.action_nav_menu_to_videosFragment)
        }

        card11.setOnClickListener {
            findNavController().navigate(R.id.action_nav_menu_to_restArea)
        }

        card12.setOnClickListener {
            findNavController().navigate(R.id.action_nav_menu_to_journeyPlanFragment)
        }
// Add similar listeners for other cards


        // ...

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}