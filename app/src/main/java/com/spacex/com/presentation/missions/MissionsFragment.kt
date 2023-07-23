package com.spacex.com.presentation.missions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.spacex.com.databinding.FragmentMissionsBinding
import com.spacex.domain.models.launch.DocksModelDomain
import org.koin.androidx.viewmodel.ext.android.viewModel


class MissionsFragment : Fragment() {
    private val viewModel by viewModel<MissionsViewModel>()
    private lateinit var binding: FragmentMissionsBinding
    private val adapter by lazy(LazyThreadSafetyMode.NONE) {
        MissionsAdapter { callback(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentMissionsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.RcView.adapter = adapter

        viewModel.getLaunches()

        viewModel._missionsLiveData.observe(viewLifecycleOwner) {
            binding.buttonRefresh.visibility = View.GONE
            it?.let { it1 -> adapter.addRepoz(it1) }
        }
        viewModel._failLiveData.observe(viewLifecycleOwner) {
            binding.buttonRefresh.visibility = View.VISIBLE
        }

        binding.buttonRefresh.setOnClickListener {
            viewModel.getLaunches()
        }

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {}
    }

    private fun callback(it: DocksModelDomain) {
        findNavController().navigate(
            MissionsFragmentDirections.actionMissionsFragmentToDetailsFragment(
                it
            )
        )
    }
}