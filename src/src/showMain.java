import java.util.Scanner;

public class showMain {
    public void showMain() throws InterruptedException {
        while (true) {
            System.out.println("Welcome to the Library");
            System.out.println("[1] 도서 등록\t [2] 전체 조회\t [3] 개별 조회\t [4] 책 정보 수정\t [5] 책 삭제\t [6] 도서 반납 및 대여\t[0] 종료");
            Scanner sc = null;
            String userInput = sc.nextLine();

            switch (userInput) {
                case ("1"):
                    new insertBook();
                    break;

                case ("2"):
                    new selectAll();
                    break;
                case ("3"):
                    new selectOne();
                    break;

                case ("4"):
                    new updateBook();
                    break;

                case ("5"):
                    new checkBook();
                    break;
                case ("0"):
                    System.out.println("프로그램 종료");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
                    break;
            }

        } // end while
    }


}