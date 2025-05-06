package com.example.mealmateapp.ui.theme.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mealmeatapp.R
import com.example.mealmeatapp.ui.theme.model.Meal
import com.example.mealmeatapp.ui.theme.*
import com.example.mealmeatapp.ui.theme.controller.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    navController: NavController
) {
    val categories = listOf("All", "Breakfast", "Lunch", "Dinner")

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Spacer(modifier = Modifier.height(16.dp))

                // Search box
                OutlinedTextField(
                    value = viewModel.searchQuery.value,
                    onValueChange = { viewModel.onSearchQueryChange(it) },
                    label = { Text("Search for a meal") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .padding(vertical = 8.dp),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = "Search Icon",
                            modifier = Modifier.size(20.dp)
                        )
                    },
                    shape = RoundedCornerShape(8.dp),
                    textStyle = MaterialTheme.typography.bodyMedium.copy(fontSize = 14.sp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Các category button
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    categories.forEach { category ->
                        Button(
                            onClick = { viewModel.onCategoryChange(category) },
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 2.dp),
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (viewModel.selectedCategory.value == category) Orange else White,
                                contentColor = if (viewModel.selectedCategory.value == category) White else Black
                            ),
                            contentPadding = PaddingValues(8.dp)
                        ) {
                            Text(
                                text = category.uppercase(),
                                style = MaterialTheme.typography.bodySmall.copy(fontSize = 10.sp),
                                fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Heading
                Text(
                    text = "What should I eat today?",
                    style = MaterialTheme.typography.headlineSmall.copy(fontSize = 20.sp),
                )

                // Subheading
                Text(
                    text = "Deciding what to eat can be a chore. Let us help you out.",
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 14.sp),
                    color = Gray,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                // Button "Random Meal"
                Button(
                    onClick = { viewModel.onRandomMealClick() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp),
                    shape = RoundedCornerShape(22.5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Orange)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.random),
                            contentDescription = "Random Icon",
                            tint = White,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Random Meal",
                            color = White,
                            style = MaterialTheme.typography.labelLarge.copy(fontSize = 14.sp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))
            }

            // Hiển thị 2 món ăn mỗi hàng
            items(viewModel.meals.value.chunked(2)) { rowMeals ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    MealItemLarge(
                        meal = rowMeals[0],
                        modifier = Modifier.weight(1f),
                        onClick = { navController.navigate("foodDetail/${rowMeals[0].id}") }
                    )

                    if (rowMeals.size > 1) {
                        MealItemLarge(
                            meal = rowMeals[1],
                            modifier = Modifier.weight(1f),
                            onClick = { navController.navigate("foodDetail/${rowMeals[1].id}") }
                        )
                    } else {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Composable
fun MealItemLarge(
    meal: Meal,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = modifier
            .height(170.dp)
            .clickable { onClick() }
    ) {
        Column {
            Image(
                painter = painterResource(id = meal.imageResId),
                contentDescription = meal.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = meal.name,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    painter = painterResource(id = R.drawable.favorite),
                    contentDescription = "Favorite",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val navItems = listOf(
        BottomNavItem("home", R.drawable.home, "Home"),
        BottomNavItem("planner", R.drawable.planner, "Planner"),
        BottomNavItem("favorite", R.drawable.heart, "Favorite"),
        BottomNavItem("setting", R.drawable.setting, "Setting"),
    )

    NavigationBar(
        containerColor = White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navItems.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.label,
                        modifier = Modifier.size(20.dp)
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        fontSize = 10.sp
                    )
                },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Orange,
                    selectedTextColor = Orange,
                    unselectedIconColor = Black,
                    unselectedTextColor = Black
                )
            )
        }
    }
}

data class BottomNavItem(
    val route: String,
    val icon: Int,
    val label: String
)

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MealtimeAppTheme {
        HomeScreen(HomeViewModel(), rememberNavController())
    }
}