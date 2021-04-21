package ru.work.leruaexample

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.work.leruaexample.databinding.FragmentMainScreenBinding

class FragmentMainScreen : Fragment(R.layout.fragment_main_screen) {
    lateinit var categoriesAdapter: CategoriesAdapter
    lateinit var earlySeenAdapter: ItemAdapter
    lateinit var limitedOfferAdapter: ItemAdapter
    lateinit var bestPriceAdapter: ItemAdapter
    private val binding by viewBinding(FragmentMainScreenBinding::bind)
    private var categories = mutableListOf<CategoryElement>()
    private var earlySeenList = mutableListOf<Item>()
    private var limitedOfferList = mutableListOf<Item>()
    private var bestPriceList = mutableListOf<Item>()


    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categories.addAll(
            listOf(
            CategoryElement.Header(0, "Каталог", R.drawable.ic_baseline_list_24),
            CategoryElement.Category(1, "Сад", R.drawable.gratis),
            CategoryElement.Category(2, "Освещение", R.drawable.gratis)
            )
        )

        earlySeenList.addAll(
            listOf(
                Item(0, "930,60 ₽/кор.", "Ламинат Artens",R.drawable.artens_1),
                Item(1, "899,21 ₽/кор.", "Ламинат Artens",R.drawable.artens_2),
                Item(2, "413 ₽/шт.", "Штукатурка гипсовая", R.drawable.volma)
            )
        )

        limitedOfferList.addAll(
            listOf(
                Item(0, "930,60 ₽/кор.", "Ламинат Artens",R.drawable.artens_1),
                Item(1, "899,21 ₽/кор.", "Ламинат Artens",R.drawable.artens_2),
                Item(2, "413 ₽/шт.", "Штукатурка гипсовая", R.drawable.volma)
            )
        )

        bestPriceList.addAll(
            listOf(
                Item(0, "930,60 ₽/кор.", "Ламинат Artens",R.drawable.artens_1),
                Item(1, "899,21 ₽/кор.", "Ламинат Artens",R.drawable.artens_2),
                Item(2, "413 ₽/шт.", "Штукатурка гипсовая", R.drawable.volma)
            )
        )


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoriesAdapter = CategoriesAdapter()
        earlySeenAdapter = ItemAdapter()
        limitedOfferAdapter = ItemAdapter()
        bestPriceAdapter = ItemAdapter()
        with(binding){
            rvCategories.adapter = categoriesAdapter
            rvCategories.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            rvCategories.addItemDecoration(LinearSpacingItemDecoration(
                resources.getDimension(R.dimen.linearItemsDist).toInt()
            ))
            categoriesAdapter.submitList(categories)

            rvEarlySeen.adapter = earlySeenAdapter
            rvEarlySeen.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            rvEarlySeen.addItemDecoration(LinearSpacingItemDecoration(
                resources.getDimension(R.dimen.linearItemsDistForItems).toInt()
            ))
            earlySeenAdapter.submitList(earlySeenList)

            rvLimitedOffer.adapter = limitedOfferAdapter
            rvLimitedOffer.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            rvLimitedOffer.addItemDecoration(LinearSpacingItemDecoration(
                resources.getDimension(R.dimen.linearItemsDistForItems).toInt()
            ))
            limitedOfferAdapter.submitList(limitedOfferList)

            rvBestPrice.adapter = bestPriceAdapter
            rvBestPrice.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            rvBestPrice.addItemDecoration(LinearSpacingItemDecoration(
                resources.getDimension(R.dimen.linearItemsDistForItems).toInt()
            ))
            bestPriceAdapter.submitList(bestPriceList)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_screen, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentMainScreen()
    }
}