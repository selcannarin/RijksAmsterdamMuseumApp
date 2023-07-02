package com.selcannarin.rijksamsterdammuseumapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.selcannarin.rijksamsterdammuseumapp.adapter.ArtObjectAdapter
import com.selcannarin.rijksamsterdammuseumapp.data.model.artobject.ArtObject
import com.selcannarin.rijksamsterdammuseumapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        updateArtObjectState()
        return binding.root
    }

    private fun updateArtObjectState() {
        viewLifecycleOwner.lifecycleScope.launch {
            homeViewModel.getArtObject()
            homeViewModel.artObjectState.collect {
                if (it.isLoading) {
                    binding.progressBar.visibility = View.VISIBLE
                } else if (it.artObjectList?.artObjects?.isNotEmpty() == true) {
                    binding.progressBar.visibility = View.GONE
                    initRecycler(it.artObjectList.artObjects)
                } else {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(context, "No Data Found", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun initRecycler(list: List<ArtObject>) {
        binding.rvArtobjects.apply {
            adapter = ArtObjectAdapter(list, ArtObjectAdapter.OnClickListener {
                val action = HomeFragmentDirections.homeToDetail(it)
                findNavController().navigate(action)
            })
        }

    }
}

