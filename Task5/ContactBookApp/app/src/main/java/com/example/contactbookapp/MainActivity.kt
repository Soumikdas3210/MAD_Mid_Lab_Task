package com.example.contactbookapp

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    val allContacts = mutableListOf<Contact>()
    lateinit var adapter: ContactAdapter
    lateinit var listView: ListView
    lateinit var emptyView: TextView
    var currentQuery = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)
        emptyView = findViewById(R.id.emptyView)
        val searchView = findViewById<SearchView>(R.id.searchView)
        val fab = findViewById<FloatingActionButton>(R.id.fab)

        adapter = ContactAdapter(this, mutableListOf())
        listView.adapter = adapter
        updateEmptyState()

        fab.setOnClickListener { showAddContactDialog() }

        listView.setOnItemClickListener { _, _, position, _ ->
            val contact = adapter.getItem(position)!!
            Toast.makeText(
                this,
                "Name: ${contact.name}\nPhone: ${contact.phone}\nEmail: ${contact.email}",
                Toast.LENGTH_LONG
            ).show()
        }

        listView.setOnItemLongClickListener { _, _, position, _ ->
            val contact = adapter.getItem(position)!!
            AlertDialog.Builder(this)
                .setTitle("Remove Contact")
                .setMessage("Delete ${contact.name} from contacts?")
                .setPositiveButton("Delete") { _, _ ->
                    allContacts.remove(contact)
                    filterContacts(currentQuery)
                }
                .setNegativeButton("Cancel", null)
                .show()
            true
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?) = false
            override fun onQueryTextChange(newText: String?): Boolean {
                currentQuery = newText ?: ""
                filterContacts(currentQuery)
                return true
            }
        })
    }

    fun showAddContactDialog() {
        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(52, 24, 52, 16)

        val etName = EditText(this)
        etName.hint = "Full Name"

        val etPhone = EditText(this)
        etPhone.hint = "Phone Number"
        etPhone.inputType = android.text.InputType.TYPE_CLASS_PHONE

        val etEmail = EditText(this)
        etEmail.hint = "Email Address"
        etEmail.inputType = android.text.InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS

        layout.addView(etName)
        layout.addView(etPhone)
        layout.addView(etEmail)

        AlertDialog.Builder(this)
            .setTitle("New Contact")
            .setView(layout)
            .setPositiveButton("Save") { _, _ ->
                val name = etName.text.toString().trim()
                val phone = etPhone.text.toString().trim()
                val email = etEmail.text.toString().trim()
                if (name.isNotEmpty()) {
                    val initial = name.first().uppercase()
                    allContacts.add(Contact(name, phone, email, initial))
                    filterContacts(currentQuery)
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    fun filterContacts(query: String) {
        adapter.clear()
        if (query.isEmpty()) {
            adapter.addAll(allContacts)
        } else {
            val filtered = allContacts.filter { it.name.contains(query, ignoreCase = true) }
            adapter.addAll(filtered)
        }
        adapter.notifyDataSetChanged()
        updateEmptyState()
    }

    fun updateEmptyState() {
        if (adapter.count == 0) {
            listView.visibility = View.GONE
            emptyView.visibility = View.VISIBLE
        } else {
            listView.visibility = View.VISIBLE
            emptyView.visibility = View.GONE
        }
    }
}
