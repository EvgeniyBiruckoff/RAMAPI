package com.example.ramapikotlin_ver_20.presentation.ListOfEpisodes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.DecelerateInterpolator
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ramapikotlin_ver_20.MainActivity
import com.example.ramapikotlin_ver_20.R
import com.example.ramapikotlin_ver_20.databinding.FragmentListOfEpisodesBinding
import com.example.ramapikotlin_ver_20.domain.models.Episode
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListOfEpisodes : Fragment() {

    private val viewModel: ListOfEpisodesViewModel by viewModels()
    private var _binding: FragmentListOfEpisodesBinding? = null
    private val binding get() = _binding!!
    private var data:ArrayList<Episode> = ArrayList()
    private var sortFlag:Boolean = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentListOfEpisodesBinding.inflate(inflater, container, false)
        val view = binding.root
        /*val fadeIn = AlphaAnimation(0f, 1f)
        fadeIn.interpolator = DecelerateInterpolator() //add this
        fadeIn.duration = 2000

        view.startAnimation(fadeIn)*/

        return view
    }


    override fun onStart() {
        super.onStart()
        binding.indeterminateBar.visibility = View.VISIBLE
        var adapter = Adapter(data)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.backButton.setOnClickListener {
            (activity as MainActivity).onBackPressed()
        }
        binding.sortBy.setOnClickListener {
            viewModel.getListOfEpisodesById(arguments?.get(getString(R.string.bundle_key_2)) as String)
            binding.indeterminateBar.visibility = View.VISIBLE
        }
        viewModel.getListOfEpisodesById(arguments?.get(getString(R.string.bundle_key_2)) as String)
        viewModel.viewModelLiveData.observe(this, Observer {
            binding.indeterminateBar.visibility = View.INVISIBLE
            if(it!=null){
            if(sortFlag){
                adapter = Adapter(it)
                binding.sortBy.text =getString(R.string.sort_by_alph)
                sortFlag = false
            }else{
                adapter = Adapter(it.sortedBy { it.name })
                binding.sortBy.text = getString(R.string.sort_by_date)
                sortFlag = true

            }

            binding.recyclerView.adapter = adapter
            }else{
                Snackbar.make(binding.root, R.string.error, Snackbar.LENGTH_INDEFINITE)
                    .setAction(R.string.again) {
                        viewModel.getListOfEpisodesById(arguments?.get(getString(R.string.bundle_key_2)) as String)
                        binding.indeterminateBar.visibility = View.VISIBLE
                    }
                    .show()
            }

        })
    }


}