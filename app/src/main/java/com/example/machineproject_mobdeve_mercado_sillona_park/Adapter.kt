package com.example.machineproject_mobdeve_mercado_sillona_park

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val data: ArrayList<Course>, cur_Day: String): RecyclerView.Adapter<ViewHolder>() {
    var day:String = cur_Day
    lateinit var view: View

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        // Choose the layout based on the current day
        if (day == "ALL") {
            // Try out your layout here
            view = inflater.inflate(R.layout.course_list_layout, parent, false)
            // Make a separate ViewHolder for the new course view layout
            return ViewHolder(view, day, this::onItemDeleteClick)
        } else {
            view = inflater.inflate(R.layout.course_layout, parent, false)
            return ViewHolder(view, day, this::onItemDeleteClick)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    override fun getItemCount(): Int {
        // This needs to be modified, so don't forget to add this in.
        return data.size
    }

    private fun onItemDeleteClick(position: Int) {
        // Remove the item from the list
        if (position != RecyclerView.NO_POSITION) {
            data.removeAt(position)
            // Notify the adapter that the data set has changed
            notifyDataSetChanged()
        }
    }
}
