package com.example.universityeventapp

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.CollapsingToolbarLayout
import java.text.SimpleDateFormat
import java.util.Locale

class EventDetailActivity : AppCompatActivity() {
    private var countDownTimer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_detail)

        @Suppress("DEPRECATION")
        val event = intent.getSerializableExtra("event") as Event

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val collapsingToolbar = findViewById<CollapsingToolbarLayout>(R.id.collapsingToolbar)
        collapsingToolbar.title = event.title

        val ivHeader = findViewById<ImageView>(R.id.ivEventHeader)
        ivHeader.setBackgroundResource(event.imageRes)
        ivHeader.transitionName = "event_banner_${event.id}"

        findViewById<TextView>(R.id.tvDetailTitle).text = event.title
        findViewById<TextView>(R.id.tvDetailDate).text = "Date: ${event.date}"
        findViewById<TextView>(R.id.tvDetailTime).text = "Time: ${event.time}"
        findViewById<TextView>(R.id.tvDetailVenue).text = "Venue: ${event.venue}"
        findViewById<TextView>(R.id.tvDetailOrganizer).text = "Organizer: ${event.organizer}"
        findViewById<TextView>(R.id.tvDetailDescription).text = event.description

        startCountdown(event.date, event.time)

        val photos = listOf(
            R.color.banner_bg1,
            R.color.banner_bg2,
            R.color.banner_bg3,
            R.color.banner_bg5,
            R.color.banner_bg6
        )
        val recyclerPhotos = findViewById<RecyclerView>(R.id.recyclerPhotos)
        recyclerPhotos.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerPhotos.adapter = PhotoAdapter(photos)

        val speakers = SampleData.speakersMap[event.id] ?: listOf(
            Speaker("Prof. ${event.organizer}", "Event Coordinator", R.color.banner_bg1)
        )
        val recyclerSpeakers = findViewById<RecyclerView>(R.id.recyclerSpeakers)
        recyclerSpeakers.layoutManager = LinearLayoutManager(this)
        recyclerSpeakers.adapter = SpeakerAdapter(speakers)

        findViewById<Button>(R.id.btnRegister).setOnClickListener {
            val intent = Intent(this, SeatBookingActivity::class.java)
            intent.putExtra("event", event)
            startActivity(intent)
        }
    }

    private fun startCountdown(date: String, time: String) {
        val tvCountdown = findViewById<TextView>(R.id.tvCountdown)
        val sdf = SimpleDateFormat("MMM d, yyyy hh:mm a", Locale.ENGLISH)
        val eventDate = try {
            sdf.parse("$date $time")
        } catch (e: Exception) {
            null
        }
        if (eventDate == null) {
            tvCountdown.text = "Event date unavailable"
            return
        }
        val diff = eventDate.time - System.currentTimeMillis()
        if (diff <= 0) {
            tvCountdown.text = "Event has ended"
            return
        }
        countDownTimer = object : CountDownTimer(diff, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val days = millisUntilFinished / (1000 * 60 * 60 * 24)
                val hours = (millisUntilFinished % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60)
                val minutes = (millisUntilFinished % (1000 * 60 * 60)) / (1000 * 60)
                val seconds = (millisUntilFinished % (1000 * 60)) / 1000
                tvCountdown.text = "Starts in: ${days}d ${String.format("%02d:%02d:%02d", hours, minutes, seconds)}"
            }
            override fun onFinish() {
                tvCountdown.text = "Event is live now!"
            }
        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        countDownTimer?.cancel()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
