import jdk.internal.classfile.impl.ClassPrinterImpl;

public class checkBook {
    public void checkBook(ClassPrinterImpl.ListNodeImpl bookList) {
        while (true) {
            System.out.println("해당 도서 번호를 입력해주세요");
            String temp = sc.nextLine();
            int cnt = 0;
            for (int i = 0; i < bookList.size(); i++) {
                if (temp.equals(bookList.get(i).getClass())) {
                    cnt++;
                    boolean bStatus = bookList.get(i).isbAvailable();

                    if (bStatus) {
                        bStatus = false;
                        System.out.println("도서가 대여되었습니다.");
                    } else {
                        bStatus = true;
                        System.out.println("도서가 반납되었습니다.");
                    }
                    bookList.get(i).setbAvailable(bStatus);
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