package ir.tapsell.sample.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ir.tapsell.shared.TestTags

@Composable
fun LogText(
    text: String,
    modifier: Modifier = Modifier
) {
    Box(modifier = Modifier.padding(8.dp)) {
        Text(
            modifier = modifier
                .testTag(TestTags.Log)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .padding(4.dp),
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Start,
            maxLines = 5
        )
    }
}
