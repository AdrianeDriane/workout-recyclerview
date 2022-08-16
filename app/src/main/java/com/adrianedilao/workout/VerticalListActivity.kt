package com.adrianedilao.workout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adrianedilao.workout.adapter.ExerciseCardAdapter
import com.adrianedilao.workout.const.Layout
import com.adrianedilao.workout.data.Datasource
import com.adrianedilao.workout.databinding.ActivityVerticalListBinding


class VerticalListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVerticalListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerticalListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myDataSet = Datasource().loadExercises()

        binding.verticalRecyclerView.adapter = ExerciseCardAdapter(
            applicationContext,
            Layout.VERTICAL,
            myDataSet
        )

        binding.verticalRecyclerView.setHasFixedSize(true)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}