package com.ute.vuelos_aeropuerto_kt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.*
import com.ute.vuelos_aeropuerto_kt.ui.theme.VuelosAeropuertoKtTheme

// Modelo de datos para vuelos
data class Flight(
    val id: Int,
    val flightNumber: String,
    val airline: String,
    val origin: String,
    val destination: String,
    val departureTime: String,
    val arrivalTime: String,
    val gate: String,
    val status: FlightStatus,
    val terminal: String = "T1"
)

enum class FlightStatus(val displayName: String, val color: Color) {
    ON_TIME("A Tiempo", Color(0xFF4CAF50)),
    DELAYED("Retrasado", Color(0xFFFFC107)),
    BOARDING("Abordando", Color(0xFF2196F3)),
    DEPARTED("Despegado", Color(0xFF9E9E9E)),
    CANCELLED("Cancelado", Color(0xFFF44336))
}

// Rutas de navegación
sealed class Screen(val route: String, val label: String) {
    data object Departures : Screen("departures", "Salidas")
    data object Arrivals : Screen("arrivals", "Llegadas")
    data object Search : Screen("search", "Buscar")
    data object Info : Screen("info", "Info")
    companion object { val all = listOf(Departures, Arrivals, Search, Info) }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VuelosAeropuertoKtTheme {
                AirportApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AirportApp() {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route ?: Screen.Departures.route

    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Column {
                        Text("✈️ Aeropuerto UTE", style = MaterialTheme.typography.titleLarge)
                        Text(
                            getTitleForRoute(currentRoute),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        bottomBar = {
            NavigationBar {
                Screen.all.forEach { screen ->
                    if (screen != null) {
                        val selected = currentRoute == screen.route
                        NavigationBarItem(
                            selected = selected,
                            onClick = {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) { 
                                        saveState = true 
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = { Icon(getIconForScreen(screen), contentDescription = screen.label) },
                            label = { Text(screen.label) }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Departures.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Departures.route) { DeparturesScreen() }
            composable(Screen.Arrivals.route) { ArrivalsScreen() }
            composable(Screen.Search.route) { SearchScreen() }
            composable(Screen.Info.route) { InfoScreen() }
        }
    }
}

fun getTitleForRoute(route: String): String = when (route) {
    Screen.Departures.route -> "Vuelos de Salida"
    Screen.Arrivals.route -> "Vuelos de Llegada"
    Screen.Search.route -> "Buscar Vuelo"
    Screen.Info.route -> "Información del Aeropuerto"
    else -> "Aeropuerto"
}

fun getIconForScreen(screen: Screen) = when (screen) {
    Screen.Departures -> Icons.AutoMirrored.Filled.Send
    Screen.Arrivals -> Icons.Default.Home
    Screen.Search -> Icons.Default.Search
    Screen.Info -> Icons.Default.Info
}

// Pantalla de Salidas
@Composable
fun DeparturesScreen() {
    val flights = remember {
        listOf(
            Flight(1, "IB304", "Iberia", "Madrid", "New York", "14:30", "18:45", "A12", FlightStatus.ON_TIME),
            Flight(2, "AA101", "American Airlines", "Madrid", "Miami", "15:15", "19:30", "B4", FlightStatus.BOARDING, "T2"),
            Flight(3, "LH205", "Lufthansa", "Madrid", "Frankfurt", "16:00", "18:20", "C7", FlightStatus.DELAYED),
            Flight(4, "BA890", "British Airways", "Madrid", "London", "17:30", "19:00", "A5", FlightStatus.ON_TIME),
            Flight(5, "AF452", "Air France", "Madrid", "Paris", "18:00", "19:45", "B12", FlightStatus.CANCELLED, "T2"),
            Flight(6, "DL123", "Delta", "Madrid", "Atlanta", "19:15", "23:30", "C3", FlightStatus.ON_TIME)
        )
    }

    FlightListScreen(flights, isDeparture = true)
}

// Pantalla de Llegadas
@Composable
fun ArrivalsScreen() {
    val flights = remember {
        listOf(
            Flight(7, "IB305", "Iberia", "New York", "Madrid", "10:30", "14:45", "A8", FlightStatus.DEPARTED),
            Flight(8, "AA102", "American Airlines", "Miami", "Madrid", "11:15", "15:30", "B6", FlightStatus.ON_TIME, "T2"),
            Flight(9, "LH206", "Lufthansa", "Frankfurt", "Madrid", "12:00", "14:20", "C9", FlightStatus.DELAYED),
            Flight(10, "BA891", "British Airways", "London", "Madrid", "13:30", "15:00", "A3", FlightStatus.BOARDING),
            Flight(11, "AF453", "Air France", "Paris", "Madrid", "14:00", "15:45", "B10", FlightStatus.ON_TIME, "T2")
        )
    }

    FlightListScreen(flights, isDeparture = false)
}

@Composable
fun FlightListScreen(flights: List<Flight>, isDeparture: Boolean) {
    var selectedFlight by remember { mutableStateOf<Flight?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Leyenda de estados
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                FlightStatus.entries.forEach { status ->
                    StatusBadge(status)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Lista de vuelos
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(items = flights, key = { it.id }) { flight ->
                FlightCard(
                    flight = flight,
                    isDeparture = isDeparture,
                    onClick = { selectedFlight = flight }
                )
            }
        }

        // Detalles del vuelo seleccionado
        selectedFlight?.let { flight ->
            Spacer(modifier = Modifier.height(8.dp))
            FlightDetailsCard(flight, onDismiss = { selectedFlight = null })
        }
    }
}

@Composable
fun FlightCard(flight: Flight, isDeparture: Boolean, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = flight.flightNumber,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(flight.status.color)
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = flight.status.displayName,
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                
                Spacer(modifier = Modifier.height(4.dp))
                
                Text(
                    text = flight.airline,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = if (isDeparture) flight.origin else flight.destination,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Medium
                    )
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = "to",
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = if (isDeparture) flight.destination else flight.origin,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
            
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = if (isDeparture) flight.departureTime else flight.arrivalTime,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "Puerta ${flight.gate}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = flight.terminal,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }
        }
    }
}

@Composable
fun FlightDetailsCard(flight: Flight, onDismiss: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Detalles del Vuelo",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                IconButton(onClick = onDismiss) {
                    Icon(Icons.Default.Close, contentDescription = "Cerrar")
                }
            }
            
            HorizontalDivider()
            
            DetailRow("Número de Vuelo:", flight.flightNumber)
            DetailRow("Aerolínea:", flight.airline)
            DetailRow("Origen:", flight.origin)
            DetailRow("Destino:", flight.destination)
            DetailRow("Salida:", flight.departureTime)
            DetailRow("Llegada:", flight.arrivalTime)
            DetailRow("Puerta:", flight.gate)
            DetailRow("Terminal:", flight.terminal)
            DetailRow("Estado:", flight.status.displayName)
        }
    }
}

@Composable
fun DetailRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.7f)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun StatusBadge(status: FlightStatus) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Box(
            modifier = Modifier
                .size(8.dp)
                .clip(CircleShape)
                .background(status.color)
        )
        Text(
            text = status.displayName,
            style = MaterialTheme.typography.labelSmall
        )
    }
}

