package com.selcannarin.rijksamsterdammuseumapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.selcannarin.rijksamsterdammuseumapp.databinding.FragmentDetailBinding
import com.selcannarin.rijksamsterdammuseumapp.util.loadUrl
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val detailViewModel: DetailViewModel by viewModels()
    val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        updateArtObjectState()
        return binding.root
    }

    private fun updateArtObjectState() {
        val objectNumberArg = args.objectNumber
        viewLifecycleOwner.lifecycleScope.launch {
            detailViewModel.getArtObjectDetail(objectNumberArg)
            detailViewModel.artObjectDetailState.collect {
                if (it.isLoading) {
                    binding.progressBar.visibility = View.VISIBLE
                } else if (it.artObjectDetail?.artObject != null) {
                    binding.progressBar.visibility = View.GONE
                    val artObjectX = it.artObjectDetail.artObject

                    with(binding) {
                        textViewLongTitle.text = "Long Title: ${artObjectX.longTitle}"
                        textViewTitle.text = artObjectX.title
                        textViewDating.text = "Dating: ${artObjectX.dating.presentingDate}"
                        textViewMaterials.text =
                            "Materials: ${artObjectX.materials.joinToString(", ")}"
                        textViewObjectTypes.text =
                            "Object Types: ${artObjectX.objectTypes.joinToString(", ")}"
                        textViewObjectCollection.text =
                            "Object Collection: ${artObjectX.objectCollection.joinToString(", ")}"
                        textViewPrincipalMaker.text =
                            "Principal Maker: ${artObjectX.principalMaker}"
                        textViewProductionPlaces.text =
                            "Production Places: ${artObjectX.productionPlaces.joinToString(", ")}"
                        textViewTechniques.text =
                            "Techniques: ${artObjectX.techniques.joinToString(", ")}"

                        artObjectX.webImage.let { imageView.loadUrl(artObjectX.webImage.url) }
                    }
                } else {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(context, "No Data Found", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }

}