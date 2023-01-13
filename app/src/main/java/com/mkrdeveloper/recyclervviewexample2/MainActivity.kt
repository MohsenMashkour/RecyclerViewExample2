package com.mkrdeveloper.recyclervviewexample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.mkrdeveloper.recyclervviewexample2.adapters.MyAdapter
import com.mkrdeveloper.recyclervviewexample2.models.ItemsDataClass
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var items: ArrayList<String>
    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: MyAdapter

    private lateinit var itemsArrayList: ArrayList<ItemsDataClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)


        itemsArrayList = arrayListOf()



        items = arrayListOf(
            "position 01",
            "position 02",
            "position 03",
            "position 04",
            "position 05",
            "position 06",
            "position 07",
            "position 08",
            "position 09",
            "position 10"
        )



        for (i in items.indices) {
            val item = ItemsDataClass(items[i])
            itemsArrayList.add(item)
        }
        myAdapter = MyAdapter(itemsArrayList)

        recyclerView.setHasFixedSize(true)


        recyclerView.adapter = myAdapter


       val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN, 0){
           override fun onMove(
               recyclerView: RecyclerView,
               source: RecyclerView.ViewHolder,
               target: RecyclerView.ViewHolder
           ): Boolean {
               val sourcePosition = source.adapterPosition
               val targetPosition = target.adapterPosition

               Collections.swap(itemsArrayList,sourcePosition,targetPosition)
               myAdapter.notifyItemMoved(sourcePosition,targetPosition)

               return true

           }

           override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
               TODO("Not yet implemented")
           }

       })
        itemTouchHelper.attachToRecyclerView(recyclerView)


       }


    }
