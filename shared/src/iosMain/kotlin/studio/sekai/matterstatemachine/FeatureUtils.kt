package studio.sekai.matterstatemachine

import studio.sekai.matterstatemachine.feature.matter.MatterFeature

fun MatterFeature.watchState() = observeState().wrap()
