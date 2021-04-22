package ru.work.leruaexample

import android.animation.ValueAnimator
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.appbar.AppBarLayout
import ru.work.leruaexample.databinding.FragmentMainScreenBinding
import kotlin.math.abs


class FragmentMainScreen : Fragment(R.layout.fragment_main_screen),
    AppBarLayout.OnOffsetChangedListener {
    lateinit var categoriesAdapter: CategoriesAdapter
    lateinit var earlySeenAdapter: ItemAdapter
    lateinit var limitedOfferAdapter: ItemAdapter
    lateinit var bestPriceAdapter: ItemAdapter
    private val binding by viewBinding(FragmentMainScreenBinding::bind)
    private var categories = mutableListOf<CategoryElement>()
    private var earlySeenList = mutableListOf<Item>()
    private var limitedOfferList = mutableListOf<Item>()
    private var bestPriceList = mutableListOf<Item>()

    private val PERCENTAGE_TO_START = 20
    private var mMaxScrollSize = 0
    private var mIsImageHidden = false
    private lateinit var colorAnim: ValueAnimator

    init {
        categories.addAll(
            listOf(
                CategoryElement.Header(0, "Каталог", R.drawable.ic_baseline_list_24),
                CategoryElement.Category(1, "Сад", R.drawable.gratis),
                CategoryElement.Category(2, "Освещение", R.drawable.gratis)
            )
        )

        earlySeenList.addAll(
            listOf(
                Item(0, "930,60 ₽/кор.", "Ламинат Artens", R.drawable.artens_1),
                Item(1, "899,21 ₽/кор.", "Ламинат Artens", R.drawable.artens_2),
                Item(2, "413 ₽/шт.", "Штукатурка гипсовая", R.drawable.volma)
            )
        )

        limitedOfferList.addAll(
            listOf(
                Item(0, "930,60 ₽/кор.", "Ламинат Artens", R.drawable.artens_1),
                Item(1, "899,21 ₽/кор.", "Ламинат Artens", R.drawable.artens_2),
                Item(2, "413 ₽/шт.", "Штукатурка гипсовая", R.drawable.volma)
            )
        )

        bestPriceList.addAll(
            listOf(
                Item(0, "930,60 ₽/кор.", "Ламинат Artens", R.drawable.artens_1),
                Item(1, "899,21 ₽/кор.", "Ламинат Artens", R.drawable.artens_2),
                Item(2, "413 ₽/шт.", "Штукатурка гипсовая", R.drawable.volma)
            )
        )
    }

    override fun onAttach(context: Context) {

        val ca = context.getColor(R.color.green)
        val cw = context.getColor(android.R.color.white)

        colorAnim = ValueAnimator.ofArgb(cw, ca)
//        colorAnim.addUpdateListener { binding.ivBackHeader.setBackgroundColor(it.animatedValue as Int) }

        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoriesAdapter = CategoriesAdapter()
        earlySeenAdapter = ItemAdapter()
        limitedOfferAdapter = ItemAdapter()
        bestPriceAdapter = ItemAdapter()
        with(binding) {
            rvCategories.adapter = categoriesAdapter
            rvCategories.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
            rvCategories.addItemDecoration(
                LinearSpacingItemDecoration(
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
//            appBar.addOnOffsetChangedListener(this@FragmentMainScreen)
        }
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        if (mMaxScrollSize == 0) mMaxScrollSize = appBarLayout!!.totalScrollRange

        val currentScrollPercentage: Int = (abs(verticalOffset) * 100
                / mMaxScrollSize)

        if (currentScrollPercentage >= PERCENTAGE_TO_START) {
            if (!mIsImageHidden) {
                mIsImageHidden = true
//                ViewCompat.animate(binding.btnBarcode).alpha(0f).start()
//                ViewCompat.animate(binding.appBar).alpha(0f).start()
//                colorAnim.reverse()
//                ViewCompat.animate(binding.constraintLayout).translationX(-30f)
            }
        }

        if (currentScrollPercentage < PERCENTAGE_TO_START) {
            if (mIsImageHidden) {
                mIsImageHidden = false
//                ViewCompat.animate(binding.btnBarcode).alpha(1f).start()
//                ViewCompat.animate(binding.appBar).alpha(1f).start()
//                colorAnim.start()
//                ViewCompat.animate(binding.constraintLayout).translationX(0f)
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentMainScreen()
    }
}