package com.route.islami_c39.ui.screens.ahadeth_details

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.route.islami_c39.R
import com.route.islami_c39.databinding.ActivityAhadethDetailsBinding
import com.route.islami_c39.ui.Constants
import com.route.islami_c39.ui.model.HadethModel

class AhadethDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityAhadethDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAhadethDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var hadeth = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra(Constants.HADETH, HadethModel::class.java)
        } else {
            intent.getSerializableExtra(Constants.HADETH) as HadethModel
        }
        binding.hadethNameTv.text = hadeth!!.title
        binding.hadethContentTv.text = hadeth.content

    }
}