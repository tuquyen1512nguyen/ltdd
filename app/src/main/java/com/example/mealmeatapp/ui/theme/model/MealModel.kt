package com.example.mealmeatapp.ui.theme.model

import com.example.mealmeatapp.R

data class Meal(
    val id: Int,
    val name: String,
    val imageResId: Int,
    val category: String,
    val ingredients: List<String>,
    val instructions: List<String>
)

class MealRepository {
    private val meals = listOf(
        // Bữa sáng
        Meal(
            id = 1,
            name = "Bánh mì trứng",
            imageResId = R.drawable.banhmi_trung,
            category = "Breakfast",
            ingredients = listOf(
                "1 ổ bánh mì.",
                "2 quả trứng gà.",
                "1 thìa hành lá băm nhỏ.",
                "Gia vị: muối, tiêu, hạt nêm.",
                "1 thìa dầu ăn."
            ),
            instructions = listOf(
                "1. Đánh tan trứng với chút muối, tiêu và hành lá.",
                "2. Làm nóng chảo với dầu ăn.",
                "3. Đổ trứng vào chiên lửa vừa đến khi chín vàng.",
                "4. Xẻ bánh mì, cho trứng vào giữa.",
                "5. Có thể thêm chút xì dầu hoặc tương ớt tùy thích."
            )
        ),
        Meal(
            id = 2,
            name = "Bún riêu",
            imageResId = R.drawable.bun_rieu,
            category = "Breakfast",
            ingredients = listOf(
                "300g bún tươi.",
                "200g cua đồng.",
                "100g thịt băm.",
                "1 miếng đậu hũ chiên.",
                "2 quả cà chua.",
                "Hành lá, rau thơm.",
                "Gia vị: mắm, muối, hạt nêm."
            ),
            instructions = listOf(
                "1. Giã cua, lọc lấy nước cua.",
                "2. Phi thơm hành tỏi, xào cà chua đến khi mềm.",
                "3. Cho nước cua vào đun sôi.",
                "4. Thả đậu hũ và thịt băm vào nồi.",
                "5. Nêm nếm vừa ăn.",
                "6. Trình bày với bún và rau thơm."
            )
        ),
        Meal(
            id = 3,
            name = "Phở bò",
            imageResId = R.drawable.pho_bo,
            category = "Breakfast",
            ingredients = listOf(
                "300g bánh phở.",
                "200g thịt bò.",
                "Xương bò để nấu nước dùng.",
                "Hành tím, gừng, quế, hồi.",
                "Rau thơm: hành lá, ngò gai.",
                "Gia vị: muối, đường, nước mắm."
            ),
            instructions = listOf(
                "1. Hầm xương bò với gừng, hành tím, quế hồi.",
                "2. Thái mỏng thịt bò.",
                "3. Chần bánh phở qua nước sôi.",
                "4. Xếp thịt bò lên trên, chan nước dùng nóng.",
                "5. Thêm hành lá, rau thơm."
            )
        ),
        Meal(
            id = 4,
            name = "Xôi gà",
            imageResId = R.drawable.xoi_ga,
            category = "Breakfast",
            ingredients = listOf(
                "200g xôi.",
                "100g thịt gà.",
                "Hành phi."
            ),
            instructions = listOf(
                "1. Nấu xôi cho chín.",
                "2. Luộc thịt gà và xé nhỏ.",
                "3. Trộn xôi với thịt gà và hành phi."
            )
        ),
        Meal(
            id = 5,
            name = "Cháo trắng trứng muối",
            imageResId = R.drawable.chao_trang_trung_muoi,
            category = "Breakfast",
            ingredients = listOf(
                "1 chén gạo.",
                "500ml nước.",
                "2 quả trứng muối."
            ),
            instructions = listOf(
                "1. Nấu gạo với nước cho đến khi nhuyễn.",
                "2. Thái nhỏ trứng muối.",
                "3. Trình bày cháo với trứng muối."
            )
        ),
        Meal(
            id = 6,
            name = "Bánh cuốn",
            imageResId = R.drawable.banh_cuon,
            category = "Breakfast",
            ingredients = listOf(
                "200g bột gạo.",
                "300ml nước.",
                "Thịt băm, nấm hương, hành phi."
            ),
            instructions = listOf(
                "1. Pha bột với nước thành hỗn hợp sền sệt.",
                "2. Đổ bột vào chảo và hấp chín.",
                "3. Cuốn nhân thịt và nấm vào bánh."
            )
        ),
        Meal(
            id = 7,
            name = "Mì quảng",
            imageResId = R.drawable.mi_quang,
            category = "Breakfast",
            ingredients = listOf(
                "200g mì quảng.",
                "100g thịt heo.",
                "100g tôm.",
                "Gia vị: nước mắm, tiêu."
            ),
            instructions = listOf(
                "1. Nấu nước dùng từ xương heo.",
                "2. Luộc tôm và thịt heo.",
                "3. Trình bày mì với nước dùng và rau sống."
            )
        ),
        Meal(
            id = 8,
            name = "Cơm gà",
            imageResId = R.drawable.ga,
            category = "Lunch",
            ingredients = listOf(
                "1 con gà.",
                "Gạo tẻ.",
                "Gia vị: muối, tiêu, nước mắm."
            ),
            instructions = listOf(
                "1. Luộc gà cho chín.",
                "2. Nấu cơm với nước luộc gà.",
                "3. Thái gà và trình bày cùng cơm."
            )
        ),
        Meal(
            id = 9,
            name = "Cá kho tộ",
            imageResId = R.drawable.ca_kho_to,
            category = "Lunch",
            ingredients = listOf(
                "500g cá lóc.",
                "Gia vị: nước mắm, tiêu, đường."
            ),
            instructions = listOf(
                "1. Thái cá thành từng miếng.",
                "2. Ướp cá với gia vị.",
                "3. Kho cá trong nồi đất cho đến khi thấm."
            )
        ),
        Meal(
            id = 10,
            name = "Thịt kho trứng",
            imageResId = R.drawable.thit_kho_trung,
            category = "Lunch",
            ingredients = listOf(
                "400g thịt ba chỉ.",
                "4 quả trứng.",
                "Gia vị: nước mắm, tiêu."
            ),
            instructions = listOf(
                "1. Luộc trứng cho chín.",
                "2. Thái thịt và ướp gia vị.",
                "3. Kho thịt với trứng cho đến khi thấm."
            )
        ),
        Meal(
            id = 11,
            name = "Canh chua cá lóc",
            imageResId = R.drawable.canh_chua_ca_loc,
            category = "Lunch",
            ingredients = listOf(
                "300g cá lóc.",
                "200g cà chua.",
                "Gia vị: me, nước mắm."
            ),
            instructions = listOf(
                "1. Nấu nước dùng với me.",
                "2. Thêm cá và cà chua vào nấu chín.",
                "3. Nêm nếm vừa ăn."
            )
        ),
        Meal(
            id = 12,
            name = "Gà kho gừng",
            imageResId = R.drawable.ga_kho_gung,
            category = "Lunch",
            ingredients = listOf(
                "500g gà.",
                "50g gừng.",
                "Gia vị: nước mắm, tiêu."
            ),
            instructions = listOf(
                "1. Thái gừng và ướp gà với gia vị.",
                "2. Kho gà với gừng cho đến khi thấm."
            )
        ),
        Meal(
            id = 13,
            name = "Cơm gà xối mỡ",
            imageResId = R.drawable.com_ga_xoi_mo,
            category = "Lunch",
            ingredients = listOf(
                "1 con gà.",
                "Gạo tẻ.",
                "Gia vị: muối, tiêu."
            ),
            instructions = listOf(
                "1. Luộc gà cho chín.",
                "2. Nấu cơm và xối mỡ lên trên."
            )
        ),
        Meal(
            id = 14,
            name = "Bò xào rau củ",
            imageResId = R.drawable.bo_xao_rau_cu,
            category = "Lunch",
            ingredients = listOf(
                "300g thịt bò.",
                "100g rau củ.",
                "Gia vị: nước mắm, tiêu."
            ),
            instructions = listOf(
                "1. Thái thịt bò và ướp gia vị.",
                "2. Xào thịt bò với rau củ cho đến khi chín."
            )
        ),
        Meal(
            id = 15,
            name = "Canh chua cá",
            imageResId = R.drawable.canhchua,
            category = "Dinner",
            ingredients = listOf(
                "300g cá.",
                "200g cà chua.",
                "Gia vị: me, nước mắm."
            ),
            instructions = listOf(
                "1. Nấu nước dùng với me.",
                "2. Thêm cá và cà chua vào nấu chín.",
                "3. Nêm nếm vừa ăn."
            )
        ),
        Meal(
            id = 16,
            name = "Lẩu gà lá é",
            imageResId = R.drawable.lau_ga_la_e,
            category = "Dinner",
            ingredients = listOf(
                "1 con gà ta.",
                "100g lá é.",
                "Các loại rau nhúng lẩu.",
                "Sả, ớt, tỏi.",
                "Gia vị: muối, đường, hạt nêm."
            ),
            instructions = listOf(
                "1. Làm sạch gà, chặt miếng vừa ăn.",
                "2. Phi thơm sả tỏi, xào sơ gà.",
                "3. Cho nước vào đun sôi, thả lá é.",
                "4. Nêm gia vị vừa ăn.",
                "5. Nhúng rau và thịt gà khi ăn."
            )
        ),
        Meal(
            id = 17,
            name = "Cháo gà",
            imageResId = R.drawable.chao_ga,
            category = "Dinner",
            ingredients = listOf(
                "200g gạo.",
                "300g thịt gà.",
                "Gia vị: muối, tiêu."
            ),
            instructions = listOf(
                "1. Nấu gạo với nước cho đến khi nhuyễn.",
                "2. Thêm thịt gà vào nấu chín.",
                "3. Nêm nếm vừa ăn."
            )
        ),
        Meal(
            id = 18,
            name = "Canh rau ngót thịt băm",
            imageResId = R.drawable.rau_ngot_thit_bam,
            category = "Dinner",
            ingredients = listOf(
                "200g rau ngót.",
                "100g thịt băm.",
                "Gia vị: muối, tiêu."
            ),
            instructions = listOf(
                "1. Nấu nước dùng.",
                "2. Thêm thịt băm vào nấu chín.",
                "3. Thêm rau ngót vào và nêm nếm."
            )
        ),
        Meal(
            id = 19,
            name = "Trứng chiên thịt",
            imageResId = R.drawable.trung_chien_thit,
            category = "Dinner",
            ingredients = listOf(
                "4 quả trứng.",
                "100g thịt băm.",
                "Gia vị: muối, tiêu."
            ),
            instructions = listOf(
                "Đánh trứng với gia vị.",
                "Xào thịt băm cho chín.",
                "Đổ trứng vào chảo và chiên."
            )
        ),
        Meal(
            id = 20,
            name = "Cá hấp hành gừng",
            imageResId = R.drawable.ca_hap_hanh_gung,
            category = "Dinner",
            ingredients = listOf(
                "300g cá.",
                "50g hành.",
                "50g gừng.",
                "Gia vị: muối, tiêu."
            ),
            instructions = listOf(
                "1. Thái hành và gừng.",
                "2. Ướp cá với gia vị.",
                "3. Hấp cá với hành và gừng."
            )
        ),
        Meal(
            id = 21,
            name = "Cơm rang trứng",
            imageResId = R.drawable.com_rang_trung,
            category = "Dinner",
            ingredients = listOf(
                "2 chén cơm.",
                "2 quả trứng.",
                "Gia vị: muối, tiêu."
            ),
            instructions = listOf(
                "1. Đánh trứng và chiên.",
                "2. Thêm cơm vào xào.",
                "3. Nêm nếm vừa ăn."
            )
        ),
        Meal(
            id = 22,
            name = "Đậu hũ sốt cà chua",
            imageResId = R.drawable.dau_hu_sot_ca_chua,
            category = "Dinner",
            ingredients = listOf(
                "200g đậu hũ.",
                "100g cà chua.",
                "Gia vị: muối, đường."
            ),
            instructions = listOf(
                "1. Chiên đậu hũ cho vàng.",
                "2. Xào cà chua với gia vị.",
                "3. Thêm đậu hũ vào và nấu chín."
            )
        )
    )

    fun getMeals(category: String = "All"): List<Meal> {
        println("MealRepository: Fetching meals for category=$category")
        return if (category == "All") {
            meals
        } else {
            meals.filter { it.category == category }
        }.also {
            println("MealRepository: Returned meals=${it.map { it.id to it.name }}")
        }
    }

    fun getMealById(id: Int): Meal? {
        println("MealRepository: Fetching meal with id=$id")
        return meals.find { it.id == id }.also {
            println("MealRepository: Found meal=${it?.id to it?.name}")
        }
    }

    fun getRandomMeal(): Meal? {
        return meals.randomOrNull().also {
            println("MealRepository: Random meal=${it?.id to it?.name}")
        }
    }
}