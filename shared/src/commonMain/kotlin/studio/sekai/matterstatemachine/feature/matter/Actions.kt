package studio.sekai.matterstatemachine.feature.matter

import ru.kontur.mobile.visualfsm.Action
import ru.kontur.mobile.visualfsm.Transition

sealed class MatterAction : Action<MatterState>()

class Heat : MatterAction() {
    inner class Melt : Transition<MatterState.Solid, MatterState.Liquid>() {
        override fun transform(state: MatterState.Solid) = MatterState.Liquid
    }

    inner class Vaporize : Transition<MatterState.Liquid, MatterState.Gas>() {
        override fun transform(state: MatterState.Liquid) = MatterState.Gas
    }
}

class Refrigerate : MatterAction() {
    inner class Condense : Transition<MatterState.Gas, MatterState.Liquid>() {
        override fun transform(state: MatterState.Gas) = MatterState.Liquid
    }

    inner class Freeze : Transition<MatterState.Liquid, MatterState.Solid>() {
        override fun transform(state: MatterState.Liquid) = MatterState.Solid
    }
}
