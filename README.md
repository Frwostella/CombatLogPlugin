# ⚔️ CombatLogPlugin

A lightweight combat logging plugin for Minecraft Paper servers that prevents players from escaping fights unfairly.

CombatLogPlugin tags players when they fight, shows an action bar countdown, and punishes players who log out while still in combat.

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
- 🧱 Build profile support for Paper 1.21.11 and Paper 26.1+

---

## Version Support

CombatLogPlugin can be built for both Paper 1.21.11 and newer Paper 26.1+ versions.

| Target | Java | Maven Profile |
|---|---|---|
| Paper 1.21.11 | Java 21 | `paper-1.21.11` |
| Paper 26.1+ | Java 25 | `paper-26.1-plus` |

Build for Paper 1.21.11:

```bash
mvn clean package
```

or:

```bash
mvn clean package -Ppaper-1.21.11
```

Build for Paper 26.1+:

```bash
mvn clean package -Ppaper-26.1-plus
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

- Paper 1.21.11 with Java 21, or Paper 26.1+ with Java 25

---

## Package Name

```txt
jre.frwostella.combatLogPlugin
```

---

## Author

Made by Frwostella.
