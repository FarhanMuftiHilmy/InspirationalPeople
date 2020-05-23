package com.dicoding.picodiploma.inspirationalpeople

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.ImageView
import android.widget.ListView
import android.widget.ScrollView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_row_people.*
import org.w3c.dom.Text

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val navBarTitle = intent.getStringExtra(EXTRA_NAME)
        supportActionBar?.title = navBarTitle

        val tvSetName = findViewById<TextView>(R.id.tv_item_name)
        val imgSetPhoto = findViewById<ImageView>(R.id.img_item_photo)
        val tvDetail = findViewById<TextView>(R.id.tv_item_detail)
        val tvQuote = findViewById<TextView>(R.id.tv_item_quote)
        val tvInfo = findViewById<TextView>(R.id.tv_item_info)

        val tName  = intent.getStringExtra(EXTRA_NAME)
        val tImg = intent.getIntExtra(EXTRA_PHOTO,0)
        val tDetail = intent.getStringExtra(EXTRA_DETAIL)
        val tQuote = intent.getStringExtra(EXTRA_QUOTE)
        val tInfo = intent.getStringExtra(EXTRA_INFO)

        tvSetName.text = tName
        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgSetPhoto)
        tvInfo.text = tInfo
        tvQuote.text = tQuote
        tvDetail.text = tDetail


    }
    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_QUOTE = "extra_quote"
        const val EXTRA_INFO = "extra_info"
    }





}
