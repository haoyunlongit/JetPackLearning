package com.example.jetpack.view.act

import com.example.jetpack.contract.BannerContract
import com.example.jetpack.presenter.BannerPresenter
import mvp.ljb.kt.act.BaseMvpActivity

/**
 * @Author Kotlin MVP Plugin
 * @Date 2020/10/14
 * @Description input description
 **/
class BannerActivity : BaseMvpActivity<BannerContract.IPresenter>() , BannerContract.IView {

    override fun registerPresenter() = BannerPresenter::class.java

    override fun getLayoutId(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setBanner(bannerUrl: String) {
        TODO("Not yet implemented")
    }

}
