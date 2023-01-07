# MatterStateMachine

The simple matter state machine.  
Made with KMM and [VisualFSM](https://github.com/Kontur-Mobile/VisualFSM).

## Demo

<img width=250 src=https://user-images.githubusercontent.com/93278577/211149327-06f97a26-e16c-47aa-bf31-789d87ba0956.gif />

### graph
```mermaid

stateDiagram-v2
direction LR
Liquid --> Gas : Vaporize
Gas --> Liquid : Condense
Solid --> Liquid : Melt
Liquid --> Solid : Freeze
```

## Todo

- [ ] Create Android View.
