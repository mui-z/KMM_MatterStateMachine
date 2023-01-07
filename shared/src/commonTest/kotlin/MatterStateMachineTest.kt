import studio.sekai.matterstatemachine.feature.matter.MatterState
import studio.sekai.matterstatemachine.feature.matter.actions.MatterAction
import kotlin.test.Test
import kotlin.test.assertTrue
import ru.kontur.mobile.visualfsm.tools.VisualFSM

class MatterStateMachineTest {
    @Test
    fun generateDigraph() {
        println(
            VisualFSM.generateDigraph(
                baseAction = MatterAction::class,
                baseState = MatterState::class,
                initialState = MatterState.Solid::class,
            )
        )
        assertTrue(true)
    }

//    @Test
//    fun allStatesReachableTest() {
//        val notReachableStates = VisualFSM.getUnreachableStates(
//            baseAction = MatterAction::class,
//            baseState = MatterState::class,
//            initialState = MatterState.Solid::class,
//        )
//
//        assertTrue(
//            "FSM have unreachable states: ${notReachableStates.joinToString(", ")}",
//            notReachableStates.isEmpty()
//        )
//    }
//
//    @Test
//    fun noFinalStateTest() {
//        val finalStates = VisualFSM.getFinalStates(
//            baseAction = MatterAction::class,
//            baseState = MatterState::class,
//        )
//
//        assertTrue(
//            "FSM have not correct final states: ${finalStates.joinToString(", ")}",
//            finalStates.isEmpty()
//        )
//    }
}
