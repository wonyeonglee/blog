# "210's blog"
------------------------
>스프링부트 공부를 위해 나만의 블로그(게시판) 만들기 
------------------------
### 1. 게시판 기능
#### a. 글 목록 불러오기
![image](https://user-images.githubusercontent.com/43198629/117146155-ddcdb600-adee-11eb-8470-3636e5783a8d.png)

#### b. 글 작성

#### c. 상세 페이지 보기
![image](https://user-images.githubusercontent.com/43198629/117146320-0b1a6400-adef-11eb-9fbb-a600ad8f66f1.png)

#### d. 조회수 증가
![image](https://user-images.githubusercontent.com/43198629/117382729-1ddd8780-af1a-11eb-98c3-c420c9c1d26f.png)

#### e. 글 삭제
해당 작성자만이 글을 삭제할 수 있어야 하기 때문에 먼저 작성자가 맞는지 확인한다.
글을 작성할 때 입력했던 비밀번호를 적고 맞는지 확인해야만 글 삭제 버튼이 활성화가 된다.

1) 비밀번호 check 
![image](https://user-images.githubusercontent.com/43198629/117382846-61d08c80-af1a-11eb-9f6c-13763f9e72f5.png)

2-1) 비밀번호가 틀렸을 때
![image](https://user-images.githubusercontent.com/43198629/117382954-9f351a00-af1a-11eb-99c2-8ec9cc15db0a.png)

일치하지 않는다는 alert 메세지가 뜬다.

2-2) 비밀번호가 일치할 때
![image](https://user-images.githubusercontent.com/43198629/117382996-bbd15200-af1a-11eb-9221-b8f38bb93217.png)

비밀번호가 일치했기 때문에 글 삭제 버튼이 활성화 되었다.

#### d. 댓글 작성
먼저 댓글을 작성 할 수 있는 공간이다.
![image](https://user-images.githubusercontent.com/43198629/117383102-f0450e00-af1a-11eb-8f46-1e786f1ebebc.png)

글을 작성하고 submit 버튼을 누르면

![image](https://user-images.githubusercontent.com/43198629/117383233-41ed9880-af1b-11eb-9157-89d7f6d752b2.png)


#### e. 글 수정
#### f. 글 검색
