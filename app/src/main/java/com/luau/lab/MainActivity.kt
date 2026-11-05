package com.luau.lab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luau.lab.runtime.NativeBridge

private val Background = Color(0xFF090B12)
private val Panel = Color(0xFF151927)
private val Accent = Color(0xFF9B7BFF)
private val Muted = Color(0xFF9299AD)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(
                colorScheme = darkColorScheme(
                    primary = Accent,
                    background = Background,
                    surface = Panel
                )
            ) {
                LuauLabScreen()
            }
        }
    }
}

@Composable
private fun LuauLabScreen() {
    var selectedTab by remember { mutableStateOf("EDITOR") }
    var source by remember {
        mutableStateOf("print(\\"Hello from Luau Lab!\\")\\n\\nlocal message = \\"Welcome\\"\\nprint(message)")
    }
    var output by remember { mutableStateOf("Luau Lab initialized.\\nNative bridge: checking...") }

    LaunchedEffect(Unit) {
        output = try {
            "Native bridge connected.\\n${NativeBridge.engineVersion()}"
        } catch (error: Exception) {
            "Native bridge unavailable: ${error.message}"
        }
    }

    Column(
        Modifier.fillMaxSize().background(Background).padding(16.dp)
    ) {
        Text("LUAU LAB", color = Color.White, fontSize = 25.sp)
        Text("ANDROID DEVELOPMENT STUDIO", color = Accent, fontSize = 10.sp)
        Spacer(Modifier.height(20.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf("EDITOR", "GUI STUDIO", "DOCS").forEach { tab ->
                FilterChip(
                    selected = selectedTab == tab,
                    onClick = { selectedTab = tab },
                    label = { Text(tab) }
                )
            }
        }

        Spacer(Modifier.height(16.dp))

        when (selectedTab) {
            "EDITOR" -> {
                Text("main.luau", color = Muted)
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(
                    value = source,
                    onValueChange = { source = it },
                    modifier = Modifier.weight(1f).fillMaxWidth(),
                    textStyle = LocalTextStyle.current.copy(
                        fontFamily = FontFamily.Monospace,
                        fontSize = 14.sp,
                        color = Color(0xFFE2E5F0)
                    ),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Accent,
                        unfocusedBorderColor = Panel,
                        cursorColor = Accent
                    )
                )
                Spacer(Modifier.height(10.dp))
                Button(
                    onClick = {
                        output = "Runtime integration is the next milestone.\\nSource length: ${source.length} characters."
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("RUN")
                }
                Spacer(Modifier.height(12.dp))
                Text("OUTPUT", color = Accent)
                Text(
                    output,
                    color = Color(0xFFB9C2D8),
                    fontFamily = FontFamily.Monospace,
                    modifier = Modifier.fillMaxWidth()
                        .background(Panel, RoundedCornerShape(12.dp))
                        .padding(12.dp)
                )
            }
            "GUI STUDIO" -> {
                Text("GUI Studio foundation", color = Color.White, fontSize = 20.sp)
                Text(
                    "The independent UI simulator will be built here.",
                    color = Muted
                )
                Spacer(Modifier.height(20.dp))
                Box(
                    Modifier.fillMaxWidth().weight(1f)
                        .background(Panel, RoundedCornerShape(16.dp))
                        .padding(20.dp)
                ) {
                    Text("Preview Canvas", color = Muted)
                }
            }
            else -> {
                Column(Modifier.verticalScroll(rememberScrollState())) {
                    Text("Welcome to Luau Lab", color = Color.White, fontSize = 22.sp)
                    Spacer(Modifier.height(12.dp))
                    Text(
                        "An independent, open-source Luau development environment for Android.",
                        color = Muted
                    )
                    Spacer(Modifier.height(12.dp))
                    Text("Version 0.1.0", color = Accent)
                    Text("The native bridge is a foundation, not the full Luau runtime yet.", color = Muted)
                }
            }
        }
    }
}
