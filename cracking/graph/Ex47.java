import java.awt.datatransfer.StringSelection;
import java.util.*;

public class Ex47 {
    public static class Node {
        private final int value;
        private Node parent;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node parent) {
            this.value = value;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "Node(" + value + ")";
        }
    }

    String[] findBuildOrder(String[] projects, String[][] dependencies) {
        Map<String, Set<String>> projectDependencies = new HashMap<>();
        Map<String, Set<String>> projectUnlocks = new HashMap<>();
        var locked = new HashSet<String>();
        for (var project : projects) {
            projectDependencies.put(project, new HashSet<>());
            projectUnlocks.put(project, new HashSet<>());
            locked.add(project);
        }
        for (var dependency : dependencies) {
            projectDependencies.get(dependency[1]).add(dependency[0]);
            projectUnlocks.get(dependency[0]).add(dependency[1]);
        }
        var checkQueue = new LinkedList<String>();
        var buildOrder = new ArrayList<String>();
        for (var entry : projectDependencies.entrySet()) {
            if (entry.getValue().isEmpty()) {
                checkQueue.add(entry.getKey());
                locked.remove(entry.getKey());
            }
        }
        while (!checkQueue.isEmpty()) {
            var project = checkQueue.remove();
            buildOrder.add(project);
            for (var unlock : projectUnlocks.get(project)) {
                if (locked.contains(unlock)) {
                    var deps = projectDependencies.get(unlock);
                    deps.remove(project);
                    if (deps.isEmpty()) {
                        checkQueue.add(unlock);
                        locked.remove(unlock);
                    }
                }
            }
        }
        if (projects.length == buildOrder.size()) {
            return buildOrder.toArray(new String[0]);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        var ex = new Ex47();
        String[] projects = {"a", "b", "c", "d", "e", "f"};
        String[][] dependencies = {{"a", "d"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"}};
        String[] result = ex.findBuildOrder(projects, dependencies);
        if (result != null) {
            System.out.println(String.join(", ", Arrays.asList(result)));
        } else {
            System.out.println("No solution");
        }
    }

}