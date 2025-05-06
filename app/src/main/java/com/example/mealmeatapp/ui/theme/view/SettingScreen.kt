package com.example.mealmeatapp.ui.theme.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.mealmeatapp.R
import com.example.mealmeatapp.ui.theme.*

data class SettingItem(
    val iconResId: Int,
    val title: String,
    val onClick: () -> Unit
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingScreen(
    navController: NavController
) {
    var showLogoutDialog by remember { mutableStateOf(false) }

    val settingItems = listOf(
        SettingItem(
            iconResId = R.drawable.moon,
            title = "Change Your Theme",
            onClick = { /* TODO: Implement theme change logic */ }
        ),
        SettingItem(
            iconResId = R.drawable.notification,
            title = "Notifications",
            onClick = { /* TODO: Navigate to notification settings screen */ }
        ),
        SettingItem(
            iconResId = R.drawable.report,
            title = "Suggest or Report Anything",
            onClick = { /* TODO: Navigate to feedback screen or form */ }
        ),
        SettingItem(
            iconResId = R.drawable.stars,
            title = "Rate Us on Play Store",
            onClick = { /* TODO: Open Play Store link */ }
        ),
        SettingItem(
            iconResId = R.drawable.share,
            title = "Share the App with Friends",
            onClick = { /* TODO: Implement share intent */ }
        ),
        SettingItem(
            iconResId = R.drawable.privacy,
            title = "Privacy Policy",
            onClick = { /* TODO: Navigate to privacy policy screen or web link */ }
        ),
        SettingItem(
            iconResId = R.drawable.logout,
            title = "Log Out",
            onClick = { showLogoutDialog = true }
        )
    )

    if (showLogoutDialog) {
        AlertDialog(
            onDismissRequest = { showLogoutDialog = false },
            title = { Text("Log Out", style = MaterialTheme.typography.titleLarge) },
            text = { Text("Are you sure you want to log out?", style = MaterialTheme.typography.bodyLarge) },
            confirmButton = {
                TextButton(
                    onClick = {
                        showLogoutDialog = false
                        navController.navigate("mealtime") {
                            popUpTo(navController.graph.startDestinationId) { inclusive = true }
                        }
                        // TODO: Clear user session/auth data
                    },
                    colors = ButtonDefaults.textButtonColors(contentColor = Orange)
                ) {
                    Text("Log Out", fontWeight = FontWeight.Medium)
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showLogoutDialog = false },
                    colors = ButtonDefaults.textButtonColors(contentColor = Gray)
                ) {
                    Text("Cancel", fontWeight = FontWeight.Medium)
                }
            },
            containerColor = White,
            titleContentColor = Black,
            textContentColor = Black
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Settings",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                        color = Black,
                        fontSize = 20.sp
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() },
                        modifier = Modifier
                            .size(20.dp)
                            .background(White.copy(alpha = 0.7f), CircleShape)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.back),
                            contentDescription = "Back",
                            tint = Black
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = White,
                    titleContentColor = Black
                ),
                modifier = Modifier.shadow(4.dp)
            )
        },
        containerColor = White
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier
                .fillMaxSize()
                .background(White)
                .padding(horizontal = 15.dp)
        ) {
            items(settingItems.size) { index ->
                val item = settingItems[index]
                Card(
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .shadow(2.dp, RoundedCornerShape(12.dp))
                        .clickable { item.onClick() },
                    colors = CardDefaults.cardColors(containerColor = White)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(30.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(32.dp)
                                    .background(Orange.copy(alpha = 0.1f), CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    painter = painterResource(id = item.iconResId),
                                    contentDescription = item.title,
                                    tint = Orange,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(14.dp))
                            Text(
                                text = item.title,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Medium,
                                fontSize = 20.sp,
                                color = Black
                            )
                        }
                        Icon(
                            painter = painterResource(id = R.drawable.right),
                            contentDescription = "Navigate",
                            tint = Orange,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
                if (index < settingItems.size - 1) {
                    Divider(
                        color = Gray.copy(alpha = 0.2f),
                        thickness = 0.5.dp,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun SettingScreenPreview() {
    MealtimeAppTheme {
        SettingScreen(rememberNavController())
    }
}