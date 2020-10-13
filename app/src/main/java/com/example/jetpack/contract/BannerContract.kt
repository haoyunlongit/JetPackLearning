package com.example.jetpack.contract

import mvp.ljb.kt.contract.IPresenterContract
import mvp.ljb.kt.contract.IViewContract
import mvp.ljb.kt.contract.IModelContract

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/10/14
 * @Description input description
 **/
interface BannerContract {

    interface IView : IViewContract {
        fun setBanner(bannerUrl: String)
    }

    interface IPresenter : IPresenterContract {
        fun refreshDate()
    }

    interface IModel : IModelContract {
        fun requestBannerDate()
    }
}
