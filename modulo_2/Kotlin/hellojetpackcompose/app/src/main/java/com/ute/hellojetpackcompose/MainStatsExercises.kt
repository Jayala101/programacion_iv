package com.ute.hellojetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class StatsScreen(val route: String) {
    object Home : StatsScreen("stats_home")
    object Grades : StatsScreen("grades")
    object Savings : StatsScreen("savings")
}

class MainStatsExercises : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { StatsNavApp() }
    }
}

@Composable
fun StatsNavApp() {
    val nav = rememberNavController()
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            NavHost(
                navController = nav,
                startDestination = StatsScreen.Home.route
            ) {
                composable(StatsScreen.Home.route) { StatsHomeScreen(nav) }
                composable(StatsScreen.Grades.route) { GradesScreen(nav) }
                composable(StatsScreen.Savings.route) { SavingsScreen(nav) }
                composable(StatsScreen.Calc.route) { Calculator(nav) }
            }
        }
    }
}

@Composable
fun StatsHomeScreen(nav: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Simple Stats Exercises",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(20.dp))
        Button(
            onClick = { nav.navigate(StatsScreen.Grades.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Grades Average")
        }
        Spacer(Modifier.height(12.dp))
        Button(
            onClick = { nav.navigate(StatsScreen.Savings.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Savings Planner")
        }
        Spacer(Modifier.height(12.dp))
        Button(
            onClick = { nav.navigate(StatsScreen.Calc.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Arithmetic operator")
        }
    }
}

@Composable
fun GradesScreen(nav: NavController) {
    var grade1 by remember { mutableStateOf("") }
    var grade2 by remember { mutableStateOf("") }
    var grade3 by remember { mutableStateOf("") }

    val average = statsAverage(grade1, grade2, grade3)
    val message = when {
        average == 0.0 -> "Enter valid grades"
        average >= 9.0 -> "Excellent"
        average >= 7.0 -> "Good"
        average >= 5.0 -> "Needs improvement"
        else -> "Failed"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Grades Average",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = grade1,
            onValueChange = { grade1 = it },
            label = { Text("Grade 1") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = grade2,
            onValueChange = { grade2 = it },
            label = { Text("Grade 2") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = grade3,
            onValueChange = { grade3 = it },
            label = { Text("Grade 3") },
            modifier = Modifier.fillMaxWidth()
        )

        Text("Average = ${"%.2f".format(average)}")
        Text(message)

        Button(
            onClick = { nav.navigateUp() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back")
        }
    }
}

@Composable
fun SavingsScreen(nav: NavController) {
    var goal by remember { mutableStateOf("") }
    var perMonth by remember { mutableStateOf("") }

    val months = savingMonths(goal, perMonth)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Savings Planner",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = goal,
            onValueChange = { goal = it },
            label = { Text("Goal amount ($)") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = perMonth,
            onValueChange = { perMonth = it },
            label = { Text("Save per month ($)") },
            modifier = Modifier.fillMaxWidth()
        )

        Text("Months needed = ${"%.1f".format(months)}")

        Button(
            onClick = { nav.navigateUp() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back")
        }
    }
}

@Composable
fun Calculator(nav: NavController) {
    var value1 by remember { mutableStateOf("") }
    var value2 by remember { mutableStateOf("") }
    var value3 by remember { mutableStateOf("") }

    val average = statsArithmetic(value1, value2, value3)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Grades Average",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = value1,
            onValueChange = { value1 = it },
            label = { Text("Grade 1") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = value2,
            onValueChange = { value2 = it },
            label = { Text("Grade 2") },
            modifier = Modifier.fillMaxWidth()
        )

        Text("Average = ${"%.2f".format(average)}")

        Button(
            onClick = { nav.navigateUp() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back")
        }
    }
}

fun statsAverage(g1: String, g2: String, g3: String): Double {
    val n1 = g1.replace(",", ".").toDoubleOrNull() ?: 0.0
    val n2 = g2.replace(",", ".").toDoubleOrNull() ?: 0.0
    val n3 = g3.replace(",", ".").toDoubleOrNull() ?: 0.0
    if (n1 == 0.0 && n2 == 0.0 && n3 == 0.0) return 0.0
    return (n1 + n2 + n3) / 3.0
}

fun statsArithmetic(x1: String, y2: String, op: String): Double? {

    val x = x1.replace(",", ".").toDoubleOrNull()
    val y = y2.replace(",", ".").toDoubleOrNull()

    if (x == null || y == null) return null

    return when (op) {
        "+" -> x + y
        "-" -> x - y
        "*" -> x * y
        "/" -> x / y
        else -> null
    }
}


fun savingMonths(goal: String, perMonth: String): Double {
    val g = goal.replace(",", ".").toDoubleOrNull() ?: 0.0
    val m = perMonth.replace(",", ".").toDoubleOrNull() ?: 0.0
    if (g <= 0.0 || m <= 0.0) return 0.0
    return g / m
}

@Preview(showBackground = true)
@Composable
fun PreviewStatsNav() {
    StatsNavApp()
}