package com.adrianedilao.workout.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.adrianedilao.workout.R
import com.adrianedilao.workout.const.Layout
import com.adrianedilao.workout.model.Exercise

class ExerciseCardAdapter(
    private val context: Context,
    private val layout: Int,
    private val dataset: List<Exercise>
): RecyclerView.Adapter<ExerciseCardAdapter.ExerciseCardViewHolder>() {

    class ExerciseCardViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imageView: ImageView = view.findViewById(R.id.workout_image)
        val workoutNameTextView: TextView = view.findViewById(R.id.workout_name)
        val workoutTargetTextView: TextView = view.findViewById(R.id.workout_target)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseCardViewHolder {
        val adapterLayout = when(layout){
            Layout.VERTICAL -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.vertical_horizontal_list_item, parent, false)
            }
            else -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.vertical_horizontal_list_item, parent, false)
            }
        }
        return ExerciseCardViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ExerciseCardViewHolder, position: Int) {

        val workoutItem = dataset[position]
        holder.imageView.setImageResource(workoutItem.imageResourceId)
        holder.workoutNameTextView.text = context.resources.getString(workoutItem.workoutResourceId)
        holder.workoutTargetTextView.text = context.resources.getString(workoutItem.targetResourceId)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}