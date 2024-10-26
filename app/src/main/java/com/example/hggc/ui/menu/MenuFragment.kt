package com.example.hggc.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
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

        fun setCardClickAnimation(card: View, destinationId: Int, bundle: Bundle? = null) {
            card.setOnClickListener {
                it.animate()
                    .scaleX(0.9f)
                    .scaleY(0.9f)
                    .alpha(0.8f)
                    .setDuration(150)
                    .setInterpolator(AccelerateDecelerateInterpolator())
                    .withEndAction {
                        val navOptions = NavOptions.Builder()
                            .setEnterAnim(R.anim.slide_in_right)  // Use custom animation for entering
                            .setExitAnim(R.anim.slide_out_left)   // Use custom animation for exiting
                            .setPopEnterAnim(R.anim.slide_in_left) // Animation for going back
                            .setPopExitAnim(R.anim.slide_out_right) // Animation for going back
                            .build()

                        findNavController().navigate(destinationId, bundle, navOptions)

                        // Reset animation after navigation
                        it.animate()
                            .scaleX(1f)
                            .scaleY(1f)
                            .alpha(1f)
                            .setDuration(150)
                            .setInterpolator(AccelerateDecelerateInterpolator())
                            .start()
                    }
                    .start()
            }
        }

        // Set up animated navigation for each card
        setCardClickAnimation(card1, R.id.action_nav_menu_to_introFragment)
        setCardClickAnimation(card2, R.id.action_nav_menu_to_driverFragment)
        setCardClickAnimation(card3, R.id.action_nav_menu_to_policiesFragment)
        setCardClickAnimation(card4, R.id.action_nav_menu_to_proceduresFragment)
        setCardClickAnimation(card5, R.id.action_nav_menu_to_emergencyProceduresFragment)
        setCardClickAnimation(card6, R.id.action_nav_menu_to_trainingFragment)

        val pdfBundle = Bundle().apply {
            putString("pdfFileName", "handbook.pdf")
        }
        setCardClickAnimation(card7, R.id.action_nav_menu_to_readerFragment, pdfBundle)
        setCardClickAnimation(card8, R.id.action_nav_menu_to_rewardsAndPenaltiesFragment)
        setCardClickAnimation(card9, R.id.action_nav_menu_to_workFormFragment)
        setCardClickAnimation(card10, R.id.action_nav_menu_to_videosFragment)
        setCardClickAnimation(card11, R.id.action_nav_menu_to_restArea)
        setCardClickAnimation(card12, R.id.action_nav_menu_to_journeyPlanFragment)


        // ...

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}