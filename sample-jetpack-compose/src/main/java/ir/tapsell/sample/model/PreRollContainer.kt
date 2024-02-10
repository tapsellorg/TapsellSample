package ir.tapsell.sample.model

import android.view.ViewGroup
import androidx.media3.ui.PlayerView

data class PreRollContainer(
    val player: ViewGroup,
    val companion: ViewGroup,
    val playerView: PlayerView
) {
    companion object {
        fun from(player: ViewGroup, companion: ViewGroup, playerView: PlayerView) =
            PreRollContainer(
                player = player,
                companion = companion,
                playerView = playerView
            )
    }
}