import java.io.*;
import java.util.*;

class Bag implements Comparable<Bag> {
    int maxWeight;

    public Bag(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public int compareTo(Bag bag) {
        return Integer.compare(this.maxWeight, bag.maxWeight);
    }
}

class Gem implements Comparable<Gem> {
    int weight;
    int value;

    public Gem(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    @Override
    public int compareTo(Gem gem) {
        return Integer.compare(this.weight, gem.weight);
    }
}

public class P1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        Gem[] gems = new Gem[N];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            gems[n] = new Gem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Bag[] bags = new Bag[K];
        for (int k = 0; k < K; k++) {
            bags[k] = new Bag(Integer.parseInt(br.readLine()));
        }

        Arrays.sort(gems);
        Arrays.sort(bags);
        PriorityQueue<Integer> values = new PriorityQueue<>(Comparator.reverseOrder());
        long result = 0;
        int i = 0;
        for (Bag bag : bags) {
            while (i < N && bag.maxWeight >= gems[i].weight) {
                values.offer(gems[i].value);
                i++;
            }
            if (!values.isEmpty()) {
                result += values.poll();
            }
        }
        System.out.println(result);
    }
}
