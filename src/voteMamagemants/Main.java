package voteMamagemants;

import java.util.Random;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                Random random = new Random();


                System.out.print("진행할 투표 수를 입력하세요: ");
                int numberOfVotes = scanner.nextInt();
                scanner.nextLine();

                System.out.print("선거에 참여할 후보자 수를 입력하세요: ");
                int numberOfCandidates = scanner.nextInt();
                scanner.nextLine();

                String[] candidates = new String[numberOfCandidates];
                int[] voteCounts = new int[numberOfCandidates];
                for (int i = 0; i < numberOfCandidates; i++) {
                        System.out.print((i + 1) + "번째 후보자의 이름을 입력하세요: ");
                        candidates[i] = scanner.nextLine();
                }

                System.out.println("후보자 명단:");
                for (int i = 0; i < numberOfCandidates; i++) {
                        System.out.println("기호 " + (i + 1) + "번: " + candidates[i]);
                }

                int votesPerPercent = numberOfVotes / 100;
                for (int i = 0; i < numberOfVotes; i++) {
                        int randomVote = random.nextInt(numberOfCandidates);  // 후보자 선택
                        voteCounts[randomVote]++;
                        int randomNumber = random.nextInt(10000) + 1;  // 1에서 10000 사이의 임의 번호
                        System.out.println("투표 " + (i + 1) + ": 기호 " + (randomVote + 1) + "번 후보자 (" + candidates[randomVote] + ") - 투표 번호: " + randomNumber);

                        // 1% 단위로 진행 상황 출력
                        if ((i + 1) % votesPerPercent == 0) {
                                int progressPercentage = (int) (((double) (i + 1) / numberOfVotes) * 100);
                                System.out.println("현재 진행률: " + progressPercentage + "%");

                                try {
                                        Thread.sleep(200);  // 0.2초 대기
                                } catch (InterruptedException e) {
                                        e.printStackTrace();
                                }
                        }
                }

                System.out.println("\n투표 결과:");
                for (int i = 0; i < numberOfCandidates; i++) {
                        System.out.println("기호 " + (i + 1) + "번 후보자 (" + candidates[i] + "): " + voteCounts[i] + "표");
                }

                scanner.close();
        }
}
