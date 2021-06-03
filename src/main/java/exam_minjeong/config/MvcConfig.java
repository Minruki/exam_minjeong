package exam_minjeong.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc // 스프링 MVC 설정 활성화
public class MvcConfig implements WebMvcConfigurer {

	// DispatcherServlet의 매핑경로를 '/' 주었을 때, JSP/HTML/CSS 등을 올바르게 처리하기 위한 설정 추가
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	// JSP를 통해서 컨트롤러의 실행 결과를 보여주기 위한 설정
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/view/", ".jsp");
	}

	// 컨트롤러 구현 없는 경로 매핑
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/emplist").setViewName("list");
	}
	
	/* Bean의 아이디를 반드시 "messageSource"로 지정해야 됨
	 * message 패키지에 속한 label 프로퍼티 파일로부터 메시지를 읽어 옴
	 * src/main/resources 폴더도클래스 패스에 포함되고 message 폴더는 message 패키지에 대응
	 * 앞서 작성한 label.properties 파일로부터 메시지를 읽어 옴
	 */
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
		ms.setBasename("message.label");
		ms.setDefaultEncoding("UTF-8");
		return ms;
	}
	
}