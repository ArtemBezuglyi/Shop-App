package ru.artbez.shopapptest.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import ru.artbez.shopapptest.adapters.RVBrandsAdapter
import ru.artbez.shopapptest.adapters.RVFlashsaleAdapter
import ru.artbez.shopapptest.adapters.RVLatestAdapter
import ru.artbez.shopapptest.databinding.FragmentPage1Binding
import ru.artbez.shopapptest.models.FlashsaleViewModel
import ru.artbez.shopapptest.models.LatestViewModel

class Page1Fragment : Fragment() {

    private var p1fBinding: FragmentPage1Binding?=null
    private val binding get() = p1fBinding!!
    lateinit var lRecyclerView: RecyclerView
    lateinit var fRecyclerView: RecyclerView
    lateinit var bRecyclerView: RecyclerView
    private val lAdapter by lazy { RVLatestAdapter() }
    private val fAdapter by lazy { RVFlashsaleAdapter() }
    private val bAdapter by lazy { RVBrandsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        p1fBinding = FragmentPage1Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        page1initial()
    }

    private fun page1initial() {
        val viewModelLatest = ViewModelProvider(this)[LatestViewModel::class.java]
        val viewModelFlashsale = ViewModelProvider(this)[FlashsaleViewModel::class.java]
        val viewModelBrands = ViewModelProvider(this)[LatestViewModel::class.java]

        lRecyclerView = binding.latestrv
        lRecyclerView.adapter = lAdapter

        fRecyclerView = binding.flashsalerv
        fRecyclerView.adapter = fAdapter

        bRecyclerView = binding.brandsrv
        bRecyclerView.adapter = bAdapter

        viewModelLatest.getLatest()
        viewModelLatest.myLatest.observe(viewLifecycleOwner) { list ->
            lAdapter.setList(list.body()!!.latest)
        }

        viewModelFlashsale.getFlashsale()
        viewModelFlashsale.myFlashsale.observe(viewLifecycleOwner) { list ->
            fAdapter.setList(list.body()!!.flash_sale)
        }

        viewModelBrands.getLatest()
        viewModelBrands.myLatest.observe(viewLifecycleOwner) { list ->
            bAdapter.setList(list.body()!!.latest)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        p1fBinding = null
    }

}