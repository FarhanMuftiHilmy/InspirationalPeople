package com.dicoding.picodiploma.inspirationalpeople

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_row_people.*


class MainActivity : AppCompatActivity() {
    private lateinit var rvPeople: RecyclerView // inisiasi recycle view yang sudah dibuat
    private var list: ArrayList<People> = arrayListOf() //panggil data dari kelas PeopleData



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvPeople = findViewById(R.id.rv_people) // inisiasi recycle view yang sudah dibuat
        rvPeople.setHasFixedSize(true) // inisiasi recycle view yang sudah dibuat
        list.addAll(PeopleData.listData) //panggil data dari kelas PeopleData
        showRecyclerList() //panggil data dari kelas PeopleData


    }
    private fun showSelectedPeople(people: People) {
        val pindahIntent = Intent(this@MainActivity, DetailActivity::class.java)
        pindahIntent.putExtra("extra_photo",people.photo)
        pindahIntent.putExtra("extra_name",people.name)
        pindahIntent.putExtra("extra_detail",people.detail)
        pindahIntent.putExtra("extra_quote",people.quote)
        pindahIntent.putExtra("extra_info",people.info)
        startActivity(pindahIntent)

        Toast.makeText(this, "Membuka " + people.name, Toast.LENGTH_SHORT).show()
    }
    //panggil data dari kelas PeopleData
    //-----------------------------------
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_about, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun showRecyclerList() {
        rvPeople.layoutManager = LinearLayoutManager(this)
        val listPeopleAdapter = ListPeopleAdapter(list)
        rvPeople.adapter = listPeopleAdapter
    //----------------------------------
        listPeopleAdapter.setOnItemClickCallback(object : ListPeopleAdapter.OnItemClickCallback {

            override fun onItemClicked(data: People) {
                showSelectedPeople(data)

            }
        })
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.aboutMe -> {
                val pindahIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(pindahIntent)
            }
        }
    }






}
