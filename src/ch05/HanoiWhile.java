package ch05;

import java.util.Stack;

class HanoiWhile {
    static class Move {
        int diskNumber; // 실제 디스크
        int from, to;

        Move(int diskNumber, int from, int to) {
            this.diskNumber = diskNumber;
            this.from = from;
            this.to = to;
        }
    }

    public static void solveHanoiIterative(int numDisks, int fromRod, int auxRod, int toRod) {
        Stack<Move> stack = new Stack<>();
        Stack<Integer> disksStack = new Stack<>(); // 움직일 원판의 개수

        // 처음 호출을 위해 numDisks, 시작, 보조, 목표 기둥을 넣습니다.
        stack.push(new Move(numDisks, fromRod, toRod));
        disksStack.push(numDisks);

        while (!stack.isEmpty()) {
            Move move = stack.pop();
            int disks = disksStack.pop();

            if (disks == 1) {
                System.out.println("Disk " + move.diskNumber + ": " + move.from + " -> " + move.to);
            } else {
                int aux = 6 - move.from - move.to; // 남은 하나의 막대를 자동으로 찾음

                // 스택에 역순으로 작업을 넣습니다.
                stack.push(new Move(disks - 1, aux, move.to));
                disksStack.push(disks - 1);

                stack.push(new Move(disks, move.from, move.to)); // 실재 디스크
                disksStack.push(1);  // 움직일 원판의 개수

                stack.push(new Move(disks - 1, move.from, aux));
                disksStack.push(disks - 1);
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;  // 원반 개수
        solveHanoiIterative(n, 1, 2,3);
    }
}
