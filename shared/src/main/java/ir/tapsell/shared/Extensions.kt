package ir.tapsell.shared

/**
 * Sorts all ad networks by their supported ad types.
 * It puts the ad network with most supported ad types at the top
 */
internal val List<TapsellKeys>.sorted get() =
    sortedByDescending { it::class.java.declaredFields.size }