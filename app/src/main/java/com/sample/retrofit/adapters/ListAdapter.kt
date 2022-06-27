package com.sample.retrofit.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.question_item.view.*

class ListAdapter(
    private val context: Context,
    private val mQuestions: List<com.sample.retrofit.model.Result>,
    private val mRowLayout: Int
) : RecyclerView.Adapter<ListAdapter.QuestionViewHolder>() {
    class QuestionViewHolder(val containerView: View) : RecyclerView.ViewHolder(containerView) {
        val title = containerView.title;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(mRowLayout, parent, false)
        return QuestionViewHolder(view)
    }

    @SuppressLint("StringFormatInvalid")
    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.title.text = mQuestions[position].joke

        holder.containerView.setOnClickListener {
            Toast.makeText(context, "Clicked on: " + holder.title.text, Toast.LENGTH_SHORT).show();
        }
    }

    override fun getItemCount(): Int {
        return mQuestions.size
    }
}




