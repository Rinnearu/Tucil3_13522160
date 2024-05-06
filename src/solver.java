import java.util.List;
import java.util.Set;

abstract class solver {
    protected String start;
    protected String end;
    protected Set<String> used_dictionary;
    protected List<String> path_result;

    public void findSolution() {}

    public void printResult() {
        if (path_result == null) {
            System.out.println(" There are no path found...");
            return;
        }
        System.out.println("Here is the path:");
        int i = 0;
        for (; i < path_result.size() - 1; i++) {
            System.out.printf("%s -> ", path_result.get(i));
        }
        System.out.println(path_result.get(i));
    }
}
