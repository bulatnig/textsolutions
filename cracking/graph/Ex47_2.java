import java.util.*;

public class Ex47_2 {
    static final class Project {
        final String name;
        List<Project> dependencies = new ArrayList<>();
        Status status = Status.PENDING;

        public Project(String name) {
            this.name = name;
        }

        enum Status {
            PENDING,
            PROCESSING,
            COMPLETE
        }
    }

    Deque<String> findBuildOrder(String[] project_names, String[][] dependencies) {
        var projects = new HashMap<String, Project>();
        for (var name : project_names) {
            projects.put(name, new Project(name));
        }
        for (var dependency : dependencies) {
            projects.get(dependency[0]).dependencies.add(projects.get(dependency[1]));
        }
        var buildOrder = new ArrayDeque<String>();
        for (var project : projects.values()) {
            if (!buildDeps(project, buildOrder)) {
                return null;
            }
        }
        return buildOrder;
    }

    boolean buildDeps(Project project, Deque<String> buildOrder) {
        if (project.status == Project.Status.PROCESSING) {
            return false;
        }
        if (project.status == Project.Status.COMPLETE) {
            return true;
        }
        project.status = Project.Status.PROCESSING;
        for (var dep : project.dependencies) {
            if (!buildDeps(dep, buildOrder)) {
                return false;
            }
        }
        project.status = Project.Status.COMPLETE;
        buildOrder.add(project.name);
        return true;
    }

    public static void main(String[] args) {
        var ex = new Ex47();
//        String[] projects = {"a", "b", "c", "d", "e", "f"};
//        String[][] dependencies = {{"a", "d"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"}};
        String[] projects = {"a", "b"};
        String[][] dependencies = {{"a", "b"}, {"b", "a"}};
        String[] result = ex.findBuildOrder(projects, dependencies);
        if (result != null) {
            System.out.println(String.join(", ", Arrays.asList(result)));
        } else {
            System.out.println("No solution");
        }
    }

}
