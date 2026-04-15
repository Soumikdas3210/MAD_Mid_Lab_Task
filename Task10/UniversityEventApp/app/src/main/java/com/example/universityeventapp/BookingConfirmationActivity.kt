package com.example.universityeventapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class BookingConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_confirmation)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.title = "Booking Confirmed"

        @Suppress("DEPRECATION")
        val event = intent.getSerializableExtra("event") as? Event
        val selectedSeats = intent.getIntExtra("selectedSeats", 0)
        val totalPrice = intent.getIntExtra("totalPrice", 0)
        val bookingRef = intent.getStringExtra("bookingRef") ?: "BK000000"

        findViewById<TextView>(R.id.tvBookingRef).text = "Booking ID: $bookingRef"
        findViewById<TextView>(R.id.tvConfirmEventName).text = event?.title ?: "Event"
        findViewById<TextView>(R.id.tvConfirmDate).text = "Date: ${event?.date ?: "-"}"
        findViewById<TextView>(R.id.tvConfirmTime).text = "Time: ${event?.time ?: "-"}"
        findViewById<TextView>(R.id.tvConfirmVenue).text = "Venue: ${event?.venue ?: "-"}"
        findViewById<TextView>(R.id.tvConfirmOrganizer).text = "Organizer: ${event?.organizer ?: "-"}"
        findViewById<TextView>(R.id.tvConfirmSeats).text = "Seats Booked: $selectedSeats"
        val priceText = if (totalPrice == 0) "Free" else "BDT $totalPrice"
        findViewById<TextView>(R.id.tvConfirmTotal).text = "Amount Paid: $priceText"

        findViewById<Button>(R.id.btnDone).setOnClickListener {
            finishAffinity()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
