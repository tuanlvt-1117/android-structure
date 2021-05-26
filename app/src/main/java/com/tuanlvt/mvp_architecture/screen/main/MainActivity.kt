package com.tuanlvt.mvp_architecture.screen.main

import com.tuanlvt.mvp_architecture.R
import com.tuanlvt.mvp_architecture.screen.listMovie.MoviesFragment
import com.tuanlvt.mvp_architecture.utils.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun getLayoutResourceId() = R.layout.activity_main

    override fun initView() {
        supportFragmentManager
                .beginTransaction()
                .addToBackStack(MoviesFragment::javaClass.name)
                .replace(R.id.layoutContainer, MoviesFragment.newInstance())
                .commit()
    }

    override fun initData() {}
}
