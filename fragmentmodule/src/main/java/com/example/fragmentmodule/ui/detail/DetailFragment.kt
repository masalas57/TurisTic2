package com.example.fragmentmodule.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.fragmentmodule.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso
import android.util.Log.d as d1


class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val detailViewModel: DetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)

        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bogota = args.poibogota

        with(detailBinding){
            nombreTextView.text = bogota.nombre
            Picasso.get().load(bogota.urlpic).into(imagenImageView)
            contenidoTextView.text = bogota.contenido
            tempTextView.text = bogota.temperatura

            mapButton.setOnClickListener {
                findNavController().navigate(DetailFragmentDirections.actionNavigationDetailToMapsFragment(posicionPunto = bogota))
            }
        }
    }

}