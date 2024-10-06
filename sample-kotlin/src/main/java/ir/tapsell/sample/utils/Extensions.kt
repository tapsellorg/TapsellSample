package ir.tapsell.sample.utils

import android.content.Context
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import ir.tapsell.sample.R
import ir.tapsell.shared.TapsellKeys


fun ChipGroup.addChip(context: Context, name: String, onCheckedChange: (Boolean) -> Unit = {}) {
    addView(
        Chip(context).apply {
            isClickable = true; isCheckable = true
            setTextColor(resources.getColor(R.color.purple_500))
            setChipStrokeColorResource(R.color.purple_500)
            chipStrokeWidth = 0.5F
            text = name.also { adNetworkName ->
                // enable "AllAdNetworks" chip by default
                if (adNetworkName == TapsellKeys.TapsellMediationKeys.name) {
                    isChecked = true
                }
            }
            setOnCheckedChangeListener { _, checked ->
                onCheckedChange(checked)
            }
        })
}


