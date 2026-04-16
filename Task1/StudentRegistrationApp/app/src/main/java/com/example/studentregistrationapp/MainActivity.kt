package com.example.studentregistrationapp

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val inputStudentId = findViewById<EditText>(R.id.inputStudentId)
        val inputFullName = findViewById<EditText>(R.id.inputFullName)
        val inputEmail = findViewById<EditText>(R.id.inputEmail)
        val inputPassword = findViewById<EditText>(R.id.inputPassword)
        val inpAge = findViewById<EditText>(R.id.inpAge)

        val radioGrpGender = findViewById<RadioGroup>(R.id.radioGrpGender)
        val spinnerCountry = findViewById<Spinner>(R.id.spinnerCountry)

        val checkBoxFootball = findViewById<CheckBox>(R.id.checkBoxFootball)
        val checkBoxCricket = findViewById<CheckBox>(R.id.checkBoxBasketball)
        val checkBoXBasketball = findViewById<CheckBox>(R.id.checkBoxBasketball)
        val checkBoxBadminton = findViewById<CheckBox>(R.id.checkBoxBadminton)


        val btnDatePicker = findViewById<Button>(R.id.btnDatePicker)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val btnReset = findViewById<Button>(R.id.btnReset)

        val defaultDateText = "Select Date"


        val rootView = findViewById<android.view.View>(android.R.id.content)


        btnDatePicker.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                val formattedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                btnDatePicker.text = formattedDate
            }, year, month, day).show()
        }


        btnSubmit.setOnClickListener {
            val studentId = inputStudentId.text.toString().trim()
            val fullName = inputFullName.text.toString().trim()
            val email = inputEmail.text.toString().trim()
            val password = inputPassword.text.toString().trim()
            val ageStr = inpAge.text.toString().trim()
            val country = spinnerCountry.selectedItem?.toString() ?: "Unknown"
            val dob = btnDatePicker.text.toString()

            val age = ageStr.toIntOrNull() ?: 0
            val isGenderSelected = radioGrpGender.checkedRadioButtonId != -1
            val isDateSelected = dob != defaultDateText

            if (studentId.isEmpty() || fullName.isEmpty() || email.isEmpty() ||
                password.isEmpty() || ageStr.isEmpty() || !isGenderSelected || !isDateSelected) {
                Toast.makeText(this, "Please complete all required fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (age <= 0) {
                Toast.makeText(this, "Age must be greater than 0", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!email.contains("@")) {
                Toast.makeText(this, "Email must contain '@'", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedGenderBtn = findViewById<RadioButton>(radioGrpGender.checkedRadioButtonId)
            val gender = selectedGenderBtn.text.toString()


            val sportsList = mutableListOf<String>()
            if (checkBoxFootball.isChecked) sportsList.add("Football")
            if (checkBoxCricket.isChecked) sportsList.add("Cricket")
            if (checkBoXBasketball.isChecked) sportsList.add("Basketball")
            if (checkBoxBadminton.isChecked) sportsList.add("Badminton")
            val sports = if (sportsList.isNotEmpty()) sportsList.joinToString(", ") else "None"

            val summary = "ID: $studentId\nName: $fullName\nGender: $gender\nSports: $sports\nCountry: $country\nDOB: $dob"


            val snackbar = Snackbar.make(rootView, summary, Snackbar.LENGTH_SHORT)
            val textView = snackbar.view.findViewById<android.widget.TextView>(
                com.google.android.material.R.id.snackbar_text
            )
            textView.maxLines = 10
            snackbar.show()
        }


        btnReset.setOnClickListener {
            inputStudentId.text.clear()
            inputFullName.text.clear()
            inputEmail.text.clear()
            inputPassword.text.clear()
            inpAge.text.clear()

            radioGrpGender.clearCheck()
            spinnerCountry.setSelection(0)
            btnDatePicker.text = defaultDateText

            checkBoxFootball.isChecked = false
            checkBoxCricket.isChecked = false
            checkBoXBasketball.isChecked = false
            checkBoxBadminton.isChecked = false
        }
    }
}