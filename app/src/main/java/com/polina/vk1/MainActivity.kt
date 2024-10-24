package com.polina.vk1

import MyAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MyActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var fab: FloatingActionButton
    private val adapter = MyAdapter()
    private var list_items = ArrayList<Int>(listOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)
        fab = findViewById(R.id.fab)

        recyclerView.adapter = adapter

        fab.setOnClickListener {
            val item_count = adapter.itemCount + 1
            adapter.addItems(item_count)
            list_items.add(item_count)
        }

        if (savedInstanceState != null) {
            list_items = savedInstanceState.getIntegerArrayList("list_items") ?: list_items
            adapter.setItems(list_items)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntegerArrayList("list_items", list_items)
    }
}