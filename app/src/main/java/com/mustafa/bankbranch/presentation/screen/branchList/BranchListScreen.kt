package com.mustafa.bankbranch.presentation.screen.branchList

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.mustafa.bankbranch.R
import com.mustafa.bankbranch.data.dto.BranchItem
import com.mustafa.bankbranch.presentation.components.BranchItemCard
import com.mustafa.bankbranch.presentation.components.BranchItemSearchbar
import com.mustafa.bankbranch.presentation.components.UiText
import com.mustafa.bankbranch.presentation.navigation.BranchDetailScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun BranchListScreen(
    navController: NavController,
    viewModel: BranchListViewModel = koinViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    Scaffold(modifier = Modifier
        .fillMaxSize()
        .statusBarsPadding(),
        containerColor = MaterialTheme.colorScheme.primary,
        topBar = {
            BranchItemSearchbar(queryString = state.queryString, placeholder = "Search..") {
                viewModel.onEvent(BranchListEvent.SearchBranch(it))
            }
        }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (state.isLoading) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
            state.error?.let {
                ErrorScreen(it) {
                    viewModel.onEvent(BranchListEvent.TryAgain)
                }
            }
            if (state.branchList.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(
                        items = state.branchList,
                        key = BranchItem::id
                    ) {
                        BranchItemCard(branch = it, onClick = {
                            navController.navigate(BranchDetailScreen(it))
                        })
                    }
                }
            }
        }

    }
}

@Preview
@Composable
fun ErrorScreen(
    errorMessage: UiText = UiText.DynamicString("Şube verileri alınamıyor"),
    onRefresh: () -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.sad_face),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.secondary),
            contentDescription = null
        )
        Text(text = errorMessage.asString(), color = MaterialTheme.colorScheme.secondary)
        Button(
            modifier = Modifier.padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary),
            onClick = { onRefresh() }) {
            Text(text = stringResource(id = R.string.try_again), color = Color.White)
        }
    }
}