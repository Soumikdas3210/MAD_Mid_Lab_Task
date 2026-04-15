package com.example.contactbookapp

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ContactAdapter(context: Context, contacts: MutableList<Contact>) :
    ArrayAdapter<Contact>(context, 0, contacts) {

    val letterColorMap = mapOf(
        'A' to "#E53935", 'B' to "#D81B60", 'C' to "#8E24AA", 'D' to "#5E35B1",
        'E' to "#3949AB", 'F' to "#1E88E5", 'G' to "#039BE5", 'H' to "#00ACC1",
        'I' to "#00897B", 'J' to "#43A047", 'K' to "#7CB342", 'L' to "#C0CA33",
        'M' to "#FFB300", 'N' to "#FB8C00", 'O' to "#F4511E", 'P' to "#6D4C41",
        'Q' to "#757575", 'R' to "#546E7A", 'S' to "#E53935", 'T' to "#D81B60",
        'U' to "#8E24AA", 'V' to "#3949AB", 'W' to "#1E88E5", 'X' to "#00897B",
        'Y' to "#43A047", 'Z' to "#FB8C00"
    )

    class ViewHolder {
        lateinit var tvAvatar: TextView
        lateinit var tvName: TextView
        lateinit var tvPhone: TextView
        lateinit var ivCall: ImageView
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val holder: ViewHolder
        val view: View
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false)
            holder = ViewHolder()
            holder.tvAvatar = view.findViewById(R.id.tvAvatar)
            holder.tvName = view.findViewById(R.id.tvName)
            holder.tvPhone = view.findViewById(R.id.tvPhone)
            holder.ivCall = view.findViewById(R.id.ivCall)
            view.tag = holder
        } else {
            view = convertView
            holder = convertView.tag as ViewHolder
        }
        val contact = getItem(position)!!
        holder.tvAvatar.text = contact.initial
        holder.tvName.text = contact.name
        holder.tvPhone.text = contact.phone
        val colorHex = letterColorMap[contact.initial.uppercase().firstOrNull()] ?: "#546E7A"
        val shape = GradientDrawable()
        shape.shape = GradientDrawable.OVAL
        shape.setColor(Color.parseColor(colorHex))
        holder.tvAvatar.background = shape
        return view
    }
}
