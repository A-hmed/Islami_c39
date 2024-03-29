package com.route.islami_c39.ui.screens.home.fragments.quran

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.route.islami_c39.databinding.FragmentQuranBinding
import com.route.islami_c39.ui.Constants
import com.route.islami_c39.ui.screens.home.fragments.quran.adapters.SuraNamesAdapter
import com.route.islami_c39.ui.screens.sura_details.SuraDetailsActivity

class QuranFragment : Fragment() {
    lateinit var binding: FragmentQuranBinding
    lateinit var surasAdapter: SuraNamesAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuranBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        surasAdapter = SuraNamesAdapter(Constants.SURAS_NAMES_LIST)
        surasAdapter.onSuraClick = object : SuraNamesAdapter.OnItemClickListener{
            override fun onItemClick(suraName: String, index: Int) {
                val intent = Intent(activity, SuraDetailsActivity::class.java)
                intent.putExtra(Constants.FILE_NAME, "${index + 1}.txt")
                intent.putExtra(Constants.SURA_NAME, suraName)
                startActivity(intent)
            }

        }
        binding.suraNamesRecyclerView.adapter = surasAdapter
    }

}