import jdk.internal.classfile.impl.ClassPrinterImpl;

import java.awt.print.Book;
import java.util.Scanner;

public class insertBook {
    public void insertBook(ClassPrinterImpl.ListNodeImpl bookList, Scanner sc) throws InterruptedException {
        while (true) {
            var book = new Book();
            // 도서 번호는 중복되면 안 됨
            while (true) {
                int cnt = 0;
                System.out.println("도서 번호 입력");
                String temp = sc.nextLine();
                for (int i = 0; i < bookList.size(); i++) {
                    if (temp.equals(bookList.get(i).getClass())) {
                        cnt++;
                        System.out.println("도서 번호 중복입니다. 다시 입력하세요.");
                        break;
                    } // end if
                } // end for
                if (cnt == 0) {
                    book.setPage(temp);
                    break;
                }
            } // end while
            System.out.println("책 제목 입력");
            book.setbTitle(sc.nextLine());
            System.out.println("작가 입력");
            book.setbAuthor(sc.nextLine());
            System.out.println("장르 입력");
            book.setbGenre(sc.nextLine());
            book.setbAvailable(true);
            Thread.sleep(1000);

            // 컨펌 후에 리스트에 객체 저장
            System.out.println("도서번호 : " + book.getbNo());
            System.out.println("도서제목 : " + book.getbTitle());
            System.out.println("지 은 이  : " + book.getbAuthor());
            System.out.println("장     르  : " + book.getbGenre());
            System.out.println("대여가능 : " + book.isbAvailable());

            System.out.println("입력하신 사항이 모두 맞습니까? 예(Y) 아니오(N)");
            String confirm = sc.nextLine();
            if (confirm.equalsIgnoreCase("y")) {
                bookList.add(book);
                System.out.println("======입력 완료=====");
                break;
            } else if (confirm.equalsIgnoreCase("n")) {
                System.out.println("도서 정보를 새로 입력하세요.");
            } else {
                System.out.println("잘못 누르셨습니다. 초기 메뉴로 이동합니다");
                break; // 초기메뉴로 이동
            } // if-else end
        } // end while

        Thread.sleep(1000);
    }
}