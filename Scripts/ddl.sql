-- 내 스키마
DROP SCHEMA IF EXISTS exam_lmj;

-- 내 스키마
CREATE SCHEMA exam_lmj;

-- 직책
CREATE TABLE exam_lmj.Title (
   TITLE_NO   INT         NOT NULL COMMENT '직책코드', -- 직책코드
   TITLE_NAME VARCHAR(10) NOT NULL COMMENT '직책명' -- 직책명
)
COMMENT '직책';

-- 직책
ALTER TABLE exam_lmj.Title
   ADD CONSTRAINT PK_Title -- 직책 기본키
      PRIMARY KEY (
         TITLE_NO -- 직책코드
      );

-- 부서
CREATE TABLE exam_lmj.department (
   DEPT_NO   INT         NOT NULL COMMENT '부서번호', -- 부서번호
   DEPT_NAME VARCHAR(20) NOT NULL COMMENT '부서명', -- 부서명
   FLOOR    INT         NULL     COMMENT '위치' -- 위치
)
COMMENT '부서';

-- 부서
ALTER TABLE exam_lmj.department
   ADD CONSTRAINT PK_department -- 부서 기본키
      PRIMARY KEY (
         DEPT_NO -- 부서번호
      );

-- 사원
CREATE TABLE exam_lmj.employee (
   EMP_NO   INT         NOT NULL COMMENT '사원번호', -- 사원번호
   EMP_NAME VARCHAR(20) NOT NULL COMMENT '사원명', -- 사원명
   TNO   INT         NULL     COMMENT '직책', -- 직책
   MANAGER INT         NULL     COMMENT '직속상사', -- 직속상사
   SALARY  INT         NULL     COMMENT '급여', -- 급여
   DNO    INT         NULL     COMMENT '부서' -- 부서
)
COMMENT '사원';

-- 사원
ALTER TABLE exam_lmj.employee
   ADD CONSTRAINT PK_employee -- 사원 기본키
      PRIMARY KEY (
         EMP_NO -- 사원번호
      );

-- 사원
ALTER TABLE exam_lmj.employee
   ADD CONSTRAINT FK_Title_TO_employee -- 직책 -> 사원
      FOREIGN KEY (
         TNO -- 직책
      )
      REFERENCES exam_lmj.Title ( -- 직책
         TITLE_NO -- 직책코드
      );

-- 사원
ALTER TABLE exam_lmj.employee
   ADD CONSTRAINT FK_employee_TO_employee -- 사원 -> 사원
      FOREIGN KEY (
         MANAGER -- 직속상사
      )
      REFERENCES exam_lmj.employee ( -- 사원
         EMP_NO -- 사원번호
      );

-- 사원
ALTER TABLE exam_lmj.employee
   ADD CONSTRAINT FK_department_TO_employee -- 부서 -> 사원
      FOREIGN KEY (
         DNO -- 부서
      )
      REFERENCES exam_lmj.department ( -- 부서
         DEPT_NO -- 부서번호
      );