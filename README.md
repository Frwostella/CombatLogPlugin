# ⚔️ CombatLogPlugin

A lightweight combat logging plugin for Minecraft Paper servers that prevents players from escaping fights unfairly.

---

## Features

- 🗡️ Combat tagging when players hit each other
- 🏹 Supports melee, bows, and tridents
- ⏳ Action bar countdown timer
- 🚫 Punishes players who log out during combat
- 💬 Clean messaging (no spam)
- ☠️ Combat ends when tagged player dies
- ⚙️ Configurable settings
- 🔄 Reload command support

---
## Supports 1.21.x Minecraft

---
## Installation

1. Download the latest `.jar` file
2. Put it in your `/plugins` folder
3. Start or restart your server
4. Configure `config.yml` to your liking

---

## Commands

| Command | Description |
|--------|-------------|
| `/combatlog reload` | Reloads the plugin configuration |

---

## Permissions

| Permission | Description |
|-----------|-------------|
| `combatlog.reload` | Allows use of reload command |

---

## Configuration

Example `config.yml`:

```yml
combat-time: 15
actionbar: true
punish-command: "kill %player%"
