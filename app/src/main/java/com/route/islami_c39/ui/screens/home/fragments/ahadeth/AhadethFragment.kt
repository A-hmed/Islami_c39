package com.route.islami_c39.ui.screens.home.fragments.ahadeth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.route.islami_c39.R
import com.route.islami_c39.databinding.FragmentAhadethBinding
import com.route.islami_c39.databinding.FragmentQuranBinding
import com.route.islami_c39.ui.Constants
import com.route.islami_c39.ui.model.HadethModel
import com.route.islami_c39.ui.screens.ahadeth_details.AhadethDetailsActivity
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class AhadethFragment : Fragment() {
    lateinit var binding: FragmentAhadethBinding
    var ahadeth = mutableListOf<HadethModel>()
    lateinit var ahadethAdapter: AhadethAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAhadethBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readAhadeth()
        initRecyclerView()
    }

    private fun initRecyclerView() {

        for (hadeth in ahadeth) {
            Log.e("initRecyclerView", "hadeth title : ${hadeth.title}")
        }
        ahadethAdapter = AhadethAdapter(ahadeth)
        ahadethAdapter.onHadethClick = object : AhadethAdapter.OnItemClickListener {
            override fun onItemClick(hadeth: HadethModel, index: Int) {
                val intent = Intent(activity, AhadethDetailsActivity::class.java)
                intent.putExtra(Constants.HADETH, hadeth)
                startActivity(intent)
            }

        }
        binding.ahadethRecyclerView.adapter = ahadethAdapter
    }

    private fun readAhadeth() {
        try {
            val inputStream = requireActivity().assets.open("ahadeeth.txt")
            val reader = BufferedReader(InputStreamReader(inputStream))
            val hadethFileContent = reader.readText()
            val ahadethList: List<String> = hadethFileContent.split("#")
            for (hadeth: String in ahadethList) {
                val singleHadethWithSpaces = hadeth.trim()
                val singleHadethLines: MutableList<String> =
                    singleHadethWithSpaces.split("\n").toMutableList()
                val hadethTitle = singleHadethLines[0];
                singleHadethLines.removeAt(0)
                val content = singleHadethLines.joinToString(separator = " ") {
                    return@joinToString it
                }
                ahadeth.add(HadethModel(title = hadethTitle, content = content))
                Log.e("readAhadeth", "////////////////")
            }
            inputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}