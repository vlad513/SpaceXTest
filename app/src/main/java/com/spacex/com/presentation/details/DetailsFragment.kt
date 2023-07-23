package com.spacex.com.presentation.details


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.spacex.com.R
import com.spacex.com.databinding.FragmentDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailsFragment : Fragment() {
    private val args: DetailsFragmentArgs by navArgs()
    private val viewModel by viewModel<DetailsViewModel>()
    private val adapter by lazy(LazyThreadSafetyMode.NONE) {
        DetailsAdapter ()
    }
    private lateinit var binding: FragmentDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            RcView.adapter = adapter
            TvName.text = "Name: ${args.dock.name}"
            ImAvatar.load(args.dock.links?.patch?.small)
            TvCoresFlight.text = "FlightNumber: ${args.dock.flight_number}"
            TvSuccess.text = "Success: ${args.dock.success}"
            TvDetails.text = "Details: ${args.dock.details}"
            toolbar.setNavigationOnClickListener {
                findNavController().navigate(R.id.action_detailsFragment_to_missionsFragment)
            }
        }
        if (args.dock.crew.isNotEmpty()) {
            val list = args.dock.crew
            list.forEach {
                it?.let { it1 -> viewModel.getCrew(id = it1) }
            }
        }

        viewModel._crewLiveData.observe(viewLifecycleOwner){
            it?.let { it1 -> adapter.addRepoz(repoz = it1) }
        }

        val callback = requireActivity().onBackPressedDispatcher.addCallback(owner = this) {
            findNavController().navigate(R.id.action_detailsFragment_to_missionsFragment)
        }
    }


}