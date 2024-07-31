package voteMamagemants;

import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                System.out.print("진행할 투표 수를 입력하세요: ");
                int numberOfVotes = scanner.nextInt();
                scanner.nextLine();

                System.out.print("선거에 참여할 후보자 수를 입력하세요: ");
                int numberOfCandidates = scanner.nextInt();
                scanner.nextLine();

                String[] candidates = new String[numberOfCandidates];
                for (int i = 0; i < numberOfCandidates; i++) {
                        System.out.print((i + 1) + "번째 후보자의 이름을 입력하세요: ");
                        candidates[i] = scanner.nextLine();
                }

                System.out.println("후보자 명단:");
                for (int i = 0; i < numberOfCandidates; i++) {
                        System.out.println("기호 " + (i + 1) + "번: " + candidates[i]);
                }
        }
}
