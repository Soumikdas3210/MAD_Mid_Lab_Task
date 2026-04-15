package com.example.universityeventapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SpeakerAdapter(private val speakers: List<Speaker>) : RecyclerView.Adapter<SpeakerAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivPhoto: ImageView = view.findViewById(R.id.ivSpeakerPhoto)
        val tvName: TextView = view.findViewById(R.id.tvSpeakerName)
        val tvDesignation: TextView = view.findViewById(R.id.tvSpeakerDesignation)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_speaker, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val speaker = speakers[position]
        holder.tvName.text = speaker.name
        holder.tvDesignation.text = speaker.designation
        holder.ivPhoto.setBackgroundResource(speaker.photoColor)
    }

    override fun getItemCount() = speakers.size
}
