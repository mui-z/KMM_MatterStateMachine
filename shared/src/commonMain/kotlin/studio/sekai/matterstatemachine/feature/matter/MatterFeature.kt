package studio.sekai.matterstatemachine.feature.matter

import ru.kontur.mobile.visualfsm.Feature
import ru.kontur.mobile.visualfsm.GenerateTransitionsFactory
import studio.sekai.matterstatemachine.feature.matter.actions.Heat
import studio.sekai.matterstatemachine.feature.matter.actions.MatterAction
import studio.sekai.matterstatemachine.feature.matter.actions.Refrigerate

@GenerateTransitionsFactory
class MatterFeature(initialState: MatterState) : Feature<MatterState, MatterAction>(
    initialState = initialState,
    asyncWorker = null,
    transitionsFactory = GeneratedMatterFeatureTransitionsFactory(),
) {
    fun heat() {
        proceed(Heat())
    }

    fun refrigerate() {
        proceed(Refrigerate())
    }
}
