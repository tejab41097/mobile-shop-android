package com.tejas.mobileshop.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.tejas.mobileshop.databinding.FragmentShowListBinding
import com.tejas.mobileshop.model.Option
import com.tejas.mobileshop.ui.adapter.MainAdapter
import com.tejas.mobileshop.viewmodel.MainViewModel

class ShowListFragment : Fragment(), MainAdapter.ItemClickListener {

    private var binding: FragmentShowListBinding? = null
    private val viewBinding get() = binding!!
    private lateinit var mainViewModel: MainViewModel
    private val mainAdapter = MainAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShowListBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = (requireActivity() as MainActivity).mainViewModel
        viewBinding.rvMain.adapter = mainAdapter
        mainAdapter.itemClickListener = this
        mainViewModel.getAllMobiles().observe(viewLifecycleOwner) {
            it?.let { mainAdapter.submitList(it) }
        }
    }

    override fun click(model: Option) {
        Toast.makeText(requireContext(), model.name, Toast.LENGTH_SHORT).show()
    }

}