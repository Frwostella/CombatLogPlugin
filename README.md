# ⚔️ CombatLogPlugin

A lightweight combat logging plugin for Minecraft Paper servers that prevents players from escaping fights unfairly.

CombatLogPlugin tags players when they fight, shows an action bar countdown, and punishes players who log out while still in combat.

> **Current version support:** CombatLogPlugin is now updated to support **Paper 26.1+**.
>
> Looking for **Paper 1.21+ / 1.21.11 support**? Download release `1.1` here:
> https://github.com/Frwostella/CombatLogPlugin/releases/tag/1.1

---

## Features

- 🗡️ Combat tagging when players hit each other
- 🏹 Supports melee, bows, and tridents
- ⏳ Action bar countdown timer
- 🚫 Punishes players who log out during combat
- 💬 Clean messaging with less spam
- ☠️ Combat ends when the tagged player dies
- 🛫 Can block Elytra usage while in combat
- ⚙️ Configurable settings
- 🔄 Reload command support
- 🧩 Compatible with TogglePVPCustom combat checks
- 🧱 Current release support for Paper 26.1+

---

## Version Support

The current version of CombatLogPlugin supports **Paper 26.1+** and should be built or used with **Java 25**.

| Target | Java | Status |
|---|---|---|
| Paper 26.1+ | Java 25 | Current version |
| Paper 1.21+ / 1.21.11 | Java 21 | Use release `1.1` |

For Paper 1.21+ / 1.21.11 support, download release `1.1` here:

```txt
https://github.com/Frwostella/CombatLogPlugin/releases/tag/1.1
```

Build the current Paper 26.1+ version:

```bash
mvn clean package
```

For the Paper 26.1+ build, make sure Maven is running with JDK 25:

```bash
mvn -version
```

The output should show Java version 25.

---

## Installation

1. Download or build the latest `.jar` file.
2. Put it in your server's `plugins` folder.
3. Start or restart your server.
4. Configure `config.yml` to your liking.
5. Use `/combatlog reload` after editing the config.

For Paper 1.21+ / 1.21.11 servers, use release `1.1` instead:

```txt
https://github.com/Frwostella/CombatLogPlugin/releases/tag/1.1
```

---

## Commands

| Command | Description |
|---|---|
| `/combatlog reload` | Reloads the plugin configuration |

---

## Permissions

| Permission | Description | Default |
|---|---|---|
| `combatlog.reload` | Allows use of the reload command | OP |

---

## Configuration

Example `config.yml`:

```yml
combat-time: 15
logout-action: "kill"
logout-command: "kill %player%"

messages:
  tagged: "&cYou are now in combat! Do not log out."
  safe: "&aYou are no longer in combat."
  actionbar: "&cCombat: &e%time%s"
```

Config options may vary depending on your current plugin version.

---

## TogglePVPCustom Support

CombatLogPlugin can be used with Frwostella's TogglePVPCustom plugin:

```txt
https://github.com/Frwostella/TogglePVPCustom
```

When TogglePVPCustom's CombatLog hook is enabled, players cannot disable PvP while they are combat tagged.

---

## Requirements

- Paper 26.1+
- Java 25

For Paper 1.21+ / 1.21.11 support, use release `1.1`:

```txt
https://github.com/Frwostella/CombatLogPlugin/releases/tag/1.1
```

---

## Package Name

```txt
jre.frwostella.combatLogPlugin
```

---

## Author

Made by Frwostella.
