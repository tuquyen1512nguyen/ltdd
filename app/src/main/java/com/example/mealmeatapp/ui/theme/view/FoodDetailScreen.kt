package com.example.mealmeatapp.ui.theme.view

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mealmeatapp.R
import com.example.mealmeatapp.ui.theme.*
import com.example.mealmeatapp.ui.theme.model.MealRepository

@Composable
fun FoodDetailScreen(
    navController: NavController,
    mealId: Int
) {
    val mealRepository = MealRepository()
    val meal = mealRepository.getMealById(mealId) ?: run {
        navController.popBackStack()
        return
    }

    var isFavorite by remember { mutableStateOf(false) }
    val favoriteIconColor by animateColorAsState(
        targetValue = if (isFavorite) Orange else Gray,
        label = "Favorite Icon Color"
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(bottom = 56.dp) // Space for bottom navigation bar
    ) {
        item {
            // Image Header with Gradient Overlay
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
            ) {
                Image(
                    painter = painterResource(id = meal.imageResId),
                    contentDescription = meal.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(Color.Black.copy(alpha = 0.4f), Color.Transparent),
                                startY = 0f,
                                endY = 150f
                            )
                        )
                )
                // Back Button
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(15.dp)
                        .size(20.dp)
                        .background(White.copy(alpha = 0.1f), CircleShape)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = "Back",
                        tint = Black
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Meal Name and Favorite Button
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = meal.name,
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                    color = Black,
                    modifier = Modifier.weight(1f)
                )
                IconButton(
                    onClick = { isFavorite = !isFavorite },
                    modifier = Modifier
                        .size(48.dp)
                        .background(White, CircleShape)
                        .shadow(4.dp, CircleShape)
                ) {
                    Icon(
                        painter = painterResource(
                            id = if (isFavorite) android.R.drawable.btn_star_big_on
                            else android.R.drawable.btn_star_big_off
                        ),
                        contentDescription = "Favorite",
                        tint = favoriteIconColor,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Ingredients Section
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .shadow(4.dp, RoundedCornerShape(12.dp)),
                colors = CardDefaults.cardColors(containerColor = White)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Ingredients",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 22.sp,
                        color = Orange
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    meal.ingredients.forEach { ingredient ->
                        Text(
                            text = "• $ingredient",
                            style = MaterialTheme.typography.bodyLarge,
                            fontSize = 16.sp,
                            color = Black,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Cooking Instructions Section
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .shadow(4.dp, RoundedCornerShape(12.dp)),
                colors = CardDefaults.cardColors(containerColor = White)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Cooking Instructions",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 22.sp,
                        color = Orange
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    meal.instructions.forEachIndexed { index, instruction ->
                        Text(
                            text = "${index + 1}. $instruction",
                            style = MaterialTheme.typography.bodyLarge,
                            fontSize = 16.sp,
                            color = Black,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FoodDetailScreenPreview() {
    MealtimeAppTheme {
        FoodDetailScreen(
            navController = rememberNavController(),
            mealId = 1
        )
    }
}