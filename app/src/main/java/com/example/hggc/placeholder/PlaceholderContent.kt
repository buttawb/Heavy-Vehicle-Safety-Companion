package com.example.hggc.placeholder

import android.os.Parcel
import android.os.Parcelable
import java.util.ArrayList
import java.util.HashMap

object PlaceholderContent {

    val ITEMS: MutableList<PlaceholderItem> = ArrayList()
    val ITEM_MAP: MutableMap<String, PlaceholderItem> = HashMap()

    init {
        // Add custom items
        addItem(createCustomItem("1", "Cell Phone Policy", "Custom Details 1"))
        addItem(createCustomItem("2", "Fatigue Policy", "Custom Details 2"))
        addItem(createCustomItem("3", "HR Policy", "Custom Details 3"))
        addItem(createCustomItem("4", "HSE Policy", "Custom Details 4"))
        addItem(createCustomItem("5", "Medical Policy", "Custom Details 5"))
        addItem(createCustomItem("6", "PPE Policy", "Custom Details 6"))
        addItem(createCustomItem("7", "Reward & Sanction Policy", "Custom Details 7"))
        addItem(createCustomItem("8", "Seat Belt Policy", "Custom Details 8"))
        addItem(createCustomItem("9", "Smoking Policy", "Custom Details 9"))
        addItem(createCustomItem("10", "Stop Work Policy", "Custom Details 10"))
    }

    private fun addItem(item: PlaceholderItem) {
        ITEMS.add(item)
        ITEM_MAP[item.id] = item
    }

    private fun createCustomItem(id: String, content: String, details: String): PlaceholderItem {
        return PlaceholderItem(id, content, details)
    }

    data class PlaceholderItem(val id: String, val content: String, val details: String) :
        Parcelable {
        override fun toString(): String = content

        // Implement the Parcelable interface methods
        override fun describeContents(): Int {
            return 0
        }

        override fun writeToParcel(dest: Parcel, flags: Int) {
            dest.writeString(id)
            dest.writeString(content)
            dest.writeString(details)
        }

        // Create a companion object for the Parcelable.Creator
        companion object CREATOR : Parcelable.Creator<PlaceholderItem> {
            override fun createFromParcel(parcel: Parcel): PlaceholderItem {
                return PlaceholderItem(
                    parcel.readString()!!,   // Read id as a String
                    parcel.readString()!!,   // Read content as a String
                    parcel.readString()!!    // Read details as a String
                )
            }

            override fun newArray(size: Int): Array<PlaceholderItem?> {
                return arrayOfNulls(size)
            }
        }

        // Parcelable constructor
        constructor(parcel: Parcel) : this(
            parcel.readString()!!,   // Read id as a String
            parcel.readString()!!,   // Read content as a String
            parcel.readString()!!    // Read details as a String
        )

    }
}