// Pantalla de Búsqueda
@Composable
fun SearchScreen() {
    var searchQuery by rememberSaveable { mutableStateOf("") }
    var searchResults by remember { mutableStateOf<List<Flight>>(emptyList()) }

    val allFlights = remember {
        listOf(
            Flight(1, "IB304", "Iberia", "Madrid", "New York", "14:30", "18:45", "A12", FlightStatus.ON_TIME),
            Flight(2, "AA101", "American Airlines", "Madrid", "Miami", "15:15", "19:30", "B4", FlightStatus.BOARDING),
            Flight(7, "IB305", "Iberia", "New York", "Madrid", "10:30", "14:45", "A8", FlightStatus.DEPARTED),
            Flight(8, "AA102", "American Airlines", "Miami", "Madrid", "11:15", "15:30", "B6", FlightStatus.ON_TIME)
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { 
                searchQuery = it
                searchResults = if (it.isNotBlank()) {
                    allFlights.filter { flight ->
                        flight.flightNumber.contains(it, ignoreCase = true) ||
                        flight.destination.contains(it, ignoreCase = true) ||
                        flight.origin.contains(it, ignoreCase = true)
                    }
                } else emptyList()
            },
            label = { Text("Buscar vuelo") },
            placeholder = { Text("Número de vuelo, origen o destino") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Buscar") },
            trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                    IconButton(onClick = { 
                        searchQuery = ""
                        searchResults = emptyList()
                    }) {
                        Icon(Icons.Default.Clear, contentDescription = "Limpiar")
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        if (searchQuery.isEmpty()) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = null,
                        modifier = Modifier.size(48.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "Busca tu vuelo",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        "Ingresa número de vuelo, ciudad de origen o destino",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                    )
                }
            }
        } else if (searchResults.isEmpty()) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.errorContainer)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        Icons.Default.Warning,
                        contentDescription = null,
                        modifier = Modifier.size(48.dp),
                        tint = MaterialTheme.colorScheme.error
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "No se encontraron vuelos",
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        } else {
            Text(
                "${searchResults.size} resultado(s) encontrado(s)",
                style = MaterialTheme.typography.titleMedium
            )
            
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(searchResults) { flight ->
                    FlightCard(flight, isDeparture = true, onClick = {})
                }
            }
        }
    }
}

// Pantalla de Información
@Composable
fun InfoScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "✈️",
                        style = MaterialTheme.typography.displayLarge
                    )
                    Text(
                        "Aeropuerto UTE",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        "Sistema de Información de Vuelos",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }

        item {
            InfoSectionCard(
                title = "Servicios",
                icon = Icons.Default.Star,
                items = listOf(
                    "WiFi gratuito en todas las terminales",
                    "Salas VIP disponibles",
                    "Restaurantes y cafeterías",
                    "Tiendas duty-free",
                    "Servicios médicos 24/7"
                )
            )
        }

        item {
            InfoSectionCard(
                title = "Información General",
                icon = Icons.Default.Info,
                items = listOf(
                    "Terminal 1: Vuelos nacionales",
                    "Terminal 2: Vuelos internacionales",
                    "Check-in: 2 horas antes del vuelo",
                    "Puerta de embarque: 45 min antes",
                    "Contacto: +34 900 123 456"
                )
            )
        }

        item {
            InfoSectionCard(
                title = "Transporte",
                icon = Icons.Default.LocationOn,
                items = listOf(
                    "Metro: Línea 8 (cada 15 min)",
                    "Autobuses: Líneas 101, 200, 203",
                    "Taxis disponibles 24/7",
                    "Parking: P1, P2, P3 (Larga estancia)",
                    "Alquiler de coches en Terminal 1"
                )
            )
        }
    }
}

@Composable
fun InfoSectionCard(title: String, icon: androidx.compose.ui.graphics.vector.ImageVector, items: List<String>) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(icon, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                Text(
                    title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
            }
            
            HorizontalDivider()
            
            items.forEach { item ->
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text("•", style = MaterialTheme.typography.bodyMedium)
                    Text(
                        item,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AirportAppPreview() {
    VuelosAeropuertoKtTheme {
        AirportApp()
    }
}
