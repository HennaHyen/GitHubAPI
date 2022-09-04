package com.example.githubapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.githubapi.R
import com.example.githubapi.databinding.ActivityMainBinding
import com.example.githubapi.viewModel.SearchViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var searchViewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        searchViewModel = ViewModelProvider(this)[SearchViewModel::class.java]
        searchList()
        observerUserViewModel()
    }

    private fun searchList() {
        binding.btnSearch.setOnClickListener {
            val search = binding.editTxt.text.toString()
            searchViewModel.getSearchList(search)
        }
    }

    private fun observerUserViewModel() {
        searchViewModel.basicResponse.observe(this) { basic ->
            binding.resultTotalCount.text = basic.totalCount.toString()
            binding.resultIncompleteResults.text = basic.incompleteResults.toString()
        }
    }
}