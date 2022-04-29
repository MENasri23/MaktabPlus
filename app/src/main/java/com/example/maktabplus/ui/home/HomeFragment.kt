package com.example.maktabplus.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.maktabplus.R
import com.example.maktabplus.databinding.HomeFragmentBinding
import com.example.maktabplus.ui.util.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.home_fragment) {


    private val homeViewModel by viewModels<HomeViewModel>()
    private val binding by viewBinding(HomeFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
//            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
//                homeViewModel.images.collectLatest {
//                    Log.d("HomeFragment", "onViewCreated: ${it.data?.size}")
//                }
//            }
        }
    }
}