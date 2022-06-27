package com.sample.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.retrofit.adapters.ListAdapter
import com.sample.retrofit.api.JokesApi
import com.sample.retrofit.api.RetrofitHelper
import com.sample.retrofit.model.JokesList
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var mApiService: JokesApi? = null

    private var mAdapter: ListAdapter?= null;
    private var mQuestions: MutableList<com.sample.retrofit.model.Result> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mApiService = RetrofitHelper.client.create(JokesApi::class.java)

        listRecyclerView!!.layoutManager = LinearLayoutManager(this)

        mAdapter = ListAdapter(this, mQuestions, R.layout.question_item)
        listRecyclerView!!.adapter = mAdapter
        fetchJokesList()
    }

    private fun fetchJokesList() {
        val call = mApiService!!.fetchJockes("15");
        call.enqueue(object : Callback<JokesList> {

            override fun onResponse(call: Call<JokesList>, response: Response<JokesList>) {

                Log.d(TAG, "Total JokesList: " + response.body()!!.jokes!!.size)
                val questions = response.body()
                if (questions != null) {
                    mQuestions.addAll(questions.jokes!!)
                    mAdapter!!.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<JokesList>, t: Throwable) {
                Log.e(TAG, "Got error : " + t.localizedMessage)
            }
        })
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
}