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

![ezgif com-gif-maker (1)](https://user-images.githubusercontent.com/43198629/117383333-8416da00-af1b-11eb-9ea2-f4060a703ad5.gif)

댓글 작성이 완료 되고 작성된 댓글 역시 볼 수 있다.

#### e. 글 수정
![image](https://user-images.githubusercontent.com/43198629/117383395-a577c600-af1b-11eb-8d35-3d0f24ed7791.png)

글 삭제와 동일하게 해당 작성자만이 글을 삭제할 수 있어야 한다. 비밀번호가 일치해야만 글 수정할 수 있는 칸과 버튼이 활성화된다.

1) 비밀번호 check
![image](https://user-images.githubusercontent.com/43198629/117383395-a577c600-af1b-11eb-8d35-3d0f24ed7791.png)

2-1) 비밀번호가 틀렸을 때
삭제 기능과 똑같이 alert 메세지가 뜬다.

2-2) 비밀번호가 일치할 때
![image](https://user-images.githubusercontent.com/43198629/117383588-10290180-af1c-11eb-941a-835be134993d.png)

수정할 수 있는 칸과 버튼 활성화 

#### f. 글 검색
![image](https://user-images.githubusercontent.com/43198629/117383679-42d2fa00-af1c-11eb-82fc-2902dbdd5c1b.png)

1) 글 내용으로 검색
2) 글 제목으로 검색
3) 작성자로 검색

쿼리문 작성
``` 
<select id="selectSearchList" parameterType="com.youngs.springboot.Board.dto.BoardDto" resultType="com.youngs.springboot.Board.dto.BoardDto">
   SELECT *
   FROM dbo.real_board
   WHERE delete_yn='N'
   <choose>
      <when test="type !=null  and type.equals('title')">
      AND title LIKE  CONCAT('%', #{keyword}, '%')
      </when>
      <when test="type!=null and type.equals('content')">
      AND content LIKE  CONCAT('%', #{keyword}, '%')
      </when>
      <when test="type!=null and type.equals('writer')">
      AND writer = #{keyword}
      </when>
   </choose>
   </select>
``` 

![ezgif com-gif-maker (2)](https://user-images.githubusercontent.com/43198629/117383784-862d6880-af1c-11eb-8701-2b2600a861c6.gif)
