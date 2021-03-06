package com.app.mytoolbox.fragments.subscription.adapter

import android.content.Context
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.graphics.drawable.DrawableCompat
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.app.mytoolbox.R
import com.app.mytoolbox.databinding.FragmentPackageBinding
import com.app.mytoolbox.modelClasses.InApp.PackDetail
import com.app.mytoolbox.usermanagment.modelClasses.activeSubscription.AccountServiceMessageItem
import com.app.mytoolbox.usermanagment.modelClasses.getProducts.Attribute
import com.app.mytoolbox.utils.helpers.carousel.SliderPotrait
import java.util.*
import kotlin.collections.ArrayList


class SubscriptionPagerAdapter(
    private var context: Context,
    private val packagesList: List<PackDetail>,
    private val productList: AccountServiceMessageItem,
    private val onPackageChooseClickListener: OnPackageChooseClickListener
) : PagerAdapter() {

    private var activePlan: String? = null

    override fun isViewFromObject(view: View, mObject: Any): Boolean {
        return view == mObject

    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(context)
        val bannerBinding: FragmentPackageBinding = DataBindingUtil.bind<FragmentPackageBinding>(
            inflater.inflate(
                R.layout.fragment_package,
                container,
                false
            )
        )!! //HomeViewPagerBannerBinding.bind(view);
        bannerBinding.executePendingBindings()
        val packageModel = packagesList[position].productsResponseMessageItem
        val skuModel = packagesList[position].skuDetails
        if (position == 1) {
            bannerBinding.btnChooseMe.setTextColor(context.resources.getColor(R.color.title_color))
            bannerBinding.text.setTextColor(context.resources.getColor(R.color.title_color))
        } else {
            bannerBinding.btnChooseMe.setTextColor(context.resources.getColor(R.color.black_text_color))
            bannerBinding.text.setTextColor(context.resources.getColor(R.color.black_text_color))
        }
        if (packageModel.isFreemium != null && !packageModel.isFreemium!!) {
            bannerBinding.text.visibility = View.INVISIBLE
            bannerBinding.text.setPadding(0, 0, 0, 0)
        } else {
            bannerBinding.text.visibility = View.VISIBLE
            bannerBinding.text.setPadding(
                0,
                SliderPotrait.dp2px(context, 6f),
                0,
                SliderPotrait.dp2px(context, 6f)
            )
        }
        bannerBinding.packagePriceOld.visibility = View.GONE
        val rainbow = context.resources.getIntArray(R.array.packages_colors)
        val currentColor = rainbow[position % rainbow.size]

        var backgroundDrawable: Drawable = bannerBinding.mainBackground.background
        backgroundDrawable = DrawableCompat.wrap(backgroundDrawable)
        DrawableCompat.setTint(backgroundDrawable, currentColor)
        bannerBinding.mainBackground.background = backgroundDrawable
        bannerBinding.packageTitle.text = packageModel.displayName
        bannerBinding.packageTitle.setTextColor(currentColor)
        if (skuModel.introductoryPricePeriod != null) {
            //Log.w("priceValues", skuModel!!.introductoryPrice + "<--->"+skuModel!!.price+"<----->"+packageModel.duration+"  "+skuModel.introductoryPricePeriod)
        }

        if (skuModel.introductoryPricePeriod != null && !skuModel.introductoryPricePeriod.equals(
                "",
                true
            )
        ) {
            if (packageModel.promotions != null && packageModel.promotions?.size!! > 0) {
                bannerBinding.text.visibility = View.VISIBLE
                bannerBinding.text.setPadding(
                    0,
                    SliderPotrait.dp2px(context, 6f),
                    0,
                    SliderPotrait.dp2px(context, 6f)
                )
                bannerBinding.text.text = packageModel.promotions!![0].promoDescrip
                if (packageModel.promotions!![0].promoCpDescription != null && !packageModel.promotions!![0].promoCpDescription.equals(
                        "",
                        true
                    )
                ) {
                    bannerBinding.offer.visibility = View.VISIBLE
                    bannerBinding.offer.text = packageModel.promotions!![0].promoCpDescription
                }
            }
            bannerBinding.currency.text = skuModel.priceCurrencyCode
            bannerBinding.packagePrice.text = skuModel.introductoryPrice + "/"
            bannerBinding.period.text = packageModel.duration.toString() + packageModel.period
            bannerBinding.packagePriceOld.text =
                skuModel.price.toString() + "/" + packageModel.duration + packageModel.period
            bannerBinding.packagePriceOld.visibility = View.VISIBLE
            bannerBinding.packagePriceOld.paintFlags =
                bannerBinding.packagePriceOld.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            //Log.w("priceValues else", skuModel!!.price )
            bannerBinding.offer.visibility = View.GONE
            bannerBinding.currency.text = skuModel.priceCurrencyCode
            bannerBinding.packagePrice.text = skuModel.price + "/"
            bannerBinding.period.text = packageModel.duration.toString() + packageModel.period
        }
        bannerBinding.packageDescription.text = packageModel.uiDisplayText

        var buttonDrawable: Drawable = bannerBinding.btnChooseMe.background
        buttonDrawable = DrawableCompat.wrap(buttonDrawable)
        DrawableCompat.setTint(buttonDrawable, currentColor)
        bannerBinding.btnChooseMe.background = buttonDrawable
        bannerBinding.masktop.setColorFilter(currentColor)
        bannerBinding.maskbottom.setColorFilter(currentColor)
        var attributeList = packageModel.attributes!!
        Collections.sort(attributeList, object : Comparator<Attribute?> {
            override fun compare(o1: Attribute?, o2: Attribute?): Int {
                return o1?.attributeLabel?.compareTo(o2?.attributeLabel!!)!!
            }
        })
        val my_array = ArrayList<String>()
        if (packageModel.attributes != null) {
            for (attribute in attributeList) {
                if (!attribute.attributeLabel.equals("ImageURL1", true)) {
                    my_array.add(attribute.attributeValue.toString())
                }
            }

        }
        if (packageModel.skuORQuickCode != null && productList != null) {
            if (checkActiveOrNot(packageModel.skuORQuickCode!!)) {
                bannerBinding.btnChooseMe.background =
                    context.resources.getDrawable(R.drawable.ic_btn)
                bannerBinding.btnChooseMe.isEnabled = false
                activePlan = skuModel.sku
            } else {
                bannerBinding.btnChooseMe.text = "Choose Me"
            }
        } else {
            bannerBinding.btnChooseMe.text = "Choose Me"
        }


        val adapter: ArrayAdapter<String> = BulletsAdapter(context, my_array, currentColor)
        bannerBinding.bulletsList.adapter = adapter
        bannerBinding.btnChooseMe.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                onPackageChooseClickListener.onPackageClicked(
                    position,
                    packagesList[position],
                    activePlan,
                    packagesList[position].productsResponseMessageItem.displayName,
                    skuModel.priceAmountMicros
                )
            }

        })

        container.addView(bannerBinding.root)
        return bannerBinding.root
    }

    private fun checkActiveOrNot(skuORQuickCode: String): Boolean {
        var matched = false
        matched = productList.serviceID.equals(skuORQuickCode, true)
        return matched
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }

    override fun getCount(): Int {
        return packagesList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return packagesList[position].productsResponseMessageItem.displayName
    }

    interface OnPackageChooseClickListener {
        fun onPackageClicked(
            position: Int,
            packDetails: PackDetail,
            activePlan: String?,
            planName: String?,
            price: Long?
        )
    }
}