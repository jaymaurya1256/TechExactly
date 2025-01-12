package com.example.techexactly.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.techexactly.R
import com.example.techexactly.adapter.ItemAdapter
import com.example.techexactly.data.Application
import com.example.techexactly.databinding.FragmentApplicationListBinding
import com.example.techexactly.viewModel.ApplicationListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import retrofit2.Response
import kotlin.text.contains
import kotlin.text.filter

@AndroidEntryPoint
class ApplicationListFragment : Fragment() {

    private lateinit var binding: FragmentApplicationListBinding
    private lateinit var itemAdapter: ItemAdapter
    private val applicationListViewModel: ApplicationListViewModel by viewModels()
    private var filteredList: List<Application> = emptyList()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentApplicationListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemAdapter = ItemAdapter()
        binding.appRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.appRecyclerView.adapter = itemAdapter
        applicationListViewModel.appData.observe(viewLifecycleOwner) {
            if (!it.isNullOrEmpty()) {
                itemAdapter.submitList(it)
                binding.progressBar.visibility = View.GONE
            } else {
                binding.progressBar.visibility = View.VISIBLE
            }
            setupSearchBar()
        }
    }

    private fun setupSearchBar() {
        binding.textSearchBar.editText?.doAfterTextChanged { editable ->
            val query = editable.toString()
            filterList(query)
        }
    }

    private fun filterList(query: String) {
        filteredList = if (query.isEmpty()) {
            applicationListViewModel.appData.value!!
        } else {
            applicationListViewModel.appData.value!!.filter { application ->
                application.appName.contains(query, ignoreCase = true)
            }
        }
        itemAdapter.submitList(filteredList)
    }
}