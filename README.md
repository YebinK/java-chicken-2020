# java-chicken-2019

### 도메인 요구사항
1. 주문등록
- [x] 테이블 목록을 보여준다.
    - [ ] 결제가 완료되지 않은 테이블은 표시를 해준다.
- [ ] 테이블을 선택하면 주문할 수 있는 메뉴 번호/이름/가격을 보여준다.
- [x] 사용자가 메뉴 번호와 수량을 선택하면 이를 해당 테이블이 저장한다.
    - [x] 한 테이블에서 한 메뉴 당 최대 99개까지 주문이 가능하다.
    - [x] 주문이 불가능하다면 그 이유를 출력한다.

2. 결제하기
- [ ] 테이블 목록을 보여준다.
- [ ] 테이블을 선택하면 해당 테이블에서 주문한 메뉴/수량/금액을 보여준다.
    - [ ] 치킨 종류는 10개 이상이면 10,000원씩 할인된다.
- [ ] 현금 결제는 5%가 할인된다. (중복 할인 가능)
- [ ] 최종 결제 금액을 보여준다.

### I/O 요구사항
- [x] 사용자 입력이 올바른지 확인한다.