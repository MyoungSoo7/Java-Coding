import java.io.*;

public class P17478 {
    static final String start = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
    static final String[] content =  new String[]{"\"재귀함수가 뭔가요?\"\n",
            "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n",
            "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n",
            "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""
    };
    static final String answer = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
    static final String ending = "라고 답변하였지.";

    static int N;

    static void print(int indent) {
        if (indent <= N) {
            StringBuilder sb = new StringBuilder();
            StringBuilder tab = new StringBuilder();
            for (int i = 0; i < indent; i++) {
                tab.append("____");
            }

            if (indent == N) {
                sb.append(tab)
                        .append(content[0])
                        .append(tab)
                        .append(answer);
                System.out.println(sb);
            } else {
                for (String s : content) {
                    sb.append(tab)
                            .append(s);
                }
                System.out.println(sb);
                print(indent + 1);
            }
            System.out.println(sb.delete(0, sb.length())
                    .append(tab)
                    .append(ending));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        System.out.println(start);
        print(0);
    }
}
