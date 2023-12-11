import jdk.internal.classfile.impl.ClassPrinterImpl;

public class selectOne {
    public void selectOne(ClassPrinterImpl.ListNodeImpl bookList) {
        while (true) {
            System.out.println("검색 할 책의 번호를 입력해주세요");
            String temp = sc.nextLine();
            int cnt = 0;
            for (int i = 0; i < bookList.size(); i++) {
                if (temp.equals(bookList.get(i).getClass())) {
                    System.out.println("===============================");
                    System.out.println("책 번호 : " + bookList.get(i).getClass());
                    System.out.println("책 제목 : " + bookList.get(i).getbTitle());
                    System.out.println("지은이  : " + bookList.get(i).getbAuthor());
                    System.out.println("장   르  : " + bookList.get(i).getbGenre());
                    System.out.println("대여가능 : " + bookList.get(i).isbAvailable());
                    System.out.println("===============================\n");
                    cnt++;
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