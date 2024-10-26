import android.os.Bundle
import android.view.View
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.navigation.findNavController
import com.example.hggc.R

object AnimationUtils {
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

                    // Use the card's parent fragment to find the NavController
                    val navController = card.findNavController()
                    navController.navigate(destinationId, bundle, navOptions)

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
}
