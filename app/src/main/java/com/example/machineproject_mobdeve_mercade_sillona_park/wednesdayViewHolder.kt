package com.example.machineproject_mobdeve_mercade_sillona_park

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class wednesdayViewHolder(itemView: View): ViewHolder(itemView) {
    private var courseTime: TextView = itemView.findViewById(R.id.courseTimeTv)
    private var courseCode: TextView = itemView.findViewById(R.id.courseCodeTv)
    private var courseRoom: TextView = itemView.findViewById(R.id.courseRoomTv)
    private var courseSection: TextView = itemView.findViewById(R.id.courseSectionTv)

    lateinit var courseDay: String
    var cur_Day: String = "Wednesday"

    fun bindData(course: Course) {

        courseTime.text = course.courseTime
        courseCode.text = course.courseCode
        courseRoom.text = course.courseRoom
        courseSection.text = course.courseSection
        courseDay = course.courseDay

        itemView.setVisibility(View.VISIBLE);

        if (courseDay.equals(cur_Day)){
            itemView.setVisibility(View.VISIBLE);
        }
        else{
            itemView.setVisibility(View.GONE);
            itemView.setLayoutParams(RecyclerView.LayoutParams(0, 0))
        }
    }


}