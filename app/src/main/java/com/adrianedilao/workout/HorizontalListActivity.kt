package com.adrianedilao.workout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adrianedilao.workout.adapter.ExerciseCardAdapter
import com.adrianedilao.workout.const.Layout
import com.adrianedilao.workout.data.Datasource
import com.adrianedilao.workout.databinding.ActivityHorizontalListBinding
import com.adrianedilao.workout.databinding.ActivityMainBinding


class HorizontalListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHorizontalListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHorizontalListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myDataSet = Datasource().loadExercises()

        binding.horizontalRecyclerView.adapter = ExerciseCardAdapter(
            applicationContext,
            Layout.HORIZONTAL,
            myDataSet
        )

        binding.horizontalRecyclerView.setHasFixedSize(true)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}