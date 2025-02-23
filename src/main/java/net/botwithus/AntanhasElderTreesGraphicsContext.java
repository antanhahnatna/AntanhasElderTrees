package net.botwithus;

import net.botwithus.rs3.game.skills.Skills;
import net.botwithus.rs3.imgui.ImGui;
import net.botwithus.rs3.imgui.ImGuiWindowFlag;
import net.botwithus.rs3.script.ScriptConsole;
import net.botwithus.rs3.script.ScriptGraphicsContext;

import java.util.LinkedList;

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
            if (ImGui.BeginTabBar("My bar", ImGuiWindowFlag.None.getValue())) {
                if (ImGui.BeginTabItem("Main", ImGuiWindowFlag.None.getValue())) {
                    ImGui.Text("Script state: " + script.getBotState());
                    ImGui.BeginDisabled(script.getBotState() != AntanhasElderTrees.BotState.STOPPED);
                    if (ImGui.Button("Start")) {
                        //button has been clicked
                        script.setBotState(AntanhasElderTrees.BotState.SETUP);
                        script.logNames = new LinkedList<>();
                        script.logAmounts = new LinkedList<>();
                        script.experienceGained = 0;
                        script.startingTime = System.currentTimeMillis();
                    }
                    ImGui.EndDisabled();
                    ImGui.SameLine();
                    ImGui.BeginDisabled(script.getBotState() == AntanhasElderTrees.BotState.STOPPED);
                    if (ImGui.Button("Stop")) {
                        //has been clicked
                        script.setBotState(AntanhasElderTrees.BotState.STOPPED);
                        script.timeScriptWasLastActive = System.currentTimeMillis();
                    }
                    ImGui.EndDisabled();
                    ImGui.BeginDisabled(script.getBotState() != AntanhasElderTrees.BotState.STOPPED);
                    script.setPickUpBirdsNests(ImGui.Checkbox("Pick bird's nests up?", script.getPickUpBirdsNests()));
                    ImGui.Text("Select at least 3 elder trees:");
                    script.checkboxesOfElderTreesToPickFrom[0] = ImGui.Checkbox("Varrock", script.checkboxesOfElderTreesToPickFrom[0]);
                    script.checkboxesOfElderTreesToPickFrom[1] = ImGui.Checkbox("Edgeville", script.checkboxesOfElderTreesToPickFrom[1]);
                    script.checkboxesOfElderTreesToPickFrom[2] = ImGui.Checkbox("Yanille", script.checkboxesOfElderTreesToPickFrom[2]);
                    script.checkboxesOfElderTreesToPickFrom[3] = ImGui.Checkbox("Legends' Guild", script.checkboxesOfElderTreesToPickFrom[3]);
                    script.checkboxesOfElderTreesToPickFrom[4] = ImGui.Checkbox("Tree Gnome Stronghold", script.checkboxesOfElderTreesToPickFrom[4]);
                    script.checkboxesOfElderTreesToPickFrom[5] = ImGui.Checkbox("Piscatoris Hunter area", script.checkboxesOfElderTreesToPickFrom[5]);
                    script.checkboxesOfElderTreesToPickFrom[6] = ImGui.Checkbox("Draynor", script.checkboxesOfElderTreesToPickFrom[6]);
                    script.checkboxesOfElderTreesToPickFrom[7] = ImGui.Checkbox("Rimmington", script.checkboxesOfElderTreesToPickFrom[7]);
                    script.checkboxesOfElderTreesToPickFrom[8] = ImGui.Checkbox("Falador", script.checkboxesOfElderTreesToPickFrom[8]);
                    script.checkboxesOfElderTreesToPickFrom[9] = ImGui.Checkbox("Lletya", script.checkboxesOfElderTreesToPickFrom[9]);
                    script.checkboxesOfElderTreesToPickFrom[10] = ImGui.Checkbox("Grove (requires tier 3 cabin)", script.checkboxesOfElderTreesToPickFrom[10]);
                    script.checkboxesOfElderTreesToPickFrom[11] = ImGui.Checkbox("Prifddinas (requires planting)", script.checkboxesOfElderTreesToPickFrom[11]);
                    ImGui.EndDisabled();
                    ImGui.Separator();
                    ImGui.Text("Instructions:");
                    ImGui.Text("Requires War's Retreat teleport to be unlocked or that you have Ring of Fortune or Luck of the Dwarves equipped. Running the script with the grove selected plus wood box in inv may obviate this.");
                    ImGui.Text("It'll pick bird's nests up, and it'll use decorated urns and/or wood box if you leave them in your inventory.");
                    ImGui.Text("If you have a normal and/or perfect juju woodcutting potion when starting the script, it will use it and withdraw more if needed the next time it banks.");
                    ImGui.Text("Make sure your backpack and magic (if using War's Retreat teleport) or equipment (if using Ring of Fortune or Luck of the Dwarves) menus are open, select at least 3 elder trees then start the script.");
                    ImGui.EndTabItem();
                }
                if (ImGui.BeginTabItem("Stats", ImGuiWindowFlag.None.getValue())) {
                    ImGui.Text(script.logString());
                    ImGui.EndTabItem();
                }
                ImGui.EndTabBar();
            }
            ImGui.End();
        }

    }

    @Override
    public void drawOverlay() {
        super.drawOverlay();
    }
}
