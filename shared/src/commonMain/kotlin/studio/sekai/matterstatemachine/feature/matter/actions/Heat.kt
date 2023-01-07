package studio.sekai.matterstatemachine.feature.matter.actions

import ru.kontur.mobile.visualfsm.Transition
import studio.sekai.matterstatemachine.feature.matter.MatterState


class Heat : MatterAction() {
    inner class Melt : Transition<MatterState.Solid, MatterState.Liquid>() {
        override fun transform(state: MatterState.Solid) = MatterState.Liquid
    }

    inner class Vaporize : Transition<MatterState.Liquid, MatterState.Gas>() {
        override fun transform(state: MatterState.Liquid) = MatterState.Gas
    }
}

