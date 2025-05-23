package sample07;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sun.source.tree.Scope;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor //final fields and fields with constraints such as @NonNull. 
@ToString
//@ToString(exclude = "subject") // subject 제외하고 tostring
@Component //생성
@org.springframework.context.annotation.Scope("prototype")
public class BoardDTO {
	@NonNull
	@Value("10")
	private int no; //requiredArgsConstructor에 포함된다.
//	private final String subject; //requiredArgsConstructor에 포함된다.
	@Value("Spring")
	private String subject;
	@Value("Spring framework")
	private String content;
}
