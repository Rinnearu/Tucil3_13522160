import java.util.*;

public class UCS extends solver{
    public UCS(String startingWord, String goalWord) {
        this.start = startingWord;
        this.end = goalWord;
        this.used_dictionary = englishWords.getDictionary(this.start.length());
    }

    public void findSolution() {
        PriorityQueue<treeNode> active_nodes = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));

        Set<String> visited = new HashSet<>();

        Map<String, String> parentMap = new HashMap<>();

        active_nodes.add(new treeNode(start, 0));

        while (!active_nodes.isEmpty()) {
            treeNode currentNode = active_nodes.poll();
            String currentWord = currentNode.word;
            int currentCost = currentNode.cost;

            if (currentWord.equals(end)) {
                constructPath(parentMap);
                System.out.println("Node yang dikunjungi : " + visited.size());
                return;
            }

            if (visited.contains(currentWord)) {
                continue;
            }

            visited.add(currentWord);

            List<String> adjacent = new ArrayList<>();
            for (String candidate : this.used_dictionary) {
                if (englishWords.charDiff(currentWord, candidate) == 1) {
                    adjacent.add(candidate);
                }
            }

            for (String nextWord : adjacent) {
                int newCost = currentCost + 1;
                if (!visited.contains(nextWord) && !parentMap.containsKey(nextWord)) {
                    active_nodes.add(new treeNode(nextWord, newCost));
                    parentMap.put(nextWord, currentWord);
                }
            }
        }

        System.out.println(" No solution found...");
    }

    private void constructPath (Map<String, String> parentMap) {
        List<String> path = new LinkedList<>();
        String currentWord = this.end;

        while (currentWord != null) {
            path.add(0, currentWord);
            currentWord = parentMap.get(currentWord);
        }

        this.path_result = path;
    }
}
