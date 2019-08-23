package com.abdhilabs.sampleretrofitkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.abdhilabs.sampleretrofitkotlin.api.ApiRetrofit
import com.abdhilabs.sampleretrofitkotlin.entity.Github
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = ApiRetrofit.create()
        api.getUSer("abdhilabs")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { user->
                            getData(user)
                        },
                        {error ->
                            Log.e("Error",error.message)
                        }
                )
    }

    private fun getData(user: Github?) {
        Glide.with(this)
                .load(user?.avatarUrl)
                .into(image)
        username.text = user?.name
        company.text = user?.company
    }
}
