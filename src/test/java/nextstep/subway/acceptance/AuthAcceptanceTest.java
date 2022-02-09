package nextstep.subway.acceptance;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static nextstep.subway.acceptance.MemberSteps.*;


class AuthAcceptanceTest extends AcceptanceTest {
    private static final String EMAIL = "email@email.com";
    private static final String PASSWORD = "password";
    private static final Integer AGE = 20;

    @DisplayName("Session 로그인 후 내 정보 조회")
    @Test
    void myInfoWithSession() {
        회원_생성_요청(EMAIL, PASSWORD, AGE);

        ExtractableResponse<Response> response = 내_회원_정보_조회_요청(EMAIL, PASSWORD);

        회원_정보_조회됨(response, EMAIL, AGE);
    }

    /**
        When 회원 생성을 요청
        Then 회원 생성됨
        When 회원 정보 조회 요청
        Then 회원 정보 조회됨
        When 회원 정보 수정 요청
        Then 회원 정보 수정됨
        When 회원 삭제 요청
        Then 회원 삭제됨
     */
    @DisplayName("회원 정보를 관리")
    @Test
    void 회원_생명_주기(){
        
    }


    @Disabled
    @DisplayName("Bearer Auth")
    @Test
    void myInfoWithBearerAuth() {
        회원_생성_요청(EMAIL, PASSWORD, AGE);

        String accessToken = 로그인_되어_있음(EMAIL, PASSWORD);

        ExtractableResponse<Response> response = 내_회원_정보_조회_요청(accessToken);

        회원_정보_조회됨(response, EMAIL, AGE);
    }
}
