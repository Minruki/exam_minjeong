package exam_minjeong.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ContextDataSource.class, ContextSqlSession.class, MvcConfig.class})
@ComponentScan(basePackages = {
		"exam_minjeong.mapper", "exam_minjeong.controller", 
		"exam_minjeong.service" })
public class ContextRoot {

}
