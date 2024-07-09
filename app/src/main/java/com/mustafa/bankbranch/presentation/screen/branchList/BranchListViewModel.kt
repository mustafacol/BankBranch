package com.mustafa.bankbranch.presentation.screen.branchList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustafa.bankbranch.data.dto.BranchItem
import com.mustafa.bankbranch.domain.use_case.GetBankBranchListUseCase
import com.mustafa.bankbranch.domain.use_case.LogEventUseCase
import com.mustafa.bankbranch.domain.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BranchListViewModel(
    private val getBankBranchListUseCase: GetBankBranchListUseCase,
    private val logEventUseCase: LogEventUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(BranchListState())
    val state = _state.asStateFlow()
    private var originalList = listOf<BranchItem>()

    init {
        getBranchList()
    }

    private fun searchBranch(queryString: String) {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true, isSearching = true, queryString = queryString)
            }
            val searchList = originalList.filter {
                it.city.trim().contains(queryString.trim(), ignoreCase = true)
            }
            _state.update {
                it.copy(isLoading = false, isSearching = false, branchList = searchList)
            }
        }

    }

    fun onEvent(event: BranchListEvent) {
        when (event) {
            is BranchListEvent.SearchBranch -> {
                searchBranch(event.queryString)
            }

            BranchListEvent.TryAgain -> {
                getBranchList()
            }

            is BranchListEvent.BranchItemClicked -> {
                logEventUseCase(event.branchItem)
            }
        }
    }

    private fun getBranchList() {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }
            when (val resource = getBankBranchListUseCase()) {
                is Resource.Error -> {
                    resource.message?.let { errorMessage ->
                        _state.update {
                            it.copy(error = errorMessage, isLoading = false)
                        }
                    }

                }

                is Resource.Success -> {
                    resource.data?.let { branchList ->
                        originalList = branchList
                        _state.update {
                            it.copy(isLoading = false, branchList = branchList, error = null)
                        }
                    }
                }
            }
        }
    }
}