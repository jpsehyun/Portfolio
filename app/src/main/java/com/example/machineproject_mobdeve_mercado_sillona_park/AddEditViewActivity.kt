package com.example.machineproject_mobdeve_mercado_sillona_park

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddEditViewActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_edit_view)

        var confirmBtn: Button = findViewById(R.id.add_Confirm_Btn)
        var backBtn: Button = findViewById(R.id.add_Back_Btn)
        var removeBtn: Button = findViewById(R.id.add_Remove_Btn)

        var codeEtv: EditText = findViewById(R.id.add_Code_Etv)
        var sectionEtv: EditText = findViewById(R.id.add_Section_Etv)
        var timeEtv: EditText = findViewById(R.id.add_Time_Etv)
        var roomEtv: EditText = findViewById(R.id.add_Room_Etv)
        var dayEtv: EditText = findViewById(R.id.add_Day_Etv)

        var context= this
        var db = DataBaseHandler(context)

        confirmBtn.setOnClickListener({
            if (codeEtv.text.toString().length > 0 && sectionEtv.text.toString().length > 0 && timeEtv.text.toString().length > 0 && roomEtv.text.toString().length > 0 && dayEtv.text.toString().length > 0){
                var course = Course(codeEtv.text.toString(), sectionEtv.text.toString(), roomEtv.text.toString(), timeEtv.text.toString(), dayEtv.text.toString())
                db.insertData(course)

                Toast.makeText(context, "Added to DB", Toast.LENGTH_SHORT).show()
            }
            else
                Toast.makeText(context, "Some of the input fields are blank!", Toast.LENGTH_SHORT).show()
        })

        backBtn.setOnClickListener({
            val intentLoadNextActivity = Intent(this, CourseViewActivity::class.java)
            startActivity(intentLoadNextActivity)
        })

        removeBtn.setOnClickListener({
            db.deleteData()
            Toast.makeText(context, "All data removed!", Toast.LENGTH_SHORT).show()

        })

    }
}