package com.mustafa.bankbranch.presentation.components

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mustafa.bankbranch.R
import com.mustafa.bankbranch.data.dto.BranchItem
import com.mustafa.bankbranch.ui.theme.White


@Composable
fun ItemDetailForm(branchItem: BranchItem, onNavigateClick: (Context, String) -> Unit) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.secondary)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        BranchDetailHeader(title = branchItem.addressName)

        ItemButton(text = stringResource(R.string.get_directions)) {
            onNavigateClick(context, branchItem.address)
        }
        Spacer(modifier = Modifier.height(16.dp))
        ItemDetailRow(
            title = stringResource(R.string.bank_code),
            text = branchItem.bankCode
        )
        Divider(
            modifier = Modifier.padding(horizontal = 16.dp),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.tertiary
        )
        ItemDetailRow(title = stringResource(R.string.address), text = branchItem.address)
        Divider(
            modifier = Modifier.padding(horizontal = 16.dp),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.tertiary
        )

        ItemDetailRow(
            title = stringResource(R.string.district),
            text = branchItem.district + "/" + branchItem.city
        )
        Divider(
            modifier = Modifier.padding(horizontal = 16.dp),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.tertiary
        )
        ItemDetailRow(
            title = stringResource(R.string.postal_code),
            text = branchItem.postalCode
        )
        Divider(
            modifier = Modifier.padding(horizontal = 16.dp),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.tertiary
        )
        ItemDetailRow(
            title = stringResource(R.string.region_coordinator),
            text = branchItem.regionCoordinator
        )
        Divider(
            modifier = Modifier.padding(horizontal = 16.dp),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.tertiary
        )
        ItemDetailRow(
            title = stringResource(R.string.closest_atm),
            text = branchItem.closestAtm
        )

    }
}

@Composable
fun ItemDetailRow(
    modifier: Modifier = Modifier,
    title: String,
    text: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = modifier
                .padding(8.dp)
                .weight(1f),
            text = title,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            modifier = modifier
                .padding(8.dp)
                .weight(1f),
            text = text,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary
        )
    }

}

@Composable
fun ItemButton(text: String, onClick: () -> Unit) {
    OutlinedButton(
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(
            1.dp,
            if (!isSystemInDarkTheme()) White else MaterialTheme.colorScheme.tertiary
        ),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = if (!isSystemInDarkTheme()) White else MaterialTheme.colorScheme.tertiary),
        onClick = {
            onClick()
        }) {
        Text(text = text, style = MaterialTheme.typography.labelMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun ItemDetailPreview() {
    ItemDetailRow(title = "City", text = "Adana")
}