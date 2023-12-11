// end selectAll

import jdk.internal.classfile.impl.ClassPrinterImpl;

public class selectAll {
    public void selectAll(ClassPrinterImpl.ListNodeImpl bookList) throws InterruptedException {
        while (true) {
            System.out.println("보유 도서량:  " + bookList.size());
            for (int i = 0; i < bookList.size(); i++) {
                System.out.println("===============================");
                System.out.println("책 번호 : " + bookList.get(i).getClass());
                System.out.println("책 제목 : " + bookList.get(i).getbTitle());
                System.out.println("지은이  : " + bookList.get(i).getbAuthor());
                System.out.println("장   르  : " + bookList.get(i).getbGenre());
                System.out.println("대여가능 : " + bookList.get(i).isbAvailable());
                System.out.println("===============================\n");

            } // end for
            System.out.println("초기 메뉴 이동 : [b] \t 프로그램 종료 : [0]");
            String temp = sc.nextLine();
            if (temp.equalsIgnoreCase("b")) {
                break;
            } else if (temp.equals("0")) {
                System.out.println("프로그램을 종료합니다.");
                Thread.sleep(1000);
                System.exit(0);
            } else {
                System.out.println("잘못 누르셨습니다. 초기화면으로 이동합니다.");
                Thread.sleep(1000);
                break; // 메인으로 돌아감
            } // if-else end
        } // while end
    }
}