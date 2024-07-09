package com.mustafa.bankbranch.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.mustafa.bankbranch.domain.network_connectivity.ConnectivityObserver
import com.mustafa.bankbranch.domain.network_connectivity.NetworkConnectivityObserver
import com.mustafa.bankbranch.presentation.navigation.BankBranchApp
import com.mustafa.bankbranch.ui.theme.BankBranchTheme

class MainActivity : ComponentActivity() {
    private lateinit var connectivityObserver: ConnectivityObserver

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        connectivityObserver = NetworkConnectivityObserver(applicationContext)
        enableEdgeToEdge()
        setContent {
            BankBranchTheme {
                val status by connectivityObserver.observe().collectAsState(
                    initial = ConnectivityObserver.Status.Available
                )

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.primary
                ) { _ ->
                    BankBranchApp(status)
                }
            }
        }
    }
}

