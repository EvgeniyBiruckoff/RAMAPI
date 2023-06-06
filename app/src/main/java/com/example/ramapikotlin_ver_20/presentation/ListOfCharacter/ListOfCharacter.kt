package com.example.ramapikotlin_ver_20.presentation.ListOfCharacter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ramapikotlin_ver_20.Adapter
import com.example.ramapikotlin_ver_20.Listener
import com.example.ramapikotlin_ver_20.MainActivity
import com.example.ramapikotlin_ver_20.R
import com.example.ramapikotlin_ver_20.databinding.FragmentListOfCharacterBinding
import com.example.ramapikotlin_ver_20.domain.models.RAMCharacter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class ListOfCharacter  : Fragment(), Listener {
    private val viewModel: ListOfCharacterViewModel by viewModels()
    private var _binding: FragmentListOfCharacterBinding? = null
    private val binding get() = _binding!!
    private val adapter = Adapter(this)
    private val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListOfCharacterBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onStart() {
        super.onStart()
        //binding.indeterminateBar.visibility = View.VISIBLE
        setupUsersList()
    }
    private fun setupUsersList(){

        adapter.addLoadStateListener {adapter.retry()}
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = adapter
        observeCharacter(adapter = adapter)

    }
    private fun observeCharacter(adapter: Adapter){
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.usersFlow.collectLatest { it->
                adapter.submitData(it)
                //binding.indeterminateBar.visibility = View.INVISIBLE


            }
        }

    }

    override fun onClick(result: RAMCharacter) {
        bundle.putInt(getString(R.string.bundle_key_1),result.id)
        (activity as MainActivity).navController.navigate(R.id.action_listOfCharacter_to_aboutCharacter, bundle)
    }


}


