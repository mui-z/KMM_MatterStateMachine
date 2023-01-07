package studio.sekai.matterstatemachine.feature.matter.actions

import ru.kontur.mobile.visualfsm.Transition
import studio.sekai.matterstatemachine.feature.matter.MatterState

class Refrigerate : MatterAction() {
    inner class Condense : Transition<MatterState.Gas, MatterState.Liquid>() {
        override fun transform(state: MatterState.Gas) = MatterState.Liquid
    }

    inner class Freeze : Transition<MatterState.Liquid, MatterState.Solid>() {
        override fun transform(state: MatterState.Liquid) = MatterState.Solid
    }
}
