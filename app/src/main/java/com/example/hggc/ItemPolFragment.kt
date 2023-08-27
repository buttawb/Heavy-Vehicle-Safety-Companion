package com.example.hggc

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hggc.placeholder.PlaceholderContent
import com.example.hggc.MyItemRecyclerViewAdapter


/**
 * A fragment representing a list of Items.
 */
class ItemPolFragment : Fragment(), MyItemRecyclerViewAdapter.OnItemClickListener {

    private var columnCount = 1
    private lateinit var adapter: MyItemRecyclerViewAdapter // Initialize the adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_pol_list, container, false)

        // Initialize the adapter and set the click listener
        adapter = MyItemRecyclerViewAdapter(PlaceholderContent.ITEMS, this@ItemPolFragment)

        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = this@ItemPolFragment.adapter // Set the adapter here
            }
        }
        return view
    }

    // Rest of your code...

    override fun onItemClick(position: Int) {
        // Use the position to identify the clicked item
        val clickedItem = PlaceholderContent.ITEMS[position] // Access the clicked item
        // Now you can use 'clickedItem' as needed
        // For example, you can navigate to a new fragment with item details
        val fragment = PolFragment.newInstance(clickedItem) // Pass the clickedItem to the fragment
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }


    companion object {
        const val ARG_COLUMN_COUNT = "column-count"
        // ...
    }
}
