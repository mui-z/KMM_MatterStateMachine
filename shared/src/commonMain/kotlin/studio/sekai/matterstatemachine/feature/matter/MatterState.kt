package studio.sekai.matterstatemachine.feature.matter

import ru.kontur.mobile.visualfsm.State

sealed class MatterState : State {
    object Solid : MatterState()

    object Liquid : MatterState()

    object Gas : MatterState()
}
