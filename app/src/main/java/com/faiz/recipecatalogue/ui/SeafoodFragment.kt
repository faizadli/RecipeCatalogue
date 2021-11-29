package com.faiz.recipecatalogue.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.faiz.recipecatalogue.R
import com.faiz.recipecatalogue.adapter.RecipesAdapter
import com.faiz.recipecatalogue.data.DataRecipes
import com.faiz.recipecatalogue.data.Recipes
import com.faiz.recipecatalogue.databinding.FragmentSeafoodBinding

class SeafoodFragment : Fragment() {

    private var _binding: FragmentSeafoodBinding? = null

    private val binding get() = _binding!!
    private var listSeafood: ArrayList<Recipes> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentSeafoodBinding.inflate(inflater, container, false)
        initData()
        return binding.root
    }

    private fun initData() {
        resources.apply {
            val name = resources.getStringArray(R.array.name_seafood)
            val category = resources.getStringArray(R.array.category_seafood)
            val description = resources.getStringArray(R.array.description_seafood)
            val ingredients = resources.getStringArray(R.array.ingredients_seafood)
            val instruction = resources.getStringArray(R.array.instructions_seafood)
            val photo = resources.getStringArray(R.array.photo_seafood)
            val price = resources.getStringArray(R.array.price_seafood)
            val calories = resources.getStringArray(R.array.calories_seafood)
            val carbo = resources.getStringArray(R.array.carbo_seafood)
            val protein = resources.getStringArray(R.array.protein_seafood)

            for (data in protein.indices) {
                val seafood = Recipes(
                    name[data],
                    category[data],
                    description[data],
                    ingredients[data],
                    instruction[data],
                    photo[data],
                    price[data],
                    calories[data],
                    carbo[data],
                    protein[data]
                )
                listSeafood.add(seafood)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvSeafood.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 2)
            adapter = RecipesAdapter(listSeafood)
        }
    }
}