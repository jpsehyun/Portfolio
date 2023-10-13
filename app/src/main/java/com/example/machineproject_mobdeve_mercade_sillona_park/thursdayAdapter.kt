package com.example.machineproject_mobdeve_mercade_sillona_park

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter

class thursdayAdapter(private val data: ArrayList<Course>): Adapter<thursdayViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): thursdayViewHolder {
        // Create a LayoutInflater using the parent's (i.e. RecyclerView's) context
        val inflater = LayoutInflater.from(parent.context)
        // Inflate a new View given the item_layout.xml item view we created.
        val view = inflater.inflate(R.layout.course_layout, parent, false)
        // Return a new instance of our MyViewHolder passing the View object we created
        return thursdayViewHolder(view)

    }

    override fun onBindViewHolder(holder: thursdayViewHolder, position: Int) {
        holder.bindData(data.get(position))
    }

    override fun getItemCount(): Int {
        // This needs to be modified, so don't forget to add this in.
        return data.size
    }
}