package studio.sekai.matterstatemachine.feature.matter.actions

import ru.kontur.mobile.visualfsm.Action
import studio.sekai.matterstatemachine.feature.matter.MatterState

sealed class MatterAction : Action<MatterState>()
