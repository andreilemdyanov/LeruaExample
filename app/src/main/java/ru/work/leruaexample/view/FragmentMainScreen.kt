package ru.work.leruaexample.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.work.leruaexample.*
import ru.work.leruaexample.data.category.CategoriesAdapter
import ru.work.leruaexample.data.category.CategoryElement
import ru.work.leruaexample.data.item.Item
import ru.work.leruaexample.data.category.LinearSpacingCategoryItemDecoration
import ru.work.leruaexample.data.item.ItemsAdapter
import ru.work.leruaexample.data.item.LinearSpacingItemDecoration
import ru.work.leruaexample.databinding.FragmentMainScreenBinding


class FragmentMainScreen : Fragment(R.layout.fragment_main_screen) {
    lateinit var categoriesAdapter: CategoriesAdapter
    lateinit var earlySeenAdapter: ItemsAdapter
    lateinit var limitedOfferAdapter: ItemsAdapter
    lateinit var bestPriceAdapter: ItemsAdapter
    private val binding by viewBinding(FragmentMainScreenBinding::bind)
    private var categories = mutableListOf<CategoryElement>()
    private var earlySeenList = mutableListOf<Item>()
    private var limitedOfferList = mutableListOf<Item>()
    private var bestPriceList = mutableListOf<Item>()

    init {
        categories.addAll(
            listOf(
                CategoryElement.Header(0, "Каталог", R.drawable.ic_baseline_list_24),
                CategoryElement.Category(1, "Сад", R.drawable.bush),
                CategoryElement.Category(2, "Освещение", R.drawable.lamp),
                CategoryElement.Category(2, "Инструменты", R.drawable.harp),
                CategoryElement.Category(3, "Стройматериалы", R.drawable.brick),
            )
        )

        earlySeenList.addAll(
            listOf(
                Item(0, "413 ₽/шт.", "Штукатурка гипсовая Волма Слой 30 кг", R.drawable.volma),
                Item(1, "143 ₽/шт.", "Пескобетон Axton 30 кг", R.drawable.peskobeton),
                Item(2, "2383 ₽/шт.", "Тачка садовая одноколесная 200 кг/90 л", R.drawable.telega),
                Item(
                    3,
                    "930,60 ₽/кор.",
                    "Ламинат Artens «Тангай» 33 класс толщина 8 мм",
                    R.drawable.artens_1
                ),
                Item(
                    4,
                    "899,21 ₽/кор.",
                    "Ламинат Artens «Ленасиа» 33 класс толщина 8 мм",
                    R.drawable.artens_2
                ),
                Item(5, "122 ₽/шт.", "Салфетка, 35x35 см, микрофибра, 4 шт.", R.drawable.salfetka),
                Item(
                    6,
                    "316 ₽/шт.",
                    "Подушка «Бархат», 40х40 см, цвет жёлтый",
                    R.drawable.podushka
                ),
            )
        )

        limitedOfferList.addAll(
            listOf(
                Item(
                    0,
                    "316 ₽/шт.",
                    "Подушка «Бархат», 40х40 см, цвет жёлтый",
                    R.drawable.podushka
                ),
                Item(1, "122 ₽/шт.", "Салфетка, 35x35 см, микрофибра, 4 шт.", R.drawable.salfetka),
                Item(
                    2,
                    "899,21 ₽/кор.",
                    "Ламинат Artens «Ленасиа» 33 класс толщина 8 мм",
                    R.drawable.artens_2
                ),
                Item(3, "2383 ₽/шт.", "Тачка садовая одноколесная 200 кг/90 л", R.drawable.telega),
                Item(
                    4,
                    "930,60 ₽/кор.",
                    "Ламинат Artens «Тангай» 33 класс толщина 8 мм",
                    R.drawable.artens_1
                ),
                Item(5, "413 ₽/шт.", "Штукатурка гипсовая Волма Слой 30 кг", R.drawable.volma),
                Item(6, "143 ₽/шт.", "Пескобетон Axton 30 кг", R.drawable.peskobeton),
            )
        )

        bestPriceList.addAll(
            listOf(
                Item(
                    0,
                    "930,60 ₽/кор.",
                    "Ламинат Artens «Тангай» 33 класс толщина 8 мм",
                    R.drawable.artens_1
                ),
                Item(
                    1,
                    "899,21 ₽/кор.",
                    "Ламинат Artens «Ленасиа» 33 класс толщина 8 мм",
                    R.drawable.artens_2
                ),
                Item(2, "413 ₽/шт.", "Штукатурка гипсовая Волма Слой 30 кг", R.drawable.volma),
                Item(3, "122 ₽/шт.", "Салфетка, 35x35 см, микрофибра, 4 шт.", R.drawable.salfetka),
                Item(4, "143 ₽/шт.", "Пескобетон Axton 30 кг", R.drawable.peskobeton),
                Item(
                    5,
                    "316 ₽/шт.",
                    "Подушка «Бархат», 40х40 см, цвет жёлтый",
                    R.drawable.podushka
                ),
                Item(6, "2383 ₽/шт.", "Тачка садовая одноколесная 200 кг/90 л", R.drawable.telega),
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoriesAdapter = CategoriesAdapter()
        earlySeenAdapter = ItemsAdapter()
        limitedOfferAdapter = ItemsAdapter()
        bestPriceAdapter = ItemsAdapter()
        with(binding) {
            rvCategories.adapter = categoriesAdapter
            rvCategories.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
            rvCategories.addItemDecoration(
                LinearSpacingCategoryItemDecoration(
                    resources.getDimension(R.dimen.linearItemsDist).toInt()
                )
            )
            categoriesAdapter.submitList(categories)

            rvEarlySeen.adapter = earlySeenAdapter
            rvEarlySeen.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
            rvEarlySeen.addItemDecoration(
                LinearSpacingItemDecoration(
                    resources.getDimension(R.dimen.linearItemsDistForItems).toInt()
                )
            )
            earlySeenAdapter.submitList(earlySeenList)

            rvLimitedOffer.adapter = limitedOfferAdapter
            rvLimitedOffer.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
            rvLimitedOffer.addItemDecoration(
                LinearSpacingItemDecoration(
                    resources.getDimension(R.dimen.linearItemsDistForItems).toInt()
                )
            )
            limitedOfferAdapter.submitList(limitedOfferList)

            rvBestPrice.adapter = bestPriceAdapter
            rvBestPrice.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
            rvBestPrice.addItemDecoration(
                LinearSpacingItemDecoration(
                    resources.getDimension(R.dimen.linearItemsDistForItems).toInt()
                )
            )
            bestPriceAdapter.submitList(bestPriceList)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentMainScreen()
    }
}