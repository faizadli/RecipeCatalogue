package com.faiz.recipecatalogue.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.faiz.recipecatalogue.adapter.RecipesAdapter
import com.faiz.recipecatalogue.data.DataRecipes
import com.faiz.recipecatalogue.databinding.FragmentDessertBinding

class DessertFragment : Fragment() {

    private var _binding: FragmentDessertBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDessertBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvDessert.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 2)
            adapter = RecipesAdapter(DataRecipes.listBreakfast)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}