package com.example.machineproject_mobdeve_mercado_sillona_park

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(itemView: View, cur_Day: String, private val onDeleteClick: (Int) -> Unit, enableButton: Boolean) : RecyclerView.ViewHolder(itemView) {
    private var courseTime: TextView = itemView.findViewById(R.id.courseTimeTv)
    private var courseCode: TextView = itemView.findViewById(R.id.courseCodeTv)
    private var courseRoom: TextView = itemView.findViewById(R.id.courseRoomTv)
    private var courseSection: TextView = itemView.findViewById(R.id.courseSectionTv)
    private var deleteButton: ImageButton = itemView.findViewById(R.id.courseDelete_Btn)

    lateinit var courseDay: String
    var current_Day = cur_Day

    init{
        itemView.setOnClickListener{v: View ->
            var intentLoadNextActivity = Intent(itemView.context, UpdateViewActivity::class.java)
            intentLoadNextActivity.putExtra("code", courseCode.text.toString())
            intentLoadNextActivity.putExtra("section", courseSection.text.toString())
            intentLoadNextActivity.putExtra("room", courseRoom.text.toString())
            intentLoadNextActivity.putExtra("time", courseTime.text.toString())
            intentLoadNextActivity.putExtra("day", courseDay.toString())
            itemView.context.startActivity(intentLoadNextActivity)
        }

        if (enableButton){
        // Set click listener for the delete button
            deleteButton.setOnClickListener {
                showDeleteConfirmationDialog(adapterPosition)
            }
        }
    }

    private fun showDeleteConfirmationDialog(position: Int) {
        val context: Context = itemView.context
        val alertDialogBuilder = AlertDialog.Builder(context)

        alertDialogBuilder.setTitle("Confirm Deletion")
        alertDialogBuilder.setMessage("Are you sure you want to delete this item?")

        alertDialogBuilder.setPositiveButton("Yes") { _, _ ->
            // User clicked Yes, proceed with deletion
            Toast.makeText(context, "${courseCode.text} Deleted from DB!", Toast.LENGTH_SHORT).show()
            onDeleteClick(position)
            var db = DataBaseHandler(context)
            db.deleteOne(courseCode.text.toString())
        }

        alertDialogBuilder.setNegativeButton("No") { dialog, _ ->
            // User clicked No, do nothing
            dialog.dismiss()
        }

        val alertDialog: AlertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    fun bindData(course: Course) {
        // Bind data to the views
        courseTime.text = course.courseTime
        courseCode.text = course.courseCode
        courseRoom.text = course.courseRoom
        courseSection.text = course.courseSection
        courseDay = course.courseDay

        // Set the visibility of the itemView based on the current day
        itemView.visibility = View.VISIBLE

        if ((courseDay == current_Day) || (current_Day == "ALL")) {
            itemView.visibility = View.VISIBLE
        } else {
            itemView.visibility = View.GONE
            itemView.layoutParams = RecyclerView.LayoutParams(0, 0)
        }
    }
}