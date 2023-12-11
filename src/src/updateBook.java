import jdk.internal.classfile.BufWriter;

import java.util.Scanner;

public class updateBook {

    private BufWriter bookList;

    public void updateBook() {
        while (true) {
            System.out.println("수정 할 책의 번호를 입력해주세요");
            Scanner sc = null;
            String temp = sc.nextLine();
            int cnt = 0;
            for (int i = 0; i < bookList.size(); i++) {
                if (temp.equals(bookList.getClass().getAnnotation())) {
                    System.out.println("새로운 제목 입력: ");
                    bookList.getClass().getField(sc.nextLine());
                    System.out.println("새로운 지은이 입력: ");
                    bookList.getClass().setbAuthor(sc.nextLine());
                    cnt++;
                    System.out.println("도서 수정 완료");
                    break;
                }
            } // end for
            if (cnt == 0) {
                System.out.println("해당 도서가 존재하지 않습니다. 도서 번호를 다시 입력하세요.");
            } else {
                break;// 메인으로
            }
        } // end while
    }
}