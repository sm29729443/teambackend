package com.twoTeam.groupProject.exceptionhandler;

import com.twoTeam.groupProject.exceptions.UserIdentityException;
import com.twoTeam.groupProject.exceptions.UserValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /*
     * 預計功能:用於使用者登入及註冊，只要是「任何」使用者資訊違規的事情就拋出此例外，
     * 譬如註冊時發現 email 已被註冊過，或登入時發現 email 未被註冊過，
     * 如果是註冊時密碼要符合長度，name不可以有空白字串等等驗證，也都用此例外處理
     * */
    @ExceptionHandler(UserValidationException.class)
    public ResponseEntity<String> handle(UserValidationException exception) {

        //前端接收到的 body 如果有中文會是亂碼，需要配置這個訊息，至於亂碼原因不清楚，一開始測試時不是亂碼
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType(MediaType.TEXT_PLAIN, StandardCharsets.UTF_8));


        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .headers(headers)
                .body(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handle(MethodArgumentNotValidException exception) {
        log.warn("前端參數錯誤訊息:{}", Objects.requireNonNull(exception.getFieldError()).getDefaultMessage());
        //前端接收到的 body 如果有中文會是亂碼，需要配置這個訊息，至於亂碼原因不清楚，一開始測試時不是亂碼
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType(MediaType.TEXT_PLAIN, StandardCharsets.UTF_8));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .headers(headers)
                .body(exception.getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(UserIdentityException.class)
    public ResponseEntity<String> handle(UserIdentityException exception) {

        //前端接收到的 body 如果有中文會是亂碼，需要配置這個訊息，至於亂碼原因不清楚，一開始測試時不是亂碼
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType(MediaType.TEXT_PLAIN, StandardCharsets.UTF_8));


        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .headers(headers)
                .body(exception.getMessage());
    }
}

