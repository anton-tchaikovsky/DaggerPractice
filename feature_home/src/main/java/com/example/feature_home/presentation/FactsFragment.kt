package com.example.feature_home.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.feature_home.R
import com.example.feature_home.data.dto.CatsFactDto
import com.example.feature_home.data.dto.DogsFactDto
import com.example.feature_home.databinding.FragmentFactsBinding
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.launch
import javax.inject.Inject

class FactsFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: FactsViewModelFactory.Factory

    private val viewModel: FactsViewModel by viewModels {
        viewModelFactory.create(
            getDefaultCatsFact(),
            getDefaultDogsFact()
        )
    }

    private var _binding: FragmentFactsBinding? = null
    private val binding: FragmentFactsBinding
        get() = _binding!!

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFactsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        subscribeViewModel()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun initView() {
        with(binding) {
            catsFactButton.setOnClickListener { viewModel.onCatsFactRequest() }
            dogsFactButton.setOnClickListener { viewModel.onDogsFactRequest() }
        }
    }

    private fun subscribeViewModel() {
        lifecycleScope.launch {
            viewModel.factsScreenState.collect { state ->
                when (state) {
                    is FactsScreenState.Error -> showError(state.error)
                    FactsScreenState.Loading -> showLoading()
                    is FactsScreenState.SuccessFact -> showFact(state.factsCat, state.factsDog)
                }
            }
        }
    }

    private fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
        binding.loadingProgressBar.visibility = View.INVISIBLE
    }

    private fun showLoading() {
        binding.loadingProgressBar.visibility = View.VISIBLE
    }

    private fun showFact(catsFact: CatsFactDto, dogsFact: DogsFactDto) {
        with(binding) {
            loadingProgressBar.visibility = View.INVISIBLE
            catsFactTextView.text = catsFact.fact
            dogsFactTextView.text = dogsFact.fact
        }
    }

    private fun getDefaultCatsFact() = CatsFactDto(getString(R.string.cat))

    private fun getDefaultDogsFact() = DogsFactDto(getString(R.string.dog))

    companion object {
        @JvmStatic
        fun newInstance() =
            FactsFragment()
    }
}