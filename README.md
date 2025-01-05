# Quest Runner: A Turn-Based Survival Game in Java

Quest Runner is a survival game where the player creates a team of characters and faces waves of enemies. The main goal is to survive as many waves as possible.

## Purpose
The main purpose of this game is to work on design patterns. The game uses multiple design patterns, such as Visitor, Strategy, Singleton, and others, to improve the structure and scalability of the code.

## How to Play

### Characters
Choose from 4 different characters:

- **King**:
    - HP: ++++
    - Damage: +
- **Sorcerer**:
    - HP: ++
    - Damage: +++
- **Warrior**:
    - HP: +++
    - Damage: +++
- **Healer**:
    - HP: +++
    - Damage: ++

Once you've created your team, the game progresses as a turn-based combat system, where you will face enemy teams. After each victory, the next enemy team will be stronger, with more health and damage, making each wave progressively harder.

### Modes
You can switch between different combat modes:

- **Attack Mode**: Increases damage dealt.
- **Defense Mode**: Reduces incoming damage.
- **Balanced Mode**: A mix of attack and defense.

### Enemies
Each wave will present a new set of enemies. With each victory, the next wave becomes progressively harder, with stronger enemies that have more health and attack power.

## Design Patterns Used
This game implements the following design patterns:
- [**Visitor**](https://refactoring.guru/design-patterns/visitor)
- [**Strategy**](https://refactoring.guru/design-patterns/strategy)
- [**Singleton**](https://refactoring.guru/design-patterns/singleton)
- [**Facade**](https://refactoring.guru/design-patterns/facade)
- [**Factory**](https://refactoring.guru/design-patterns/factory-method)
- [**State**](https://refactoring.guru/design-patterns/state)
- [**Composite**](https://refactoring.guru/design-patterns/composite)
- [**Command**](https://refactoring.guru/design-patterns/command)


### UML Diagrams

Each design patterns used in the project is represented by a [UML class diagramm](https://plantuml.com/en/class-diagram) in this [folder](/src/diagramme)

