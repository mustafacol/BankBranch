package com.mustafa.bankbranch.presentation.screen.branchDetail

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mustafa.bankbranch.R
import com.mustafa.bankbranch.data.dto.BranchItem
import com.mustafa.bankbranch.presentation.components.ItemDetailForm

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailScreen(branchItem: BranchItem, onNavigateClick: (Context, String) -> Unit) {
    Scaffold(modifier = Modifier
        .fillMaxSize()
        .statusBarsPadding(),
        containerColor = MaterialTheme.colorScheme.primary,
        topBar = {
            Column {
                Image(
                    modifier = Modifier.clip(
                        RoundedCornerShape(
                            bottomStart = 8.dp,
                            bottomEnd = 8.dp
                        )
                    ),
                    painter = painterResource(id = R.drawable.branch_image),
                    contentDescription = null
                )
            }

        }) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
                .padding(8.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            ItemDetailForm(branchItem = branchItem, onNavigateClick = onNavigateClick)
        }

    }
}