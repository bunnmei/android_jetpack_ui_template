package com.example.android_jetpack_ui_template.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
//import androidx.compose.material3.rememberModalBottomSheetState

//@Composable
//fun BottomSheet() {
//    var openBottomSheet by rememberSaveable { mutableStateOf(false) }
//    var skipPartiallyExpanded by remember { mutableStateOf(false) }
//    var edgeToEdgeEnabled by remember { mutableStateOf(false) }
//    val scope = rememberCoroutineScope()
//    val bottomSheetState = rememberModalBottomSheetState(
//        skipPartiallyExpanded = skipPartiallyExpanded
//    )
//
//// App content
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Row(
//            Modifier.toggleable(
//                value = skipPartiallyExpanded,
//                role = Role.Checkbox,
//                onValueChange = { checked -> skipPartiallyExpanded = checked }
//            )
//        ) {
//            Checkbox(checked = skipPartiallyExpanded, onCheckedChange = null)
//            Spacer(Modifier.width(16.dp))
//            Text("Skip partially expanded State")
//        }
//        Row(
//            Modifier.toggleable(
//                value = edgeToEdgeEnabled,
//                role = Role.Checkbox,
//                onValueChange = { checked -> edgeToEdgeEnabled = checked }
//            )
//        ) {
//            Checkbox(checked = edgeToEdgeEnabled, onCheckedChange = null)
//            Spacer(Modifier.width(16.dp))
//            Text("Toggle edge to edge enabled.")
//        }
//        Button(onClick = { openBottomSheet = !openBottomSheet }) {
//            Text(text = "Show Bottom Sheet")
//        }
//    }
//
//// Sheet content
//    if (openBottomSheet) {
//        val windowInsets = if (edgeToEdgeEnabled)
//            WindowInsets(0) else BottomSheetDefaults.windowInsets
//
//        ModalBottomSheet(
//            onDismissRequest = { openBottomSheet = false },
//            sheetState = bottomSheetState,
//            windowInsets = windowInsets
//        ) {
//            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
//                Button(
//                    // Note: If you provide logic outside of onDismissRequest to remove the sheet,
//                    // you must additionally handle intended state cleanup, if any.
//                    onClick = {
//                        scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
//                            if (!bottomSheetState.isVisible) {
//                                openBottomSheet = false
//                            }
//                        }
//                    }
//                ) {
//                    Text("Hide Bottom Sheet")
//                }
//            }
//            var text by remember { mutableStateOf("") }
//            OutlinedTextField(value = text, onValueChange = { text = it })
//            LazyColumn {
//                items(50) {
//                    ListItem(
//                        headlineContent = { Text("Item $it") },
//                        leadingContent = {
//                            Icon(
//                                Icons.Default.Favorite,
//                                contentDescription = "Localized description"
//                            )
//                        }
//                    )
//                }
//            }
//        }
//    }
//}