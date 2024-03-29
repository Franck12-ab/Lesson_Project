package com.example.project_g02.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project_g02.R
import com.example.project_g02.models.Lesson

class LessonAdapter (
    var yourListData: List<Lesson>,
//    var functionFromMainActivity: (Int) -> Unit
) : RecyclerView.Adapter<LessonAdapter.LessonViewHolder>(){

    var onLessonClick: ((Lesson) -> Unit)? = null

    inner class LessonViewHolder(itemView: View) : RecyclerView.ViewHolder (itemView) {

    }


    // tell the function which layout file to use for each row of the recycler view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.lesson_row_layout, parent, false)
        return LessonViewHolder(view)
    }


    // how many items are in the list
    override fun getItemCount(): Int {
        return yourListData.size
    }


    // In a single row, what data goes in the <TextView>?
    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {

        // 0. Get the current employee
        val currLesson: Lesson = yourListData.get(position)


        // 1. Get the TextView from the row layout
        val ivLessonNumber = holder.itemView.findViewById<ImageView>(R.id.ivLessonNumber)
        val tvLessonName = holder.itemView.findViewById<TextView>(R.id.tvRowLessonName)
        val tvLessonLength = holder.itemView.findViewById<TextView>(R.id.tvRowLessonLength)
        val ivIsLessonCompleted = holder.itemView.findViewById<ImageView>(R.id.ivLessonCheck)


        // 2. Set its value
        tvLessonName.text = currLesson.lessonName
        tvLessonLength.text = currLesson.lessonDuration

        when(position+1) {
            1 -> ivLessonNumber.setImageResource(R.drawable.twotone_looks_one_24)
            2 -> ivLessonNumber.setImageResource(R.drawable.twotone_looks_two_24)
            3 -> ivLessonNumber.setImageResource(R.drawable.twotone_looks_3_24)
            4 -> ivLessonNumber.setImageResource(R.drawable.twotone_looks_4_24)
            5 -> ivLessonNumber.setImageResource(R.drawable.twotone_looks_5_24)
            else -> {
                print("Out of lessons")
            }
        }



        holder.itemView.setOnClickListener{
            onLessonClick?.invoke(currLesson)
        }

        if (currLesson.isCompleted) {
            ivIsLessonCompleted.visibility = View.VISIBLE
        } else {
            ivIsLessonCompleted.visibility = View.INVISIBLE
        }

    }
}