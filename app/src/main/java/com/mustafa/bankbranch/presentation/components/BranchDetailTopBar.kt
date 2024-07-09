package com.mustafa.bankbranch.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mustafa.bankbranch.R
import com.mustafa.bankbranch.ui.theme.Blue

@Composable
fun BranchDetailTopBar(
    onNavigateBack: () -> Unit
) {
    Box(modifier = Modifier.fillMaxWidth()) {
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
        IconButton(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.5f)),
            onClick = { onNavigateBack() }) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, tint = Blue)

        }

    }
}