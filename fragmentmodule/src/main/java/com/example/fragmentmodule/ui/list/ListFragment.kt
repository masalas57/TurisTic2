package com.example.fragmentmodule.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragmentmodule.databinding.FragmentListBinding
import com.example.fragmentmodule.model.CartagenaItem


class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var cartagenaAdapter: CartagenaAdapter
    private var listCartagena: ArrayList<CartagenaItem> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //listViewModel.loadMockBogotaFromJson(context?.assets?.open("poicartagena.json"))

        listViewModel.getCartagenaFromServer()

        listViewModel.onCartagenaLoaded.observe(viewLifecycleOwner, { result ->
            onBogotaLoadedSubscribe(result)
        })

        bogotaAdapter = CartagenaAdapter(listCartagena, onItemClicked = { onCartagenaClicked(it) } )

        listBinding.cartagenaRecyclerView.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = cartagenaAdapter
            setHasFixedSize(false)
        }

    }

    private fun onCartagenaLoadedSubscribe(result: ArrayList<CartagenaItem>?) {
        result?.let { listCartagena ->
            bogotaAdapter.appendItems(listCartagena)
        }
    }

    private fun onBogotaClicked(cartagena: CartagenaItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(poibogota = cartagena))
    }

}