package net.botwithus;

import net.botwithus.rs3.imgui.ImGui;
import net.botwithus.rs3.imgui.ImGuiWindowFlag;
import net.botwithus.rs3.script.ScriptConsole;
import net.botwithus.rs3.script.ScriptGraphicsContext;

import static net.botwithus.rs3.script.ScriptConsole.println;

public class AntanhasElderTreesGraphicsContext extends ScriptGraphicsContext {

    private AntanhasElderTrees script;

    public AntanhasElderTreesGraphicsContext(ScriptConsole scriptConsole, AntanhasElderTrees script) {
        super(scriptConsole);
        this.script = script;
    }

    @Override
    public void drawSettings() {
        if (ImGui.Begin("Antanha's elder trees", ImGuiWindowFlag.None.getValue())) {
            ImGui.Text("Script state: " + script.getBotState());
            ImGui.BeginDisabled(script.getBotState() != AntanhasElderTrees.BotState.STOPPED);
            if (ImGui.Button("Start")) {
                //button has been clicked
                script.setBotState(AntanhasElderTrees.BotState.SETUP);
            }
            ImGui.EndDisabled();
            ImGui.SameLine();
            ImGui.BeginDisabled(script.getBotState() == AntanhasElderTrees.BotState.STOPPED);
            if (ImGui.Button("Stop")) {
                //has been clicked
                script.setBotState(AntanhasElderTrees.BotState.STOPPED);
            }
            ImGui.EndDisabled();
            ImGui.Separator();
            ImGui.Text("Instructions:");
            ImGui.Text("Requires War's Retreat teleport to be unlocked or that you have Ring of Fortune or Luck of the Dwarves equipped.");
            ImGui.Text("It'll pick bird's nests up, and it'll use decorated urns and/or wood box if you leave them in your inventory.");
            ImGui.Text("Make sure your backpack and magic (if using War's Retreat teleport) or equipment (if using Ring of Fortune or Luck of the Dwarves) menus are open, then start the script.");
            ImGui.End();
        }

    }

    @Override
    public void drawOverlay() {
        super.drawOverlay();
    }
}
