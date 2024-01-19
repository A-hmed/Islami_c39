package com.route.islami_c39.ui.screens.sura_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.route.islami_c39.R
import com.route.islami_c39.databinding.ActivitySuraDetailsBinding
import com.route.islami_c39.ui.Constants
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class SuraDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivitySuraDetailsBinding
    lateinit var suraName: String
    lateinit var fileName: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        suraName = intent.getStringExtra(Constants.SURA_NAME)!!
        fileName = intent.getStringExtra(Constants.FILE_NAME)!!
        binding.suraContentTv.text = readFileContent()
        binding.suraNameTv.text = suraName
    }
    private fun readFileContent(): String{
        var fileContent = ""
        try {
            val inputStream = assets.open(fileName)
            val reader = BufferedReader(InputStreamReader(inputStream))
             val fileLines: List<String> = reader.readLines()
             fileContent = fileLines.joinToString(separator = " ") {line->
                val index = fileLines.indexOf(line) + 1
                return@joinToString line + "{${index}}"
            }
            inputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return fileContent
    }
}