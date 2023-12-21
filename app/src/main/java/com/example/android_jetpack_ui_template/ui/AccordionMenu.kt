package com.example.android_jetpack_ui_template.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_jetpack_ui_template.R

@Composable
fun AccordionMenu() {
    var expanded by remember { mutableStateOf(false) }
    Column {
        AccordionMenuTitle(isExpanded = expanded){
            expanded = !expanded
        }
        AnimatedVisibility(
            visible = expanded,
            enter = expandVertically(
                animationSpec = tween(durationMillis = 150)
            ),
            exit = shrinkVertically(
                animationSpec = tween(durationMillis = 150)
            )
        ) {
            Column {
                AccordionMenuItem()
                AccordionMenuItem()
                AccordionMenuItem()
                AccordionMenuItem()
            }

        }
    }
}

@Composable
fun AccordionMenuTitle(
    isExpanded: Boolean = false,
    onTapped: () -> Unit = {}
) {
    val degrees = if (isExpanded) 180f else 0f
    val interactionSource = MutableInteractionSource()
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.Cyan)
            .padding(10.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                onTapped()
            }
    ) {
        Icon(
            painter = painterResource(R.drawable.folder_24),
            contentDescription = "FolderName",
            modifier = Modifier.size(28.dp),
            tint = Color.Blue
        )
        Text(
            text = "AccrdionTitle",
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 10.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(R.drawable.arrow_down_24),
            contentDescription = "toggleArrow",
            modifier = Modifier
                .size(28.dp)
                .rotate(degrees),
        )
    }
}

@Composable
fun AccordionMenuItem() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.Gray)
            .padding(10.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.bookmark_24),
            contentDescription = "FolderName",
            modifier = Modifier.size(28.dp),
            tint = Color.White
        )
        Text(
            text = "AccrdionItem",
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 10.dp)
        )
    }
}
