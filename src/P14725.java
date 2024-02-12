import java.io.*;
import java.util.*;

class Trie {
    static class Node {
        Map<String, Node> nodes = new HashMap<>();

        boolean hasNode(String s) {
            return this.nodes.containsKey(s);
        }

        void setNode(String s) {
            this.nodes.put(s, new Node());
        }

        Node getNode(String s) {
            return this.nodes.get(s);
        }

        String[] getKeys() {
            String[] result = this.nodes.keySet().toArray(new String[0]);
            Arrays.sort(result);
            return result;
        }
    }

    Node root = new Node();

    void add(StringTokenizer rooms) {
        int K = Integer.parseInt(rooms.nextToken());
        Node cur = this.root;

        for (int i = 0; i < K; i++) {
            String room = rooms.nextToken();
            if (!cur.hasNode(room)) {
                cur.setNode(room);
            }
            cur = cur.getNode(room);
        }
    }

    public String toString(int depth, Node node) {
        StringBuilder sb = new StringBuilder();

        String[] keys = node.getKeys();
        if (keys.length == 0) {
            return "";
        }

        StringBuilder dash = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            dash.append("--");
        }

        for (String key : keys) {
            sb.append(dash).append(key).append("\n");
            sb.append(toString(depth + 1, node.getNode(key)));
        }
        return sb.toString();
    }
}

public class P14725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Trie trie = new Trie();
        for (int i = 0; i < N; i++) {
            trie.add(new StringTokenizer(br.readLine()));
        }

        System.out.println(trie.toString(0, trie.root));
    }
}
