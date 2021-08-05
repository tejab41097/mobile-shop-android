package com.tejas.mobileshop.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tejas.mobileshop.databinding.FragmentShowListBinding
import com.tejas.mobileshop.ui.adapter.MainAdapter

class ShowListFragment : Fragment() {

    private var binding: FragmentShowListBinding? = null
    private val viewBinding get() = binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShowListBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainViewModel = (requireActivity() as MainActivity).mainViewModel

        mainViewModel.getData().observe(viewLifecycleOwner) {
            val mainAdapter = MainAdapter().apply {
                this.submitList(it[0].options.toMutableList())
            }
            viewBinding.rvMain.adapter = mainAdapter
        }
    }

}