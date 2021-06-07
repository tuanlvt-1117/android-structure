package com.tuanlvt.mvvm.utils.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<viewBinding : ViewBinding, viewModel : BaseViewModel> : Fragment() {

    protected abstract val viewModel: viewModel

    private var _viewBinding: viewBinding? = null
    protected val viewBinding get() = _viewBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _viewBinding = inflateViewBinding(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
        bindView()
        registerLiveData()
    }

    abstract fun inflateViewBinding(inflater: LayoutInflater): viewBinding
    abstract fun setUpView()
    abstract fun bindView()
    abstract fun registerLiveData()
}
