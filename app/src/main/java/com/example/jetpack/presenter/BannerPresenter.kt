package com.example.jetpack.presenter

import mvp.ljb.kt.presenter.BaseMvpPresenter
import com.example.jetpack.contract.BannerContract
import com.example.jetpack.model.BannerModel

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/10/14
 * @Description input description
 **/
class BannerPresenter : BaseMvpPresenter<BannerContract.IView, BannerContract.IModel>(), BannerContract.IPresenter{

    override fun registerModel() = BannerModel::class.java
    override fun refreshDate() {
        TODO("Not yet implemented")
    }

}
