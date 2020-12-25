package com.dwivedyaakash.thememeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadMeme()
    }

    private fun loadMeme(){
        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.herokuapp.com/gimme"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
                { response ->
                    val url = response.getString("url")
                    Glide.with(this).load(url).into(findViewById(R.id.memeImageView))
                },
                {
                    Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show()
                })

        queue.add(jsonObjectRequest)
    }

    fun shareMeme(view: View) {
    }

    fun nextMeme(view: View) {
        loadMeme()
    }
}