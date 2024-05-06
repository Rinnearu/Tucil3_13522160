import java.util.*;

public class GBFS extends solver{
    public GBFS(String startingWord, String goalWord) {
        this.start = startingWord;
        this.end = goalWord;
        this.used_dictionary = englishWords.getDictionary(this.start.length());
    }

    @Override
    public void findSolution(){
        PriorityQueue<treeNode> active_nodes = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));

        Set<String> visited = new HashSet<>();

        Map<String, String> parentMap = new HashMap<>();

        active_nodes.add(new treeNode(start, englishWords.charDiff(start, end)));

        while (!active_nodes.isEmpty()){
            treeNode currentNode = active_nodes.poll();
            String currentWord = currentNode.word;

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
                if (!visited.contains(nextWord) && !parentMap.containsKey(nextWord)) {
                    active_nodes.add(new treeNode(nextWord, englishWords.charDiff(nextWord, end)));
                    parentMap.put(nextWord, currentWord);
                }
            }
        }

        System.out.println(" No solution found...");
    }
}
