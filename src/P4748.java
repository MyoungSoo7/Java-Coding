import java.io.*;
import java.util.*;

public class P4748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String dom = br.readLine();
        Gene.isDom = new boolean[dom.length()];
        for (int i = 0; i < dom.length(); i++) {
            Gene.isDom[i] = dom.charAt(i) == 'D';
        }

        List<Shrew> male = new ArrayList<>();
        List<Shrew> female = new ArrayList<>();
        String input;
        while (!(input = br.readLine()).equals("***")) {
            StringTokenizer st = new StringTokenizer(input);
            String name = st.nextToken();
            String sex = st.nextToken();
            Gene gene = new Gene(st.nextToken());
            if (sex.equals("M")) {
                male.add(new Shrew(name, gene));
            } else {
                female.add(new Shrew(name, gene));
            }
        }

        male.sort(Comparator.comparing(s -> s.name));
        female.sort(Comparator.comparing(s -> s.name));

        while (!(input = br.readLine()).equals("***")) {
            StringTokenizer st = new StringTokenizer(input);
            String name = st.nextToken();
            String gene = st.nextToken();
            List<String> answer = new ArrayList<>();
            System.out.printf("%s by ", name);
            for (int i = 0; i < female.size(); i++) {
                for (int j = 0; j < male.size(); j++) {
                    String cross = female.get(i).gene.cross(male.get(j).gene);
                    if (cross.equals(gene)) {
                        answer.add(String.format("%s-%s", female.get(i).name, male.get(j).name));
                        answer.add("or");
                    }
                }
            }
            if (!answer.isEmpty()) answer.remove(answer.size() - 1);
            System.out.println(String.join(" ", answer));
        }
    }

    static class Shrew {
        String name;
        Gene gene;

        Shrew(String name, Gene gene) {
            this.name = name;
            this.gene = gene;
        }
    }

    static class Gene {
        static boolean[] isDom;

        boolean[] gene;

        Gene(String gene) {
            this.gene = new boolean[isDom.length];
            for (int i = 0; i < isDom.length; i++) {
                this.gene[i] = gene.charAt(i) == '1';
            }
        }

        String cross(Gene target) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < isDom.length; i++) {
                if (isDom[i]) {
                    sb.append(this.gene[i] || target.gene[i] ? 1 : 0);
                } else {
                    sb.append(this.gene[i] && target.gene[i] ? 1 : 0);
                }
            }
            return sb.toString();
        }
    }
}
