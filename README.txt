PerfPlus - Minecraft Fabric client mod starter
Target: Minecraft 26.1.2, Fabric Loader 0.20.1, Java 25.

This ZIP is a cleaned starter project, not a verified compiled JAR.
It currently contains the ClickGUI and example module framework, with AutoSprint.
The supplied source document's combat automation and custom ESP renderer were not
silently copied because the ESP section itself marks a broken vertex loop and
several 26.1.2 API names as unverified. They need a compile-and-test pass first.

Build on a machine with JDK 25 and internet access:
  gradle wrapper --gradle-version 9.1.0
  ./gradlew build

Expected output if the build succeeds:
  build/libs/perfplus-1.1.0.jar

Install that JAR in the Minecraft 26.1.2 Fabric instance's mods folder.
Press Right Shift in-game to open the GUI.
