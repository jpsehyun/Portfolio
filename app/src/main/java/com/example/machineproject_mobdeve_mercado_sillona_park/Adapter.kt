package com.example.machineproject_mobdeve_mercado_sillona_park

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter

class Adapter(private val data: ArrayList<Course>, cur_Day: String): Adapter<ViewHolder>() {
    var day:String = cur_Day
    lateinit var view: View
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a LayoutInflater using the parent's (i.e. RecyclerView's) context

        val inflater = LayoutInflater.from(parent.context)
        // Inflate a new View given the item_layout.xml item view we created.

        if (day.equals("ALL")){
            //Try out your layout here
            view = inflater.inflate(R.layout.course_list_layout, parent, false)

            //I think the Viewholder might crash with redundant id
            //So make a separate Viewholder for new course view layout
            return ViewHolder(view, day)
        }

        else{
            view = inflater.inflate(R.layout.course_layout, parent, false)
            return ViewHolder(view, day)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(data.get(position))
    }

    override fun getItemCount(): Int {
        // This needs to be modified, so don't forget to add this in.
        return data.size
    }
}