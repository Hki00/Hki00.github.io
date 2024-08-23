---
title: FAILURE- Build failed with an exception. Incompatible because this component declares a component for use during compile-time, compatible with Java 17 and the consumer needed a component for use during runtime, compatible with Java 10
date: 2024-03-29 18:15:00 +0900
categories: [SPRING, JAVA, MAC, GRADLE]
tags: [gradle, spring, java, mac]  # TAG names should always be lowercase
authors: [gonnichiwa]
---

# 스프링 부트 하면서 내가 이해한 내용 대충 정리


### 2-12 프리픽스는 앞으로 고정할 사이트에 첫화면을 코딩한 영역

```
package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequestMapping("/question") // 여기랑
@RequiredArgsConstructor
@Controller
public class QuestionController {
	
	private final QuestionService questionService;
	
	@GetMapping("/list") /* 2-6(1)번 URL 매핑, 여기*/ 
	public String list(Model model) {
		List<Question> questionList = this.questionService.getList();
		
		model.addAttribute("questionList", questionList);
		return "question_list";
	}
	@GetMapping(value = "/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
		return "question_detail";
	}
}


```

앞으로 URL 매핑 시 반드시 /question으로 시작


### 2-13 질문에 답변하기

- 질문 고유에 페이지도 매핑해야 입력한 내용이 출력된다.
- @PostMapping은 Post요청을처리하는 경우에 사용

## 2-14 페이지 스타일링 CSS파일

- CSS 파일은 HTML 파일과 달리 스태틱(static) 디렉터리에 저장해야 한다. (nnn.css)

- 그리고 HTML파일에 적용하여 사용한다
```
<link rel="stylesheet" type="text/css" th:href="@{/style.css}">
<h1 th:text="${question.subject}"></h1>
```

- 부트스트랩을 다운받고 'bootstrap.min.css' 파일을
스태틱 폴더에 붙여넣기 한다.
- 스프링부트 내에서 한줄로 된 큰 파일을 읽느라 '응답없음'이 뜨니 하지말고 저장 꾸준히 하자

- 그 후 부트스트랩을 적용한다.

```
<link rel="stylesheet" type="text/css" th:href="@{/bootstrap.min.css}">
<div class="container my-3">
    <table class="table">
        <thead class="table-dark">
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성일시</th>
            </tr>
        </thead>
        <tbody>
            <tr th:each="question, loop : ${questionList}">
                <td th:text="${loop.count}"></td>
                <td>
                    <a th:href="@{|/question/detail/${question.id}|}" th:text="${question.subject}"></a>
                </td>
                <td th:text="${#temporals.format(question.createDate, 'yyyy-MM-dd HH:mm')}"></td>
            </tr>
        </tbody>
    </table>
</div>

```
되게 많고 아직 이해안된다 여기. 일단 그냥 하는중

### 2-15 표준 HTML 구조로 변경하기
- HTML 문서는 html, head, body요소가 있어야 하며    CSS 파일은 head 태그 안에 링크되어야한다.   head 태그 안에는 mata, title 요소등이 포함되어야하 한다.

기본 html 파일이 있고
```
<!doctype html>
<html lang="ko">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" th:href="@{/bootstrap.min.css}">
    <!-- sbb CSS -->
    <link rel="stylesheet" type="text/css" th:href="@{/style.css}">
    <title>Hello, sbb!</title>
</head>
<body>
<!-- 기본 템플릿 안에 삽입될 내용 Start -->
<th:block layout:fragment="content"></th:block>
<!-- 기본 템플릿 안에 삽입될 내용 End -->
</body>
</html>

```
만들어둔 기존에 만들어둔 html 파일에 상속시키면

```
<html layout:decorate="~{layout}">
<div layout:fragment="content" class="container my-3">
    <table class="table">
        (... 생략 ...)
    </table>
</div>
</html>

```


만든 웹사이트에 페이지 소스 진입 시 html 코드를 확인할 수 있다.

기능을 추가할 웹페이지에 연결될 링크주소와 키값과 내용을 적는다.
컨트롤러로 주소를 정해주고(URL매핑) 만든 html 템플릿을 연결하여 내용을 만든다

버튼과 화면 만들기 - 버튼과 화면 맵핑하기 - 기능구현 템플릿 만들기 - 요청방법 컨트롤러에 추가(POST)
뭘 적어야되냐....